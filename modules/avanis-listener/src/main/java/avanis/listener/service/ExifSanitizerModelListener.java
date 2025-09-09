package avanis.listener.service;

import avanis.listener.util.ExifSanitizerUtil;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class ExifSanitizerModelListener extends BaseModelListener<DLFileEntry> {

    private static final Log _log = LogFactoryUtil.getLog(ExifSanitizerModelListener.class);

    @Reference
    private ExifSanitizerUtil _exifSanitizerUtil;

    @Override
    public void onAfterUpdate(DLFileEntry originalModel, DLFileEntry updatedModel) throws ModelListenerException {
        try {
            if (!_exifSanitizerUtil.isImage(updatedModel.getFileName())) {
                return;
            }

            ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

            if (serviceContext != null && Boolean.TRUE.equals(serviceContext.getAttribute("EXIF_SANITIZED"))) {
                _log.debug("EXIF_SANITIZED flag detected, skipping reprocessing for: " + updatedModel.getFileName());
                return;
            }

            _exifSanitizerUtil.sanitizeExif(updatedModel);

        } catch (Exception e) {
            _log.error("Error during EXIF sanitization process", e);
            throw new ModelListenerException(e);
        }
    }
}
