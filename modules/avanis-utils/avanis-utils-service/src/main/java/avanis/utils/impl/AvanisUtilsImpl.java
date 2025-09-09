package avanis.utils.impl;

import avanis.utils.api.util.AvanisUtils;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate=true,
    configurationPid = "avanis.utils.configuration.AvanisConfiguration",
    service= AvanisUtils.class
)
public class AvanisUtilsImpl implements AvanisUtils{
    private static final Log _log = LogFactoryUtil.getLog(AvanisUtilsImpl.class);

    @Reference
    private MBMessageLocalService _mbMessageLocalService;

    public String sanitizeInput(String input) {
        if (input == null) {
            return null;        }

        Safelist safelist = Safelist.none()
                .addTags("b", "i", "u", "strike", "p")
                .addAttributes("u", "style");

        return Jsoup.clean(input, safelist);
    }

    public String sanitizeInputSimpleText(String input) {
        if (input == null)
            return null;

        return Jsoup.clean(input, Safelist.simpleText());
    }


    @Override
    public boolean deleteMessage(long userId, long messageId) {
        try {
            MBMessage mensaje = _mbMessageLocalService.getMessage(messageId);

            if (mensaje.getUserId() != userId) {
                return false;
            }

            _mbMessageLocalService.getChildMessages(messageId, WorkflowConstants.STATUS_ANY)
                    .forEach(childMessage -> eliminarMensaje(childMessage.getMessageId()));

            eliminarMensaje(messageId);

            return true;

        } catch (Exception e) {
            _log.error(e.getMessage(), e);
            return false;
        }
    }

    private void eliminarMensaje(long messageId){
        try {
            _mbMessageLocalService.deleteMessage(messageId);
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateMessage(long userId, long messageId, String newMessage) {
        try{
            MBMessage mensaje = _mbMessageLocalService.getMessage(messageId);

            if (mensaje.getUserId() != userId) {
                return false;
            }

            mensaje.setBody(sanitizeInput(newMessage));
            _mbMessageLocalService.updateMBMessage(mensaje);
            return true;

        }catch (Exception e) {
            _log.error(e.getMessage(), e);
            return false;
        }
    }
}
