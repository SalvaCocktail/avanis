package avanis.ayudas.subvenciones.portlet;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.ayudas.subvenciones.cache.AyudasCacheUtil;
import avanis.ayudas.subvenciones.configuration.AyudasSubvencionesConfig;
import avanis.ayudas.subvenciones.constants.AvanisAyudasSubvencionesPortletKeys;
import avanis.ayudas.subvenciones.util.AyudasSubvencionesUtils;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Victor Antunez
 */
@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=avanis",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=Ayudas y Subvenciones General",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/ayudasView.jsp",
        "javax.portlet.name=" + AvanisAyudasSubvencionesPortletKeys.AVANISAYUDASSUBVENCIONESGENERAL,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    configurationPid = "avanis.ayudas.subvenciones.configuration.AyudasSubvencionesConfig",
    service = Portlet.class
)
public class AvanisAyudasSubvencionesGeneralPortlet extends MVCPortlet {
    private static final Log _log = LogFactoryUtil.getLog(AvanisAyudasSubvencionesPortlet.class);

    @Reference
    private AssetEntryLocalService _assetEntryLocalService;

    @Reference
    private AssetCategoryLocalService _assetCategoryLocalService;

    @Reference
    private AyudasSubvencionesUtils _ayudasSubvencionesUtils;

    private volatile AyudasSubvencionesConfig _configuration;

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _configuration = Configurable.createConfigurable(AyudasSubvencionesConfig.class, properties);
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        String cacheKeyAllAyudas = "all_ayudas";
        List<Map<String, Object>> allAyudas = (List<Map<String, Object>>) AyudasCacheUtil.getFromCache(cacheKeyAllAyudas);

        if (allAyudas == null) {
            allAyudas = _ayudasSubvencionesUtils.obtenerDatosArticulos(themeDisplay);
            AyudasCacheUtil.addToCache(cacheKeyAllAyudas, allAyudas);
            _log.info("Ayudas almacenadas en caché con clave: " + cacheKeyAllAyudas);
        } else {
            _log.info("Ayudas obtenidas de la caché.");
        }
        renderRequest.setAttribute("allAyudas", allAyudas);

        String cacheKeyMisAyudas = "mis_ayudas_general";
        List<Map<String, Object>> misAyudas = (List<Map<String, Object>>) AyudasCacheUtil.getFromCache(cacheKeyMisAyudas);

        if (misAyudas == null) {
            try {
                misAyudas = obtenerAyudasDeExplotacion(themeDisplay);
                AyudasCacheUtil.addToCache(cacheKeyMisAyudas, misAyudas);
            } catch (Exception e) {
                _log.error("Error obteniendo ayudas personales.", e);
                throw new RuntimeException(e);
            }
        }
        renderRequest.setAttribute("misAyudas", misAyudas);

        String urlsessionGoogle = PropsUtil.get("google.login.url");
        renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);

        super.doView(renderRequest, renderResponse);
    }

    private List<Map<String, Object>> obtenerAyudasDeExplotacion(ThemeDisplay themeDisplay) throws Exception {
        List<Map<String, Object>> allAyudas = _ayudasSubvencionesUtils.obtenerDatosArticulos(themeDisplay);
        List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.getExplotacions(-1, -1); // Obtener todas las explotaciones

        Set<String> uniqueCategories = new HashSet<>();
        explotaciones.forEach(explotacion -> {
            AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(Explotacion.class.getName(), explotacion.getExplotacionId());
            if (assetEntry != null) {
                assetEntry.getCategories().forEach(category -> {
                    try {
                        AssetCategory assetCategory = _assetCategoryLocalService.getAssetCategory(category.getCategoryId());
                        uniqueCategories.add(assetCategory.getName());
                    } catch (Exception e) {
                        _log.error("Error obteniendo la categoría: " + e.getMessage());
                    }
                });
            }
        });

        List<String> categoriasNormalizadas = uniqueCategories.stream()
                .map(this::normalizeString)
                .collect(Collectors.toList());

        return allAyudas.stream()
                .filter(ayuda -> {
                    List<String> categoriasAyuda = (List<String>) ayuda.get("categories");
                    List<String> categoriasNormalizadasAyuda = categoriasAyuda.stream()
                            .map(this::normalizeString)
                            .collect(Collectors.toList());
                    return categoriasNormalizadasAyuda.stream().anyMatch(categoriasNormalizadas::contains);
                })
                .collect(Collectors.toList());
    }

    private String normalizeString(String input) {
        return _ayudasSubvencionesUtils.normalizeString(input);
    }
}
