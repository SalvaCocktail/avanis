package avanis.utils.impl;

import avanis.utils.api.util.CargaMasivaUtils;
import avanis.utils.configuration.CargaMasivaConfiguration;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(
    immediate=true,
    configurationPid = "avanis.utils.configuration.CargaMasivaConfiguration",
    service= CargaMasivaUtils.class
)
public class CargaMasivaUtilsImpl implements CargaMasivaUtils {

    private static final Log _log = LogFactoryUtil.getLog(CargaMasivaUtilsImpl.class);
    private volatile CargaMasivaConfiguration _config;

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _config = ConfigurableUtil.createConfigurable(CargaMasivaConfiguration.class, properties);
    }

    @Reference
    private DDMStructureLocalService _ddmStructureLocalService;

    @Override
    public List<DDMStructure> getEstructurasCargaMasiva() {
        String data = _config.estructurasCargaMasiva();
        return (data == null || data.isEmpty()) ? List.of() :
                Arrays.stream(StringUtil.split(data, ";"))
                        .map(String::trim)
                        .map(id -> {
                            try {
                                return _ddmStructureLocalService.getDDMStructure(Long.parseLong(id));
                            } catch (Exception e) {
                                _log.error("No se pudo obtener la estructura con ID: " + id);
                                return null;
                            }
                        })
                        .filter(structure -> structure != null)
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> getCabeceraAyudas() {
        return Arrays.asList(_config.cabeceraCargaMasivaAyudas().split(StringPool.SEMICOLON));
    }

    @Override
    public String getMapaValoresCSV() {
        return _config.mapaValoresCSV();
    }
}
