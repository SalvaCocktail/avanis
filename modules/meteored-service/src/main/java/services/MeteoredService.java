package services;

import model.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MeteoredService {
    List<MeteoredLocation> getLocationsByCoords(String latitude, String longitude);

    MeteoredForecastWrapper<MeteoredDailyForecast> getDailyForecastByHash(String hash);

    CompletableFuture<MeteoredForecastWrapper<MeteoredDailyForecast>> getDailyForecastByCoords(String latitude, String longitude, String altitude, String timezone);

    MeteoredForecastWrapper<MeteoredHourlyForecast> getHourlyForecastByDayHash(Integer dayNumber, String hash);

    CompletableFuture<MeteoredForecastWrapper<MeteoredHourlyForecast>> getHourlyForecastByDayCoords(Integer dayNumber, String latitude, String longitude, String altitude, String timezone);

    List<MeteoredWarning> getWarningsForTodayByCoords(String latitude, String longitude);

    List<MeteoredWarning> getWarningsForTomorrowByCoords(String latitude, String longitude);

    CompletableFuture<List<MeteoredWarning>> getWarningsForNextDaysByCoords(Integer dayNumber, String latitude, String longitude);
}
