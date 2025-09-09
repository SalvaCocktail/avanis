package avanis.buscador.portlet.utils;

import avanis.buscador.portlet.cache.NoticiasCacheUtil;
import avanis.buscador.portlet.vo.Noticia;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Component(immediate=true, service= NoticiasUtils.class)
public class NoticiasUtils {
    private static final Log _log = LogFactoryUtil.getLog(NoticiasUtils.class);

    @Reference
    private NoticiasCacheUtil _noticiasCacheUtil;

    @Reference
    private AssetCategoryLocalService _assetCategoryLocalService;

    @Reference
    private BlogsEntryLocalService _blogsEntryLocalService;

    @Reference
    private ExpandoValueLocalService _expandoValueLocalService;

    @Reference
    private DLAppLocalService _DLAppLocalService;

    public long getTotalBlogsCount() {
        List<BlogsEntry> blogsEntries = _noticiasCacheUtil.getFromCache("blogsTodas");
        return Validator.isNotNull(blogsEntries) ? blogsEntries.size() : 0;
    }

    public List<Noticia> getNoticiasPaginadas(ThemeDisplay td, int start, int end) {
        List<Noticia> noticias = new ArrayList<>();

        try {
            List<BlogsEntry> blogsEntries = _noticiasCacheUtil.getFromCache("blogsTodas");
            if(Validator.isNull(blogsEntries)){
                QueryDefinition<BlogsEntry> queryDefinition = new QueryDefinition<>();
                queryDefinition.setStatus(WorkflowConstants.STATUS_APPROVED);
                blogsEntries = _blogsEntryLocalService.getGroupEntries(
                    td.getScopeGroupId(), new Date(), queryDefinition);
                List<BlogsEntry> blogsEntriesWithoutFirst = blogsEntries.subList(1, blogsEntries.size());
                _noticiasCacheUtil.addToCache("blogsTodas", blogsEntriesWithoutFirst);
            }

            if (Validator.isNotNull(blogsEntries) && !blogsEntries.isEmpty()) {
                int toIndex = Math.min(end, blogsEntries.size());
                blogsEntries = blogsEntries.subList(start, toIndex);
            }

            for (BlogsEntry entry : blogsEntries) {
                noticias.add(getDataNoticia(td, entry));
            }
        } catch (Exception e) {
            _log.error("Error al obtener las noticias: ", e);
        }

        return noticias;
    }

    public List<Noticia> getNoticiasPorCategorias(ThemeDisplay td, List<Long> categoryIds) {
        List<Noticia> noticias = new ArrayList<>();

        try {
            List<BlogsEntry> blogsEntries = _noticiasCacheUtil.getFromCache("blogsTodas");
            if(Validator.isNull(blogsEntries)){
                QueryDefinition<BlogsEntry> queryDefinition = new QueryDefinition<>();
                queryDefinition.setStatus(WorkflowConstants.STATUS_APPROVED);

                blogsEntries = _blogsEntryLocalService.getGroupEntries(
                        td.getScopeGroupId(), new Date(), queryDefinition);

                List<BlogsEntry> blogsEntriesWithoutFirst = blogsEntries.subList(1, blogsEntries.size());

                _noticiasCacheUtil.addToCache("blogsTodas", blogsEntriesWithoutFirst);
            }

            if (Validator.isNotNull(blogsEntries)) {
                List<BlogsEntry> blogsFiltrados = blogsEntries.stream()
                        .filter(blog -> {
                            try {
                                List<AssetCategory> categories = _assetCategoryLocalService.getCategories(
                                        BlogsEntry.class.getName(), blog.getPrimaryKey());
                                return categories.stream().anyMatch(category -> categoryIds.contains(category.getCategoryId()));
                            } catch (Exception e) {
                                return false;
                            }
                        })
                        .collect(Collectors.toList());

                for (BlogsEntry entry : blogsFiltrados) {
                    noticias.add(getDataNoticia(td, entry));
                }
            }
        } catch (Exception e) {
            _log.error("Error al filtrar noticias por categorías: ", e);
        }

        return noticias;
    }

    public List<Noticia> getTodasLasNoticias(ThemeDisplay td) {
        List<Noticia> noticias = new ArrayList<>();

        try {
            List<BlogsEntry> blogsEntries = _noticiasCacheUtil.getFromCache("blogsTodas");

            if (Validator.isNotNull(blogsEntries)) {
                for (BlogsEntry entry : blogsEntries) {
                    noticias.add(getDataNoticia(td, entry));
                }
            }
        } catch (Exception e) {
            _log.error("Error al obtener todas las noticias: ", e);
        }

        return noticias;
    }

    public List<Noticia> getNoticiasPorBusqueda(ThemeDisplay td, String searchQuery) {
        List<Noticia> noticias = new ArrayList<>();

        try {
            List<BlogsEntry> blogsEntries = _noticiasCacheUtil.getFromCache("blogsTodas");

            if (Validator.isNotNull(blogsEntries)) {
                List<String> keywords = Arrays.stream(searchQuery.split(" "))
                        .map(this::normalizeText)
                        .collect(Collectors.toList());

                blogsEntries = blogsEntries.stream()
                        .filter(blog -> {
                            String normalizedTitle = normalizeText(blog.getTitle());
                            return keywords.stream().anyMatch(normalizedTitle::contains);
                        })
                        .collect(Collectors.toList());

                for (BlogsEntry entry : blogsEntries) {
                    noticias.add(getDataNoticia(td, entry));
                }
            }
        } catch (Exception e) {
            _log.error("Error al buscar noticias: ", e);
        }

        return noticias;
    }

    public List<Noticia> getNoticiasPorCategoriasYBusqueda(
            ThemeDisplay td, List<Long> categoryIds, List<String> tipos, List<Integer> diasFiltro, String searchQuery) {

        List<Noticia> noticias = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        try {
            List<BlogsEntry> blogsEntries = _noticiasCacheUtil.getFromCache("blogsTodas");
            if (blogsEntries == null) {
                blogsEntries = new ArrayList<>();
            }

            if (Validator.isNotNull(blogsEntries)) {
                _log.debug("Total de entradas antes de aplicar filtros: " + blogsEntries.size());

                if (Validator.isNull(searchQuery)) {
                    searchQuery = "";
                }

                String finalSearchQuery = searchQuery;

                blogsEntries = blogsEntries.stream()
                        .filter(blog -> {
                            boolean coincideBusqueda = true; // Si hay búsqueda, se filtra después
                            boolean coincideCategoria = true; // Categorías (AND)
                            boolean coincideTipo = tipos.isEmpty(); // Tipos (OR)
                            boolean coincideFecha = diasFiltro.isEmpty(); // Fechas (OR)

                            if (Validator.isNotNull(finalSearchQuery) && !finalSearchQuery.isEmpty()) {
                                List<String> keywords = Arrays.stream(finalSearchQuery.split(" "))
                                        .map(this::normalizeText)
                                        .collect(Collectors.toList());

                                String title = Validator.isNotNull(blog.getTitle()) ? blog.getTitle() : "";
                                String normalizedTitle = normalizeText(title);

                                coincideBusqueda = keywords.stream().anyMatch(normalizedTitle::contains);
                            }

                            if (!categoryIds.isEmpty()) {
                                List<AssetCategory> categories = _assetCategoryLocalService.getCategories(
                                        BlogsEntry.class.getName(), blog.getPrimaryKey());

                                List<Long> blogCategoryIds = categories.stream()
                                        .map(AssetCategory::getCategoryId)
                                        .collect(Collectors.toList());

                                coincideCategoria = categoryIds.stream().allMatch(blogCategoryIds::contains);
                            }

                            if (!tipos.isEmpty()) {
                                List<String> tiposNoticia = Optional.ofNullable(obtenerExpandoValores(blog))
                                        .orElse(Collections.singletonList("Noticia"))
                                        .stream()
                                        .map(String::trim)
                                        .map(String::toLowerCase)
                                        .collect(Collectors.toList());

                                List<String> tiposFiltrados = tipos.stream()
                                        .map(String::trim)
                                        .map(String::toLowerCase)
                                        .collect(Collectors.toList());


                                coincideTipo = tiposNoticia.stream().anyMatch(tiposFiltrados::contains);
                            }

                            if (!diasFiltro.isEmpty()) {
                                LocalDate fechaActualizacion = Optional.ofNullable(blog.getDisplayDate())
                                        .map(date -> date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) // Convertimos a LocalDate
                                        .orElse(hoy);

                                coincideFecha = false;

                                for (Integer dias : diasFiltro) {
                                    LocalDate fechaLimite = hoy.minusDays(dias);
                                    LocalDate fechaMaxima = hoy; // Se permite hasta hoy, ignorando la hora

                                    if (!fechaActualizacion.isBefore(fechaLimite) && !fechaActualizacion.isAfter(fechaMaxima)) {
                                        coincideFecha = true;
                                        break;
                                    }
                                }

                        }

                            return coincideBusqueda && coincideTipo && coincideFecha && coincideCategoria;
                        })
                        .collect(Collectors.toList());


                for (BlogsEntry entry : blogsEntries) {
                    noticias.add(getDataNoticia(td, entry));
                }

                _log.debug("Total de entradas después de aplicar filtros: " + noticias.size());
            }
        } catch (Exception e) {
            _log.error("Error al buscar noticias por categorías, tipo y fechas: ", e);
        }

        return noticias;
    }

    private List<String> obtenerExpandoValores(BlogsEntry entry) {
        List<String> tipos;

        try {
            _log.debug("Intentando obtener Expando 'Tipo Blog' para Blog ID: " + entry.getEntryId());

            BlogsEntry entryConTipos = _blogsEntryLocalService.getBlogsEntry(entry.getEntryId());

            Serializable data = _expandoValueLocalService.getData(
                    entryConTipos.getCompanyId(),
                    BlogsEntry.class.getName(),
                    ExpandoTableConstants.DEFAULT_TABLE_NAME,
                    "Tipo Blog",
                    entryConTipos.getPrimaryKey()
            );

            if (data == null || (data instanceof String && ((String) data).trim().isEmpty())
                    || (data instanceof String[] && ((String[]) data).length == 0)) {
                _log.warn("Expando 'Tipo Blog' vacío o no definido para Blog ID: " + entry.getEntryId() + ". Se asigna 'Noticia' por defecto.");
                return Arrays.asList("Noticia");
            }

            if (data instanceof String[]) {
                tipos = Arrays.asList((String[]) data);
                _log.debug("Expando 'Tipo Blog' obtenido como String[]: " + tipos);
            } else if (data instanceof String) {
                tipos = Arrays.stream(((String) data).split(","))
                        .map(String::trim) // Eliminamos espacios en los valores
                        .collect(Collectors.toList());
                _log.debug("Expando 'Tipo Blog' obtenido como String separado por comas: " + tipos);
            } else {
                _log.warn("Formato desconocido del Expando 'Tipo Blog' para Blog ID: " + entry.getEntryId());
                return Arrays.asList("Noticia"); // Devolver 'Lectura' por defecto si hay un error
            }
        } catch (Exception e) {
            _log.error("Error al obtener el Expando 'Tipo Blog' para Blog ID: " + entry.getEntryId(), e);
            return Arrays.asList("Noticia"); // En caso de error, devolver 'Lectura' por defecto
        }

        return tipos;
    }


    private Noticia getDataNoticia(ThemeDisplay td, BlogsEntry entry) {
        try {
            Noticia noticia = new Noticia();
            noticia.setTitulo(entry.getTitle());
            noticia.setUrl(td.getPortalURL() + "/es/b/" + entry.getUrlTitle());
            noticia.setFechaPublicacion(entry.getDisplayDate());

            // Obtener campo personalizado
            String customFieldValue = _expandoValueLocalService.getData(
                    entry.getCompanyId(),
                    BlogsEntry.class.getName(),
                    ExpandoTableConstants.DEFAULT_TABLE_NAME,
                    "source",
                    entry.getPrimaryKey(),
                    ""
            );

            // Manejar caso de valor vacío
            if (customFieldValue == null || customFieldValue.isEmpty()) {
                customFieldValue = entry.getUserName(); // Valor por defecto
            }

            noticia.setAutor(customFieldValue);

            if (entry.getCoverImageFileEntryId() > 0) {
                long coverImageFileEntryId = entry.getCoverImageFileEntryId();
                if(coverImageFileEntryId!=0){
                    FileEntry fileEntry = _DLAppLocalService.getFileEntry(coverImageFileEntryId);

                    String viewURL = DLURLHelperUtil.getPreviewURL(
                            fileEntry,
                            fileEntry.getFileVersion(),
                            td,
                            ""
                    );
                    noticia.setImagen(viewURL);
                }
            } else {
                noticia.setImagen("/o/blogs-web/images/cover_image_placeholder.jpg");
            }

            String trimmedContent = entry.getContent().trim();
            int wordCount = trimmedContent.isEmpty() ? 0 : trimmedContent.split("\\s+").length;
            int readingTime = (int) Math.ceil(wordCount / 200.0);
            noticia.setTiempoLectura(readingTime);

            List<AssetCategory> categories = _assetCategoryLocalService.getCategories(BlogsEntry.class.getName(), entry.getPrimaryKey());
            List<String> categoryNames = new ArrayList<>();
            List<String> categoryUrls = new ArrayList<>();

            for (AssetCategory category : categories) {
                categoryNames.add(category.getName());

                String categoryUrl = buildCategoryUrl(td, category);
                categoryUrls.add(categoryUrl);
            }
            noticia.setCategorias(categoryNames);
            noticia.setCategoryUrls(categoryUrls);

            return noticia;
        }catch (Exception e){
            return null;
        }
    }

    private String buildCategoryUrl(ThemeDisplay td, AssetCategory category) {
        try {
            AssetCategory parentCategory = category.getParentCategory();

            if (parentCategory != null) {
                String parentFriendlyUrl = normalizeText(parentCategory.getName().toLowerCase().replace(" ", "-"));
                String childFriendlyUrl = normalizeText(category.getName().toLowerCase().replace(" ", "-"));
                return td.getPortalURL() + "/es/actualidad/" + parentFriendlyUrl + "/" + childFriendlyUrl;
            } else {
                String friendlyUrl = normalizeText(category.getName().toLowerCase().replace(" ", "-"));
                return td.getPortalURL() + "/es/actualidad/" + friendlyUrl;
            }
        } catch (Exception e) {
            _log.error("Error al construir la URL para la categoría: " + category.getName(), e);
            return "#";
        }
    }

    public String normalizeText(String input) {
        if (input == null) {
            return null;
        }
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }
}
