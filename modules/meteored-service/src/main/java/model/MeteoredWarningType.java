package model;

import java.util.Arrays;
import java.util.List;

public enum MeteoredWarningType {
    OTHERS(0, Arrays.asList()),
    RAIN(1, Arrays.asList("lluvia")),
    STORM(2, Arrays.asList("tormenta")),
    FOG(3, Arrays.asList("niebla", "banco")),
    WIND(4, Arrays.asList("viento")),
    FROST(5, Arrays.asList("helada", "hielo")),
    SNOWFALL(6, Arrays.asList("nieve", "nevada")),
    FLOODS(7, Arrays.asList("inunda", "riada")),
    HIGH_TEMPERATURES(8, Arrays.asList("Alta")),
    LOW_TEMPERATURES(9, Arrays.asList("Baja")),
    COASTAL(10, Arrays.asList("costero", "costa")),
    ROAD_WARNING(11, Arrays.asList("carretera"), false),
    FIRES(12, Arrays.asList("fuego", "incendio")),
    SAND_STORM(13, Arrays.asList("arena")),
    SEVERE_WEATHER(14, Arrays.asList("clima severo")),
    AVALANCHE(15, Arrays.asList("avalancha")),
    HAZE(16, Arrays.asList("calima")),
    CYCLONE(17, Arrays.asList("ciclón", "ciclones")),
    AIR_QUALITY(18, Arrays.asList("calidad")),
    HAIL(19, Arrays.asList("granizo"));

    private final Integer symbol;
    private final List<String> keywords;
    private final Boolean enabled;

    MeteoredWarningType(Integer symbol, List<String> keywords) {
        this(symbol, keywords, true);
    }

    MeteoredWarningType(Integer symbol, List<String> keywords, Boolean enabled) {
        this.symbol = symbol;
        this.keywords = keywords;
        this.enabled = enabled;
    }

    public Integer getSymbol() {
        return symbol;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public static MeteoredWarningType fromPhenomenon(String phenomenon) {
        for (MeteoredWarningType type : MeteoredWarningType.values()) {
            for (String keyword : type.keywords) {
                if (phenomenon.toLowerCase().contains(keyword.toLowerCase())) {
                    return type;
                }
            }
        }
        return MeteoredWarningType.OTHERS;
    }
}
