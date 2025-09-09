package avanis.lonjas.portlet.action;

import avanis.lonjas.constants.AvanisLonjasPortletKeys;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.model.ProductoExplot;
import avanis.lonjas.service.PrecioLonjaLocalServiceUtil;
import avanis.lonjas.service.ProductoExplotLocalServiceUtil;
import avanis.lonjas.util.LonjasUtil;
import avanis.lonjas.vo.InfoProducto;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        property = {
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASWIDGET,
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASDETALLE,
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJAS,
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASEXPLOTACIONWIDGET,
                "mvc.command.name=render_cmd_command"
        },

        service = MVCRenderCommand.class
)
public class AvanisLonjasProductoRenderCommand implements MVCRenderCommand {

    private static final String VIEW_TEMPLATE = "/view.jsp";
    private static final String VIEW_TEMPLATE_PRODUCTO_EXPLOTACION = "/fragments/productoExplotaciones.jsp";
    private static final String VIEW_TEMPLATE_PRODUCTOS_PARCELA_EDIT = "/fragments/productosParcelaEdit.jsp";
    private static final String VIEW_TEMPLATE_PRODUCTOS_PARCELA_LIST = "/fragments/productosParcelaList.jsp";
    private static final String VIEW_TEMPLATE_PRODUCTOS_USER_EDIT = "/fragments/productosUserEdit.jsp";
    private static final String VIEW_TEMPLATE_PRODUCTOS_USER_LIST = "/fragments/productosUserList.jsp";
    private static final String VIEW_TEMPLATE_PRODUCTOS_HISTORICO = "/fragments/productosHistorico.jsp";

    private static final Log _log = LogFactoryUtil.getLog(AvanisLonjasProductoRenderCommand.class);

    @Reference
    private LonjasUtil _lonjasUtil;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

        if ("lista_historico_producto".equals(cmd)) {
            return getListaHistoricoProducto(renderRequest);
        } else if ("lista_producto_favoritos".equals(cmd)) {
            productosFavoritos(renderRequest);
            return VIEW_TEMPLATE_PRODUCTOS_USER_LIST;
        } else if ("editar_producto_favoritos".equals(cmd)) {
            productosFavoritos(renderRequest);
            return VIEW_TEMPLATE_PRODUCTOS_USER_EDIT;
        } else if ("lista_productos_parcela".equals(cmd)) {
            productosParcela(renderRequest);
            return VIEW_TEMPLATE_PRODUCTOS_PARCELA_LIST;
        } else if ("editar_productos_parcela".equals(cmd)) {
            productosParcela(renderRequest);
            return VIEW_TEMPLATE_PRODUCTOS_PARCELA_EDIT;
        } else if ("anadir_a_explotacion".equals(cmd)) {
            return getAnadirAExplotacion(renderRequest);
        } else {
            return VIEW_TEMPLATE;
        }
    }

    private String getListaHistoricoProducto(RenderRequest renderRequest){
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long productoId = ParamUtil.getLong(renderRequest, "productoId");
        long idLonja = ParamUtil.getLong(renderRequest, "idLonja");

        OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false) ;
        List<PrecioLonja> productosLista = PrecioLonjaLocalServiceUtil.getPrecioLonjaByLonjaIdByProductoId(idLonja, productoId, orderByComparator);

        // Verificar que la lista no esté vacía
        if (productosLista != null && !productosLista.isEmpty()) {

            // Crear la lista de productos sin el primer elemento
            List<InfoProducto> listaProductos = new ArrayList<>();

            for (int i = 0; i < productosLista.size(); i++) {
                PrecioLonja producto = productosLista.get(i);

                // Añadir InfoProducto a la lista
                listaProductos.add(_lonjasUtil.completarInfoProducto(producto, null, themeDisplay.getUserId()));
            }
            int numListaProductos = listaProductos.size();
//            if(Validator.isNotNull(_lonjasUtil.ctdaUltimasSubastasDetalleProducto())){
//                numListaProductos = Math.min(listaProductos.size(), Integer.valueOf(_lonjasUtil.ctdaUltimasSubastasDetalleProducto()));
//            }

            // Establecer la lista de productos restantes en el request
            renderRequest.setAttribute("listaProductos", listaProductos.subList(0 , numListaProductos));
        }

        return VIEW_TEMPLATE_PRODUCTOS_HISTORICO;
    }

    private void productosParcela(RenderRequest renderRequest) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long plotId = ParamUtil.getLong(renderRequest, "plotId");
        long userId = themeDisplay.getUserId();

        long plotValido = _lonjasUtil.plotValidoUser(plotId, userId);
        if (Validator.isNotNull(plotValido)){
            renderRequest.setAttribute("plotId", plotValido);
            List<InfoProducto> listaProductos = _lonjasUtil.productosParcela(plotValido, userId);
            renderRequest.setAttribute("productosPacela", listaProductos);
        }
    }

    private void productosFavoritos(RenderRequest renderRequest) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        List<InfoProducto> favoritosUser = _lonjasUtil.getFavoritosUser(themeDisplay.getUserId());
        renderRequest.setAttribute("favoritosUser", favoritosUser);
    }

    private String getAnadirAExplotacion(RenderRequest renderRequest) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long productoId = ParamUtil.getLong(renderRequest, "productoId");
        long idLonja = ParamUtil.getLong(renderRequest, "idLonja");
        renderRequest.setAttribute("productoId", productoId);
        renderRequest.setAttribute("idLonja", idLonja);

        OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false) ;
        List<PrecioLonja> productosLista = PrecioLonjaLocalServiceUtil.getPrecioLonjaByLonjaIdByProductoId(idLonja, productoId, orderByComparator);

        if(!productosLista.isEmpty()){
            PrecioLonja precioLonja = productosLista.get(0);
            try {
                User user = themeDisplay.getUser();
                List<ProductoExplot> productoExplotaciones = new ArrayList<ProductoExplot>();
                List<String> productoExplotacionesIds = new ArrayList();
                List<Integer> ctdaProductosPorExplotacion = new ArrayList();
                List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(user.getUserId());
                List<ProductoExplot> productoExplotSearch;
                for (Explotacion explotacion : explotaciones) {
                    productoExplotSearch = ProductoExplotLocalServiceUtil.getProductoExplotByExplotacionId(explotacion.getExplotacionId());
                    ctdaProductosPorExplotacion.add(productoExplotSearch.size());
                    for (ProductoExplot productoExplot : productoExplotSearch) {
                        if (productoExplot.getProductoId() == precioLonja.getProductoId() &&  productoExplot.getLonjaId() == precioLonja.getLonjaId()) {
                            productoExplotaciones.add(productoExplot);
                            productoExplotacionesIds.add(String.valueOf(productoExplot.getExplotacionId()));
                            break;
                        }
                    }
                }

                renderRequest.setAttribute("explotaciones", explotaciones);
                renderRequest.setAttribute("productoExplotaciones", productoExplotaciones);
                renderRequest.setAttribute("productoExplotacionesIds", productoExplotacionesIds.stream().collect(Collectors.joining(",")));
                renderRequest.setAttribute("ctdaProductosPorExplotacion", ctdaProductosPorExplotacion);

                int ctdaProductosPorExplotacionMax = 0;
                if(Validator.isNotNull(_lonjasUtil.ctdaProductosPorParcela())){
                    ctdaProductosPorExplotacionMax = Integer.valueOf(_lonjasUtil.ctdaProductosPorParcela());
                }
                renderRequest.setAttribute("ctdaProductosPorExplotacionMax", ctdaProductosPorExplotacionMax);

            } catch(RuntimeException runtimeException){
                _log.error("Error visualizando relacion de explotaciones con producto");
                throw runtimeException;
            } catch(Exception exception){
                _log.error("Error visualizando relacion de explotaciones con producto");
                throw new PortletException(exception);
            }
        }
        return VIEW_TEMPLATE_PRODUCTO_EXPLOTACION;
    }
}
