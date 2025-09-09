package avanis.lonjas.configuration;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import avanis.lonjas.constants.AvanisLonjasPortlet;
import avanis.lonjas.constants.AvanisLonjasPortletKeys;

@OCD(id = AvanisLonjasPortletKeys.AVANISLONJAS_CONFIGURATION)
public interface AvanisLonjasPortletConfiguration {

    @AD(name= AvanisLonjasPortlet.HISTORIC_DATE_UPDATE, deflt = "", required = false)
    String historicDateUpdate();

}
