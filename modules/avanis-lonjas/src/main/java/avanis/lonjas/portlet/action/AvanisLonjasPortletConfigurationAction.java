package avanis.lonjas.portlet.action;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.lonjas.configuration.AvanisLonjasPortletConfiguration;
import avanis.lonjas.constants.AvanisLonjasPortletKeys;
import avanis.lonjas.constants.AvanisLonjasPortlet;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.scheduler.util.LonjasSchedulerUtil;
import avanis.lonjas.service.LonjaLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Component(
        immediate = true,
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        configurationPid = {AvanisLonjasPortletKeys.AVANISLONJAS_CONFIGURATION},
        property = {
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASWIDGET
        },
        service = ConfigurationAction.class
)
public class AvanisLonjasPortletConfigurationAction extends DefaultConfigurationAction {

        private static final Log _log = LogFactoryUtil.getLog(AvanisLonjasPortletConfigurationAction.class);

        private volatile AvanisLonjasPortletConfiguration _configuration;

        @Reference
        private LonjasSchedulerUtil _lonjasSchedulerUtil;

        @Override
        public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
                if (_log.isDebugEnabled()) {
                        _log.debug("AvanisComunidadPortletConfigurationAction#processAction");
                }
                SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdfOut = new SimpleDateFormat("yyyyMMdd");

                String historicDateUpdate = ParamUtil.getString(actionRequest, AvanisLonjasPortlet.HISTORIC_DATE_UPDATE);
                if(Validator.isNotNull(historicDateUpdate)) {
                        Calendar historic = GregorianCalendar.getInstance();
                        historic.setTime(sdfIn.parse(historicDateUpdate));

                        Calendar today = Calendar.getInstance();
                        today.setTime(sdfIn.parse(sdfIn.format(new Date())));
                        //today.set(Calendar.HOUR_OF_DAY, 0);
                        //today.set(Calendar.MINUTE, 0);
                        //today.set(Calendar.SECOND, 0);
                        //today.set(Calendar.MILLISECOND, 0);

                        int milisecondsByDay = 86400000;
                        int dias = (int) ((today.getTimeInMillis()-historic.getTimeInMillis()) / milisecondsByDay);
                        dias++;
                        List<Lonja> lonjaList = LonjaLocalServiceUtil.getLonjas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
                        for (int index = 0; index < dias; index++){
                                for (Lonja lonja : lonjaList) {
                                        _lonjasSchedulerUtil.getInformation("PreciosLonja", "http://sbd.telelonjas.es:9090/XML/PreciosLonja/IdLonja=" + lonja.getLonjaId() + "&Fecha=" + sdfOut.format(historic.getTime()));
                                }
                                historic.add(Calendar.DAY_OF_YEAR, 1);
                        }
                }
                //setPreference(actionRequest, AvanisLonjasPortlet.HISTORIC_DATE_UPDATE, String.valueOf(historicDateUpdate));

                super.processAction(portletConfig, actionRequest, actionResponse);
        }

        @Override
        public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
                if (_log.isDebugEnabled()) {
                        _log.debug("AvanisLonjasPortletConfigurationAction#include");
                }
                httpServletRequest.setAttribute(AvanisLonjasPortletConfiguration.class.getName(), _configuration);

                super.include(portletConfig, httpServletRequest, httpServletResponse);
        }

        @Activate
        @Modified
        protected void activate(Map<Object, Object> properties) {
                _configuration = Configurable.createConfigurable(AvanisLonjasPortletConfiguration.class, properties);
        }
}

