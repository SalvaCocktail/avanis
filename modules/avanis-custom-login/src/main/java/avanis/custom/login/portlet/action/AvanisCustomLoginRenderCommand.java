package avanis.custom.login.portlet.action;

import avanis.custom.login.constants.AvanisCustomLoginPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        property = {
                "javax.portlet.name=" + AvanisCustomLoginPortletKeys.AVANISCUSTOMLOGIN,
                "mvc.command.name=render_cmd_command"
        },

        service = MVCRenderCommand.class
)
public class AvanisCustomLoginRenderCommand implements MVCRenderCommand {

    private static final String VIEW_MODAL_USE_CASES_TEMPLATE = "/modalUseCases.jsp";
    private static final String VIEW_MODAL_POLITICA_PRIVACIDAD_TEMPLATE = "/modalPoliticaPrivacidad.jsp";

    private static final Log _log = LogFactoryUtil.getLog(AvanisCustomLoginRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

        if ("modal-use-cases".equals(cmd)) {
            return VIEW_MODAL_USE_CASES_TEMPLATE;
        } else if ("modal-politica-privacidad".equals(cmd)) {
            return VIEW_MODAL_POLITICA_PRIVACIDAD_TEMPLATE;
        } else {
            return VIEW_MODAL_USE_CASES_TEMPLATE;
        }
    }

}
