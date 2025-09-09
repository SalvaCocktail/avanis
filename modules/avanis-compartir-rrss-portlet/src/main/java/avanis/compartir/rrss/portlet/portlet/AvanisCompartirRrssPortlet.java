package avanis.compartir.rrss.portlet.portlet;

import avanis.compartir.rrss.portlet.constants.AvanisCompartirRrssPortletKeys;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jesusblasco
 */
@Component(
        property = {
                "javax.portlet.version=3.0",
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "com.liferay.portlet.add-default-resource=true",
                "javax.portlet.display-name=AvanisCompartirRrss",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AvanisCompartirRrssPortletKeys.AVANISCOMPARTIRRRSS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AvanisCompartirRrssPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(AvanisCompartirRrssPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        String resourceName = renderRequest.getRenderParameters().getValue("resourceName");
        long resourceId = ParamUtil.getLong(renderRequest, "resourceId", 0);
        String url = renderRequest.getRenderParameters().getValue("url");

        //Veo todos los parámetros que vienen
        System.out.println("__________PARAMETROS DEL RENDER__________________");
        renderRequest.getRenderParameters().getNames().forEach(paramName -> {
            System.out.println(paramName + " = " + Arrays.toString(renderRequest.getRenderParameters().getValues(paramName)));
        });
        System.out.println("_________________________________________________");
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (url != null && !url.isBlank()) {
            if("Eventos".equals(resourceName)){
                try {
                    CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(resourceId);
                    url = url + "?eventTitle=" + (String) calendarBooking.getExpandoBridge().getAttribute("event_url");
                    //String nombreEvento= calendarBooking.getTitle();
                    String nombreEvento = LocalizationUtil.getLocalization(calendarBooking.getTitle(), themeDisplay.getLocale().toString());

                    System.out.println("Nombre del evento: "+nombreEvento);
                } catch (PortalException e) {
                    _log.error("Excepción compartiendo evento ", e);
                    throw new RuntimeException(e);
                }
            }
            else if("AyudasSubvenciones".equals(resourceName)){
                try {
                    // Obtener el artículo de contenido web (asumiendo que las ayudas son JournalArticles)
                    //JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(resourceId);
                    JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), String.valueOf(resourceId));
                    // Extraer el título localizado del artículo
                    String tituloAyuda = LocalizationUtil.getLocalization(journalArticle.getTitle(), themeDisplay.getLocale().toString());

                    // Imprimir el título de la ayuda
                    System.out.println("Título de la ayuda/subvención: " + tituloAyuda);
                } catch (PortalException e) {
                    _log.error("Excepción obteniendo la ayuda/subvención ", e);
                    throw new RuntimeException(e);
                }
            }
            //AyudasSubvenciones
            renderRequest.setAttribute("url", url);
        } else {
            renderRequest.setAttribute("url", themeDisplay.getPortalURL() + themeDisplay.getURLCurrent());
        }


        super.doView(renderRequest, renderResponse);
    }
}
