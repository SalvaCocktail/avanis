package avanis.tu.explotacion.portlet.portlet.action;

import avanis.tu.explotacion.portlet.constants.AvanisTuExplotacionPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component(
        property = {
                "javax.portlet.name=" + AvanisTuExplotacionPortletKeys.AVANIS_EXPLOTACION_EDIT,
                "javax.portlet.name=" + AvanisTuExplotacionPortletKeys.AVANISTUEXPLOTACION,
                "mvc.command.name=resource_cmd_command"
        },
        service = MVCResourceCommand.class
)
public class AvanisTuExplotacionMVCResourceCommand extends BaseMVCResourceCommand {

        private static final Log _log = LogFactoryUtil.getLog(AvanisTuExplotacionMVCResourceCommand.class);

        @Override
        protected void doServeResource(
                ResourceRequest resourceRequest, ResourceResponse resourceResponse)
                throws Exception {

                double latitude = ParamUtil.getDouble(resourceRequest, "latitude");
                double longitude = ParamUtil.getDouble(resourceRequest, "longitude");

                String location = getFullLocationFromCoordinates(String.valueOf(latitude), String.valueOf(longitude));

                _log.debug("latitude:" + latitude + "; longitude: " + longitude + "; location: " + location);

                HttpServletResponse httpServletResponse =_portal.getHttpServletResponse(resourceResponse);
                httpServletResponse.setContentType(ContentTypes.APPLICATION_JSON);
                JSONObject jsonMessageObject = JSONFactoryUtil.createJSONObject();
                jsonMessageObject.put("location", location);

                JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonMessageObject);
        }

        private String getFullLocationFromCoordinates(String latitude, String longitude) {
                String location = "";
                String urlString = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + latitude + "&lon=" + longitude + "&addressdetails=1";

                try {
                        URL url = new URL(urlString);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");

                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;

                        while ((line = reader.readLine()) != null) {
                                response.append(line);
                        }

                        reader.close();
                        JSONObject json = JSONFactoryUtil.createJSONObject(response.toString());
                        JSONObject address = json.getJSONObject("address");

                        if (address != null) {
                                String road = address.getString("road", "");
                                String suburb = address.getString("suburb", "");
                                String village = address.getString("village", "");
                                String city = address.getString("city", "");
                                String state = address.getString("state", "");
                                String postcode = address.getString("postcode", "");
                                String country = address.getString("country", "");

                                // Construir la dirección
                                StringBuilder locationBuilder = new StringBuilder();
                                if (!road.isEmpty()) {
                                        locationBuilder.append(road);
                                        if (!suburb.isEmpty()) {
                                                locationBuilder.append(", ").append(suburb);
                                        }
                                } else if (!village.isEmpty()) {
                                        locationBuilder.append(village);
                                } else if (!city.isEmpty()) {
                                        locationBuilder.append(city);
                                }

                                if (!postcode.isEmpty()) {
                                        locationBuilder.append(" ").append(postcode);
                                }
                                if (!state.isEmpty()) {
                                        if (locationBuilder.length() > 0) locationBuilder.append(", ");
                                        locationBuilder.append(state);
                                }
                                if (!country.isEmpty()) {
                                        if (locationBuilder.length() > 0) locationBuilder.append(", ");
                                        locationBuilder.append(country);
                                }

                                location = locationBuilder.toString();
                        }
                } catch (Exception e) {
                        _log.error("Error fetching location from coordinates", e);
                }

                return location;
        }

        @Reference
        private Portal _portal;



}
