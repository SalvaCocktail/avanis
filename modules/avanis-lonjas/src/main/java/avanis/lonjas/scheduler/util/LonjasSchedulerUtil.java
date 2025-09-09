package avanis.lonjas.scheduler.util;

import avanis.lonjas.model.Area;
import avanis.lonjas.model.FechaLonja;
import avanis.lonjas.model.Grupo;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.model.SubGrupo;
import avanis.lonjas.service.AreaLocalService;
import avanis.lonjas.service.FechaLonjaLocalService;
import avanis.lonjas.service.GrupoLocalService;
import avanis.lonjas.service.LonjaLocalService;
import avanis.lonjas.service.PrecioLonjaLocalService;
import avanis.lonjas.service.SubGrupoLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = LonjasSchedulerUtil.class
)
public class LonjasSchedulerUtil {

    private static final Log _log = LogFactoryUtil.getLog(LonjasSchedulerUtil.class);
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    private final SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sdfUrl = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat sdfPreciosLonja = new SimpleDateFormat("yyyy-MM-dd");

    @Reference
    private AreaLocalService _areaLocalService;

    @Reference
    private FechaLonjaLocalService _fechaLonjaLocalService;

    @Reference
    private GrupoLocalService _grupoLocalService;

    @Reference
    private SubGrupoLocalService _subGrupoLocalService;

    @Reference
    private LonjaLocalService _lonjaLocalService;

    @Reference
    private PrecioLonjaLocalService _precioLonjaLocalService;

    @Reference
    private CounterLocalService _counterLocalService;

    public String getInformation(String entityName, String urlBase) {
        _log.debug("Fetching information for entity: " + entityName + " from URL: " + urlBase);
        try {
            return sendGetRequest(urlBase);
        } catch (Exception e) {
            _log.error("Error fetching information for entity: " + entityName, e);
            return null;
        }
    }

    private void logNodeStructure(Document doc) {
        _log.debug("Logging XML structure...");
        NodeList allNodes = doc.getChildNodes();
        for (int i = 0; i < allNodes.getLength(); i++) {
            Node node = allNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                _log.debug("Root Node: " + node.getNodeName());
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        _log.debug("Child Node: " + childNode.getNodeName());
                    }
                }
            }
        }
    }

    public void saveLonjas(String response) {
        try {
            Document doc = parseXMLFromString(response);
            if (doc == null) {
                _log.debug("Document is null for Lonjas.");
                return;
            }

            NodeList parentNodes = doc.getElementsByTagName("ListaLonjas");
            if (parentNodes.getLength() == 0) {
                _log.debug("No parent nodes found for Lonjas.");
                return;
            }

            Node parentNode = parentNodes.item(0);
            NodeList childNodes = ((Element) parentNode).getElementsByTagName("Lonja");

            if (childNodes.getLength() == 0) {
                _log.debug("No child nodes found for Lonjas.");
                return;
            }

            _log.debug("Found " + childNodes.getLength() + " Lonja nodes.");

            for (int i = 0; i < childNodes.getLength(); i++) {
                Element element = (Element) childNodes.item(i);
                saveLonja(element);
            }
        } catch (Exception e) {
            _log.error("Error saving Lonjas.", e);
        }
    }

    private void saveLonja(Element element) {
        String id = element.getAttribute("Id");
        if (id.isEmpty()) {
            return;
        }

        String nombre = getTagValue("Nombre", element);
        String pais = getTagValue("Pais", element);

        List<Lonja> existingLonjas = _lonjaLocalService.getLonjaBylonjaId(Long.parseLong(id));
        if (existingLonjas != null && !existingLonjas.isEmpty()) {
            _log.debug("Lonja con ID " + id + " ya existe. Saltando...");
            return;
        }

        Lonja lonja = _lonjaLocalService.createLonja(_counterLocalService.increment());
        lonja.setLonjaId(Long.parseLong(id));
        lonja.setNombre(nombre);
        lonja.setPais(Validator.isNotNull(pais) ? pais.trim() : StringPool.BLANK);
        _lonjaLocalService.addLonja(lonja);
        _log.debug("Saved Lonja: ID=" + id + ", Nombre=" + nombre + ", Pais=" + pais);
    }

    public void saveFechasLonjas(String response, long lonjaId) {
        try {
            Document doc = parseXMLFromString(response);
            if (doc == null) {
                _log.debug("El documento XML de Fechas Lonjas es nulo.");
                return;
            }

            // Buscar los nodos "Celebracion"
            NodeList celebracionesNodes = doc.getElementsByTagName("Celebracion");
            if (celebracionesNodes.getLength() == 0) {
                _log.debug("No se encontraron nodos de Celebracion.");
                return;
            }

            _log.debug("Encontradas " + celebracionesNodes.getLength() + " Celebraciones para Lonja ID: " + lonjaId);

            for (int i = 0; i < celebracionesNodes.getLength(); i++) {
                Element element = (Element) celebracionesNodes.item(i);
                saveFechaLonja(element, lonjaId);
            }
        } catch (Exception e) {
            _log.error("Error al procesar las Fechas Lonjas (Celebraciones).", e);
        }
    }

    private void saveFechaLonja(Element element, long lonjaId) {
        String fechaStr = element.getTextContent().trim();

        if (fechaStr.isEmpty()) {
            _log.debug("Fecha de Celebracion vacía para Lonja ID: " + lonjaId);
            return;
        }

        try {
            Date fecha = sdfInput.parse(fechaStr);

            // Verificar duplicados
            List<FechaLonja> existingFechas = _fechaLonjaLocalService.getFechaLonjaByLonjaId(lonjaId);
            boolean exists = existingFechas.stream().anyMatch(f -> f.getFecha().equals(new Timestamp(fecha.getTime())));

            if (exists) {
                _log.debug("La fecha " + fechaStr + " ya existe para Lonja ID: " + lonjaId + ". Skipping...");
                return;
            }

            // Guardar la nueva fecha de celebración
            FechaLonja fechaLonja = _fechaLonjaLocalService.createFechaLonja(_counterLocalService.increment());
            fechaLonja.setLonjaId(lonjaId);
            fechaLonja.setFecha(new Timestamp(fecha.getTime()));
            _fechaLonjaLocalService.addFechaLonja(fechaLonja);

            _log.debug("Guardada Fecha de Celebracion: LonjaId=" + lonjaId + ", Fecha=" + fechaStr);
        } catch (Exception e) {
            _log.error("Error al procesar la fecha de Celebracion: " + fechaStr, e);
        }
    }

    public void saveGrupos(String response) {
        try {
            Document doc = parseXMLFromString(response);
            if (doc == null) {
                _log.debug("Document is null for Grupos.");
                return;
            }

            logNodeStructure(doc);

            NodeList parentNodes = doc.getElementsByTagName("ListaGrupos");
            if (parentNodes.getLength() == 0) {
                _log.debug("No parent nodes found for Grupos.");
                return;
            }

            Node parentNode = parentNodes.item(0); // Nodo contenedor principal
            NodeList childNodes = ((Element) parentNode).getElementsByTagName("Grupo");

            if (childNodes.getLength() == 0) {
                _log.debug("No child nodes found for Grupos.");
                return;
            }

            _log.debug("Found " + childNodes.getLength() + " Grupo nodes.");

            for (int i = 0; i < childNodes.getLength(); i++) {
                Element element = (Element) childNodes.item(i);
                saveGrupo(element);
            }
        } catch (Exception e) {
            _log.error("Error processing Grupos.", e);
        }
    }

    private void saveGrupo(Element element) {
        String id = element.getAttribute("Id");
        if (id.isEmpty()) {
            return;
        }

        String nombre = getTagValue("Nombre", element);
        Grupo existingGrupo = _grupoLocalService.findByGroupId(Long.parseLong(id));

        if (existingGrupo != null) {
            _log.debug("Grupo with ID " + id + " already exists. Skipping...");
            return;
        }

        Grupo grupo = _grupoLocalService.createGrupo(_counterLocalService.increment(Grupo.class.getName()));
        grupo.setGrupoId(Long.parseLong(id));
        grupo.setNombre(nombre);
        _grupoLocalService.addGrupo(grupo);
        _log.debug("Saved Grupo: ID=" + id + ", Nombre=" + nombre);
    }

    public void saveSubGrupos(String response) {
        try {
            Document doc = parseXMLFromString(response);
            if (doc == null) {
                _log.debug("Document is null for SubGrupos.");
                return;
            }

            logNodeStructure(doc);

            NodeList parentNodes = doc.getElementsByTagName("ListaSubgrupos");
            if (parentNodes.getLength() == 0) {
                _log.debug("No parent nodes found for SubGrupos.");
                return;
            }

            Node parentNode = parentNodes.item(0); // Nodo contenedor principal
            NodeList childNodes = ((Element) parentNode).getElementsByTagName("Subgrupo");

            if (childNodes.getLength() == 0) {
                _log.debug("No child nodes found for SubGrupos.");
                return;
            }

            _log.debug("Found " + childNodes.getLength() + " Subgrupo nodes.");

            for (int i = 0; i < childNodes.getLength(); i++) {
                Element element = (Element) childNodes.item(i);
                saveSubGrupo(element);
            }
        } catch (Exception e) {
            _log.error("Error processing SubGrupos.", e);
        }
    }

    private void saveSubGrupo(Element element) {
        String id = element.getAttribute("Id");
        String grupoId = element.getAttribute("IdGrupo");
        if (id.isEmpty() || grupoId.isEmpty()) {
            _log.debug("SubGrupo with ID " + id + " or GrupoId " + grupoId + " is invalid. Skipping...");
            return;
        }

        String nombre = getTagValue("Nombre", element);
        SubGrupo existingSubGrupo = _subGrupoLocalService.findBySubGroupId(Long.parseLong(id));

        if (existingSubGrupo != null) {
            _log.debug("SubGrupo with ID " + id + " already exists. Skipping...");
            return;
        }

        SubGrupo subGrupo = _subGrupoLocalService.createSubGrupo(_counterLocalService.increment(SubGrupo.class.getName()));
        subGrupo.setSubGrupoId(Long.parseLong(id));
        subGrupo.setGrupoId(Long.parseLong(grupoId));
        subGrupo.setNombre(nombre);
        _subGrupoLocalService.addSubGrupo(subGrupo);
        _log.debug("Saved SubGrupo: ID=" + id + ", GrupoId=" + grupoId + ", Nombre=" + nombre);
    }

    private void saveArea(Element element) {
        String id = element.getAttribute("Id");
        String subGrupoId = element.getAttribute("IdSubgrupo");
        String grupoId = element.getAttribute("IdGrupo");

        if (id.isEmpty() || subGrupoId.isEmpty() || grupoId.isEmpty()) {
            _log.debug("Area with invalid attributes. Skipping...");
            return;
        }

        String nombre = getTagValue("Nombre", element);
        Area existingArea = _areaLocalService.findByAreaId(Long.parseLong(id));

        if (existingArea != null) {
            _log.debug("Area with ID " + id + " already exists. Skipping...");
            return;
        }

        Area area = _areaLocalService.createArea(Long.parseLong(id));
        area.setAreaId(Long.parseLong(id));
        area.setSubGrupoId(Long.parseLong(subGrupoId));
        area.setGrupoId(Long.parseLong(grupoId));
        area.setNombre(nombre);

        _areaLocalService.addArea(area);
        _log.debug("Saved Area: ID=" + id + ", SubGrupoID=" + subGrupoId + ", GrupoID=" + grupoId + ", Nombre=" + nombre);
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag);
        String value = (nodes.getLength() > 0) ? nodes.item(0).getTextContent().trim() : null;

        if (value == null || value.isEmpty()) {
            _log.debug("No se encontró valor para la etiqueta: " + tag);
        }
        return value;
    }

    private Document parseXMLFromString(String xmlContent) {
        try {
            xmlContent = xmlContent.replaceAll("<!DOCTYPE[^>]*>", "");
            InputSource inputSource = new InputSource(new StringReader(xmlContent));
            inputSource.setEncoding("ISO-8859-1");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(inputSource);
        } catch (Exception e) {
            _log.error("Error parsing XML content", e);
            return null;
        }
    }

    private String sendGetRequest(String urlBase) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlBase))
                    .timeout(java.time.Duration.ofSeconds(10))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                _log.debug("GET request failed with status: " + response.statusCode());
            }
        } catch (Exception e) {
            _log.error("Error sending GET request", e);
        }
        return null;
    }

    public void saveAreas(String response) {
        try {
            Document doc = parseXMLFromString(response);
            if (doc == null) {
                _log.debug("Document is null for Areas.");
                return;
            }

            NodeList parentNodes = doc.getElementsByTagName("ListaAreas");
            if (parentNodes.getLength() == 0) {
                _log.debug("No parent nodes found for Areas.");
                return;
            }

            Node parentNode = parentNodes.item(0);
            NodeList childNodes = ((Element) parentNode).getElementsByTagName("Area");

            if (childNodes.getLength() == 0) {
                _log.debug("No child nodes found for Areas.");
                return;
            }

            _log.debug("Found " + childNodes.getLength() + " Area nodes.");

            for (int i = 0; i < childNodes.getLength(); i++) {
                Element element = (Element) childNodes.item(i);
                saveArea(element);
            }
        } catch (Exception e) {
            _log.error("Error saving Areas.", e);
        }
    }

    public void savePreciosLonjas(String response, long lonjaId, String fechaStr) {
        try {
            Document doc = parseXMLFromString(response);
            if (doc == null) {
                _log.debug("El documento XML de Precios Lonjas es nulo.");
                return;
            }

            NodeList precioNodes = doc.getElementsByTagName("Precio");
            if (precioNodes.getLength() == 0) {
                _log.debug("No se encontraron nodos de Precio para Lonja ID: " + lonjaId + " en la fecha: " + fechaStr);
                return;
            }

            Date fecha = sdfPreciosLonja.parse(fechaStr);

            _log.debug("Found " + precioNodes.getLength() + " Precio nodes for Lonja ID: " + lonjaId + " on date: " + fechaStr);

            List<PrecioLonja> existingPrecios = _precioLonjaLocalService.getPrecioLonjaByLonjaId(lonjaId);

            Map<String, PrecioLonja> existingPrecioMap = existingPrecios.stream()
                    .collect(Collectors.toMap(
                            pl -> pl.getProductoId() + "|" + sdfPreciosLonja.format(pl.getFecha()),
                            pl -> pl,
                            (existing, duplicate) -> {
                                _log.debug("Duplicate entry detected: " + existing + " and " + duplicate);
                                return existing; // or decide how to handle duplicates
                            }
                    ));

            for (int i = 0; i < precioNodes.getLength(); i++) {
                Element element = (Element) precioNodes.item(i);
                savePrecioLonjaIfNotExists(element, lonjaId, fecha, existingPrecioMap);
            }
        } catch (Exception e) {
            _log.error("Error processing Precios Lonjas.", e);
        }
    }

    private void savePrecioLonjaIfNotExists(Element precioElement, long lonjaId, Date fecha, Map<String, PrecioLonja> existingPrecioMap) {
        try {
            long idProducto = Long.parseLong(precioElement.getAttribute("Id"));

            String validationKey = idProducto + "|" + sdfPreciosLonja.format(fecha);

            if (existingPrecioMap.containsKey(validationKey)) {
                _log.debug("El precio ya existe para ProductoId=" + idProducto + ", Fecha=" + sdfPreciosLonja.format(fecha) + ", LonjaId=" + lonjaId);
                return;
            }

            String nombreProducto = precioElement.getAttribute("NombreProducto");
            long areaId = Long.parseLong(precioElement.getAttribute("IdArea"));
            long subGrupoId = Long.parseLong(precioElement.getAttribute("IdSubgrupo"));
            long grupoId = Long.parseLong(precioElement.getAttribute("IdGrupo"));

            String unidadMedida = getTagContent(precioElement, "UnidadMedida");
            String unidadLarga = getTagContent(precioElement, "UnidadLarga");
            String precioOrigen = getTagContent(precioElement, "PrecioOrigen");
            String precioAnterior = getTagContent(precioElement, "PrecioAnterior");
            String precioUltimo = getTagContent(precioElement, "PrecioUltimo");
            String anteriorEuros = getTagContent(precioElement, "AnteriorEuros");
            String ultimoEuros = getTagContent(precioElement, "UltimoEuros");

            PrecioLonja precioLonja = _precioLonjaLocalService.createPrecioLonja(_counterLocalService.increment());
            precioLonja.setLonjaId(lonjaId);
            precioLonja.setFecha(new Timestamp(fecha.getTime()));
            precioLonja.setProductoId(idProducto);
            precioLonja.setNombreProducto(nombreProducto);
            precioLonja.setAreaId(areaId);
            precioLonja.setSubGrupoId(subGrupoId);
            precioLonja.setGrupoId(grupoId);
            precioLonja.setPrecioAnterior(precioAnterior);
            precioLonja.setPrecioUltimo(precioUltimo);
            precioLonja.setUnidadMedida(unidadMedida);
            precioLonja.setUnidadLarga(unidadLarga);
            precioLonja.setPrecioOrigen(precioOrigen);
            precioLonja.setAnteriorEuros(anteriorEuros);
            precioLonja.setUltimoEuros(ultimoEuros);
            precioLonja.setCreateDate(new Timestamp(new Date().getTime()));
            precioLonja.setModifiedDate(new Timestamp(new Date().getTime()));

            _precioLonjaLocalService.addPrecioLonja(precioLonja);

            _log.debug("Guardado Precio de Lonja: ProductoId=" + idProducto + ", Fecha=" + sdfPreciosLonja.format(fecha)
                    + ", LonjaId=" + lonjaId);
        } catch (Exception e) {
            _log.error("Error al guardar el precio de LonjaID -> "+lonjaId+" -> Fecha -> "+sdfPreciosLonja.format(fecha));
            _log.debug("Error al guardar el precio de Lonja", e);
        }
    }

    private String getTagContent(Element element, String tagName) {
        NodeList nodes = element.getElementsByTagName(tagName);
        return (nodes.getLength() > 0) ? nodes.item(0).getTextContent().trim() : null;
    }

    public List<Date> getFechasSinPrecios(long lonjaId) {
        return _fechaLonjaLocalService.getFechaLonjaByLonjaId(lonjaId).stream()
                .filter(fechaLonja -> _precioLonjaLocalService.getPrecioLonjaByLonjaIdByFecha(
                        lonjaId, fechaLonja.getFecha()).isEmpty())
                .map(FechaLonja::getFecha)
                .collect(Collectors.toList());
    }

    public String formatFechaToUrl(Date fecha) {
        return sdfUrl.format(fecha);
    }
}
