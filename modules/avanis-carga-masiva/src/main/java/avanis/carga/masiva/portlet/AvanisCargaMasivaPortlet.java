package avanis.carga.masiva.portlet;

import avanis.carga.masiva.constants.AvanisCargaMasivaPortletKeys;
import avanis.utils.api.util.CargaMasivaUtils;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author VictorAntunez
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Avanis Carga Masiva",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisCargaMasivaPortletKeys.AVANISCARGAMASIVA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisCargaMasivaPortlet extends MVCPortlet {

	@Reference
	private CargaMasivaUtils _cargaMasivaUtils;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<DDMStructure> estructuras = _cargaMasivaUtils.getEstructurasCargaMasiva();
		renderRequest.setAttribute("estructurasDisponibles", estructuras);

		super.doView(renderRequest, renderResponse);
	}
}