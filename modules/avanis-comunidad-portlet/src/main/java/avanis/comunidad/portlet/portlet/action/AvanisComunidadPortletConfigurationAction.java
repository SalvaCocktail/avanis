package avanis.comunidad.portlet.portlet.action;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.comunidad.portlet.configuration.AvanisComunidadPortletConfiguration;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletConstants;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component(
        immediate = true,
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        configurationPid = {AvanisComunidadPortletKeys.AVANISCOMUNIDAD_CONFIGURATION},
        property = {
                "javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD
        },
        service = ConfigurationAction.class
)
public class AvanisComunidadPortletConfigurationAction extends DefaultConfigurationAction {

        private static final Log _log = LogFactoryUtil.getLog(AvanisComunidadPortletConfigurationAction.class);

        private volatile AvanisComunidadPortletConfiguration _configuration;

        @Override
        public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
                if (_log.isDebugEnabled()) {
                        _log.debug("AvanisComunidadPortletConfigurationAction#processAction");
                }

                String discussionCommentsDelta = ParamUtil.getString(actionRequest, AvanisComunidadPortletConstants.DISCUSSION_COMMENTS_DELTA);
                setPreference(actionRequest, AvanisComunidadPortletConstants.DISCUSSION_COMMENTS_DELTA, String.valueOf(discussionCommentsDelta));

                super.processAction(portletConfig, actionRequest, actionResponse);
        }

        @Override
        public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
                if (_log.isDebugEnabled()) {
                        _log.debug("AvanisComunidadPortletConfigurationAction#include");
                }
                httpServletRequest.setAttribute(AvanisComunidadPortletConfiguration.class.getName(), _configuration);

                super.include(portletConfig, httpServletRequest, httpServletResponse);
        }

        @Activate
        @Modified
        protected void activate(Map<Object, Object> properties) {
                _configuration = Configurable.createConfigurable(AvanisComunidadPortletConfiguration.class, properties);
        }
}

