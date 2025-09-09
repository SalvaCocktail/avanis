package avanis.utils.api.rest;

import avanis.utils.api.util.CategoriasUtils;
import com.liferay.portal.kernel.json.JSONArray;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Set;

@Component(
    property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/categorias",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=categorias",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
public class CategoriasRestService extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Reference
    private CategoriasUtils _categoriasUtils;

    @GET
    @Path("/getCategoriasAvanis")
    @Produces("application/json")
    public Response getCategoriasAvanis(@QueryParam("separator") boolean separator, @Context HttpServletRequest httpRequest) {
        JSONArray jsonCategorias = _categoriasUtils.getCategoriasAvanis(separator);
        String jsonString = jsonCategorias.toString();

        return Response.ok(jsonString).build();
    }

    @GET
    @Path("/getCategoriasUserDedications")
    @Produces("application/json")
    public Response getCategoriasUserDedications(@QueryParam("separator") boolean separator, @Context HttpServletRequest httpRequest) {
        JSONArray jsonCategorias = _categoriasUtils.getCategoriasUserDedications(separator);
        String jsonString = jsonCategorias.toString();

        return Response.ok(jsonString).build();
    }

    @GET
    @Path("/getCategoriasHijaPorNombre")
    @Produces("application/json")
    public Response getCategoriasHijaPorNombre(@QueryParam("separator") boolean separator, @QueryParam("nombre") String nombreCategoria, @Context HttpServletRequest httpRequest) {
        if (nombreCategoria == null || nombreCategoria.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El nombre de la categoría es requerido.").build();
        }

        JSONArray jsonCategorias = _categoriasUtils.getCategoriasHijaPorNombre(nombreCategoria);
        String jsonString = jsonCategorias.toString();

        return Response.ok(jsonString).build();
    }

    @GET
    @Path("/getCategoriasBlogs")
    @Produces("application/json")
    public Response getCategoriasBlogs(@QueryParam("separator") boolean separator, @Context HttpServletRequest httpRequest) {
        JSONArray jsonCategorias = _categoriasUtils.getCategoriasBlogs(separator);
        String jsonString = jsonCategorias.toString();

        return Response.ok(jsonString).build();
    }

    @GET
    @Path("/getCategoriasBlogsMasFiltros")
    @Produces("application/json")
    public Response getCategoriasBlogsMasFiltros(@QueryParam("separator") boolean separator, @Context HttpServletRequest httpRequest) {
        JSONArray jsonCategorias = _categoriasUtils.getCategoriasBlogsMasFiltros(separator);
        String jsonString = jsonCategorias.toString();

        return Response.ok(jsonString).build();
    }

    @GET
    @Path("/getUrlsCategoriaByArticleId")
    @Produces("application/json")
    public Response getUrlsCategoriaByArticleId(@QueryParam("articleId") long articleId, @Context HttpServletRequest httpRequest) {
        JSONArray jsonCategorias = _categoriasUtils.getUrlsCategoriaByArticleId(articleId);
        String jsonString = jsonCategorias.toString();

        return Response.ok(jsonString).build();
    }
}
