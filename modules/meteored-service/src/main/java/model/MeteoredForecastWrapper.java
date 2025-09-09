package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

public class MeteoredForecastWrapper<T extends MeteoredForecast> {

    private String hash;
    private String name;
    private String url;
    private Date start;
    @JsonAlias({"hours", "days"})
    private List<T> meteoredForecasts;

    public MeteoredForecastWrapper() {
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public List<T> getMeteoredForecasts() {
        return meteoredForecasts;
    }

    public void setMeteoredForecasts(List<T> meteoredForecasts) {
        this.meteoredForecasts = meteoredForecasts;
    }

    @Override
    public String toString() {
        return "MeteoredForecastWrapper{" +
                "hash='" + hash + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", start=" + start +
                ", meteoredForecasts=" + meteoredForecasts +
                '}';
    }


    public static MeteoredForecastWrapper<MeteoredHourlyForecast> fromMeteoredApiResponseToHourly(String body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = objectMapper.readTree(body);
            JsonNode locationsNode = rootNode.path("data");

            return objectMapper.readValue(locationsNode.toString(), new TypeReference<MeteoredForecastWrapper<MeteoredHourlyForecast>>() {
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public static MeteoredForecastWrapper<MeteoredDailyForecast> fromMeteoredApiResponseToDaily(String body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = objectMapper.readTree(body);
            JsonNode locationsNode = rootNode.path("data");

            return objectMapper.readValue(locationsNode.toString(), new TypeReference<MeteoredForecastWrapper<MeteoredDailyForecast>>() {
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
