package model;

import java.util.HashMap;
import java.util.Map;

public class MeteoredConsts {

    public static final HashMap<Integer, String> WEATHER_DESCRIPTION = new HashMap<>(Map.ofEntries(
            Map.entry(1, "Cielo despejado"),
            Map.entry(2, "Nubes altas"),
            Map.entry(3, "Nubes y claros"),
            Map.entry(4, "Parcialmente nuboso"),
            Map.entry(5, "Cielo cubierto"),
            Map.entry(6, "Calima con cielo despejado"),
            Map.entry(7, "Calima con cielo cubierto"),
            Map.entry(8, "Neblina"),
            Map.entry(9, "Niebla"),
            Map.entry(10, "Tormenta seca con cielo parcialmente nuboso"),
            Map.entry(11, "Tormenta seca con cielo cubierto"),
            Map.entry(12, "Lluvia débil con cielo parcialmente nuboso"),
            Map.entry(13, "Lluvia débil con cielo cubierto"),
            Map.entry(14, "Lluvia moderada con cielo parcialmente nuboso"),
            Map.entry(15, "Lluvia moderada con cielo cubierto"),
            Map.entry(16, "Lluvia de barro con cielo parcialmente nuboso"),
            Map.entry(17, "Lluvia de barro con cielo cubierto"),
            Map.entry(18, "Lluvia engelante con cielo parcialmente nuboso"),
            Map.entry(19, "Lluvia engelante con cielo cubierto"),
            Map.entry(20, "Aguanieve con cielo parcialmente nuboso"),
            Map.entry(21, "Aguanieve con cielo cubierto"),
            Map.entry(22, "Aguanieve con barro y cielo parcialmente nuboso"),
            Map.entry(23, "Aguanieve con barro y cielo cubierto"),
            Map.entry(24, "Nevada con cielo parcialmente nuboso"),
            Map.entry(25, "Nevada con cielo cubierto"),
            Map.entry(26, "Nevada con barro y cielo parcialmente nuboso"),
            Map.entry(27, "Nevada con barro y cielo cubierto"),
            Map.entry(28, "LLuvia intensa con cielo parcialmente nuboso"),
            Map.entry(29, "Lluvia intensa con cielo cubierto"),
            Map.entry(30, "Aguanieve intensa con cielo parcialmente nuboso"),
            Map.entry(31, "Aguanieve intensa con cielo cubierto"),
            Map.entry(32, "Nevada intensa con cielo parcialmente nuboso"),
            Map.entry(33, "Nevada intensa con cielo cubierto"),
            Map.entry(34, "Chubascos tormentosos con cielo parcialmente nuboso"),
            Map.entry(35, "Chubascos tormentosos con cielo cubierto"),
            Map.entry(36, "Granizo con cielo parcialmente nuboso"),
            Map.entry(37, "Granizo con cielo cubierto"),
            Map.entry(38, "Tormenta con granizo y cielo parcialmente nuboso"),
            Map.entry(39, "Tormenta con granizo y cielo cubierto"),
            Map.entry(40, "Tormenta de arena"),
            Map.entry(41, "Ventisca")
    ));
}
