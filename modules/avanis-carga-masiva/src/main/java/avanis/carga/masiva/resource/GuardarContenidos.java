package avanis.carga.masiva.resource;

import avanis.carga.masiva.constants.AvanisCargaMasivaPortletKeys;
import avanis.carga.masiva.helper.CargaMasivaHelper;
import avanis.utils.api.util.CargaMasivaUtils;
import avanis.utils.api.util.EstructurasUtils;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AvanisCargaMasivaPortletKeys.AVANISCARGAMASIVA,
        "mvc.command.name=/guardar_contenidos"
    },
    service = MVCResourceCommand.class
)
public class GuardarContenidos extends BaseMVCResourceCommand {
    private static final Log _log = LogFactoryUtil.getLog(GuardarContenidos.class);

    @Reference
    private CargaMasivaUtils _cargaMasivaUtils;

    @Reference
    private EstructurasUtils _estructurasUtils;

    @Reference
    private CargaMasivaHelper _cargaMasivaHelper;

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        _log.info("Iniciamos Carga masiva");
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
        String estructuraId = uploadRequest.getParameter("estructuraId");
        File archivo = uploadRequest.getFile("csvFile");
        String mappingsJson = uploadRequest.getParameter("mappings");

        JSONObject mappings = JSONFactoryUtil.createJSONObject(mappingsJson);

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

        String jsonMapeo = _cargaMasivaUtils.getMapaValoresCSV();
        JSONObject mapeo = JSONFactoryUtil.createJSONObject(jsonMapeo);

        List<String> cabeceras = _cargaMasivaUtils.getCabeceraAyudas();

        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
        long groupId = serviceContext.getScopeGroupId();
        long userId = serviceContext.getUserId();

        DDMTemplate template = _estructurasUtils.getTemplatePorEstructuraId(Long.parseLong(estructuraId));
        String templateKey = template.getTemplateKey();

        for (String[] fila : csvData) {
            JSONObject jsonContenido = JSONFactoryUtil.createJSONObject();
            Iterator<String> keys = mappings.keys();

            while (keys.hasNext()) {
                String idCampoEstructura = keys.next();
                String nombreColumnaCSV = mappings.getString(idCampoEstructura);
                String nombreVisibleColumna = nombreColumnaCSV.split(":")[1];

                int index = cabeceras.indexOf(nombreVisibleColumna);
                if (index != -1 && index < fila.length) {
                    String valorActual = fila[index];

                    if (mapeo.has(nombreVisibleColumna)) {
                        JSONObject valoresMapeados = mapeo.getJSONObject(nombreVisibleColumna);
                        if (valoresMapeados.has(valorActual)) {
                            valorActual = valoresMapeados.getString(valorActual);
                        }
                    }

                    if (idCampoEstructura.startsWith("Date")) {
                        valorActual = convertirFecha(valorActual);
                    }

                    if (valorActual == null || valorActual.trim().isEmpty()) {
                        valorActual = StringPool.TRIPLE_PERIOD;
                    }

                    jsonContenido.put(idCampoEstructura, valorActual);
                }
            }

            String xmlContent = "<root available-locales=\"es_ES\" default-locale=\"es_ES\">";
            for (String key : jsonContenido.keySet()) {
                xmlContent += "<dynamic-element name=\"" + key + "\" type=\"text\">";
                xmlContent += "<dynamic-content language-id=\"es_ES\"><![CDATA[" + jsonContenido.getString(key) + "]]></dynamic-content>";
                xmlContent += "</dynamic-element>";
            }
            xmlContent += "</root>";

            // Buscar dinámicamente el campo de título
            String campoTitulo = "";
            Iterator<String> keysTitulo = mappings.keys();
            while (keysTitulo.hasNext()) {
                String idCampo = keysTitulo.next();
                String nombreColumna = mappings.getString(idCampo);

                if (nombreColumna.contains("Titulo")) {  // Buscar "Titulo" en los nombres mapeados
                    campoTitulo = idCampo;
                    break;
                }
            }

            Map<Locale, String> titleMap = new HashMap<>();
            if (!campoTitulo.isEmpty() && jsonContenido.has(campoTitulo)) {
                titleMap.put(LocaleUtil.getDefault(), jsonContenido.getString(campoTitulo));
            } else {
                titleMap.put(LocaleUtil.getDefault(), "Título por defecto"); // Evitar valores nulos
            }

            Map<Locale, String> descriptionMap = new HashMap<>();
            descriptionMap.put(LocaleUtil.getDefault(), "Contenido generado desde CSV");

            serviceContext.setScopeGroupId(groupId);
            serviceContext.setUserId(userId);
            serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);

            try {
                JournalArticle article = _journalArticleLocalService.addArticle(
                        "",                      // externalReferenceCode (vacío si no es necesario)
                        userId,                  // ID del usuario
                        groupId,                 // ID del grupo (Sitio)
                        _estructurasUtils.getFolderAyudas(), // ID de la carpeta (0 para raíz)
                        titleMap,                // Título (Mapeado con Locale)
                        descriptionMap,          // Descripción (Mapeada con Locale)
                        xmlContent,              // Contenido en formato XML
                        Long.parseLong(estructuraId), // ID de la estructura asociada
                        templateKey,             // Clave de la plantilla asociada
                        serviceContext           // Contexto del servicio
                );

                _log.info("*** Contenido creado en Liferay con ID: " + article.getArticleId()+ " / Titulo: "+ article.getTitle());

            } catch (Exception e) {
                _log.error("--- Error al guardar el contenido del archivo -> "+jsonContenido.getString(campoTitulo));
            }
        }

        _log.info("Finaliza Carga masiva");
    }

    private String convertirFecha(String fechaOriginal) {
        try {
            SimpleDateFormat formatoEntrada;

            // Verificar si la fecha tiene hora
            if (fechaOriginal.matches("\\d{2}-\\d{2}-\\d{4} \\d{1,2}:\\d{2}(:\\d{2})?")) {
                formatoEntrada = new SimpleDateFormat("dd-MM-yyyy H:mm:ss");

                // Si la fecha viene sin segundos, agregamos ":00" para evitar errores
                if (!fechaOriginal.matches("\\d{2}-\\d{2}-\\d{4} \\d{1,2}:\\d{2}:\\d{2}")) {
                    fechaOriginal += ":00";
                }
            } else {
                // Formato de fecha sin hora
                formatoEntrada = new SimpleDateFormat("dd-MM-yyyy");
            }

            SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");

            Date fecha = formatoEntrada.parse(fechaOriginal);
            return formatoSalida.format(fecha);
        } catch (Exception e) {
            _log.error("Error al convertir la fecha: " + fechaOriginal, e);

            //Si la fecha es inválida o vacía, asignamos la fecha de hoy
            SimpleDateFormat formatoHoy = new SimpleDateFormat("yyyy-MM-dd");
            return formatoHoy.format(new Date());
        }
    }
}
