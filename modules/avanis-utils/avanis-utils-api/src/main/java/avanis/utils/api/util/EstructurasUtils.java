package avanis.utils.api.util;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;

import java.util.Map;

public interface EstructurasUtils {
    Map<String, String> getCamposPorEstructuraId(long structureId);
    DDMTemplate getTemplatePorEstructuraId(long templateId);
    long getFolderAyudas();
}
