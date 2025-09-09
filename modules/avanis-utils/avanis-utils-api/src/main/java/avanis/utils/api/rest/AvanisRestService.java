package avanis.utils.api.rest;

import avanis.utils.api.util.AvanisUtils;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/avanis",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=avanis",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
public class AvanisRestService extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Reference
    private AvanisUtils _avanisUtils;

    @GET
    @Path("/eliminarMensaje")
    @Produces("application/json")
    public Response eliminarMensaje(@QueryParam("userId") long userId, @QueryParam("messageId") long messageId, @Context HttpServletRequest httpRequest) {
        boolean eliminado = _avanisUtils.deleteMessage(userId, messageId);

        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        jsonResponse.put("success", eliminado);

        return Response.ok(jsonResponse.toString()).build();
    }

    @GET
    @Path("/actualizarMensaje")
    @Produces("application/json")
    public Response actualizarMensaje(@QueryParam("userId") long userId, @QueryParam("messageId") long messageId, @QueryParam("newMessage") String newMessage, @Context HttpServletRequest httpRequest) {
        boolean actualizado = _avanisUtils.updateMessage(userId, messageId, newMessage);

        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        jsonResponse.put("success", actualizado);

        return Response.ok(jsonResponse.toString()).build();
    }
}
