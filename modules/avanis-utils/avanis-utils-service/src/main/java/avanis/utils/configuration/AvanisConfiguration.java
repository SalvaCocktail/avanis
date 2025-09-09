package avanis.utils.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import org.osgi.annotation.versioning.ProviderType;

@ExtendedObjectClassDefinition(category = "other", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "avanis.utils.configuration.AvanisConfiguration", localization = "content/Language", name = "Avanis Configuraciones Generales")
@ProviderType
public interface AvanisConfiguration {

    @Meta.AD(name = "Group ID", deflt="20117")
    long groupId();

    @Meta.AD(name = "Folder Video ID", deflt="242935")
    long folderVideoId();

    @Meta.AD(name = "Fechas Filtro Buscador", deflt="0,7,30,60,90")
    String fechasFiltroBuscador();

    @Meta.AD(name = "Mostrar Titulos Buscador", deflt="false")
    String mostrarTitulosBuscador();

    @Meta.AD(name = "Url Sitio", deflt="https://www.avanis.es/es/")
    String urlSitio();

    @Meta.AD(name = "Id Vocabulario Avanis", deflt="92747")
    long idVocabularioAvanis();

    @Meta.AD(name = "Id Vocabulario User Dedications", deflt="92920")
    long idVocabularioAUserDedications();
}
