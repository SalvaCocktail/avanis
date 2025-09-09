package services.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import model.*;
import org.osgi.service.component.annotations.Component;
import services.MeteoredClient;
import services.MeteoredService;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author angelperez
 */
@Component(immediate = true, service = MeteoredService.class)
public class MeteoredServiceImpl implements MeteoredService {

    private static Log _log = LogFactoryUtil.getLog(MeteoredServiceImpl.class);

    @Override
    public List<MeteoredLocation> getLocationsByCoords(String latitude, String longitude) {
        String path = "/api/location/v1/search/coords/" + latitude + "/" + longitude;

        HttpResponse<String> response = MeteoredClient.sendGetRequest(path);

        if (response != null && response.statusCode() == 200) {
            return MeteoredLocation.fromMeteoredApiResponse(response.body());
        } else if (response != null) {
            _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());
        }
        return new ArrayList<>();
    }

    @Override
    public MeteoredForecastWrapper<MeteoredDailyForecast> getDailyForecastByHash(String hash) {
        String path = "/api/forecast/v1/daily/" + hash;
        HttpResponse<String> response = MeteoredClient.sendGetRequest(path);

        if (response != null && response.statusCode() == 200) {
            return MeteoredForecastWrapper.fromMeteoredApiResponseToDaily(response.body());
        } else if (response != null) {
            _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());
        }
        return null;
    }

    @Override
    public CompletableFuture<MeteoredForecastWrapper<MeteoredDailyForecast>> getDailyForecastByCoords(String latitude, String longitude, String altitude, String timezone) {
        return CompletableFuture.supplyAsync(() -> {
            String path = "/api/forecast/v1/daily/coords/" + latitude + "/" + longitude + "/" + altitude + "/" + timezone;
            HttpResponse<String> response = MeteoredClient.sendGetRequest(path);
            if (response != null && response.statusCode() == 200) {
                return MeteoredForecastWrapper.fromMeteoredApiResponseToDaily(response.body());
            } else if (response != null) {
                _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());
            }
            return null;
        });
    }

    @Override
    public MeteoredForecastWrapper<MeteoredHourlyForecast> getHourlyForecastByDayHash(Integer dayNumber, String hash) {
        String path = "/api/forecast/v1/hourly/" + dayNumber + "day/" + hash;
        HttpResponse<String> response = MeteoredClient.sendGetRequest(path);
        if (response != null && response.statusCode() == 200) {
            return MeteoredForecastWrapper.fromMeteoredApiResponseToHourly(response.body());

        } else if (response != null) {
            _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());
        }
        return null;
    }

    @Override
    public CompletableFuture<MeteoredForecastWrapper<MeteoredHourlyForecast>> getHourlyForecastByDayCoords(Integer dayNumber, String latitude, String longitude, String altitude, String timezone) {
        return CompletableFuture.supplyAsync(() -> {
            String path = "/api/forecast/v1/hourly/coords/" + dayNumber + "day/" + latitude + "/" + longitude + "/" + altitude + "/" + timezone;
            HttpResponse<String> response = MeteoredClient.sendGetRequest(path);
            if (response != null && response.statusCode() == 200) {
                return MeteoredForecastWrapper.fromMeteoredApiResponseToHourly(response.body());

            } else if (response != null) {
                _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());
            }
            return null;
        });
    }

    @Override
    public List<MeteoredWarning> getWarningsForTodayByCoords(String latitude, String longitude) {
        String path = "/api/warnings/v1/coords/today/" + latitude + "/" + longitude + "/es";
        HttpResponse<String> response = MeteoredClient.sendGetRequest(path);
        if (response != null && response.statusCode() == 200) {
            return MeteoredWarning.fromMeteoredApiResponse(response.body());
        } else if (response != null) {
            _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());

        }
        return new ArrayList<>();
    }

    @Override
    public List<MeteoredWarning> getWarningsForTomorrowByCoords(String latitude, String longitude) {
        String path = "/api/warnings/v1/coords/tomorrow/" + latitude + "/" + longitude + "/es";
        HttpResponse<String> response = MeteoredClient.sendGetRequest(path);
        if (response != null && response.statusCode() == 200) {
            return MeteoredWarning.fromMeteoredApiResponse(response.body());
        } else if (response != null) {
            _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());
        }
        return new ArrayList<>();
    }

    @Override
    public CompletableFuture<List<MeteoredWarning>> getWarningsForNextDaysByCoords(Integer dayNumber, String latitude, String longitude) {
        return CompletableFuture.supplyAsync(() -> {
            if (dayNumber == 1) {
                return this.getWarningsForTodayByCoords(latitude, longitude);
            } else if (dayNumber == 2) {
                return this.getWarningsForTomorrowByCoords(latitude, longitude);
            }


            String path = "/api/warnings/v1/coords/" + dayNumber + "day/" + latitude + "/" + longitude + "/es";
            HttpResponse<String> response = MeteoredClient.sendGetRequest(path);
            if (response != null && response.statusCode() == 200) {
                return MeteoredWarning.fromMeteoredApiResponse(response.body());
            } else if (response != null) {
                _log.debug("Error " + response.statusCode() + " on meteo api " + response.body());

            }
            return new ArrayList<>();
        });


    }

}