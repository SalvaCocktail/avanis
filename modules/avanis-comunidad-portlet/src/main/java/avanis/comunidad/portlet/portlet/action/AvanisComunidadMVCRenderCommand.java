package avanis.comunidad.portlet.portlet.action;

import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import avanis.comunidad.portlet.exceptions.ForbiddenMessageException;
import avanis.social.follow.sb.model.SocialFollow;
import avanis.social.follow.sb.service.SocialFollowLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.message.boards.exception.NoSuchMessageException;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBMessageDisplay;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

@Component(
        property = {
                "javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD,
                "mvc.command.name=render_cmd_command"
        },
        service = MVCRenderCommand.class
)
public class AvanisComunidadMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            MBMessageDisplay messageDisplay = ActionUtil.getMessageDisplay(
                    renderRequest);
            MBMessage message = messageDisplay.getMessage();

            HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

            checkVisibility(getVisibility(message), themeDisplay.isSignedIn(), themeDisplay.getUser(), message);
            renderRequest.setAttribute("isFromDetail", true);
            renderRequest.setAttribute("isEmbedded", ParamUtil.getBoolean(httpServletRequest, "isEmbedded"));
            renderRequest.setAttribute(
                    WebKeys.MESSAGE_BOARDS_MESSAGE_DISPLAY, messageDisplay);
            String urlsessionGoogle = PropsUtil.get("google.login.url");
            renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);
            return "/view_message.jsp";
        } catch (NoSuchMessageException | ForbiddenMessageException | PrincipalException exception) {
            SessionErrors.add(renderRequest, exception.getClass());

            return "/error.jsp";
        } catch (RuntimeException runtimeException) {
            throw runtimeException;
        } catch (Exception exception) {
            throw new PortletException(exception);
        }
    }

    private void checkVisibility(String visibility, Boolean isSignedIn, User principal, MBMessage message) throws ForbiddenMessageException {
        User author = UserLocalServiceUtil.fetchUser(message.getUserId());
        if (author == null) {
            throw new ForbiddenMessageException();
        } else if (visibility.equals("registered") && !isSignedIn) {
            throw new ForbiddenMessageException();
        } else if (visibility.equals("followers") && (!isSignedIn || !checkFollow(principal, author))) {
            throw new ForbiddenMessageException();
        }
    }

    private Boolean checkFollow(User principal, User userProfile) {
        boolean res = true;

        if (principal.getUserId() != userProfile.getUserId()) {
            SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(principal.getUserId(), userProfile.getUserId());

            if (socialFollow == null || !socialFollow.getAccepted()) {
                res = false;
            }
        }

        return res;

    }

    private String getVisibility(MBMessage message) {
        ExpandoBridge expandoBridge = message.getExpandoBridge();
        String visibility;
        String[] visibilities = (String[]) expandoBridge.getAttribute("visibility");

        if (visibilities != null && visibilities.length > 0) {
            visibility = visibilities[0];
        } else {
            visibility = "registered";
        }
        return visibility;
    }

}
