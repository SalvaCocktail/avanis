package avanis.comunidad.portlet.util;

import avanis.comunidad.portlet.cache.ComunidadCacheUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class AvanisComunidadListener extends BaseModelListener<MBMessage> {

    private static final Log _log = LogFactoryUtil.getLog(AvanisComunidadListener.class);

    private final String COMUNIDAD_MENSAJE = "comunidad_mensajes";

    @Override
    public void onAfterCreate(MBMessage model) {
        _log.info("Mensaje creado, limpiando caché...");
        ComunidadCacheUtil.removeFromCache(COMUNIDAD_MENSAJE);
    }

    @Override
    public void onAfterUpdate(MBMessage originalModel, MBMessage model) {
        _log.info("Mensaje actualizado, limpiando caché");
        ComunidadCacheUtil.removeFromCache(COMUNIDAD_MENSAJE);
    }

    @Override
    public void onAfterRemove(MBMessage model) {
        _log.info("Mensaje eliminado, limpiando caché...");
        ComunidadCacheUtil.removeFromCache(COMUNIDAD_MENSAJE);
    }
}
