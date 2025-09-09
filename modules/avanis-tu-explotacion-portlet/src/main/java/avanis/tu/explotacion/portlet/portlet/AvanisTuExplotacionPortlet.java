package avanis.tu.explotacion.portlet.portlet;

import avanis.tu.explotacion.portlet.constants.AvanisTuExplotacionPortletKeys;

import avanis.tu.explotacion.sb.model.Alertas;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.model.ExplotacionModel;
import avanis.tu.explotacion.sb.service.AlertasLocalServiceUtil;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import model.MeteoredDailyForecast;
import model.MeteoredForecastWrapper;
import model.MeteoredHourlyForecast;
import model.MeteoredWarning;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import services.MeteoredService;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author angelperez
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AvanisTuExplotacion",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AvanisTuExplotacionPortletKeys.AVANISTUEXPLOTACION,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AvanisTuExplotacionPortlet extends MVCPortlet {

    @Reference
    private MeteoredService meteoredService;

    private static final DecimalFormat COORD_DECIMAL_FORMAT = new DecimalFormat("#.#######");


    private static Log _log = LogFactoryUtil.getLog(avanis.tu.explotacion.portlet.portlet.AvanisTuExplotacionPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

        Long plotId = parseId(httpReq.getParameter("plotId"));
        Integer dayNumber = parseDayNumber(httpReq.getParameter("dayNumber"));

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();
        boolean isLoggedIn = themeDisplay.isSignedIn();

        renderRequest.setAttribute("isLoggedIn", isLoggedIn);

        if (isLoggedIn) {
            List<Explotacion> explotaciones = null;
            try {
                explotaciones = ExplotacionLocalServiceUtil.findByUserId(principal.getUserId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (!explotaciones.isEmpty()) {
                loadMeteoOfAllPlots(explotaciones, renderRequest);
                loadMeteoOfFocusedPlot(getFocusedPlot(explotaciones, plotId), dayNumber, renderRequest);

                renderRequest.setAttribute("plots", explotaciones);
                renderRequest.setAttribute("dayNumber", dayNumber);
                renderRequest.setAttribute("plots", explotaciones);
            }
        }

        super.doView(renderRequest, renderResponse);
    }



    private Explotacion getFocusedPlot(List<Explotacion> explotaciones, Long plotId) {
        if (plotId != null) {
            return explotaciones.stream().filter(explotacion -> explotacion.getExplotacionId() == plotId).findFirst().orElse(getMainPlot(explotaciones));
        } else {
            return getMainPlot(explotaciones);
        }
    }

    private Explotacion getMainPlot(List<Explotacion> explotaciones) {
        return explotaciones.stream().filter(ExplotacionModel::isIsMain).findFirst().orElse(explotaciones.get(0));
    }

    private void loadMeteoOfFocusedPlot(Explotacion focusedPlot, Integer dayNumber, RenderRequest renderRequest) {
        String latitude = formatCoord(focusedPlot.getLatitude());
        String longitude = formatCoord(focusedPlot.getLongitude());

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        AtomicReference<MeteoredForecastWrapper<MeteoredDailyForecast>> dailyForecasts = new AtomicReference<>();
        AtomicReference<MeteoredForecastWrapper<MeteoredHourlyForecast>> hourlyForecasts = new AtomicReference<>();


        CompletableFuture<Void> futureDailyForecasts = meteoredService.getDailyForecastByCoords(latitude, longitude, focusedPlot.getHeight().toString(), "es")
                .thenAccept(dailyForecasts::set);

        CompletableFuture<Void> futureHourlyForecasts = meteoredService.getHourlyForecastByDayCoords(dayNumber, latitude, longitude, focusedPlot.getHeight().toString(), "es")
                .thenAccept(hourlyForecasts::set);


        List<Integer> nextDays = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<CompletableFuture<List<MeteoredWarning>>> futureWarnings = nextDays.stream().map(day -> meteoredService.getWarningsForNextDaysByCoords(day, latitude, longitude)).collect(Collectors.toList());

        futures.add(futureDailyForecasts);
        futures.add(futureHourlyForecasts);

        CompletableFuture<Void> allOfFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOfFutures.join();

        List<MeteoredWarning> meteoredWanings = futureWarnings.stream().map(CompletableFuture::join).flatMap(List::stream).collect(Collectors.toList());


        renderRequest.setAttribute("focusedPlot", focusedPlot);
        renderRequest.setAttribute("hour", dayNumber == 1 ? 0 : getHourOfFocusedPlot(dayNumber));
        
        if (dayNumber == 1) {
            Integer hour = getHourOfFocusedPlot(dayNumber);
            MeteoredForecastWrapper<MeteoredHourlyForecast> meteoredForecastWrapper = hourlyForecasts.get();
            List<MeteoredHourlyForecast> allHours = hourlyForecasts.get().getMeteoredForecasts();
            List<MeteoredHourlyForecast> filteredHours = hourlyForecasts.get().getMeteoredForecasts().subList(hour, allHours.size());

            meteoredForecastWrapper.setMeteoredForecasts(filteredHours);

            renderRequest.setAttribute("hourlyForecasts", meteoredForecastWrapper);
        } else {
            renderRequest.setAttribute("hourlyForecasts", hourlyForecasts.get());
        }

        renderRequest.setAttribute("dailyForecasts", dailyForecasts.get());
        renderRequest.setAttribute("meteoredWanings", meteoredWanings);

    }

    private Integer getHourOfFocusedPlot(Integer dayNumber) {
        Integer hour = 12;
        if (dayNumber > 3) {
            hour = 4;
        } else if (dayNumber == 1) {
            ZoneId spainZone = ZoneId.of("Europe/Madrid");
            ZonedDateTime now = ZonedDateTime.now(spainZone);
            hour = now.getHour();
        }

        return hour;
    }

    private void loadMeteoOfAllPlots(List<Explotacion> explotaciones, RenderRequest renderRequest) {
        Map<Long, MeteoredForecastWrapper<MeteoredHourlyForecast>> mapHourlyForecast = new HashMap<>();
        Map<Long, Integer> mapWarningsToday = new HashMap<>();
        Map<Long, MeteoredHourlyForecast> mapCurrentForecast = new HashMap<>();
        Map<Long, MeteoredDailyForecast> mapTodayDailyForecast = new HashMap<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        ZoneId spainZone = ZoneId.of("Europe/Madrid");
        ZonedDateTime now = ZonedDateTime.now(spainZone);
        Integer hour = now.getHour();
        Date nowDate = Date.from(now.toInstant());

        for (Explotacion explotacion : explotaciones) {
            long explotacionId = explotacion.getExplotacionId();
            String latitude = formatCoord(explotacion.getLatitude());
            String longitude = formatCoord(explotacion.getLongitude());
            String altitude = explotacion.getHeight().toString();

            CompletableFuture<Void> futureHourlyForecasts = meteoredService.getHourlyForecastByDayCoords(1, latitude, longitude, altitude, "es")
                    .thenAccept(result -> {
                        synchronized (mapHourlyForecast) {
                            mapHourlyForecast.put(explotacionId, result);
                            mapCurrentForecast.put(explotacionId, result.getMeteoredForecasts().get(hour));
                        }
                    });

            CompletableFuture<Void> futureDailyForecasts = meteoredService.getDailyForecastByCoords(latitude, longitude, altitude, "es")
                    .thenAccept(result -> {
                        synchronized (mapTodayDailyForecast) {
                            mapTodayDailyForecast.put(explotacionId, result.getMeteoredForecasts().get(0));
                        }
                    });

            // Get warnings for the next 10 days and sum them up
            List<CompletableFuture<List<MeteoredWarning>>> futureWarnings = IntStream.rangeClosed(1, 10)
                    .mapToObj(day -> meteoredService.getWarningsForNextDaysByCoords(day, latitude, longitude))
                    .collect(Collectors.toList());

            CompletableFuture<Void> futureAllWarnings = CompletableFuture.allOf(futureWarnings.toArray(new CompletableFuture[0]))
                    .thenAccept(v -> {
                        int totalWarnings = futureWarnings.stream()
                                .map(CompletableFuture::join)
                                .mapToInt(List::size)
                                .sum();
                        synchronized (mapWarningsToday) {
                            mapWarningsToday.put(explotacionId, totalWarnings);
                        }
                    });

            futures.add(futureHourlyForecasts);
            futures.add(futureDailyForecasts);
            futures.add(futureAllWarnings);
        }

        CompletableFuture<Void> allOfFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOfFutures.join();

        renderRequest.setAttribute("now", now);
        renderRequest.setAttribute("nowDate", nowDate);
        renderRequest.setAttribute("mapTodayDailyForecast", mapTodayDailyForecast);
        renderRequest.setAttribute("mapHourlyForecast", mapHourlyForecast);
        renderRequest.setAttribute("mapWarningsToday", mapWarningsToday);
        renderRequest.setAttribute("mapCurrentForecast", mapCurrentForecast);
    }



    @ProcessAction(name = "delete")
    public void delete(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String plotId = ParamUtil.getString(actionRequest, "plotId");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        _log.info("Deleting explotacion: " + plotId);
        ExplotacionLocalServiceUtil.deleteExplotacion(parseId(plotId), principal);

        // Obtiene todas las alertas del usuario
        List<Alertas> userAlerts = AlertasLocalServiceUtil.findByUserId(principal.getUserId());

        for (Alertas alerta : userAlerts) {
            if (alerta.getExplotacionId() == parseId(plotId)) {
                // Llama al método deleteAlerta para eliminar la alerta
                AlertasLocalServiceUtil.deleteAlerta(
                        alerta.getExternalCodeReference(),
                        alerta.getDescription(),
                        alerta.getReaded(),
                        alerta.getExplotacionId(),
                        alerta.getPhenomenom(),
                        alerta.getUserId(),
                        alerta.getEndDate(),
                        alerta.getStartDate(),
                        alerta.getRisk(),
                        alerta.getScope(),
                        alerta.getProbability()
                );
            }
        }
    }


    @ProcessAction(name = "setIsMain")
    public void setIsMain(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String id = ParamUtil.getString(actionRequest, "plotId");
        Boolean isMain = ParamUtil.getBoolean(actionRequest, "isMain");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        ExplotacionLocalServiceUtil.setIsMain(parseId(id), principal.getUserId(), isMain);


    }

    @ProcessAction(name = "setFocus")
    public void setFocus(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        System.out.println("focus");

    }

    private Long parseId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer parseDayNumber(String dayNumber) {
        try {
            return Integer.parseInt(dayNumber);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    private String formatCoord(Double coord) {
        return COORD_DECIMAL_FORMAT.format(coord).replace(",", ".");
    }
}