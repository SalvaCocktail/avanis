package avanis.meteo.alerta.portlet.portlet.util;

import avanis.meteo.alerta.portlet.constants.AvanisMeteoAlertaPortletKeys;
import avanis.tu.explotacion.sb.model.Explotacion;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.push.notifications.constants.PushNotificationsPortletKeys;
import model.MeteoredWarning;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import java.util.Date;

public class AvanisMeteoAlertaUtil {

    private static final Log _log = LogFactoryUtil.getLog(AvanisMeteoAlertaUtil.class);

    public static void sendPlotsNotification(Explotacion explotacion, PortletRequest portletRequest, String bodyAlerta) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), portletRequest);

            if (explotacion.getAllowNotifications()) {
                String title = "nueva plots notification title"; // podemos dejarlo vacío si está en la plantilla
                String body = "nueva plots notification body"; // podemos dejarlo vacío si está en la plantilla
                String articleTitle = "meteoalert"; // En la plantilla se reemplazará [$TITLE$] por title y [$BODY$] por body
                String entryURL = serviceContext.getPortalURL() + "/explotacion";

                sendNotification(serviceContext, explotacion.getExplotacionId(), explotacion.getUserId(), title, bodyAlerta, articleTitle, entryURL);
            }
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendNotification(ServiceContext serviceContext, long classPK, long userId, String title, String body, String articleTitle, String entryURL) {
        String portletId = PortletProviderUtil.getPortletId(PushNotificationsPortletKeys.PUSH_NOTIFICATIONS, PortletProvider.Action.VIEW);

        User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
        JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
        notificationEventJSONObject.put("title", title);
        notificationEventJSONObject.put("body", body);
        notificationEventJSONObject.put("userId", serviceContext.getUserId());
        notificationEventJSONObject.put("fullName", user.getFullName());
        notificationEventJSONObject.put("classPK", classPK);
        notificationEventJSONObject.put("entryURL", entryURL);
        notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
        notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
        notificationEventJSONObject.put("articleTitle", articleTitle);
        //notificationEventJSONObject.put("context", serviceContext.getAttributes().toString());

        sendNotification(userId, notificationEventJSONObject);
    }

    private static void sendNotification(long userId, JSONObject notificationEventJSONObject) {
        ServiceContext serviceContext = new ServiceContext();
        String type = notificationEventJSONObject.getString("portletId");

        try {
            UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId,
                    AvanisMeteoAlertaPortletKeys.AVANISMETEOALERTA, // type
                    (new Date()).getTime(),
                    UserNotificationDeliveryConstants.TYPE_WEBSITE,
                    0,
                    notificationEventJSONObject.toString(),
                    false,
                    serviceContext);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getNotificationSetting(User principal, String notificationName) {
        ExpandoBridge expandoBridge = principal.getExpandoBridge();
        String notificationSetting;
        String[] notificationSettings = (String[]) expandoBridge.getAttribute(notificationName + "_notification");

        if (notificationSettings != null && notificationSettings.length > 0) {
            notificationSetting = notificationSettings[0];
        } else {
            notificationSetting = "none";
        }
        return notificationSetting;
    }

    private static Boolean sendNotification(String notificationSetting) {
        return "all".equals(notificationSetting) || "app".equals(notificationSetting);
    }

    private static Boolean sendEmail(String notificationSetting) {
        return "all".equals(notificationSetting) || "email".equals(notificationSetting);
    }
}
