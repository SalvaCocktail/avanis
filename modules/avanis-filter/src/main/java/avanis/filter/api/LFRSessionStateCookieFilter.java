package avanis.filter.api;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component(
        immediate = true,
        property = {
                "servlet-context-name=",
                "before-filter=URL Rewrite Filter",
                "dispatcher=REQUEST",
                "servlet-filter-name=LFR Session State Cookie + XSS Filter",
                "url-pattern=/*"
        },
        service = Filter.class
)
public class LFRSessionStateCookieFilter extends BaseFilter {

    private static final Log _log = LogFactoryUtil.getLog(LFRSessionStateCookieFilter.class);

    @Override
    protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws Exception {

        // Proteccion contra XSS/URLs maliciosas
        String[] paramsToCheck = {"p_l_back_url", "redirect", "backURL", "_url"};
        for (String param : paramsToCheck) {
            String value = ParamUtil.getString(request, param);

            if (value != null && !value.isEmpty()) {
                String decodedValue = URLDecoder.decode(value, StandardCharsets.UTF_8.name()).trim().toLowerCase();

                if (decodedValue.startsWith("javascript:")) {
                    _log.warn("XSS detectado: esquema javascript en parámetro " + param + " = " + value);
                    response.sendRedirect("/");
                    return;
                }

                if (decodedValue.startsWith("//")) {
                    _log.warn("Detectado doble slash (posible dominio externo): " + param + " = " + value);
                    response.sendRedirect("/");
                    return;
                }

                boolean isSafe = decodedValue.startsWith("/") ||
                        decodedValue.startsWith("http://localhost:8080") ||
                        decodedValue.startsWith("https://localhost:8080") ||
                        decodedValue.startsWith("https://www.dev.avanis.es") ||
                        decodedValue.startsWith("https://www.pre.avanis.es") ||
                        decodedValue.startsWith("https://www.avanis.es");

                if (!isSafe) {
                    _log.warn("Bloqueado intento de redirección a dominio externo: " + param + " = " + value);
                    response.sendRedirect("/");
                    return;
                }
            }
        }

        HttpSession session = request.getSession();

        if (session.getAttribute("LFR_SESSION_STATE_ADDED") != null) {
            processFilter(LFRSessionStateCookieFilter.class.getName(), request, response, filterChain);
            return;
        }

        session.setAttribute("LFR_SESSION_STATE_ADDED", true);

        _log.debug("Agregando LFR_SESSION_STATE_20095 al usuario NO logueado");

        Cookie sessionStateCookie = new Cookie("LFR_SESSION_STATE_20095", String.valueOf(System.currentTimeMillis()));
        sessionStateCookie.setPath("/");
        sessionStateCookie.setHttpOnly(true);
        sessionStateCookie.setSecure(true);

        response.addCookie(sessionStateCookie);

        processFilter(LFRSessionStateCookieFilter.class.getName(), request, response, filterChain);
    }

    @Override
    protected Log getLog() {
        return _log;
    }
}
