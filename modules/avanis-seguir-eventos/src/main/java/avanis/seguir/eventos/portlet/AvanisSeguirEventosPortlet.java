package avanis.seguir.eventos.portlet;

import avanis.eventos.follow.sb.model.EventFollow;
import avanis.eventos.follow.sb.service.EventFollowLocalServiceUtil;
import avanis.seguir.eventos.constants.AvanisSeguirEventosPortletKeys;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.portlet.annotations.ServeResourceMethod;
import java.io.IOException;
import java.io.PrintWriter;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author Jaime Garcia
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AvanisSeguirEventos",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "com.liferay.portlet.add-default-resource=true",
                "javax.portlet.name=" + AvanisSeguirEventosPortletKeys.AVANISSEGUIREVENTOS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.version=3.0"
        },
        service = Portlet.class
)
public class AvanisSeguirEventosPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (themeDisplay.isSignedIn()) {
            long calendarBookingId = parseId(renderRequest.getRenderParameters().getValue("calendarBookingId"));

            CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.fetchCalendarBooking(calendarBookingId);
            EventFollow eventFollow = EventFollowLocalServiceUtil.getEventFollowsByUserIdAndEventFollow(themeDisplay.getUserId(), calendarBookingId);
            String resourceImageUrl = (String) calendarBooking.getExpandoBridge().getAttribute("event_image_url");

            renderRequest.setAttribute("followed", eventFollow != null);
            renderRequest.setAttribute("calendarBooking", calendarBooking);
            renderRequest.setAttribute("eventImage", resourceImageUrl);
        }

        String urlsessionGoogle = PropsUtil.get("google.login.url");
        renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);

        super.doView(renderRequest, renderResponse);
    }

    @ServeResourceMethod(portletNames = AvanisSeguirEventosPortletKeys.AVANISSEGUIREVENTOS)
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
        String resourceID = resourceRequest.getResourceID();

        if ("follow".equals(resourceID)) {
            followEvent(resourceRequest, resourceResponse);
        } else if ("unfollow".equals(resourceID)) {
            unfollowEvent(resourceRequest, resourceResponse);
        }
    }


    private void followEvent(PortletRequest portletRequest, ResourceResponse portletResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (themeDisplay.isSignedIn()) {
            long calendarBookingId = ParamUtil.getLong(portletRequest, "calendarBookingId", 0);
            try {
                Boolean followed = EventFollowLocalServiceUtil.follows(themeDisplay.getUserId(), calendarBookingId);

                if (!followed) {
                    portletResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, String.valueOf(409));
                } else {
                    portletResponse.setContentType("application/json");
                    JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
                    jsonResponse.put("success", true);

                    PrintWriter writer = portletResponse.getWriter();
                    writer.write(jsonResponse.toString());
                    writer.flush();
                    writer.close();

                    portletResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, String.valueOf(200));
                }
            } catch (Exception e) {
                e.printStackTrace();
                portletResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, String.valueOf(409));
            }
        }

    }

    private void unfollowEvent(PortletRequest portletRequest, ResourceResponse portletResponse) {
        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (themeDisplay.isSignedIn()) {
            long calendarBookingId = ParamUtil.getLong(portletRequest, "calendarBookingId", 0);
            try {
                EventFollow eventFollow = EventFollowLocalServiceUtil.getEventFollowsByUserIdAndEventFollow(themeDisplay.getUserId(), calendarBookingId);
                EventFollowLocalServiceUtil.deleteEventFollow(eventFollow);

                portletResponse.setContentType("application/json");
                JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
                jsonResponse.put("success", true);

                PrintWriter writer = portletResponse.getWriter();
                writer.write(jsonResponse.toString());
                writer.flush();
                writer.close();

                portletResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, String.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                portletResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, String.valueOf(409));
            }
        }

    }

    private Long parseId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
