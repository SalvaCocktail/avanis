package avanis.comunidad.portlet.upload.format.handlers;

import avanis.comunidad.portlet.upload.format.MBMessageFormatUploadHandler;
import avanis.comunidad.portlet.util.MBAttachmentFileEntryReference;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.editor.constants.EditorConstants;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepository;
import com.liferay.portal.kernel.repository.model.FileEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
/**
 * @author Alejandro Tardín
 */
@Component(
        property = "format=html", service = MBMessageFormatUploadHandler.class
)
public class MBMessageHTMLFormatUploadHandler implements MBMessageFormatUploadHandler {

    @Override
    public String replaceImageReferences(
            String content,
            List<MBAttachmentFileEntryReference> mbAttachmentFileEntryReferences) {

        for (MBAttachmentFileEntryReference mbAttachmentFileEntryReference :
                mbAttachmentFileEntryReferences) {

            content = content.replaceAll(
                    StringBundler.concat(
                            "<\\s*?img", _ATTRIBUTE_LIST_REGEXP,
                            EditorConstants.ATTRIBUTE_DATA_IMAGE_ID, "\\s*?=\\s*?\"",
                            mbAttachmentFileEntryReference.
                                    getTempMBAttachmentFileEntryId(),
                            "\"", _ATTRIBUTE_LIST_REGEXP, "/>"),
                    _getMBAttachmentFileEntryHTMLImgTag(
                            mbAttachmentFileEntryReference.getMBAttachmentFileEntry()));
        }

        return content;
    }

    private String _getMBAttachmentFileEntryHTMLImgTag(
            FileEntry mbAttachmentFileEntry) {

        String fileEntryURL = _portletFileRepository.getPortletFileEntryURL(
                null, mbAttachmentFileEntry, StringPool.BLANK);

        return "<img src=\"" + fileEntryURL + "\" />";
    }

    private static final String _ATTRIBUTE_LIST_REGEXP =
            "(\\s*?\\w+\\s*?=\\s*?\"[^\"]*\")*?\\s*?";

    @Reference
    private PortletFileRepository _portletFileRepository;

}
