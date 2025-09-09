package avanis.comunidad.portlet.portlet.route;

import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
		"javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD
	},
	service = FriendlyURLMapper.class
)
public class MBFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "publicaciones";

}
