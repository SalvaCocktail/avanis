package avanis.lonjas.resource;

import avanis.lonjas.cache.LonjasCacheUtil;
import avanis.lonjas.constants.AvanisLonjasPortletKeys;
import avanis.lonjas.model.Area;
import avanis.lonjas.model.Grupo;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.service.AreaLocalService;
import avanis.lonjas.service.GrupoLocalService;
import avanis.lonjas.service.LonjaLocalService;
import avanis.lonjas.service.PrecioLonjaLocalService;
import avanis.lonjas.util.LonjasUtil;
import avanis.lonjas.vo.InfoProducto;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Victor Antunez
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name="+ AvanisLonjasPortletKeys.AVANISLONJASWIDGET,
        "javax.portlet.name="+ AvanisLonjasPortletKeys.AVANISLONJAS,
        "mvc.command.name="+ AvanisLonjasPortletKeys.AVANISLONJAS_OBTENERLONJASPRODCUTOS
    },
    service = MVCResourceCommand.class,
    configurationPolicy = ConfigurationPolicy.OPTIONAL
)
public class ObtenerLonjasProductos extends BaseMVCResourceCommand {
    private static final Log _log = LogFactoryUtil.getLog(ObtenerLonjasProductos.class);

    @Reference
    private PrecioLonjaLocalService _precioLonjaLocalService;

    @Reference
    private LonjaLocalService _lonjaLocalService;

    @Reference
    private GrupoLocalService _grupoLocalService;

    @Reference
    private AreaLocalService _areaLocalService;

    @Reference
    private LonjasUtil _lonjasUtil;

    @Reference
    private LonjasCacheUtil _lonjasCacheUtil;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        resourceRequest.setAttribute("isDefaultUser", themeDisplay.getUser().isDefaultUser());

        int inicio = Integer.parseInt(ParamUtil.getString(resourceRequest, "inicio"));
        int limite = Integer.parseInt(ParamUtil.getString(resourceRequest, "limite"));
        String groupId = ParamUtil.getString(resourceRequest, "groupId", "all");
        String criterioOrden = ParamUtil.getString(resourceRequest, "criterioOrden", "label-alphabetical");
        String searchTerm = ParamUtil.getString(resourceRequest, "searchTerm", "").toLowerCase();

        String lonjasSeleccionadasStr = ParamUtil.getString(resourceRequest, "lonjasSeleccionadas", "all");
        List<String> lonjasSeleccionadas = Arrays.asList(lonjasSeleccionadasStr.split(","));

        // Si la lista de lonjas seleccionadas está vacía o contiene "all", asignar "all"
        if (lonjasSeleccionadas.isEmpty() || (lonjasSeleccionadas.size() == 1 && lonjasSeleccionadas.get(0).isEmpty())) {
            lonjasSeleccionadas = Arrays.asList("all");
        }

        List<Area> listAreas = (List<Area>) _lonjasCacheUtil.getFromCache("listAreas");
        if (listAreas == null) {
            listAreas = _areaLocalService.getAreas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            _lonjasCacheUtil.addToCache("listAreas", listAreas);
        }
        resourceRequest.setAttribute("totalAreas", listAreas.size());

        // Obtener lista de precios desde el caché o servicio
        List<PrecioLonja> listPrecioLonja = (List<PrecioLonja>) _lonjasCacheUtil.getFromCache("listPrecioLonja");
        if (listPrecioLonja == null) {
            List<PrecioLonja> listPrecioLonjaAll = _precioLonjaLocalService.getPrecioLonjas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            List<PrecioLonja> listPrecioLonjaAux = listPrecioLonjaAll.stream()
                    .filter(distinctByKey(precioLonja -> precioLonja.getLonjaId() + "-" + precioLonja.getProductoId()))
                    .collect(Collectors.toList());

            listPrecioLonja = listPrecioLonjaAux.stream()
                    .map(precioLonjaAux -> _precioLonjaLocalService
                            .getPrecioLonjaByLonjaIdByProductoId(precioLonjaAux.getLonjaId(), precioLonjaAux.getProductoId(), OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false))
                            .stream()
                            .findFirst()
                            .orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            _lonjasCacheUtil.addToCache("listPrecioLonja", listPrecioLonja);
        }
        resourceRequest.setAttribute("totalPrecioLonja", listPrecioLonja.size());

        // Obtener lista de grupos desde el caché o servicio
        List<Grupo> gruposLonjas = (List<Grupo>) _lonjasCacheUtil.getFromCache("gruposLonjas");
        if (gruposLonjas == null) {
            gruposLonjas = _grupoLocalService.getGrupos(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream()
                    .peek(grupo -> grupo.setNombre(_lonjasUtil.capitalizeWords(grupo.getNombre())))
                    .collect(Collectors.toList());
            _lonjasCacheUtil.addToCache("gruposLonjas", gruposLonjas);
        }
        resourceRequest.setAttribute("gruposLonjas", gruposLonjas);

        // Obtener lista de lonjas desde el caché o servicio
        List<Lonja> lonjasTodas = (List<Lonja>) _lonjasCacheUtil.getFromCache("lonjasTodas");
        if (lonjasTodas == null) {
            lonjasTodas = _lonjaLocalService.getLonjas(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream()
                    .peek(lonja -> lonja.setNombre(_lonjasUtil.capitalizeWords(lonja.getNombre())))
                    .sorted(Comparator.comparing(Lonja::getNombre))
                    .collect(Collectors.toList());
            _lonjasCacheUtil.addToCache("lonjasTodas", lonjasTodas);
        }
        resourceRequest.setAttribute("lonjasTodas", lonjasTodas);

        // Obtener lista de productos desde el caché o generarla
        List<InfoProducto> listaProductos = (List<InfoProducto>) _lonjasCacheUtil.getFromCache("listaProductos");
        if (listaProductos == null) {
            List<PrecioLonja> finalListPrecioLonja = listPrecioLonja;
            listaProductos = gruposLonjas.stream()
                    .flatMap(grupo -> finalListPrecioLonja.stream()
                            .filter(precio -> precio.getGrupoId() == grupo.getGrupoId())
                            .map(precio -> _lonjasUtil.completarInfoProducto(precio, grupo, themeDisplay.getUserId())))
                    .collect(Collectors.toList());
            _lonjasCacheUtil.addToCache("listaProductos", listaProductos);
        }

        // Aplicar la lógica de ordenamiento según el criterio
        switch (criterioOrden) {
            case "label-date":
                // Ordenar por fecha (descendente)
                listaProductos.sort(Comparator.comparing(InfoProducto::getFechaLonjaFilter).reversed());
                break;

            case "label-variation":
                // Ordenar por variación porcentual (descendente)
                listaProductos.sort(Comparator.comparing(InfoProducto::getVariacionPorcentaje, Comparator.nullsLast(Comparator.reverseOrder())));
                break;

            case "label-alphabetical":
            default:
                // Ordenar alfabéticamente por nombre de producto (ascendente)
                listaProductos.sort(Comparator.comparing(InfoProducto::getNombreProducto));
                break;
        }

        // Obtener las palabras del término de búsqueda
        List<String> palabrasBusqueda = Arrays.asList(searchTerm.split("\\s+"));

        // Filtrar la lista de productos por lonjas seleccionadas, 'groupId', y 'searchTerm'
        List<String> finalLonjasSeleccionadas = lonjasSeleccionadas;
        List<InfoProducto> productosFiltrados = listaProductos.stream()
                .filter(producto -> finalLonjasSeleccionadas.contains("all") || finalLonjasSeleccionadas.contains(String.valueOf(producto.getIdLonja())))
                .filter(producto -> "all".equals(groupId) || producto.getIdGrupo().equals(groupId))
                // Agregar filtro por término de búsqueda si está presente
                .filter(producto -> palabrasBusqueda.isEmpty() || palabrasBusqueda.stream()
                        .allMatch(palabra -> producto.getNombreProducto().toLowerCase().contains(palabra)))
                .collect(Collectors.toList());

        // Establecer el número total de productos como un encabezado en la respuesta
        resourceResponse.setProperty("X-Total-Resultados", String.valueOf(productosFiltrados.size()));

        // Paginación de productos según el rango 'inicio' y 'limite' después de haber ordenado y filtrado
        int end = Math.min(inicio + limite, productosFiltrados.size());

        // Validar que el índice 'inicio' no sea mayor o igual al tamaño de la lista
        if (inicio >= productosFiltrados.size()) {
            // Si el índice de inicio es mayor o igual al número total de productos filtrados
            inicio = 0; // Reiniciar el valor de inicio para mostrar los primeros productos disponibles
            end = Math.min(inicio + limite, productosFiltrados.size()); // Ajustar el final
        }

        List<InfoProducto> productosPaginados = productosFiltrados.subList(inicio, end);
        // Iterar sobre los productos paginados y actualizar si están en favoritos para el usuario
        if(themeDisplay.isSignedIn()){
            productosPaginados = productosPaginados.stream()
                    .peek(producto -> producto.setFavorito(_lonjasUtil.isFavorito(themeDisplay.getUserId(), producto.getIdLonja(), producto.getProductoId())))
                    .collect(Collectors.toList());
        }

        // Establecer los productos paginados en la request para la vista
        resourceRequest.setAttribute("listaProductos", productosPaginados);

        // Enviar los productos paginados a la vista
        PortletRequestDispatcher dispatcher = getPortletRequestDispatcher(resourceRequest, "/card-list-v2.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
