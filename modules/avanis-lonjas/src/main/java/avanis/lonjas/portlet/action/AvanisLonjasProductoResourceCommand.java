package avanis.lonjas.portlet.action;

import avanis.lonjas.constants.AvanisLonjasPortletKeys;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.model.ProductoUser;
import avanis.lonjas.service.PrecioLonjaLocalServiceUtil;
import avanis.lonjas.service.ProductoUserLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASWIDGET,
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJAS,
                "javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASDETALLE,
                "mvc.command.name=resource_cmd_command"
        },
        service = MVCResourceCommand.class
)
public class AvanisLonjasProductoResourceCommand extends BaseMVCResourceCommand {

    private static final Log _log = LogFactoryUtil.getLog(AvanisLonjasProductoResourceCommand.class);

    @Override
    protected void doServeResource(
            ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();

        String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
        JSONObject jsonMessageObject = JSONFactoryUtil.createJSONObject();

        _log.debug("cmd:" + cmd);

        if ("addProductoUser".equals(cmd)) {
            long productoId = ParamUtil.getLong(resourceRequest, "productoId");
            long idLonja = ParamUtil.getLong(resourceRequest, "idLonja");

            List<ProductoUser> productosUserSearch = ProductoUserLocalServiceUtil.getProductoUserByUserId(userId);

            boolean foundProductoUser = false;
            for (ProductoUser productoUser : productosUserSearch) {
                if (productoId == productoUser.getProductoId() && idLonja == productoUser.getLonjaId()) {
                    foundProductoUser = true;
                    break;
                }

            }
            if (!foundProductoUser) {
                for (ProductoUser productoUser : productosUserSearch) {
                    productoUser.setOrden(productoUser.getOrden() + 1);
                    ProductoUserLocalServiceUtil.updateProductoUser(productoUser);
                }

                OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false) ;
                List<PrecioLonja> productosLista = PrecioLonjaLocalServiceUtil.getPrecioLonjaByLonjaIdByProductoId(idLonja, productoId, orderByComparator);

                ProductoUser productoUserNew = ProductoUserLocalServiceUtil.createProductoUser(CounterLocalServiceUtil.increment(ProductoUser.class.getName()));
                productoUserNew.setProductoId(productoId);
                productoUserNew.setLonjaId(idLonja);
                if(productosLista != null && !productosLista.isEmpty()) {
                    productoUserNew.setPrecioLonjaId(productosLista.get(0).getEntityId());
                }
                productoUserNew.setUserId(userId);
                productoUserNew.setOrden(1);
                ProductoUserLocalServiceUtil.addProductoUser(productoUserNew);

                //SessionMessages.add(resourceRequest, "addProductoUser");
                jsonMessageObject.put("status", Boolean.TRUE);
            } else {
                //SessionErrors.add(resourceRequest, "ProductoNotFound");
                jsonMessageObject.put("status", Boolean.FALSE);
            }
        } else if ("deleteProductoUser".equals(cmd)) {
            long productoId = ParamUtil.getLong(resourceRequest, "productoId");
            long idLonja = ParamUtil.getLong(resourceRequest, "idLonja");

            List<ProductoUser> productosUserSearch = ProductoUserLocalServiceUtil.getProductoUserByUserId(themeDisplay.getUser().getUserId());

            boolean productoBorrado = false;
            for (ProductoUser productoUser : productosUserSearch) {
                if (productoId == productoUser.getProductoId() && idLonja == productoUser.getLonjaId()) {
                    ProductoUserLocalServiceUtil.deleteProductoUser(productoUser);
                    productoBorrado = true;
                    break;
                }
            }
            if (productoBorrado) {
                productosUserSearch = ProductoUserLocalServiceUtil.getProductoUserByUserId(themeDisplay.getUser().getUserId());
                for (int i = 0; i < productosUserSearch.size(); i++) {
                    ProductoUser productoUserAux = productosUserSearch.get(i);
                    productoUserAux.setOrden(i+1);
                    ProductoUserLocalServiceUtil.updateProductoUser(productoUserAux);
                }
                //SessionMessages.add(resourceRequest, "deleteProductoUser");
                jsonMessageObject.put("status", Boolean.TRUE);
            } else {
                //SessionMessages.add(resourceRequest, "ProductoNotFound");
                jsonMessageObject.put("status", Boolean.FALSE);
            }
        }

        JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonMessageObject);
    }
}
