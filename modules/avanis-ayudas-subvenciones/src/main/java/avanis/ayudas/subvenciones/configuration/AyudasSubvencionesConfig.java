package avanis.ayudas.subvenciones.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "other", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "avanis.ayudas.subvenciones.configuration.AyudasSubvencionesConfig", localization = "content/Language", name = "Ayudas Subvenciones Config")
public interface AyudasSubvencionesConfig {

    @Meta.AD(name = "ID Estructura Ayudas Subvenciones", deflt="199118", required=true)
    String structureId();

}
