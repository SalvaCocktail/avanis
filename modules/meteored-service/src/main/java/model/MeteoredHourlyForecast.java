package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class MeteoredHourlyForecast extends MeteoredForecast {

    private Date end;
    private Double temperature;
    @JsonProperty("temperature_feels_like")
    private Double temperatureFeelsLike;
    private Double dew;
    @JsonProperty("snow_depth")
    private Integer snowDepth;
    private Integer clouds;
    private Integer visibility;
    private Integer cape;
    @JsonProperty("solar_radiation")
    private Integer solarRadiation;

    public MeteoredHourlyForecast() {

    }

    @Override
    public String toString() {
        return "MeteoredHourlyForecast{" +
                "end=" + end +
                ", temperature=" + temperature +
                ", temperatureFeelsLike=" + temperatureFeelsLike +
                ", dew=" + dew +
                ", snowDepth=" + snowDepth +
                ", clouds=" + clouds +
                ", visibility=" + visibility +
                ", cape=" + cape +
                ", solarRadiation=" + solarRadiation +
                ", symbol=" + symbol +
                ", windSpeed=" + windSpeed +
                ", windGust=" + windGust +
                ", windDirection='" + windDirection + '\'' +
                ", rain=" + rain +
                ", rainProbability=" + rainProbability +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", snowline=" + snowline +
                ", uvIndexMax=" + uvIndexMax +
                '}';
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperatureFeelsLike() {
        return temperatureFeelsLike;
    }

    public void setTemperatureFeelsLike(Double temperatureFeelsLike) {
        this.temperatureFeelsLike = temperatureFeelsLike;
    }

    public Double getDew() {
        return dew;
    }

    public void setDew(Double dew) {
        this.dew = dew;
    }

    public Integer getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(Integer snowDepth) {
        this.snowDepth = snowDepth;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getCape() {
        return cape;
    }

    public void setCape(Integer cape) {
        this.cape = cape;
    }

    public Integer getSolarRadiation() {
        return solarRadiation;
    }

    public void setSolarRadiation(Integer solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    public static List<MeteoredHourlyForecast> fromMeteoredApiResponse(String body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = objectMapper.readTree(body);
            JsonNode locationsNode = rootNode.path("data").path("hours");

            return objectMapper.readValue(locationsNode.toString(), new TypeReference<List<MeteoredHourlyForecast>>() {
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public Integer getEndHour() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(this.getEnd());
    return calendar.get(Calendar.HOUR_OF_DAY);
    }

}
