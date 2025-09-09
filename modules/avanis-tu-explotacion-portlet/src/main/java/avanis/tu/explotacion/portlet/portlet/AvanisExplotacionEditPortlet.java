package avanis.tu.explotacion.portlet.portlet;

import avanis.tu.explotacion.portlet.constants.AvanisTuExplotacionPortletKeys;
import avanis.tu.explotacion.portlet.portlet.util.ElevationUtil;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import avanis.utils.api.util.AvanisUtils;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author angelperez
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AvanisExplotacionEdit",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/createOrUpdate.jsp",
                "javax.portlet.name=" + AvanisTuExplotacionPortletKeys.AVANIS_EXPLOTACION_EDIT,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AvanisExplotacionEditPortlet extends MVCPortlet {
    private static Log _log = LogFactoryUtil.getLog(AvanisExplotacionEditPortlet.class);
    private static final String REDIRECT_EXPLOTACION_AFTER_SUBMIT = "/explotacion?plotId=";
    private static final String REDIRECT_PRIVATE_PROFILE_AFTER_SUBMIT = "/mi-perfil-privado?focusedTab=plots";
    private static final String AGRICULTURE_CATEGORY_ERC = "430e1e1e-7616-44ad-a676-9ff31364353c";
    private static final String STOCKBREADING_CATEGORY_ERC = "942f8363-2b82-45ab-95c7-0a5d1a63c2e4";

    @Reference
    private AvanisUtils _avanisUtils;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        String idParam = httpReq.getParameter("id");
        String redirectParam = httpReq.getParameter("redirect");

        if (idParam != null && !idParam.isEmpty()) {
            editForm(renderRequest, idParam);
        }

        addCategoriesToRequest(renderRequest);

        renderRequest.setAttribute("redirectParam", redirectParam);

        super.doView(renderRequest, renderResponse);
    }

    private void addCategoriesToRequest(RenderRequest req) {

        try {
            long groupId = 20119; //Global group
            long agricultureCategoryId = AssetCategoryLocalServiceUtil.getAssetCategoryByExternalReferenceCode(AGRICULTURE_CATEGORY_ERC, groupId).getCategoryId();
            long stockbreadingCategoryId = AssetCategoryLocalServiceUtil.getAssetCategoryByExternalReferenceCode(STOCKBREADING_CATEGORY_ERC, groupId).getCategoryId();

            List<AssetCategory> agricultureCategories = AssetCategoryLocalServiceUtil.getChildCategories(agricultureCategoryId);
            List<AssetCategory> stockbreadingCategories = AssetCategoryLocalServiceUtil.getChildCategories(stockbreadingCategoryId);

            req.setAttribute("agricultureCategories", agricultureCategories);
            req.setAttribute("stockbreadingCategories", stockbreadingCategories);

        } catch (PortalException e) {
            _log.error(e);
        }

    }

    @ProcessAction(name = "getLocation")
    public void getLocation(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        double latitude = ParamUtil.getDouble(actionRequest, "latitude");
        double longitude = ParamUtil.getDouble(actionRequest, "longitude");

        String location = getFullLocationFromCoordinates(String.valueOf(latitude), String.valueOf(longitude));

        actionRequest.setAttribute("location", location);
    }


    private void editForm(RenderRequest renderRequest, String id) {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();
        long explotacionId = parseId(id);

        try {
            Explotacion explotacion = ExplotacionLocalServiceUtil.getExplotacion(explotacionId);

            if (principal.getUserId() == explotacion.getUserId()) {
                renderRequest.setAttribute("explotacion", explotacion);

                AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Explotacion.class.getName(), explotacionId);
                if (assetEntry != null) {
                    List<AssetCategory> categories = assetEntry.getCategories();
                    renderRequest.setAttribute("selectedCategories", categories);
                    renderRequest.setAttribute("latitude", explotacion.getLatitude());
                    renderRequest.setAttribute("longitude", explotacion.getLongitude());
                    renderRequest.setAttribute("size", explotacion.getSize());
                    renderRequest.setAttribute("sizeUnit", explotacion.getSizeUnit());

                }
            }

        } catch (PortalException e) {
            _log.error(e);
        }
    }

    @ProcessAction(name = "createOrUpdate")
    public void createOrUpdate(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        try {
            long explotacionId = parseId(ParamUtil.getString(actionRequest, "explotacionId", "0"));
            String externalReferenceCode = null;
            Double longitude = ParamUtil.getDouble(actionRequest, "longitude");
            Double latitude = ParamUtil.getDouble(actionRequest, "latitude");

            int height = ElevationUtil.getElevation(latitude, longitude);

            String name = _avanisUtils.sanitizeInput(ParamUtil.getString(actionRequest, "name"));
            String meteoredid = ParamUtil.getString(actionRequest, "meteoredid");
            int size = ParamUtil.getInteger(actionRequest, "size");
            String sizeUnit = ParamUtil.getString(actionRequest, "sizeUnit");
            boolean isMain = ParamUtil.getBoolean(actionRequest, "isMain");
            boolean allowNotifications = ParamUtil.getBoolean(actionRequest, "allowNotifications");
            long[] categories = ParamUtil.getLongValues(actionRequest, "categoryIds");

            String provincia = getProvinceFromCoordinates(String.valueOf(latitude), String.valueOf(longitude));
            String location = getLocationFromCoordinates(String.valueOf(latitude), String.valueOf(longitude));

            Explotacion explotacionCreated = ExplotacionLocalServiceUtil.createOrUpdate(
                    explotacionId,
                    externalReferenceCode,
                    provincia,
                    longitude,
                    height,
                    location,
                    name,
                    latitude,
                    meteoredid,
                    size,
                    sizeUnit,
                    isMain,
                    allowNotifications,
                    principal,
                    categories,
                    false);

            String currentURL = themeDisplay.getURLCurrent();
            if (currentURL.contains("/mi-perfil-privado/edit")) {
                actionResponse.sendRedirect(REDIRECT_PRIVATE_PROFILE_AFTER_SUBMIT);
            } else {
                actionResponse.sendRedirect(REDIRECT_EXPLOTACION_AFTER_SUBMIT + explotacionCreated.getExplotacionId());
            }

        } catch (PortalException | NumberFormatException e) {
            _log.error(e);
            actionRequest.setAttribute("error", "error.message.explotacion.form");
            throw new RuntimeException();
        }
    }

    private long parseId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String getProvinceFromCoordinates(String latitude, String longitude) {
        String province = "";
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
                // Prefer province, fallback to town or city
                String provinceResult = address.getString("province", null);
                String town = address.getString("town", null);
                String city = address.getString("city", null);
                String locality = address.getString("locality", null);
                String village = address.getString("village", null);

                province = (provinceResult != null) ? provinceResult :
                        (town != null) ? town :
                                (city != null) ? city :
                                        (locality != null) ? locality :
                                                (village != null) ? village : "";
            }


        } catch (Exception e) {
            _log.error("Error fetching province from coordinates", e);
        }

        return province;
    }

    private String getLocationFromCoordinates(String latitude, String longitude) {
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

            String city = address.getString("city", null);
            String locality = address.getString("locality", null);
            String village = address.getString("village", null);

            String locationResult = address.getString("town", null);

            location = (locationResult != null) ? locationResult :
                    (city != null) ? city :
                            (locality != null) ? locality :
                                    (village != null) ? village : "";

        } catch (Exception e) {
            _log.error("Error fetching location from coordinates", e);
        }

        return location;
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

}
