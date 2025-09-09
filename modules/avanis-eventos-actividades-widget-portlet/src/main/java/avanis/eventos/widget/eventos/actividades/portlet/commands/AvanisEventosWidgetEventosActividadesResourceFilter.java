package avanis.eventos.widget.eventos.actividades.portlet.commands;



import avanis.eventos.widget.eventos.actividades.portlet.AvanisEventosWidgetEventosActividadesPortlet;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.*;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


import avanis.eventos.widget.eventos.actividades.constants.AvanisEventosWidgetEventosActividadesPortletKeys;
import avanis.eventos.widget.eventos.actividades.resource.BookingsHandlerResource;
import avanis.eventos.widget.eventos.actividades.util.AvanisEventUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AvanisEventosWidgetEventosActividadesPortletKeys.AVANISEVENTOSWIDGETEVENTOSACTIVIDADES,
                "mvc.command.name=" + AvanisEventosWidgetEventosActividadesPortletKeys.AVANISEVENTOSWIDGETEVENTOSACTIVIDADES_RESOURCE_FILTER,
        },
        service = MVCResourceCommand.class
)
public class AvanisEventosWidgetEventosActividadesResourceFilter implements MVCResourceCommand {
    private static final Log _log = LogFactoryUtil.getLog(
            AvanisEventosWidgetEventosActividadesResourceFilter.class);

    @Reference
    private JSONFactory jsonFactory;

    private static Log LOG = LogFactoryUtil.getLog(AvanisEventosWidgetEventosActividadesResourceFilter.class);

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        LOG.info("SERVERESOURCE");
        try {
            // Leer el cuerpo de la solicitud como un string JSON
            BufferedReader reader = null;
            try {
                reader = resourceRequest.getReader();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while (true) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                jsonBuilder.append(line);
            }

            String jsonString = jsonBuilder.toString();

            // Convertir el string JSON a un objeto JSON de Liferay
            JSONObject jsonObject = null;
            try {
                jsonObject = JSONFactoryUtil.createJSONObject(jsonString);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            // Obtener los arrays del objeto JSON
            JSONArray selectedValuesArray = jsonObject.getJSONArray("selectedValuesGlobal");
            JSONArray calendarBookingIdsArray = jsonObject.getJSONArray("calendarBookingIdsArray");

            // Convertir los JSONArrays a listas de strings
            List<String> selectedValuesList = new ArrayList<>();
            for (int i = 0; i < selectedValuesArray.length(); i++) {
                selectedValuesList.add(selectedValuesArray.getString(i));
            }

            // Lista de calendarBookingIdsList
            List<String> calendarBookingIdsList = new ArrayList<>();
            for (int i = 0; i < calendarBookingIdsArray.length(); i++) {
                calendarBookingIdsList.add(calendarBookingIdsArray.getString(i));
            }

            // Array de eventos que coinciden
            List<CalendarBooking> matchingEvents = new ArrayList<>();

            //Trae la lista filtrada
            matchingEvents = BookingsHandlerResource.getBookingListFiltered(calendarBookingIdsList,  selectedValuesArray); // NUEVO: Array de eventos coincidentes

            //Guarda en session de Portlet los eventos filrados
            resourceRequest.getPortletSession().setAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.ALL_EVENTS_LIST_FILTERED,  matchingEvents, PortletSession.PORTLET_SCOPE);

            //Eventos acotados
            if (matchingEvents.size() > 0 && matchingEvents.size() > 3) {
                matchingEvents = matchingEvents.subList(0, 3);
            }

            // Pasa la lista filtrada a JsonArray
            JSONArray jsonBookingFiltered = AvanisEventUtil.toCalendarBookingsJSONArray(themeDisplay, matchingEvents);

            // Configura el tipo de contenido de la respuesta
            resourceResponse.setContentType("application/json");
            resourceResponse.setCharacterEncoding("UTF-8");

            // Escribe el JSONArray en el ResourceResponse
            PrintWriter out = resourceResponse.getWriter();
            out.write(jsonBookingFiltered.toString());

            // Limpia el PrintWriter y lo cierra
            out.flush();
            out.close();

            return true;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
