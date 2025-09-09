package avanis.lonjas.portlet;

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
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author VictorAntunez
 */
@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=avanis",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=Avanis Widget Lonjas",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/general/view.jsp",
        "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJAS,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },

    service = Portlet.class
)
public class AvanisLonjasPortlet extends MVCPortlet {

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
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        renderRequest.setAttribute("isDefaultUser", themeDisplay.getUser().isDefaultUser());

        List<Area> listAreas = (List<Area>) _lonjasCacheUtil.getFromCache("listAreas");
        if (listAreas == null) {
            listAreas = _areaLocalService.getAreas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            _lonjasCacheUtil.addToCache("listAreas", listAreas);
        }
        renderRequest.setAttribute("totalAreas", listAreas.size());

        OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false);

        List<PrecioLonja> listPrecioLonja = (List<PrecioLonja>) _lonjasCacheUtil.getFromCache("listPrecioLonja");
        if (listPrecioLonja == null) {
            List<PrecioLonja> listPrecioLonjaAll = _precioLonjaLocalService.getPrecioLonjas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            List<PrecioLonja> listPrecioLonjaAux = listPrecioLonjaAll.stream()
                    .filter(distinctByKey(precioLonja -> precioLonja.getLonjaId() + "-" + precioLonja.getProductoId()))
                    .collect(Collectors.toList());

            listPrecioLonja = listPrecioLonjaAux.stream()
                    .map(precioLonjaAux -> _precioLonjaLocalService
                            .getPrecioLonjaByLonjaIdByProductoId(precioLonjaAux.getLonjaId(), precioLonjaAux.getProductoId(), orderByComparator)
                            .stream()
                            .findFirst()
                            .orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            _lonjasCacheUtil.addToCache("listPrecioLonja", listPrecioLonja);
        }
        renderRequest.setAttribute("totalPrecioLonja", listPrecioLonja.size());

        final List<PrecioLonja> finalListPrecioLonja = listPrecioLonja;

        List<Grupo> gruposLonjas = (List<Grupo>) _lonjasCacheUtil.getFromCache("gruposLonjas");
        if (gruposLonjas == null) {
            gruposLonjas = _grupoLocalService.getGrupos(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream()
                    .peek(grupo -> grupo.setNombre(_lonjasUtil.capitalizeWords(grupo.getNombre())))
                    .collect(Collectors.toList());
            _lonjasCacheUtil.addToCache("gruposLonjas", gruposLonjas);
        }
        renderRequest.setAttribute("gruposLonjas", gruposLonjas);

        List<Lonja> lonjasTodas = (List<Lonja>) _lonjasCacheUtil.getFromCache("lonjasTodas");
        if (lonjasTodas == null) {
            lonjasTodas = _lonjaLocalService.getLonjas(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream()
                    .peek(lonja -> lonja.setNombre(_lonjasUtil.capitalizeWords(lonja.getNombre())))
                    .sorted(Comparator.comparing(Lonja::getNombre))
                    .collect(Collectors.toList());
            _lonjasCacheUtil.addToCache("lonjasTodas", lonjasTodas);
        }
        renderRequest.setAttribute("lonjasTodas", lonjasTodas);

        renderRequest.setAttribute("productosMostrados", _lonjasUtil.ctdaProductosMostrados());
        renderRequest.setAttribute("incrementoProductos", _lonjasUtil.ctdaIncrementoProductos());

        List<InfoProducto> listaProductos = (List<InfoProducto>) _lonjasCacheUtil.getFromCache("listaProductos");
        if (listaProductos == null) {
            listaProductos = gruposLonjas.stream()
                    .flatMap(grupo -> finalListPrecioLonja.stream()
                            .filter(precio -> precio.getGrupoId() == grupo.getGrupoId())
                            .map(precio -> _lonjasUtil.completarInfoProducto(precio, grupo, themeDisplay.getUserId())))
                    .collect(Collectors.toList());

            listaProductos.sort(Comparator.comparing(InfoProducto::getNombreProducto));
            _lonjasCacheUtil.addToCache("listaProductos", listaProductos);
        }

        final List<InfoProducto> finalListaProductos = listaProductos;
        Map<String, List<InfoProducto>> listasPorGrupo = new LinkedHashMap<>();

        gruposLonjas.stream()
                .sorted(Comparator.comparingLong(Grupo::getGrupoId))
                .forEach(grupo -> {
                    List<InfoProducto> productosDelGrupo = finalListaProductos.stream()
                            .filter(producto -> producto.getIdGrupo().equals(String.valueOf(grupo.getGrupoId())))
                            .collect(Collectors.toList());
                    listasPorGrupo.put(String.valueOf(grupo.getGrupoId()), productosDelGrupo);
                });
        renderRequest.setAttribute("listasPorGrupo", listasPorGrupo);

        List<InfoProducto> favoritosUser = _lonjasUtil.getFavoritosUser(themeDisplay.getUserId());
        renderRequest.setAttribute("favoritosUser", favoritosUser);

        Set<Long> favoritosIds = favoritosUser.stream()
                .map(InfoProducto::getProductoId)
                .collect(Collectors.toSet());
        listaProductos.forEach(producto -> producto.setFavorito(favoritosIds.contains(producto.getProductoId())));
        renderRequest.setAttribute("listaProductos", listaProductos);

        String urlsessionGoogle = PropsUtil.get("google.login.url");
        renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);
        super.doView(renderRequest, renderResponse);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}
