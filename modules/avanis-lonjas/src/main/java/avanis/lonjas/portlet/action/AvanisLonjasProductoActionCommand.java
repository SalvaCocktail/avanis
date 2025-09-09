package avanis.lonjas.portlet.action;

import avanis.lonjas.constants.AvanisLonjasPortletKeys;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.model.ProductoExplot;
import avanis.lonjas.model.ProductoUser;
import avanis.lonjas.service.PrecioLonjaLocalServiceUtil;
import avanis.lonjas.service.ProductoExplotLocalServiceUtil;
import avanis.lonjas.service.ProductoUserLocalServiceUtil;
import avanis.lonjas.util.LonjasUtil;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;
import java.util.List;

@Component(
	property = {
			"javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASWIDGET,
			"javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASDETALLE,
			"javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJAS,
			"javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASEXPLOTACIONWIDGET,
			"mvc.command.name=action_cmd_command"
	},
	service = MVCActionCommand.class
)
public class AvanisLonjasProductoActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(AvanisLonjasProductoActionCommand.class);

	@Reference
	private LonjasUtil _lonjasUtil;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);


		if ("updateProductosParcela".equals(cmd)) {
			long plotId = ParamUtil.getLong(actionRequest, "plotId");
			long userId = themeDisplay.getUserId();

			long plotValido = _lonjasUtil.plotValidoUser(plotId, userId);

			String[] productoIds = ParamUtil.getStringValues(actionRequest, "productoId");
			String[] idsLonja = ParamUtil.getStringValues(actionRequest, "idLonja");

			List<ProductoExplot> productoExplotSearch = ProductoExplotLocalServiceUtil.getProductoExplotByExplotacionId(plotValido);
			for (ProductoExplot productoExplot : productoExplotSearch) {
				boolean foundSelectedProducto = false;
				for(int i = 0; i < productoIds.length; i++) {
					if (productoIds[i].equals(String.valueOf(productoExplot.getProductoId())) && idsLonja[i].equals(String.valueOf(productoExplot.getLonjaId()))) {
						productoExplot.setModifiedDate(new Date());
						productoExplot.setOrden(i+1);
						ProductoExplotLocalServiceUtil.updateProductoExplot(productoExplot);
						foundSelectedProducto = true;
						break;
					}
				}
				if (!foundSelectedProducto) {
					ProductoExplotLocalServiceUtil.deleteProductoExplot(productoExplot);
				}
			}
		} else if ("updateProductosUser".equals(cmd)) {
			String[] productoIds = ParamUtil.getStringValues(actionRequest, "productoId");
			String[] idsLonja = ParamUtil.getStringValues(actionRequest, "idLonja");

			User user = themeDisplay.getUser();
			List<ProductoUser> productosUserSearch = ProductoUserLocalServiceUtil.getProductoUserByUserId(user.getUserId());

			for (ProductoUser productoUser : productosUserSearch) {
				boolean foundSelectedProducto = false;
				for(int i = 0; i < productoIds.length; i++) {
					if (productoIds[i].equals(String.valueOf(productoUser.getProductoId())) && idsLonja[i].equals(String.valueOf(productoUser.getLonjaId()))) {
						productoUser.setModifiedDate(new Date());
						productoUser.setOrden(i+1);
						ProductoUserLocalServiceUtil.updateProductoUser(productoUser);
						foundSelectedProducto = true;
						break;
					}
				}
				if (!foundSelectedProducto) {
					ProductoUserLocalServiceUtil.deleteProductoUser(productoUser);
				}
			}
		} else if ("updateProductoExplotacion".equals(cmd)) {
			long productoId = ParamUtil.getLong(actionRequest, "productoId");
			long idLonja = ParamUtil.getLong(actionRequest, "idLonja");

			OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false) ;
			List<PrecioLonja> productosLista = PrecioLonjaLocalServiceUtil.getPrecioLonjaByLonjaIdByProductoId(idLonja, productoId, orderByComparator);

			if(!productosLista.isEmpty()){
				PrecioLonja precioLonja = productosLista.get(0);
				String[] selectedExplocionIds = ParamUtil.getStringValues(actionRequest, "explocionIds");

				User user = themeDisplay.getUser();
				List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(user.getUserId());

				List<ProductoExplot> productoExplotSearch;
				for (Explotacion explotacion : explotaciones) {
					boolean foundSelectedExplocion = false;
					for(int i = 0; i < selectedExplocionIds.length; i++) {
						if (selectedExplocionIds[i].equals(String.valueOf(explotacion.getExplotacionId()))) {
							foundSelectedExplocion = true;
							break;
						}
					}
					boolean foundProductoExplot = false;
					productoExplotSearch = ProductoExplotLocalServiceUtil.getProductoExplotByExplotacionId(explotacion.getExplotacionId());
					for (ProductoExplot productoExplot : productoExplotSearch) {
						if (productoExplot.getProductoId() == precioLonja.getProductoId() &&  productoExplot.getLonjaId() == precioLonja.getLonjaId()) {
							foundProductoExplot = true;
							if(foundSelectedExplocion) {
								productoExplot.setModifiedDate(new Date());
								//productoExplot.setPrecioLonjaId(precioLonja.getEntityId());
								ProductoExplotLocalServiceUtil.updateProductoExplot(productoExplot);
							} else {
								ProductoExplotLocalServiceUtil.deleteProductoExplot(productoExplot);
								reordenarProductosExplotacion(explotacion.getExplotacionId(), 0);
							}
							break;
						}
					}
					if (!foundProductoExplot && foundSelectedExplocion) {
						reordenarProductosExplotacion(explotacion.getExplotacionId(), 1);
						ProductoExplot productoExplot = ProductoExplotLocalServiceUtil.createProductoExplot(CounterLocalServiceUtil.increment(ProductoExplot.class.getName()));
						productoExplot.setExplotacionId(explotacion.getExplotacionId());
						productoExplot.setPrecioLonjaId(precioLonja.getEntityId());
						productoExplot.setLonjaId(precioLonja.getLonjaId());
						productoExplot.setProductoId(precioLonja.getProductoId());
						productoExplot.setOrden(1);

						ProductoExplotLocalServiceUtil.addProductoExplot(productoExplot);
					}
				}
			}
		}
	}

	private void reordenarProductosExplotacion(long explotacionId, int anadir) {
		List<ProductoExplot> productoExplotSearch = ProductoExplotLocalServiceUtil.getProductoExplotByExplotacionId(explotacionId);
		for (int i = anadir; i < productoExplotSearch.size()+anadir; i++) {
			ProductoExplot productoExplot = productoExplotSearch.get(i-anadir);
			productoExplot.setOrden(i + 1);
			ProductoExplotLocalServiceUtil.updateProductoExplot(productoExplot);
		}
	}
}
