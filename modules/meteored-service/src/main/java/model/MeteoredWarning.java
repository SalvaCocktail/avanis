package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MeteoredWarning {
    String risk;
    String phenomenon;
    String scope;
    Date start;
    Date end;
    String probability;
    String description;
    Integer symbol;
    MeteoredWarningType type; //TODO: En la app antigua se elegía el tipo en base al phenomeno y no dependía de lo que contestaba la api, ¿cómo se debería hacer?

    public MeteoredWarning() {

    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSymbol() {
        if (this.symbol == null) {
            this.setSymbol(MeteoredWarningType.fromPhenomenon(this.getPhenomenon()).getSymbol());
        }
        return this.symbol;

    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public MeteoredWarningType getType() {
        return type;
    }

    public void setType(MeteoredWarningType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MeteoredWarning{" +
                "risk='" + risk + '\'' +
                ", phenomenon='" + phenomenon + '\'' +
                ", scope='" + scope + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", probability='" + probability + '\'' +
                ", description='" + description + '\'' +
                ", symbol=" + symbol +
                ", type=" + type +
                '}';
    }

    public static List<MeteoredWarning> fromMeteoredApiResponse(String body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = objectMapper.readTree(body);
            JsonNode locationsNode = rootNode.path("data").path("warnings");

            return objectMapper.readValue(locationsNode.toString(), new TypeReference<List<MeteoredWarning>>() {
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getEnd());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public Integer getStartDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getStart());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

}

