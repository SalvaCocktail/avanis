package avanis.lonjas.portlet;

import avanis.lonjas.constants.AvanisLonjasPortletKeys;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.service.PrecioLonjaLocalService;
import avanis.lonjas.util.LonjasUtil;
import avanis.lonjas.vo.InfoProducto;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author VictorAntunez
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Avanis Detalle Lonjas",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewDetail.jsp",
		"javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASDETALLE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisLonjasDetallePortlet extends MVCPortlet {

	@Reference
	private PrecioLonjaLocalService _precioLonjaLocalService;

	@Reference
	private LonjasUtil _lonjasUtil;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute("isDefaultUser", themeDisplay.getUser().isDefaultUser());

		String urlsessionGoogle = PropsUtil.get("google.login.url");
		renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		long lonjaId = ParamUtil.getLong(httpReq, "lonjaId");
		if (Validator.isNull(lonjaId)) {
			lonjaId = ParamUtil.getLong(renderRequest, "lonjaId");
		}
		long productoId = ParamUtil.getLong(httpReq, "productoId");
		if (Validator.isNull(productoId)) {
			productoId = ParamUtil.getLong(renderRequest, "productoId");
		}

		OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false);
		List<PrecioLonja> productosLista = _precioLonjaLocalService.getPrecioLonjaByLonjaIdByProductoId(lonjaId, productoId, orderByComparator);

		if (productosLista != null && !productosLista.isEmpty()) {
			PrecioLonja primerProducto = productosLista.get(0);
			InfoProducto infoProductoPrimero = _lonjasUtil.completarInfoProducto(primerProducto, null, themeDisplay.getUserId());

			renderRequest.setAttribute("primerProducto", infoProductoPrimero);
			renderRequest.setAttribute("lonjaId", lonjaId);

			List<InfoProducto> listaProductos = new ArrayList<>();
			List<InfoProducto> listaMesActual = new ArrayList<>();
			List<InfoProducto> listaTresMeses = new ArrayList<>();
			List<InfoProducto> listaSeisMeses = new ArrayList<>();
			List<InfoProducto> listaDoceMeses = new ArrayList<>();

			productosLista.forEach(producto -> {
				InfoProducto infoProducto = _lonjasUtil.completarInfoProducto(producto, null, themeDisplay.getUserId());
				listaProductos.add(infoProducto);

				Date fechaProducto = producto.getFecha();

				// Filtros por fecha
				if (esDelMesActual(fechaProducto)) {
					listaMesActual.add(infoProducto);
				}
				if (esDentroDeUltimosMeses(fechaProducto, 3)) {
					listaTresMeses.add(infoProducto);
				}
				if (esDentroDeUltimosMeses(fechaProducto, 6)) {
					listaSeisMeses.add(infoProducto);
				}
				if (esDentroDeUltimosMeses(fechaProducto, 12)) {
					listaDoceMeses.add(infoProducto);
				}
			});

			renderRequest.setAttribute("listaProductos", listaProductos);
			renderRequest.setAttribute("listaMesActual", listaMesActual);
			renderRequest.setAttribute("listaTresMeses", listaTresMeses);
			renderRequest.setAttribute("listaSeisMeses", listaSeisMeses);
			renderRequest.setAttribute("listaDoceMeses", listaDoceMeses);

			List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(themeDisplay.getUserId());
			renderRequest.setAttribute("explotaciones", explotaciones);
		}

		super.doView(renderRequest, renderResponse);
	}

	private boolean esDelMesActual(Date fechaProducto) {
		LocalDateTime fecha = fechaProducto.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime ahora = LocalDateTime.now();
		return fecha.getYear() == ahora.getYear() && fecha.getMonth() == ahora.getMonth();
	}

	private boolean esDentroDeUltimosMeses(Date fechaProducto, int meses) {
		LocalDateTime fecha = fechaProducto.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime haceMeses = LocalDateTime.now().minusMonths(meses);
		return !fecha.isBefore(haceMeses);
	}
}