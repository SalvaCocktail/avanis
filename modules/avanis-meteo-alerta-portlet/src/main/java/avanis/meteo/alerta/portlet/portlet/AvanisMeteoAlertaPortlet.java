package avanis.meteo.alerta.portlet.portlet;

import avanis.comunidad.portlet.util.AvanisComunidadUtil;
import avanis.meteo.alerta.portlet.constants.AvanisMeteoAlertaPortletKeys;
import avanis.meteo.alerta.portlet.portlet.util.AvanisMeteoAlertaUtil;
import avanis.tu.explotacion.sb.exception.NoSuchExplotacionException;
import avanis.tu.explotacion.sb.model.Alertas;
import avanis.tu.explotacion.sb.model.ExplotacionModel;
import avanis.tu.explotacion.sb.model.impl.AlertasImpl;
import avanis.tu.explotacion.sb.service.AlertasLocalServiceUtil;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.petra.process.EchoOutputProcessor;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import avanis.tu.explotacion.sb.model.Explotacion;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import model.MeteoredWarning;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import services.MeteoredService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: noemizarco
 */
@Component(
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=AvanisMeteoAlerta",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + AvanisMeteoAlertaPortletKeys.AVANISMETEOALERTA,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class AvanisMeteoAlertaPortlet extends MVCPortlet {

	@Reference
	private MeteoredService meteoredService;
	private static Log _log = LogFactoryUtil.getLog(AvanisMeteoAlertaPortlet.class);

	private static final DecimalFormat COORD_DECIMAL_FORMAT = new DecimalFormat("#.#######");

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User principal = themeDisplay.getUser();
		boolean isLoggedIn = themeDisplay.isSignedIn();

		renderRequest.setAttribute("isLoggedIn", isLoggedIn);

		if (isLoggedIn) {
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserIdReaded(principal.getUserId(), false);

			if (explotaciones.isEmpty()) {
				renderRequest.setAttribute("noPlotsAvailable", true);
			} else {
				Map<Long, List<MeteoredWarning>> warningsByExplotacion = new HashMap<>();
				List<MeteoredWarning> allWarningsToday = new ArrayList<>();
				renderRequest.setAttribute("plots", explotaciones);

				for (Explotacion plot : explotaciones) {
					if (plot.getAllowNotifications()) {
						String latitude = formatCoord(plot.getLatitude());
						String longitude = formatCoord(plot.getLongitude());

						List<MeteoredWarning> warningsToday = meteoredService.getWarningsForTodayByCoords(latitude, longitude)
								.stream()
								.filter(warning -> !warning.getRisk().equals("yellow"))
								.collect(Collectors.toList());

						sendNotifications(renderRequest, plot, warningsToday);

						allWarningsToday.addAll(warningsToday);

						// Agregar advertencias al mapa por explotacionId
						warningsByExplotacion.put(plot.getExplotacionId(), new ArrayList<>(warningsToday));
					}
				}

				// Recoger las alertas del usuario
				List<Alertas> alertas = AlertasLocalServiceUtil.findByUserId(principal.getUserId());
				Set<MeteoredWarning> filteredWarningsToday = new HashSet<>();

				// Eliminar advertencias duplicadas
				for (MeteoredWarning warning : allWarningsToday) {
					boolean isDuplicate = alertas.stream().anyMatch(alerta ->
							alerta.getUserId() == principal.getUserId() &&
									alerta.getReaded() &&
									alerta.getExplotacionId() == alertas.get(0).getExplotacionId() &&
									alerta.getPhenomenom().equals(warning.getPhenomenon()) &&
									alerta.getScope().equals(warning.getScope()) &&
									alerta.getStartDate().equals(String.valueOf(warning.getStart())) &&
									alerta.getEndDate().equals(String.valueOf(warning.getEnd())) &&
									alerta.getProbability().equals(warning.getProbability()) &&
									alerta.getDescription().equals(warning.getDescription()) &&
									alerta.getRisk().equals(warning.getRisk())
					);
					if (!isDuplicate) {
						filteredWarningsToday.add(warning);
					}
				}

				// Ordenar advertencias por prioridad de riesgo
				Comparator<MeteoredWarning> riskComparator = Comparator.comparingInt(this::getRiskPriority);
				List<MeteoredWarning> sortedFilteredWarningsToday = filteredWarningsToday.stream()
						.sorted(riskComparator)
						.collect(Collectors.toList());

				Map<Long, List<MeteoredWarning>> filteredWarningsByExplotacion = new HashMap<>();

				warningsByExplotacion.forEach((explotacionId, warningsForExplotacion) -> {
					List<MeteoredWarning> filteredWarningsForExplotacion = warningsForExplotacion.stream()
							.filter(sortedFilteredWarningsToday::contains)
							.collect(Collectors.toList());

					filteredWarningsByExplotacion.put(explotacionId, filteredWarningsForExplotacion);
				});

				// Enviar advertencias al JSP
				renderRequest.setAttribute("meteoredWarningsToday", sortedFilteredWarningsToday);
				renderRequest.setAttribute("warningsByExplotacion", filteredWarningsByExplotacion);
			}

			renderRequest.setAttribute("actualUserId", principal.getUserId());
		}

		super.doView(renderRequest, renderResponse);
	}

	private static void sendNotifications(RenderRequest renderRequest, Explotacion plot, List<MeteoredWarning> waningsToday) {
			for (MeteoredWarning warning : waningsToday) {
				String phenomenon = warning.getPhenomenon();
				String location = getLocationAndProvinceFromCoordinates(String.valueOf(plot.getLatitude()),
						String.valueOf(plot.getLongitude()));
				String bodyAlerta = warning.getDescription();
				String prob = warning.getProbability();
				AvanisComunidadUtil.sendPlotsNotification(plot, renderRequest, phenomenon, location, bodyAlerta, prob);
			}
	}

	private Explotacion getFocusedPlot(List<Explotacion> explotaciones, Long plotId) throws NoSuchExplotacionException {
		if (plotId != null) {
			return explotaciones.stream().filter(explotacion -> explotacion.getExplotacionId() == plotId).findFirst().orElse(getMainPlot(explotaciones));
		} else {
			return getMainPlot(explotaciones);
		}
	}

	private Explotacion getMainPlot(List<Explotacion> explotaciones) {
		return explotaciones.stream()
				.filter(ExplotacionModel::isIsMain)
				.findFirst()
				.orElse(explotaciones.get(0));
	}

	private String formatCoord(Double coord) {
		return COORD_DECIMAL_FORMAT.format(coord).replace(",", ".");
	}

	private Long parseId(String id) {
		try {
			return Long.parseLong(id);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private int getRiskPriority(MeteoredWarning warning) {
		switch (warning.getRisk()) {
			case "red":
				return 1;
			case "orange":
				return 2;
			case "yellow":
				return 3;
			default:
				return 4;
		}
	}

	private static String getLocationAndProvinceFromCoordinates(String latitude, String longitude) {
		String location = "";
		String province = "";
		String urlString = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + latitude + "&lon=" + longitude + "&addressdetails=1";

		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}

			reader.close();
			JSONObject json = JSONFactoryUtil.createJSONObject(response.toString());
			JSONObject address = json.getJSONObject("address");

			if (address != null) {
				// Obtener provincia
				String provinceResult = address.getString("province", null);
				String town = address.getString("town", null);
				String city = address.getString("city", null);
				String locality = address.getString("locality", null);
				String village = address.getString("village", null);

				province = (provinceResult != null) ? provinceResult :
						(town != null) ? town :
								(city != null) ? city :
										(locality != null) ? locality :
												(village != null) ? village : "";

				String locationResult = address.getString("town", null);

				location = (locationResult != null) ? locationResult :
								(city != null) ? city :
										(locality != null) ? locality :
												(village != null) ? village : "";
			}

		} catch (Exception e) {
			_log.error("Error fetching location and province from coordinates", e);
		}

		return location + ", " + province;
	}

}
