package avanis.listener.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "other", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "avanis.listener.configuration.SchedulersExpresionConfiguration", localization = "content/Language", name = "Scheduler Expresion Config")
public interface SchedulersExpresionConfiguration {

    @Meta.AD(name = "CRON EXPRESION EXIF SANITIZER", deflt="0 20 11 24 3 ? *")
    String cronExpressionExifSanitizer();

}
