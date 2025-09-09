package avanis.utils.impl;

import avanis.utils.api.util.CategoriasUtils;
import avanis.utils.configuration.AvanisConfiguration;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.text.Normalizer;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component(
    immediate=true,
    configurationPid = "avanis.utils.configuration.AvanisConfiguration",
    service= CategoriasUtils.class
)
public class CategoriasUtilsImpl implements CategoriasUtils {
    private static final Log _log = LogFactoryUtil.getLog(CategoriasUtilsImpl.class);

    private volatile AvanisConfiguration _avanisConfig;

    @Reference
    private AssetCategoryLocalService _assetCategoryLocalService;

    @Reference
    private ExpandoTableLocalService _expandoTableLocalService;

    @Reference
    private ExpandoColumnLocalService _expandoColumnLocalService;

    @Reference
    private ExpandoValueLocalService _expandoValueLocalService;

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _avanisConfig = ConfigurableUtil.createConfigurable(AvanisConfiguration.class, properties);
    }

    @Override
    public JSONArray getCategoriasUserDedications(boolean separator) {
        long vocabularyId = _avanisConfig.idVocabularioAUserDedications();

        List<AssetCategory> rootCategories = _assetCategoryLocalService.getVocabularyRootCategories(vocabularyId, -1, -1, null);

        JSONArray jsonCategorias = JSONFactoryUtil.createJSONArray();

        for (AssetCategory rootCategory : rootCategories) {
            JSONObject categoriaJson = JSONFactoryUtil.createJSONObject();
            categoriaJson.put("type", separator ? "separator" : "option");
            categoriaJson.put("name", rootCategory.getName());
            categoriaJson.put("id", rootCategory.getCategoryId());
            jsonCategorias.put(categoriaJson);
        }

        return jsonCategorias;
    }

    @Override
    public JSONArray getCategoriasHijaPorNombre(String nombreCategoriaPadre) {
        long vocabularyId = _avanisConfig.idVocabularioAvanis();

        AssetCategory categoriaPadre = null;
        List<AssetCategory> rootCategories = _assetCategoryLocalService.getVocabularyRootCategories(vocabularyId, -1, -1, null);

        for (AssetCategory rootCategory : rootCategories) {
            if (rootCategory.getName().equalsIgnoreCase(nombreCategoriaPadre)) {
                categoriaPadre = rootCategory;
                break;
            }
        }

        if (categoriaPadre == null) {
            _log.error("Categoría padre no encontrada: " + nombreCategoriaPadre);
            return JSONFactoryUtil.createJSONArray(); // Array vacío
        }

        List<AssetCategory> childCategories = _assetCategoryLocalService.getChildCategories(categoriaPadre.getCategoryId());

        JSONArray categoriasHijasJson = JSONFactoryUtil.createJSONArray();

        for (AssetCategory childCategory : childCategories) {
            try {
                JSONObject optionJson = JSONFactoryUtil.createJSONObject();
                optionJson.put("type", "option");
                optionJson.put("id", childCategory.getCategoryId());
                optionJson.put("name", childCategory.getName());
                categoriasHijasJson.put(optionJson);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        return categoriasHijasJson;
    }

    @Override
    public JSONArray getCategoriasAvanis(boolean separator) {
        long vocabularyId = _avanisConfig.idVocabularioAvanis();

        List<AssetCategory> rootCategories = _assetCategoryLocalService.getVocabularyRootCategories(vocabularyId, -1, -1, null);
        JSONArray categoriasJson = JSONFactoryUtil.createJSONArray();

        for (AssetCategory rootCategory : rootCategories) {
            JSONObject separatorJson = JSONFactoryUtil.createJSONObject();
            separatorJson.put("type", separator ? "separator" : "option");
            separatorJson.put("name", rootCategory.getName());
            separatorJson.put("id", rootCategory.getCategoryId());
            categoriasJson.put(separatorJson);

            List<AssetCategory> childCategories = _assetCategoryLocalService.getChildCategories(rootCategory.getCategoryId());
            for (AssetCategory childCategory : childCategories) {
                JSONObject optionJson = JSONFactoryUtil.createJSONObject();
                optionJson.put("type", "option");
                optionJson.put("id", childCategory.getCategoryId());
                optionJson.put("name", childCategory.getName());
                categoriasJson.put(optionJson);
            }
        }

        return categoriasJson;
    }

    @Override
    public JSONArray getCategoriasBlogs(boolean separator) {
        JSONArray categoriasJson = JSONFactoryUtil.createJSONArray();
        Map<Long, Set<Long>> parentToChildMap = new HashMap<>();
        Set<Long> categoryIdsInBlogs = new HashSet<>();

        try {
            QueryDefinition<BlogsEntry> queryDefinition = new QueryDefinition<>();
            queryDefinition.setStatus(WorkflowConstants.STATUS_APPROVED);
            List<BlogsEntry> approvedBlogs = BlogsEntryLocalServiceUtil.getGroupEntries(
                    _avanisConfig.groupId(), new Date(), queryDefinition);

            for (BlogsEntry blog : approvedBlogs) {
                try {
                    List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getCategories(
                            BlogsEntry.class.getName(), blog.getEntryId());
                    for (AssetCategory category : categories) {
                        categoryIdsInBlogs.add(category.getCategoryId());
                        long parentCategoryId = category.getParentCategoryId();

                        if (parentCategoryId != 0) {
                            parentToChildMap.computeIfAbsent(parentCategoryId, k -> new HashSet<>()).add(category.getCategoryId());
                        }
                    }
                } catch (Exception e) {
                    _log.error("Error al obtener las categorías para el blog con ID: " + blog.getEntryId(), e);
                }
            }

            for (Long parentId : parentToChildMap.keySet()) {
                if (parentId != 0) {
                    AssetCategory parentCategory = AssetCategoryLocalServiceUtil.getCategory(parentId);
                    JSONObject separatorJson = JSONFactoryUtil.createJSONObject();
                    separatorJson.put("type", separator ? "separator" : "option");
                    separatorJson.put("name", parentCategory.getName());
                    separatorJson.put("id", parentCategory.getCategoryId());
                    categoriasJson.put(separatorJson);
                }

                for (Long childId : parentToChildMap.get(parentId)) {
                    if (categoryIdsInBlogs.contains(childId)) {
                        AssetCategory childCategory = AssetCategoryLocalServiceUtil.getCategory(childId);
                        JSONObject optionJson = JSONFactoryUtil.createJSONObject();
                        optionJson.put("type", "option");
                        optionJson.put("name", childCategory.getName());
                        optionJson.put("id", childCategory.getCategoryId());
                        categoriasJson.put(optionJson);
                    }
                }
            }
        } catch (Exception e) {
            _log.error("Error al obtener los blogs aprobados: ", e);
        }

        return categoriasJson;
    }

    @Override
    public JSONArray getCategoriasBlogsMasFiltros(boolean separator) {
        JSONArray categoriasJson = JSONFactoryUtil.createJSONArray();
        Map<Long, Set<Long>> parentToChildMap = new HashMap<>();
        Set<Long> categoryIdsInBlogs = new HashSet<>();

        try {
            long companyId = PortalUtil.getDefaultCompanyId();
            ExpandoTable expandoTable = _expandoTableLocalService.getDefaultTable(companyId, BlogsEntry.class.getName());
            List<ExpandoColumn> expandoColumns = _expandoColumnLocalService.getColumns(expandoTable.getTableId());

            if (ListUtil.isNotEmpty(expandoColumns)) {
                for (ExpandoColumn column : expandoColumns) {
                    String fieldName = column.getName();
                    String options = column.getDefaultData();

                    if (options != null && !options.isEmpty() && fieldName.equalsIgnoreCase("Tipo Blog")) {
                        JSONObject parentCustomFieldJson = JSONFactoryUtil.createJSONObject();
                        parentCustomFieldJson.put("type", separator ? "separator" : "option");
                        parentCustomFieldJson.put("name", "Tipo");
                        parentCustomFieldJson.put("id", "Tipo");
                        categoriasJson.put(parentCustomFieldJson);

                        for (String option : options.split(",")) {
                            JSONObject optionJson = JSONFactoryUtil.createJSONObject();
                            optionJson.put("type", "option");
                            optionJson.put("name", option.trim());
                            optionJson.put("id", "tipo_"+option.trim());
                            categoriasJson.put(optionJson);
                        }
                        break;
                    }
                }
            }

            String fechasConfig = _avanisConfig.fechasFiltroBuscador();
            if (fechasConfig != null && !fechasConfig.isEmpty()) {
                JSONObject fechaSeparatorJson = JSONFactoryUtil.createJSONObject();
                fechaSeparatorJson.put("type", separator ? "separator" : "option");
                fechaSeparatorJson.put("name", "Fecha");
                fechaSeparatorJson.put("id", "Fecha");
                categoriasJson.put(fechaSeparatorJson);

                for (String fechaStr : fechasConfig.split(",")) {
                    int dias = Integer.parseInt(fechaStr.trim());
                    String nombreFiltro = generarNombreFiltro(dias);

                    JSONObject fechaJson = JSONFactoryUtil.createJSONObject();
                    fechaJson.put("type", "option");
                    fechaJson.put("name", nombreFiltro);
                    fechaJson.put("id", "fecha_"+dias);
                    categoriasJson.put(fechaJson);
                }
            }

            QueryDefinition<BlogsEntry> queryDefinition = new QueryDefinition<>();
            queryDefinition.setStatus(WorkflowConstants.STATUS_APPROVED);
            List<BlogsEntry> approvedBlogs = BlogsEntryLocalServiceUtil.getGroupEntries(
                    _avanisConfig.groupId(), new Date(), queryDefinition);

            for (BlogsEntry blog : approvedBlogs) {
                try {
                    List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getCategories(
                            BlogsEntry.class.getName(), blog.getEntryId());
                    for (AssetCategory category : categories) {
                        categoryIdsInBlogs.add(category.getCategoryId());
                        long parentCategoryId = category.getParentCategoryId();

                        if (parentCategoryId != 0) {
                            parentToChildMap.computeIfAbsent(parentCategoryId, k -> new HashSet<>()).add(category.getCategoryId());
                        }
                    }
                } catch (Exception e) {
                    _log.error("Error al obtener las categorías para el blog con ID: " + blog.getEntryId(), e);
                }
            }

            for (Long parentId : parentToChildMap.keySet()) {
                if (parentId != 0) {
                    AssetCategory parentCategory = AssetCategoryLocalServiceUtil.getCategory(parentId);
                    JSONObject separatorJson = JSONFactoryUtil.createJSONObject();
                    separatorJson.put("type", separator ? "separator" : "option");
                    separatorJson.put("name", parentCategory.getName());
                    separatorJson.put("id", parentCategory.getCategoryId());
                    categoriasJson.put(separatorJson);
                }

                for (Long childId : parentToChildMap.get(parentId)) {
                    if (categoryIdsInBlogs.contains(childId)) {
                        AssetCategory childCategory = AssetCategoryLocalServiceUtil.getCategory(childId);
                        JSONObject optionJson = JSONFactoryUtil.createJSONObject();
                        optionJson.put("type", "option");
                        optionJson.put("name", childCategory.getName());
                        optionJson.put("id", childCategory.getCategoryId());
                        categoriasJson.put(optionJson);
                    }
                }
            }
        } catch (Exception e) {
            _log.error("Error al obtener los blogs aprobados: ", e);
        }

        return categoriasJson;
    }

    @Override
    public long getVocabularioAvanis() {
        return _avanisConfig.idVocabularioAvanis();
    }

    @Override
    public boolean mostrarTitulosBuscador() {
        return Boolean.parseBoolean(_avanisConfig.mostrarTitulosBuscador());
    }

    @Override
    public JSONArray getUrlsCategoriaByArticleId(long articleId) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        List<AssetCategory> categories = _assetCategoryLocalService.getCategories(
                BlogsEntry.class.getName(), articleId);

        for (AssetCategory category : categories) {
            String categoryUrl = buildCategoryUrl(category);

            JSONObject categoryJson = JSONFactoryUtil.createJSONObject();
            categoryJson.put("categoria", category.getName());
            categoryJson.put("url", categoryUrl);

            jsonArray.put(categoryJson);
        }

        return jsonArray;
    }

    private String buildCategoryUrl(AssetCategory category) {
        try {
            AssetCategory parentCategory = category.getParentCategory();

            if (parentCategory != null) {
                String parentFriendlyUrl = normalizeText(parentCategory.getName().toLowerCase().replace(" ", "-"));
                String childFriendlyUrl = normalizeText(category.getName().toLowerCase().replace(" ", "-"));
                return _avanisConfig.urlSitio() + "actualidad/" + parentFriendlyUrl + "/" + childFriendlyUrl;
            } else {
                String friendlyUrl = normalizeText(category.getName().toLowerCase().replace(" ", "-"));
                return _avanisConfig.urlSitio() + "actualidad/" + friendlyUrl;
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

    private String generarNombreFiltro(int dias) {
        if (dias == 0) {
            return "Hoy";
        } else if (dias == 1) {
            return "Ayer";
        } else if (dias == 7) {
            return "Últimos 7 días";
        } else if (dias == 30) {
            return "Últimos 30 días";
        } else if (dias == 60) {
            return "Últimos 60 días";
        } else if (dias == 90) {
            return "Últimos 90 días";
        } else if (dias == 365) {
            return "Últimos 365 días";
        } else {
            return "Últimos " + dias + " días"; // Para valores personalizados
        }
    }
}
