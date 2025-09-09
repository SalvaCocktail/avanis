package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MeteoredDailyForecast extends MeteoredForecast {


    @JsonProperty("start")
    Date start;
    @JsonProperty("temperature_min")
    private Double minTemperature;
    @JsonProperty("temperature_max")
    private Double maxTemperature;
    @JsonProperty("sun_in")
    private Date sunIn;
    @JsonProperty("sun_mid")
    private Date sunMid;
    @JsonProperty("sun_out")
    private Date sunOut;
    @JsonProperty("sun_first_light")
    private Date sunFirstLight;
    @JsonProperty("sun_last_light")
    private Date sunLastLight;
    @JsonProperty("moon_in")
    private Date moonIn;
    @JsonProperty("moon_out")
    private Date moonOut;
    @JsonProperty("moon_symbol")
    private Integer moonSymbol;
    @JsonProperty("moon_illumination")
    private Double moonIllumination;
    @JsonProperty("moon_horizon")
    private Double moonHorizon;

    public MeteoredDailyForecast() {
        super();

    }

    public Date getStart() {
        return start;
    }


    public void setStart(Date start) {
        this.start = start;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Date getSunIn() {
        return sunIn;
    }

    public void setSunIn(Date sunIn) {
        this.sunIn = sunIn;
    }

    public Date getSunMid() {
        return sunMid;
    }

    public void setSunMid(Date sunMid) {
        this.sunMid = sunMid;
    }

    public Date getSunOut() {
        return sunOut;
    }

    public void setSunOut(Date sunOut) {
        this.sunOut = sunOut;
    }

    public Date getSunFirstLight() {
        return sunFirstLight;
    }

    public void setSunFirstLight(Date sunFirstLight) {
        this.sunFirstLight = sunFirstLight;
    }

    public Date getSunLastLight() {
        return sunLastLight;
    }

    public void setSunLastLight(Date sunLastLight) {
        this.sunLastLight = sunLastLight;
    }

    public Date getMoonIn() {
        return moonIn;
    }

    public void setMoonIn(Date moonIn) {
        this.moonIn = moonIn;
    }

    public Date getMoonOut() {
        return moonOut;
    }

    public void setMoonOut(Date moonOut) {
        this.moonOut = moonOut;
    }

    public Integer getMoonSymbol() {
        return moonSymbol;
    }

    public void setMoonSymbol(Integer moonSymbol) {
        this.moonSymbol = moonSymbol;
    }

    public Double getMoonIllumination() {
        return moonIllumination;
    }

    public void setMoonIllumination(Double moonIllumination) {
        this.moonIllumination = moonIllumination;
    }

    public Double getMoonHorizon() {
        return moonHorizon;
    }

    public void setMoonHorizon(Double moonHorizon) {
        this.moonHorizon = moonHorizon;
    }

    @Override
    public String toString() {
        return "MeteoredDailyForecast{" +
                ", start=" + start +
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
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", sunIn=" + sunIn +
                ", sunMid=" + sunMid +
                ", sunOut=" + sunOut +
                ", sunFirstLight=" + sunFirstLight +
                ", sunLastLight=" + sunLastLight +
                ", moonIn=" + moonIn +
                ", moonOut=" + moonOut +
                ", moonSymbol=" + moonSymbol +
                ", moonIllumination=" + moonIllumination +
                ", moonHorizon=" + moonHorizon +
                '}';
    }


    public static List<MeteoredDailyForecast> fromMeteoredApiResponse(String body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = objectMapper.readTree(body);
            JsonNode locationsNode = rootNode.path("data").path("days");

            return objectMapper.readValue(locationsNode.toString(), new TypeReference<List<MeteoredDailyForecast>>() {
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public Integer getStartDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getStart());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    
}
