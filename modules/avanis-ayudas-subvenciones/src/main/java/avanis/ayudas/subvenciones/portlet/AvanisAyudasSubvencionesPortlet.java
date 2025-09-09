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
import com.liferay.portal.kernel.util.Validator;
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
import java.util.*;
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
		"javax.portlet.display-name=Ayudas y Subvenciones",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisAyudasSubvencionesPortletKeys.AVANISAYUDASSUBVENCIONES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	configurationPid = "avanis.ayudas.subvenciones.configuration.AyudasSubvencionesConfig",
	service = Portlet.class
)
public class AvanisAyudasSubvencionesPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(AvanisAyudasSubvencionesPortlet.class);

	@Reference
	private AssetEntryLocalService _assetEntryLocalService;

	@Reference
	private AssetCategoryLocalService _assetCategoryLocalService;

	@Reference
	private AyudasSubvencionesUtils _ayudasSubvencionesUtils;

	@Reference
	private AyudasCacheUtil _ayudasCacheUtil;

	private volatile AyudasSubvencionesConfig _configuration;

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_configuration = Configurable.createConfigurable(AyudasSubvencionesConfig.class, properties);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String cacheKey = "ayudas_user_" + user.getUserId();

		// Intentamos obtener los datos desde la caché
		List<Map<String, Object>> cachedArticles = (List<Map<String, Object>>) AyudasCacheUtil.getFromCache(cacheKey);
		if (cachedArticles != null) {
			renderRequest.setAttribute("articlesData", cachedArticles);
			super.doView(renderRequest, renderResponse);
			return;
		}

		// Si no hay caché:
		List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(user.getUserId());
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

		List<String> categoryNameList = new ArrayList<>(uniqueCategories);
		List<String> misPreferenciasNormalizadas = categoryNameList.stream()
				.map(this::normalizeString)
				.collect(Collectors.toList());

		long groupId = themeDisplay.getScopeGroupId();
		long structureId = Long.valueOf(_configuration.structureId());
		List<Map<String, Object>> articlesData = new ArrayList<>();
		List<Map<String, Object>> filteredArticlesData = new ArrayList<>();

		try {
			List<JournalArticle> articles = JournalArticleLocalServiceUtil.getArticlesByStructureId(groupId, structureId, -1, -1, null);

			for (JournalArticle article : articles) {
				String content = article.getContent();
				String articleUrl = "/w/" + article.getUrlTitle();

				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.parse(new java.io.ByteArrayInputStream(content.getBytes("UTF-8")));

				Element rootElement = document.getDocumentElement();
				NodeList dynamicElements = rootElement.getElementsByTagName("dynamic-element");

				Map<String, Object> articleData = new HashMap<>();
				articleData.put("url", articleUrl);
				for (int i = 0; i < dynamicElements.getLength(); i++) {
					Node dynamicElement = dynamicElements.item(i);

					if (dynamicElement.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) dynamicElement;
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
								case "fechaFinSolicitud":
									articleData.put("fechaFinSolicitud", fieldValue);
									break;
								case "fechaInicioSolicitud":
									articleData.put("fechaInicioSolicitud", fieldValue);
									break;
							}
						}
					}
				}

				long classPK = article.getResourcePrimKey();
				AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(JournalArticle.class.getName(), classPK);
				if (assetEntry != null) {
					long[] categoryIds = assetEntry.getCategoryIds();

					List<String> categoryNames = new ArrayList<>();
					for (long categoryId : categoryIds) {
						AssetCategory category = _assetCategoryLocalService.getAssetCategory(categoryId);
						categoryNames.add(category.getName());
					}

					List<String> categoryNamesNormalizadas = categoryNames.stream()
							.map(this::normalizeString)
							.collect(Collectors.toList());

					articleData.put("categories", categoryNames);

					if (!misPreferenciasNormalizadas.isEmpty()) {
						boolean matchesPreference = categoryNamesNormalizadas.stream().anyMatch(misPreferenciasNormalizadas::contains);
						if (matchesPreference) {
							filteredArticlesData.add(articleData);
						}
					}
				}

				String fechaInicioSolicitudStr = (String) articleData.get("fechaInicioSolicitud");
				boolean estadoCalculado = false; // Bandera para evitar doble cálculo

				if (Validator.isNotNull(fechaInicioSolicitudStr)) {
					Date fechaInicioSolicitud = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicioSolicitudStr);
					Date fechaActual = new Date();

					if (fechaInicioSolicitud.after(fechaActual)) {
						String estado = "<span class='etiqueta etiqueta-vence'>Próxima</span>";
						articleData.put("estado", estado);
						String estadoPuntitos = "punto-naranja";
						articleData.put("estadoPuntitos", estadoPuntitos);
						estadoCalculado = true;
					}
				}

				String fechaFinSolicitudStr = (String) articleData.get("fechaFinSolicitud");
				if (!estadoCalculado && Validator.isNotNull(fechaFinSolicitudStr)) {
					Date fechaFinSolicitud = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFinSolicitudStr);
					Date fechaActual = new Date();

					String estado = calcularEstado(fechaFinSolicitud, fechaActual);
					articleData.put("estado", estado);
					String estadoPuntitos = calcularEstadoPuntitos(fechaFinSolicitud, fechaActual);
					articleData.put("estadoPuntitos", estadoPuntitos);
				}

				articlesData.add(articleData);
			}

			articlesData.sort((a, b) -> Integer.compare(
					getPrioridadEstado((String) a.get("estado")),
					getPrioridadEstado((String) b.get("estado"))
			));

			filteredArticlesData = articlesData.stream()
					.filter(article -> {
						String estado = (String) article.get("estado");
						return estado.contains("Activa") || estado.contains("Próxima") || estado.contains("Vence pronto");
					})
					.limit(2)
					.collect(Collectors.toList());

		} catch (Exception e) {
			_log.error(e);
		}

		// Guardamos en caché la información obtenida
		AyudasCacheUtil.addToCache(cacheKey, filteredArticlesData);

		renderRequest.setAttribute("articlesData", filteredArticlesData);
		super.doView(renderRequest, renderResponse);
	}


	// Método para asignar prioridad a los estados
	private int getPrioridadEstado(String estado) {
		if (estado.contains("Activa")) {
			return 1; // Prioridad más alta
		} else if (estado.contains("Próxima")) {
			return 2; // Prioridad intermedia
		} else if (estado.contains("Vence pronto")) {
			return 3; // Prioridad más baja
		}
		return 4; // Por defecto, prioridad más baja para otros estados
	}

	private String calcularEstado(Date fechaFinSolicitud, Date fechaActual) {
		long diferenciaEnDias = (fechaFinSolicitud.getTime() - fechaActual.getTime()) / (1000 * 60 * 60 * 24);
		if (diferenciaEnDias < 0) {
			return "<span class='etiqueta etiqueta-vencida'>Vencida</span>";
		} else if (diferenciaEnDias <= 7) {
			return "<span class='etiqueta etiqueta-vence'>Vence pronto</span>";
		} else {
			return "<span class='etiqueta etiqueta-activa'>Activa</span>";
		}
	}

	private String calcularEstadoPuntitos(Date fechaFinSolicitud, Date fechaActual) {
		long diferenciaEnDias = (fechaFinSolicitud.getTime() - fechaActual.getTime()) / (1000 * 60 * 60 * 24);

		if (diferenciaEnDias < 0) {
			return "<span class='etiqueta etiqueta-vencida'>Vencida</span>";
		} else if (diferenciaEnDias <= 7) {
			return "punto-naranja";
		} else {
			return "punto-verde";
		}
	}

	private String normalizeString(String input) {
		return _ayudasSubvencionesUtils.normalizeString(input);
	}
}
