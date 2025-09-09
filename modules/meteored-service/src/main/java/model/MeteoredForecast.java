package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public abstract class MeteoredForecast {

    @JsonProperty("symbol")
    Integer symbol;
    @JsonProperty("wind_speed")
    Integer windSpeed;
    @JsonProperty("wind_gust")
    Integer windGust;
    @JsonProperty("wind_direction")
    String windDirection;
    Integer rain;
    @JsonProperty("rain_probability")
    Double rainProbability;
    Integer humidity;
    Integer pressure;
    Integer snowline;
    @JsonProperty("uv_index_max")
    Double uvIndexMax;

    public MeteoredForecast() {
    }

    public String getWeatherDescription() {
        return MeteoredConsts.WEATHER_DESCRIPTION.get(this.symbol);
    }

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindGust() {
        return windGust;
    }

    public void setWindGust(Integer windGust) {
        this.windGust = windGust;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Integer getRain() {
        return rain;
    }

    public void setRain(Integer rain) {
        this.rain = rain;
    }

    public Double getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(Double rainProbability) {
        this.rainProbability = rainProbability;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getSnowline() {
        return snowline;
    }

    public void setSnowline(Integer snowline) {
        this.snowline = snowline;
    }

    public Double getUvIndexMax() {
        return uvIndexMax;
    }

    public void setUvIndexMax(Double uvIndexMax) {
        this.uvIndexMax = uvIndexMax;
    }
}
