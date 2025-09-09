package avanis.utils.impl;

import avanis.utils.api.util.EstructurasUtils;
import avanis.utils.configuration.CargaMasivaConfiguration;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(
    immediate=true,
    configurationPid = "avanis.utils.configuration.CargaMasivaConfiguration",
    service= EstructurasUtils.class
)
public class EstructurasUtilsImpl implements EstructurasUtils {
    private static final Log _log = LogFactoryUtil.getLog(EstructurasUtilsImpl.class);

    private volatile CargaMasivaConfiguration _config;

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _config = ConfigurableUtil.createConfigurable(CargaMasivaConfiguration.class, properties);
    }

    @Reference
    private DDMStructureLocalService _ddmStructureLocalService;

    @Reference
    private DDMTemplateLocalService _ddmTemplateLocalService;

    @Override
    public Map<String, String> getCamposPorEstructuraId(long structureId) {
        try {
            Map<String, String> campos = new HashMap<>();

            List<DDMFormField> ddmFormFields = _ddmStructureLocalService.getDDMStructure(structureId).getDDMForm().getDDMFormFields();

            for (DDMFormField field : ddmFormFields) {
                String idCampo = field.getName();  // ID del campo (Ej: "Text47613942")
                String nombreCampo = field.getLabel().getString(LocaleUtil.getDefault()); // Nombre real

                campos.put(idCampo, nombreCampo);
            }

            return campos;
        }catch (Exception e) {
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public DDMTemplate getTemplatePorEstructuraId(long templateId) {
        try{
            return _ddmTemplateLocalService.getTemplate(Long.parseLong(_config.templatesCargaMasiva()));
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public long getFolderAyudas() {
        return _config.getFolderAyudasId();
    }
}
