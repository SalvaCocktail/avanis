package avanis.custom.login.command;

import avanis.custom.login.constants.AvanisCustomLoginPortletKeys;
import avanis.custom.login.hubspot.HubspotService;
import avanis.custom.login.portlet.AvanisCustomLoginPortlet;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.auth.session.AuthenticatedSessionManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AvanisCustomLoginPortletKeys.AVANISCUSTOMLOGIN,
                "mvc.command.name=/login/login"
        },
        service = MVCActionCommand.class
)
public class MyLoginMVCActionCommand extends BaseMVCActionCommand {

    private static Log _log = LogFactoryUtil.getLog(AvanisCustomLoginPortlet.class);

    @Reference
    HubspotService _hubspotService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest,
                                   ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
        HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

        String emailAddress = ParamUtil.getString(actionRequest, "login");
        actionRequest.setAttribute("emailAddress", emailAddress);
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
        String token = httpReq.getParameter("token");
        String password = actionRequest.getParameter("password");
        actionRequest.setAttribute("password", password);
        boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
        String authType = CompanyConstants.AUTH_TYPE_EA;
        long companyId = PortalUtil.getCompanyId(request);
        User user = UserLocalServiceUtil.getUser(UserLocalServiceUtil.getUserIdByEmailAddress(
                themeDisplay.getCompanyId(), emailAddress));

        String redirectURL = PortalUtil.getPortalURL(actionRequest)+"/reset-pass";

        try {
            if (user.getLastLoginDate() == null && AvanisCustomLoginPortlet.validateToken(token)) {
                user.setStatus(WorkflowConstants.STATUS_APPROVED);
                try {
                    _hubspotService.formSignupUser(user.getEmailAddress());
                } catch (Exception e) {
                    _log.error("Falla el envío de signupForm a hubspot");
                    //No bloqueamos si falla el envío a hubspot, que siga ejecutando.
                }
                UserLocalServiceUtil.updateUser(user);
                AuthenticatedSessionManagerUtil.login(
                        request, response, emailAddress, password, rememberMe, authType);
                redirectURL = PortalUtil.getPortalURL(actionRequest) + "/completar-perfil";
            } else if (user.getEmailAddress().equals("test@liferay.com")) {
                AuthenticatedSessionManagerUtil.login(
                        request, response, emailAddress, password, rememberMe, authType);
                redirectURL = PortalUtil.getPortalURL(actionRequest) + "/comunidad";

                // Agregas aquí el manejo de la cookie
                Cookie sessionStateCookie = new Cookie("LFR_SESSION_STATE_" + user.getUserId(), String.valueOf(System.currentTimeMillis()));
                sessionStateCookie.setPath("/");
                sessionStateCookie.setHttpOnly(true);
                sessionStateCookie.setSecure(true);
                response.addCookie(sessionStateCookie);

            } else if (!isCreateandModifyPreviuImport(user.getCreateDate(), user.getModifiedDate()) && user.getEmailAddress() != "test@liferay.com") {
                AuthenticatedSessionManagerUtil.login(
                        request, response, emailAddress, password, rememberMe, authType);
                redirectURL = PortalUtil.getPortalURL(actionRequest) + "/comunidad";

                Cookie sessionStateCookie = new Cookie("LFR_SESSION_STATE_" + user.getUserId(), String.valueOf(System.currentTimeMillis()));
                sessionStateCookie.setPath("/");
                sessionStateCookie.setHttpOnly(true);
                sessionStateCookie.setSecure(true);
                response.addCookie(sessionStateCookie);
            }
        } catch (AuthException ae){
            _log.error("***Usuario no se puede logar, error credenciales : emailAddress - " + emailAddress + " y password - " + password);
            SessionErrors.add(actionRequest, "error.credenciales");
            throw ae;
        }

        try{
            sendLoginForm(actionRequest, companyId);
        }catch (Exception e){}

        super.sendRedirect(actionRequest,
                actionResponse,redirectURL);
    }

    private static boolean isCreateandModifyPreviuImport(Date fechaCreacion, Date fechaModificacion) {

        //formato de fechas
        LocalDate localDateCreacion = fechaCreacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateModificacion = fechaModificacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Boolean isAnterior = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaCreacionFormateada = localDateCreacion.format(formatter);
        String fechaModificacionFormateada = localDateModificacion.format(formatter);
        // Fecha de referencia: 30 de julio del mismo año que la fecha a comparar
        LocalDate fechaReferencia = LocalDate.of(2024, 7, 30);

        // Comparar fechas
        if (localDateCreacion.isBefore(fechaReferencia) || localDateModificacion.isBefore(fechaReferencia)) {
           _log.info("La fecha create: " + localDateCreacion + "o modificate: " + localDateModificacion + " es anterior a: " + fechaReferencia);
           isAnterior = false;
        }
        return isAnterior;
    }

    public void sendLoginForm(ActionRequest actionRequest, long companyId) throws PortalException {
        String  email = ParamUtil.getString(actionRequest, "login");
        User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
        long id =  user.getUserId();
        ParamUtil.getString(actionRequest, "id");
        _hubspotService.formLoginUser(email,String.valueOf(id));
    }


    @Reference
    private UserService _userService;
}