package avanis.buscador.portlet.resource.noticia;

import avanis.buscador.portlet.constants.AvanisBuscadorPortletKeys;
import avanis.buscador.portlet.utils.NoticiasUtils;
import avanis.buscador.portlet.vo.Noticia;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor Antunez
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name="+ AvanisBuscadorPortletKeys.AVANISBUSCADORNOTICIAS,
        "javax.portlet.name="+ AvanisBuscadorPortletKeys.AVANISBUSCADORNOTICIASCATEGORIAS,
        "mvc.command.name="+ AvanisBuscadorPortletKeys.AVANISBUSCADORNOTICIAS_CARGASMASNOTICIAS
    },
    service = MVCResourceCommand.class,
    configurationPolicy = ConfigurationPolicy.OPTIONAL
)
public class CargarMasNoticias extends BaseMVCResourceCommand {
    private static final Log _log = LogFactoryUtil.getLog(CargarMasNoticias.class);

    @Reference
    private NoticiasUtils _noticiasUtils;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        int start = ParamUtil.getInteger(resourceRequest, "start", 0);
        int end = ParamUtil.getInteger(resourceRequest, "end", 6);

        String selectedFilters = ParamUtil.getString(resourceRequest, "selectedFilters", "");
        List<Long> categoryIds = new ArrayList<>();
        List<String> tipos = new ArrayList<>();
        List<Integer> diasFiltro = new ArrayList<>();

        for (String filtro : selectedFilters.split(",")) {
            if (filtro.startsWith("tipo_")) {
                tipos.add(filtro.replace("tipo_", ""));
            } else if (filtro.startsWith("fecha_")) {
                int dias = convertirCodigoFecha(filtro);
                if (dias != -1) {
                    diasFiltro.add(dias);
                }
            } else if (filtro.matches("\\d+")) {
                categoryIds.add(Long.parseLong(filtro));
            }
        }

        String searchQuery = ParamUtil.getString(resourceRequest, "searchQuery", "").toLowerCase();

        List<Noticia> noticiasFiltradas;

        if (!categoryIds.isEmpty()) {
            noticiasFiltradas = _noticiasUtils.getNoticiasPorCategoriasYBusqueda(themeDisplay, categoryIds, tipos, diasFiltro, searchQuery);
        } else if (!searchQuery.isEmpty()) {
            noticiasFiltradas = _noticiasUtils.getNoticiasPorBusqueda(themeDisplay, searchQuery);
        } else {
            noticiasFiltradas = _noticiasUtils.getTodasLasNoticias(themeDisplay);
        }

        List<Noticia> noticiasPaginadas = noticiasFiltradas.subList(start, Math.min(end, noticiasFiltradas.size()));
        resourceRequest.setAttribute("listaNoticias", noticiasPaginadas);
        resourceResponse.setProperty("X-Total-Resultados", String.valueOf(noticiasFiltradas.size()));

        PortletRequestDispatcher dispatcher = getPortletRequestDispatcher(resourceRequest, "/noticias/card.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
    }

    private int convertirCodigoFecha(String codigo) {
        switch (codigo) {
            case "fecha_0": return 0;   // Hoy
            case "fecha_1": return 1;   // Ayer
            case "fecha_7": return 7;   // Últimos 7 días
            case "fecha_30": return 30; // Últimos 30 días
            case "fecha_60": return 60; // Últimos 60 días
            case "fecha_90": return 90; // Últimos 90 días
            case "fecha_365": return 365; // Este año
            default:
                if (codigo.startsWith("fecha_")) {
                    try {
                        return Integer.parseInt(codigo.replace("fecha_", ""));
                    } catch (NumberFormatException e) {
                        return -1; // Valor inválido
                    }
                }
                return -1; // No es un filtro de fecha válido
        }
    }
}
