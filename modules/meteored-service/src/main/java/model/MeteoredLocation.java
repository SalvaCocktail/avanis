package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MeteoredLocation {

    private String hash;
    private String name;
    private String description;
    private String countryName;

    public MeteoredLocation() {
    }

    public MeteoredLocation(String hash, String name, String description, String countryName) {
        this.hash = hash;
        this.name = name;
        this.description = description;
        this.countryName = countryName;
    }

    public static List<MeteoredLocation> fromMeteoredApiResponse(String body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = objectMapper.readTree(body);
            JsonNode locationsNode = rootNode.path("data").path("locations");

            return objectMapper.readValue(locationsNode.toString(), new TypeReference<List<MeteoredLocation>>() {
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String toString() {
        return "MeteoredLocation{" +
                "hash='" + hash + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
