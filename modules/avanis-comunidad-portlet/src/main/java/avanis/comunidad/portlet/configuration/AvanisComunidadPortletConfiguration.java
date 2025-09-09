package avanis.comunidad.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta.OCD;
import aQute.bnd.annotation.metatype.Meta.AD;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletConstants;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletConstants;

@OCD(id = AvanisComunidadPortletKeys.AVANISCOMUNIDAD_CONFIGURATION)
public interface AvanisComunidadPortletConfiguration {

@AD(name= AvanisComunidadPortletConstants.DISCUSSION_COMMENTS_DELTA, deflt = "10", required = false)
String discussionCommentsDelta();

}
