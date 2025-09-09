package avanis.custom.login.events.post;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@Component(
        immediate = true,
        property = "key=login.events.post",
        service = LifecycleAction.class
)
public class AvanisPostLoginAction implements LifecycleAction {

    private static final Log _log = LogFactoryUtil.getLog(AvanisPostLoginAction.class);

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

        HttpServletRequest request = lifecycleEvent.getRequest();
        HttpServletResponse response = lifecycleEvent.getResponse();

        try {
            long userId = (Long) request.getSession().getAttribute("USER_ID");

            _log.info("Post Login detectado. userId: " + userId);

            if (userId > 0) {

                User user = UserLocalServiceUtil.getUser(userId);

                _log.info("Usuario getFullName: " + user.getFullName());
                _log.info("Usuario getUserId: " + user.getUserId());

                String cookieName = "LFR_SESSION_STATE_" + userId;
                String cookieValue = String.valueOf(System.currentTimeMillis());

                Cookie sessionStateCookie = new Cookie(cookieName, cookieValue);
                sessionStateCookie.setPath("/");
                sessionStateCookie.setHttpOnly(true);
                sessionStateCookie.setSecure(true);

                // Duración de 8 horas en segundos
                sessionStateCookie.setMaxAge(60 * 60 * 8); // 28,800 segundos (8 horas)
                response.addCookie(sessionStateCookie);

                _log.info("Cookie LFR_SESSION_STATE_" + userId + " agregada después de login con duración de 8 horas.");
            }

        } catch (Exception e) {
            _log.error("Error en PostLoginAction", e);
            throw new ActionException(e);
        }
    }
}
