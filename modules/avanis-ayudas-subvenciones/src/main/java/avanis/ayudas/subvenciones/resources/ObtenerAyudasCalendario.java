package avanis.ayudas.subvenciones.resources;

import avanis.ayudas.subvenciones.constants.AvanisAyudasSubvencionesPortletKeys;
import avanis.ayudas.subvenciones.util.AyudasSubvencionesUtils;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import avanis.ayudas.subvenciones.cache.AyudasCacheUtil;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Enumeration;


/**
 * @author Victor Antunez
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name="+ AvanisAyudasSubvencionesPortletKeys.AVANISAYUDASSUBVENCIONESGENERAL,
        "mvc.command.name="+ AvanisAyudasSubvencionesPortletKeys.OBTENERAYUDASCALENDARIO
    },
    service = MVCResourceCommand.class,
    configurationPid = "avanis.ayudas.subvenciones.configuration.AyudasSubvencionesConfig",
    configurationPolicy = ConfigurationPolicy.OPTIONAL
)
public class ObtenerAyudasCalendario extends BaseMVCResourceCommand {

    @Reference
    private AyudasSubvencionesUtils _ayudasSubvencionesUtils;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        // Leer el cuerpo de la solicitud
        StringBuilder jsonString = new StringBuilder();
        try (BufferedReader reader = resourceRequest.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
        }

        // Parsear el JSON recibido
        JSONObject requestBody = JSONFactoryUtil.createJSONObject(jsonString.toString());
        int mes = requestBody.getInt("mes", new Date().getMonth() + 1); // Valor predeterminado: mes actual
        int anio = requestBody.getInt("anio", new Date().getYear() + 1900);

        // Generar una clave única para la caché basada en mes y año
        String cacheKey = "ayudas_calendario_" + mes + "_" + anio;

        // Intentar obtener las ayudas desde la caché
        List<Map<String, Object>> allAyudas = (List<Map<String, Object>>) AyudasCacheUtil.getFromCache(cacheKey);

        if (allAyudas == null) {
            // Si no están en la caché, obtenerlas desde la fuente original
            allAyudas = _ayudasSubvencionesUtils.obtenerDatosArticulosPorMes(themeDisplay, mes, anio);

            // Almacenar las ayudas en la caché
            AyudasCacheUtil.addToCache(cacheKey, allAyudas);
        }



        // Filtrar las ayudas por mes y año
        //List<Map<String, Object>> allAyudas = _ayudasSubvencionesUtils.obtenerDatosArticulosPorMes(themeDisplay, mes, anio);

        JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
        responseJSON.put("allAyudas", allAyudas);

        resourceResponse.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = resourceResponse.getWriter();
        writer.write(responseJSON.toString());
        writer.flush();
        writer.close();
    }


}
