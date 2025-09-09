package avanis.ayudas.subvenciones.util;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.ayudas.subvenciones.configuration.AyudasSubvencionesConfig;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Victor Antunez
 */
@Component(
    immediate = true,
    configurationPid = "avanis.ayudas.subvenciones.configuration.AyudasSubvencionesConfig",
    service = AyudasSubvencionesUtils.class
)
public class AyudasSubvencionesUtils {

    private static Log _log = LogFactoryUtil.getLog(AyudasSubvencionesUtils.class);

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    @Reference
    private AssetEntryLocalService _assetEntryLocalService;

    @Reference
    private AssetCategoryLocalService _assetCategoryLocalService;

    private volatile AyudasSubvencionesConfig _configuration;

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _configuration = Configurable.createConfigurable(AyudasSubvencionesConfig.class, properties);
    }

    public List<Map<String, Object>> obtenerDatosArticulos(ThemeDisplay themeDisplay) {
        List<Map<String, Object>> articlesData = new ArrayList<>();

        try {
            long groupId = themeDisplay.getScopeGroupId();
            long structureId = Long.valueOf(_configuration.structureId());

            List<JournalArticle> articles = _journalArticleLocalService.getArticlesByStructureId(groupId, structureId, -1, -1, null);

            for (JournalArticle article : articles) {
                String content = article.getContent();
                String articleUrl = "/w/" + article.getUrlTitle();

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new ByteArrayInputStream(content.getBytes("UTF-8")));

                Element rootElement = document.getDocumentElement();
                NodeList dynamicElements = rootElement.getElementsByTagName("dynamic-element");

                Map<String, Object> articleData = new HashMap<>();
                articleData.put("url", articleUrl);

                for (int i = 0; i < dynamicElements.getLength(); i++) {
                    Element element = (Element) dynamicElements.item(i);
                    String fieldReference = element.getAttribute("field-reference");

                    Node dynamicContentNode = element.getElementsByTagName("dynamic-content").item(0);
                    if (dynamicContentNode != null) {
                        String fieldValue = dynamicContentNode.getTextContent();

                        switch (fieldReference) {
                            case "entidad":
                                articleData.put("entidad", fieldValue);
                                break;
                            case "titulo":
                                articleData.put("titulo", fieldValue);
                                break;
                            case "descripcionCorta":
                                articleData.put("descripcionCorta", fieldValue);
                                break;
                            case "fechaInicioSolicitud":
                                articleData.put("fechaInicioSolicitud", fieldValue);
                                break;
                            case "fechaFinSolicitud":
                                articleData.put("fechaFinSolicitud", fieldValue);
                                break;
                            case "montos":
                                articleData.put("monto", fieldValue);
                                break;
                        }
                    }
                }

                String fechaInicioSolicitudStr = (String) articleData.get("fechaInicioSolicitud");
                String fechaFinSolicitudStr = (String) articleData.get("fechaFinSolicitud");

                if (Validator.isNotNull(fechaInicioSolicitudStr)) {
                    Date fechaInicioSolicitud = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicioSolicitudStr);
                    Date fechaActual = new Date();

                    if (fechaInicioSolicitud.after(fechaActual)) {
                        articleData.put("estado", "Proxima");
                    } else if (Validator.isNotNull(fechaFinSolicitudStr)) {
                        String estado = calcularEstado(fechaFinSolicitudStr);
                        articleData.put("estado", estado);
                    } else {
                        articleData.put("estado", "Activa");
                    }
                } else if (Validator.isNotNull(fechaFinSolicitudStr)) {
                    String estado = calcularEstado(fechaFinSolicitudStr);
                    articleData.put("estado", estado);
                } else {
                    articleData.put("estado", "Activa");
                }

                AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(JournalArticle.class.getName(), article.getResourcePrimKey());
                List<String> categoryNames = new ArrayList<>();

                if (assetEntry != null) {
                    for (long categoryId : assetEntry.getCategoryIds()) {
                        AssetCategory category = _assetCategoryLocalService.getAssetCategory(categoryId);
                        categoryNames.add(category.getName());
                    }
                } else {
                    _log.warn("No AssetEntry found for article with resourcePrimKey: " + article.getResourcePrimKey());
                }

                articleData.put("categories", categoryNames);

                articlesData.add(articleData);
            }

            // Ordenar las ayudas
            articlesData.sort(Comparator.comparing(article -> {
                String fechaFin = (String) article.get("fechaFinSolicitud");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return sdf.parse(fechaFin);
                } catch (Exception e) {
                    return new Date();
                }
            }));

        } catch (Exception e) {
            _log.error("Error al obtener datos de los artículos: ", e);
        }

        return articlesData;
    }


    public List<Map<String, Object>> obtenerDatosArticulosPorMes(ThemeDisplay themeDisplay, Integer mes, Integer anio) {
        List<Map<String, Object>> articlesData = new ArrayList();

        try {
            long groupId = themeDisplay.getScopeGroupId();
            long structureId = Long.valueOf(_configuration.structureId());

            // Obtener todos los artículos por estructura
            List<JournalArticle> articles = _journalArticleLocalService.getArticlesByStructureId(groupId, structureId, -1, -1, null);

            for (JournalArticle article : articles) {
                String content = article.getContent();
                String articleUrl = "/w/" + article.getUrlTitle();

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new ByteArrayInputStream(content.getBytes("UTF-8")));

                Element rootElement = document.getDocumentElement();
                NodeList dynamicElements = rootElement.getElementsByTagName("dynamic-element");

                Map<String, Object> articleData = new HashMap();
                articleData.put("url", articleUrl);

                for (int i = 0; i < dynamicElements.getLength(); i++) {
                    Element element = (Element) dynamicElements.item(i);
                    String fieldReference = element.getAttribute("field-reference");

                    Node dynamicContentNode = element.getElementsByTagName("dynamic-content").item(0);
                    if (dynamicContentNode != null) {
                        String fieldValue = dynamicContentNode.getTextContent();

                        switch (fieldReference) {
                            case "entidad":
                                articleData.put("entidad", fieldValue);
                                break;
                            case "titulo":
                                articleData.put("titulo", fieldValue);
                                break;
                            case "descripcionCorta":
                                articleData.put("descripcionCorta", fieldValue);
                                break;
                            case "fechaInicioSolicitud":
                                articleData.put("fechaInicioSolicitud", fieldValue);
                                break;
                            case "fechaFinSolicitud":
                                articleData.put("fechaFinSolicitud", fieldValue);
                                break;
                            case "montos":
                                articleData.put("monto", fieldValue);
                                break;
                        }
                    }
                }

                // Filtrar por mes y año si se proporcionan
                if (mes != null && anio != null) {
                    String fechaInicioStr = (String) articleData.get("fechaInicioSolicitud");
                    String fechaFinStr = (String) articleData.get("fechaFinSolicitud");

                    if (!isFechaEnRango(fechaInicioStr, fechaFinStr, mes, anio)) {
                        continue; // Excluir el artículo si no está en el rango
                    }
                }

                // Calcular estado
                String fechaInicioSolicitudStr = (String) articleData.get("fechaInicioSolicitud");
                String fechaFinSolicitudStr = (String) articleData.get("fechaFinSolicitud");

                if (Validator.isNotNull(fechaInicioSolicitudStr)) {
                    Date fechaInicioSolicitud = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicioSolicitudStr);
                    Date fechaActual = new Date();

                    if (fechaInicioSolicitud.after(fechaActual)) {
                        articleData.put("estado", "Proxima");
                    } else if (Validator.isNotNull(fechaFinSolicitudStr)) {
                        String estado = calcularEstado(fechaFinSolicitudStr);
                        articleData.put("estado", estado);
                    } else {
                        articleData.put("estado", "Activa");
                    }
                } else if (Validator.isNotNull(fechaFinSolicitudStr)) {
                    String estado = calcularEstado(fechaFinSolicitudStr);
                    articleData.put("estado", estado);
                } else {
                    articleData.put("estado", "Activa");
                }

                // Obtener categorías
                AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(JournalArticle.class.getName(), article.getResourcePrimKey());
                List<String> categoryNames = new ArrayList();

                if (assetEntry != null) {
                    for (long categoryId : assetEntry.getCategoryIds()) {
                        AssetCategory category = _assetCategoryLocalService.getAssetCategory(categoryId);
                        categoryNames.add(category.getName());
                    }
                } else {
                    _log.warn("No AssetEntry found for article with resourcePrimKey: " + article.getResourcePrimKey());
                }

                articleData.put("categories", categoryNames);

                articlesData.add(articleData);
            }

            // Ordenar las ayudas
            articlesData.sort(Comparator.comparing(article -> {
                String fechaFin = (String) article.get("fechaFinSolicitud");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return sdf.parse(fechaFin);
                } catch (Exception e) {
                    return new Date();
                }
            }));

        } catch (Exception e) {
            _log.error("Error al obtener datos de los artículos: ", e);
        }

        return articlesData;
    }
    private boolean isFechaEnRango(String fechaInicioStr, String fechaFinStr, int mes, int anio) {
        try {
            LocalDate inicioMes = LocalDate.of(anio, mes, 1);
            LocalDate finMes = inicioMes.withDayOfMonth(inicioMes.lengthOfMonth());

            LocalDate fechaInicio = fechaInicioStr != null ? LocalDate.parse(fechaInicioStr) : null;
            LocalDate fechaFin = fechaFinStr != null ? LocalDate.parse(fechaFinStr) : null;

            boolean empiezaEnRango = fechaInicio != null && !fechaInicio.isAfter(finMes);
            boolean terminaEnRango = fechaFin != null && !fechaFin.isBefore(inicioMes);

            return empiezaEnRango && terminaEnRango;
        } catch (Exception e) {
            _log.error("Error al verificar rango de fechas: ", e);
            return false;
        }
    }


    public String calcularEstado(String fechaFinSolicitudStr) {
        if (fechaFinSolicitudStr == null) {
            return "Activa";
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaFinSolicitud = dateFormat.parse(fechaFinSolicitudStr);
            Date fechaActual = new Date();
            long diferenciaEnMilisegundos = fechaFinSolicitud.getTime() - fechaActual.getTime();
            long diasParaVencimiento = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24);

            if (fechaFinSolicitud.before(fechaActual)) {
                return "Vencida";
            } else if (diasParaVencimiento <= 5) {
                return "Proxima a vencer";
            } else {
                return "Activa";
            }

        } catch (Exception e) {
            _log.error(e);
            return "Error";
        }
    }

    public String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return normalized.toLowerCase(Locale.ROOT);
    }
}
