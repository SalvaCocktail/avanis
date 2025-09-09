package avanis.comunidad.portlet.usecases;

import avanis.comunidad.portlet.exceptions.ForbiddenMessageException;
import avanis.comunidad.portlet.portlet.MBThreadRelevanceComparator;
import avanis.comunidad.portlet.util.AvanisComunidadUtil;
import avanis.social.follow.sb.service.SocialFollowLocalServiceUtil;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickReplyUseCase {
    private static final Log _log = LogFactoryUtil.getLog(QuickReplyUseCase.class);
    private MBMessage parentMessage;
    private MBMessage rootMessage;

    public QuickReplyUseCase(MBMessage parentMessage, MBMessage rootMessage) {
        this.parentMessage = parentMessage;
        this.rootMessage = rootMessage;
    }

    public void quickyReply(PortletRequest renderRequest, PortletResponse renderResponse) throws PortletException, IOException, PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        if (!themeDisplay.isSignedIn()) {
            throw new ForbiddenMessageException();
        } else if (this.parentMessage == null || this.rootMessage == null) {
            throw new ForbiddenMessageException();
        }


        try {
            AvanisComunidadUtil.checkVisibility(AvanisComunidadUtil.getVisibility(rootMessage), true, themeDisplay.getUser(), rootMessage);

            long groupId = themeDisplay.getScopeGroupId();
            long userId = themeDisplay.getUserId();
            String userName = themeDisplay.getUser().getFullName();
            String subject = ParamUtil.getString(renderRequest, "subject");
            String body = ParamUtil.getString(renderRequest, "body");
            String messageFormat = ParamUtil.getString(renderRequest, "messageFormat");
            double priority = ParamUtil.getDouble(renderRequest, "priority");
            boolean anonymous = ParamUtil.getBoolean(renderRequest, "anonymous");
            boolean allowPingbacks = ParamUtil.getBoolean(renderRequest, "allowPingbacks");
            long categoryId = ParamUtil.getLong(renderRequest, "categoryId");
            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), renderRequest);

            MBMessage message = MBMessageLocalServiceUtil.addMessage(
                    userId, userName, groupId, categoryId, parentMessage.getThreadId(), parentMessage.getMessageId(), subject, body, messageFormat,
                    new ArrayList<>(), anonymous, priority, allowPingbacks, serviceContext);

            MBThread thread = MBThreadLocalServiceUtil.getThread(parentMessage.getThreadId());
            List<MBThread> threads = new ArrayList<>();
            threads.add(thread);

            renderRequest.setAttribute("threads", threads);


            AvanisComunidadUtil.sendCommentNotification(message, renderRequest);
            MBMessage rootMessage = MBMessageLocalServiceUtil.getMessage(message.getRootMessageId());
            AvanisComunidadUtil.sendAchievementInteractionNotification(rootMessage, renderRequest);

        } catch (PortalException e) {
            _log.error("An error occurred while adding the message: " + parentMessage.getMessageId());
            renderRequest.setAttribute("errorMessage", "An error occurred while adding the message: " + e.getMessage());
            throw new PortletException(e);
        }

    }


}
