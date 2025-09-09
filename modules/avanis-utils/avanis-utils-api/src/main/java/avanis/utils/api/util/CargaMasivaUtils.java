package avanis.utils.api.util;

import com.liferay.dynamic.data.mapping.model.DDMStructure;

import java.util.List;

public interface CargaMasivaUtils {
    List<DDMStructure> getEstructurasCargaMasiva();
    List<String> getCabeceraAyudas();
    String getMapaValoresCSV();
}
