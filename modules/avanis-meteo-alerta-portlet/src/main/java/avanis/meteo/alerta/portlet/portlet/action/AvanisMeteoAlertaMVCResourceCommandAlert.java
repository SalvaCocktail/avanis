package avanis.meteo.alerta.portlet.portlet.action;

import avanis.meteo.alerta.portlet.constants.AvanisMeteoAlertaPortletKeys;
import avanis.tu.explotacion.sb.service.AlertasLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AvanisMeteoAlertaPortletKeys.AVANISMETEOALERTA,
                "mvc.command.name=resource_cmd_command_alert"
        },
        service = MVCResourceCommand.class
)
public class AvanisMeteoAlertaMVCResourceCommandAlert extends BaseMVCResourceCommand {

        private static final Log _log = LogFactoryUtil.getLog(AvanisMeteoAlertaMVCResourceCommandAlert.class);

        @Override
        protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
                throws Exception {

                // Leer el cuerpo de la solicitud como String
                String jsonString = readRequestBody(resourceRequest);
                JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

                long userId = jsonObject.getLong("userId");
                long explotacionId = jsonObject.getLong("explotacionId");
                boolean readed = jsonObject.getBoolean("readed");
                String phenomenon = jsonObject.getString("phenomenon");
                String probability = jsonObject.getString("probability");
                String description = jsonObject.getString("description");

                // Marcar notificación como leída en la tabla UserNotificationEvent
                try {
                        List<UserNotificationEvent> userNotificationEvents =
                                UserNotificationEventLocalServiceUtil.getUserNotificationEvents(userId, -1, -1);

                        for (UserNotificationEvent userNotificationEvent : userNotificationEvents) {
                                if (!userNotificationEvent.getArchived()) {
                                        // Leer el payload y convertirlo a JSONObject
                                        JSONObject payloadJson = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
                                        String title = payloadJson.getString("title");
                                        String body = payloadJson.getString("body");

                                        // Comparar con la descripción de la alerta
                                        if (body.contains(description) && body.contains(probability) && title.contains(phenomenon)) {
                                                // Marcar como archivada
                                                userNotificationEvent.setArchived(true);
                                                UserNotificationEventLocalServiceUtil.updateUserNotificationEvent(userNotificationEvent);
                                        }
                                }
                        }
                } catch (PortalException e) {
                        _log.error("Error al marcar la notificación como leída", e);
                }
            // Crear respuesta JSON
                JSONObject jsonMessageObject = JSONFactoryUtil.createJSONObject();
                jsonMessageObject.put("status", "success");

                // Escribir la respuesta JSON
                HttpServletResponse httpServletResponse = _portal.getHttpServletResponse(resourceResponse);
                httpServletResponse.setContentType(ContentTypes.APPLICATION_JSON);
                httpServletResponse.getWriter().write(jsonMessageObject.toString());
        }

        private String readRequestBody(ResourceRequest resourceRequest) throws IOException {
                StringBuilder sb = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceRequest.getPortletInputStream()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                                sb.append(line);
                        }
                }
                return sb.toString();
        }

        @Reference
        private Portal _portal;

}
