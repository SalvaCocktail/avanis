package avanis.buscador.portlet.listener;

import avanis.buscador.portlet.cache.NoticiasCacheUtil;
import avanis.buscador.portlet.utils.NoticiasUtils;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelListener.class)
public class AvanisNoticiasBlogListener extends BaseModelListener<BlogsEntry> {

	private static final Log _log = LogFactoryUtil.getLog(AvanisNoticiasBlogListener.class);

	@Reference
	private NoticiasCacheUtil _noticiasCacheUtil;

	@Override
	public void onAfterUpdate(BlogsEntry originalBlogsEntry, BlogsEntry updatedBlogsEntry) throws ModelListenerException {
		_log.debug("Se ha actualizado un BlogsEntry. Actualizando la caché...");
		_noticiasCacheUtil.updateCache();
	}

	@Override
	public void onAfterRemove(BlogsEntry blogsEntry) throws ModelListenerException {
		_log.debug("Se ha eliminado un BlogsEntry. Actualizando la caché...");
		_noticiasCacheUtil.updateCache();
	}
}
