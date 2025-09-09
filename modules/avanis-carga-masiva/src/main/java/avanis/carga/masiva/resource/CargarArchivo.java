package avanis.carga.masiva.resource;

import avanis.carga.masiva.constants.AvanisCargaMasivaPortletKeys;
import avanis.carga.masiva.helper.CargaMasivaHelper;
import avanis.utils.api.util.CargaMasivaUtils;
import avanis.utils.api.util.EstructurasUtils;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AvanisCargaMasivaPortletKeys.AVANISCARGAMASIVA,
                "mvc.command.name=/procesar_csv"
        },
        service = MVCResourceCommand.class
)
public class CargarArchivo extends BaseMVCResourceCommand {

    private static final Log _log = LogFactoryUtil.getLog(CargarArchivo.class);

    @Reference
    private CargaMasivaUtils _cargaMasivaUtils;

    @Reference
    private EstructurasUtils _estructurasUtils;

    @Reference
    private CargaMasivaHelper _cargaMasivaHelper;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        try {
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
            String estructuraId = ParamUtil.getString(uploadRequest, "estructuraId");
            File archivo = uploadRequest.getFile("csvFile");

            if (archivo == null || archivo.length() == 0) {
                _log.error("Archivo inválido o vacío.");
                return;
            }

            _cargaMasivaHelper.verificarEncoding(archivo);
            archivo = _cargaMasivaHelper.convertirAUTF8(archivo);

            List<String[]> csvData = _cargaMasivaHelper.leerCSV(archivo);
            if (csvData.isEmpty()) {
                _log.error("No se encontraron datos en el archivo CSV.");
                return;
            }

            Map<String, String> estructuraCampos = _estructurasUtils.getCamposPorEstructuraId(Long.parseLong(estructuraId));

            // Obtener JSON de configuración
            String jsonMapeo = _cargaMasivaUtils.getMapaValoresCSV();
            JSONObject mapeo = JSONFactoryUtil.createJSONObject(jsonMapeo);

            // Obtener la cabecera definida en la configuración
            List<String> cabeceras = _cargaMasivaUtils.getCabeceraAyudas();

            // Procesar datos para reemplazar valores numéricos con texto
            for (String[] fila : csvData) {
                for (int i = 0; i < Math.min(cabeceras.size(), fila.length); i++) { // Evitar IndexOutOfBoundsException
                    String key = cabeceras.get(i).trim(); // Obtener el nombre de la columna según la configuración

                    if (mapeo.has(key)) {
                        JSONObject valoresMapeados = mapeo.getJSONObject(key);

                        String valorActual = fila[i].trim();
                        if (valoresMapeados.has(valorActual)) {
                            String valorReemplazado = valoresMapeados.getString(valorActual);
                            fila[i] = valorReemplazado;
                        }
                    }
                }
            }

            resourceRequest.setAttribute("estructuraCampos", estructuraCampos);
            resourceRequest.setAttribute("estructuraId", estructuraId);
            resourceRequest.setAttribute("cabeceras", cabeceras);
            resourceRequest.setAttribute("csvData", csvData);

            JSONArray csvDataJSON = JSONFactoryUtil.createJSONArray(csvData);
            resourceRequest.setAttribute("csvDataJSON", csvDataJSON.toString());

            PortletRequestDispatcher dispatcher = getPortletRequestDispatcher(resourceRequest, "/view2.jsp");
            dispatcher.include(resourceRequest, resourceResponse);

        } catch (Exception e) {
            _log.error("Error al procesar el archivo CSV", e);
        }
    }


}