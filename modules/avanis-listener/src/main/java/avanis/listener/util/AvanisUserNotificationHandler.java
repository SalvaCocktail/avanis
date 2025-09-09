package avanis.listener.util;

import avanis.listener.constants.AvanisListenerConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = "javax.portlet.name=" + AvanisListenerConstants.AVANISCOMUNIDAD,
    service = UserNotificationHandler.class
)
public class AvanisUserNotificationHandler extends BaseUserNotificationHandler {

    public AvanisUserNotificationHandler() {
        setPortletId(AvanisListenerConstants.AVANISCOMUNIDAD);
    }

    @Override
    public String getLink(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
        String entryURL = jsonObject.getString("entryURL");

        if (entryURL != null && !entryURL.isEmpty()) {
            return entryURL;
        }

        return super.getLink(userNotificationEvent, serviceContext);
    }

    @Override
    protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws PortalException {
        // Parsear el JSON para obtener los valores
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());

        // Extraer el título, el cuerpo y el subtítulo desde el JSON
        String title = jsonObject.getString("title");
        String body = jsonObject.getString("body");

        // Construir el contenido HTML para la notificación
        StringBuilder sb = new StringBuilder();

        // Añadir el título en negrita si está presente
        if (title != null && !title.isEmpty()) {
            sb.append("<strong>").append(title).append("</strong><br>");
        }

        // Añadir el cuerpo (body)
        if (body != null && !body.isEmpty()) {
            sb.append(body).append("<br>");
        }

        return sb.toString();
    }
}

