package avanis.comunidad.portlet.portlet.action;

import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import avanis.comunidad.portlet.exceptions.ForbiddenMessageException;
import avanis.comunidad.portlet.portlet.AvanisComunidadPortlet;
import avanis.comunidad.portlet.usecases.QuickReplyUseCase;
import avanis.comunidad.portlet.usecases.ViewComunidadUseCase;
import avanis.comunidad.portlet.util.AvanisComunidadUtil;
import com.liferay.asset.constants.AssetWebKeys;
import com.liferay.asset.util.AssetHelper;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBSuspiciousActivity;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.service.MBSuspiciousActivityLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.ratings.kernel.model.RatingsEntry;
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsEntryLocalServiceUtil;
import com.liferay.ratings.kernel.service.RatingsEntryServiceUtil;
import com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil;
import com.liferay.trash.TrashHelper;
import com.liferay.trash.util.TrashWebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD,
                "mvc.command.name=resource_cmd_command"
        },
        service = MVCResourceCommand.class
)
public class AvanisComunidadMVCResourceCommand extends BaseMVCResourceCommand {

    private static final Log _log = LogFactoryUtil.getLog(AvanisComunidadPortlet.class);

    //TODO: Pasar a una clase singleton para que sólo haya que solicitarlo una vez
    private Long expandoColumnVisibilityId;
    private Long expandoTableMessageId;
    private Long messageClassId;
    private static final String VISIBILITY_CUSTOM_FIELD_NAME = "visibility";

    @Reference
    private AssetHelper _assetHelper;

    @Reference
    private TrashHelper _trashHelper;

    private Long getExpandoColumnVisibilityId() {
        if (expandoColumnVisibilityId != null) {
            return expandoColumnVisibilityId;
        } else {
            try {
                DynamicQuery dynamicQuery = ExpandoColumnLocalServiceUtil.dynamicQuery();
                dynamicQuery.add(RestrictionsFactoryUtil.eq("tableId", this.getExpandoTableMessageId()));
                dynamicQuery.add(RestrictionsFactoryUtil.eq("name", VISIBILITY_CUSTOM_FIELD_NAME));

                List<ExpandoColumn> expandoColumns = ExpandoColumnLocalServiceUtil.dynamicQuery(dynamicQuery);

                this.expandoColumnVisibilityId = expandoColumns.get(0).getColumnId();
                return this.expandoColumnVisibilityId;
            } catch (Exception e) {
                _log.error("Error getting expando column of message " + e.getMessage());
                return 0L;
            }
        }
    }

    private Long getExpandoTableMessageId() {
        if (expandoTableMessageId != null) {
            return expandoTableMessageId;
        } else {
            try {
                DynamicQuery dynamicQuery = ExpandoTableLocalServiceUtil.dynamicQuery();
                dynamicQuery.add(RestrictionsFactoryUtil.eq("classNameId", this.getMessageClassId()));

                List<ExpandoTable> expandoTables = ExpandoTableLocalServiceUtil.dynamicQuery(dynamicQuery);

                this.expandoTableMessageId = expandoTables.get(0).getTableId();
                return this.expandoTableMessageId;
            } catch (Exception e) {
                _log.error("Error getting expando table of message " + e.getMessage());
                return 0L;
            }
        }
    }

    private Long getMessageClassId() {
        if (messageClassId != null) {
            return messageClassId;
        } else {
            this.messageClassId = PortalUtil.getClassNameId(MBMessage.class.getName());
            return this.messageClassId;
        }
    }


    @Override
    protected void doServeResource(
            ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        User user = themeDisplay.getUser();

        String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
        long messageId = ParamUtil.getLong(resourceRequest, "messageId", -1);
        long parentMessageId = ParamUtil.getLong(resourceRequest, "parentMessageId", -1);
        long threadId = ParamUtil.getLong(resourceRequest, "threadId", -1);

        _log.debug("cmd:" + cmd + "; messageId: " + messageId + "; threadId: " + threadId);

        if ("getMoreMessages".equals(cmd)) {

            HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
            try {
                int offset = Integer.parseInt(httpReq.getParameter("offset"));
                String order = ParamUtil.getString(resourceRequest, "ordenMessages");
                if (!"ordenarPorRelevancia".equals(order)) {
                    ViewComunidadUseCase viewComunidadUseCase = new ViewComunidadUseCase(this.getExpandoColumnVisibilityId(), this.getExpandoTableMessageId(), offset);

                    viewComunidadUseCase.viewComunidad(resourceRequest, resourceResponse);
                } else {
                    resourceRequest.setAttribute("showSentinel", false);
                    resourceRequest.setAttribute("threads", new ArrayList<>());
                }


                resourceRequest.setAttribute(AssetWebKeys.ASSET_HELPER, _assetHelper);
                resourceRequest.setAttribute(TrashWebKeys.TRASH_HELPER, _trashHelper);

                include(resourceRequest, resourceResponse, "/list_message.jsp");
            } catch (NumberFormatException exception) {
                _log.error("Comunidad - getMoreMessages - Invalid offset: " + httpReq.getParameter("offset"));
            }

        } else {


            if (!themeDisplay.isSignedIn()) {
                throw new ForbiddenMessageException();
            }

            MBMessage message = MBMessageLocalServiceUtil.getMessage(messageId > 0 ? messageId : parentMessageId);
            MBMessage rootMsg = MBMessageLocalServiceUtil.getMessage(message.getRootMessageId());

            AvanisComunidadUtil.checkVisibility(AvanisComunidadUtil.getVisibility(rootMsg), themeDisplay.isSignedIn(), themeDisplay.getUser(), rootMsg);

            HttpServletResponse httpServletResponse = _portal.getHttpServletResponse(resourceResponse);
            httpServletResponse.setContentType(ContentTypes.APPLICATION_JSON);
            JSONObject jsonMessageObject = JSONFactoryUtil.createJSONObject();

            if ("shareCounterMessage".equals(cmd)) {
                if (Validator.isNotNull(message)) {
                    ExpandoBridge expandoBridge = message.getExpandoBridge();
                    Integer shared = (Integer) expandoBridge.getAttribute("shared");
                    shared = shared + 1;
                    expandoBridge.setAttribute("shared", shared);

                    jsonMessageObject.put("sharecountervalue", shared);
                    jsonMessageObject.put("status", Boolean.TRUE);
                }
            } else if ("likeCounterMessage".equals(cmd)) {
                List<RatingsEntry> ratingsEntries = RatingsEntryLocalServiceUtil.getEntries(MBMessage.class.getName(), messageId);
                double countLikesScore = 0;
                StringBuilder userNameList = new StringBuilder();
                for (RatingsEntry ratingsEntry : ratingsEntries) {
                    countLikesScore += ratingsEntry.getScore();
                    User userLikesScore = UserLocalServiceUtil.getUser(ratingsEntry.getUserId());
                    userNameList.append(userLikesScore.getFullName());
                    userNameList.append("\n");
                }
                int countLikes = (int) Math.round(countLikesScore);
                jsonMessageObject.put("usernamelist", userNameList);
                jsonMessageObject.put("likecountervalue", countLikes);
                jsonMessageObject.put("status", Boolean.TRUE);
            } else if ("quickyReply".equals(cmd)) {
                QuickReplyUseCase quickReplyUseCase = new QuickReplyUseCase(message, rootMsg);
                quickReplyUseCase.quickyReply(resourceRequest, resourceResponse);


                resourceRequest.setAttribute(AssetWebKeys.ASSET_HELPER, _assetHelper);
                resourceRequest.setAttribute(TrashWebKeys.TRASH_HELPER, _trashHelper);

                include(resourceRequest, resourceResponse, "/list_message.jsp");
                return;


            } else if ("reportMessage".equals(cmd)) {
                long reportMessageId = ParamUtil.getLong(resourceRequest, "reportMessageId", -1);
                long reportThreadId = ParamUtil.getLong(resourceRequest, "reportThreadId", -1);
                String selectedReason = ParamUtil.getString(resourceRequest, "selectedReason");
                ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);

                _log.debug("reportMessageId:" + reportMessageId + "; reportThreadId: " + reportThreadId + "; selectedReason: " + selectedReason);

                if (reportMessageId != -1) {
                    MBMessage mbMessage = MBMessageLocalServiceUtil.fetchMBMessage(reportMessageId);

                    if (mbMessage == null) {
                        _log.error("Message not found for id " + reportMessageId);
                        SessionErrors.add(resourceRequest, "messageNotFound");
                        jsonMessageObject.put("status", Boolean.FALSE);
                    } else {
                        MBSuspiciousActivity mbSuspiciousActivity = MBSuspiciousActivityLocalServiceUtil.createMBSuspiciousActivity(CounterLocalServiceUtil.increment(MBSuspiciousActivity.class.getName()));
                        mbSuspiciousActivity.setCompanyId(companyId);
                        mbSuspiciousActivity.setCreateDate(new Date());
                        mbSuspiciousActivity.setMessageId(reportMessageId);
                        mbSuspiciousActivity.setThreadId(reportThreadId);
                        mbSuspiciousActivity.setGroupId(groupId);
                        mbSuspiciousActivity.setReason(selectedReason);
                        mbSuspiciousActivity.setUserName(user.getFullName());
                        MBSuspiciousActivityLocalServiceUtil.addMBSuspiciousActivity(mbSuspiciousActivity);
                        //FlagsEntryServiceUtil.addEntry(MBMessage.class.getName(), mbMessage.getClassPK(), user.getEmailAddress(), userId, "", "", selectedReason, serviceContext);
                        SessionMessages.add(resourceRequest, "reportSubmitted");
                        jsonMessageObject.put("status", Boolean.TRUE);
                    }
                } else {
                    MBMessage rootMessage = null;
                    MBThread thread = MBThreadLocalServiceUtil.fetchMBThread(reportThreadId);
                    if (thread == null) {
                        _log.error("Thread not found for id " + reportThreadId);
                        SessionErrors.add(resourceRequest, "threadNotFound");
                        jsonMessageObject.put("status", Boolean.FALSE);
                    }
                    if (thread != null) {
                        rootMessage = MBMessageLocalServiceUtil.fetchMBMessage(thread.getRootMessageId());
                        if (rootMessage == null) {
                            _log.error("Root message not found for thread id " + reportThreadId);
                            SessionErrors.add(resourceRequest, "rootMessageNotFound");
                            jsonMessageObject.put("status", Boolean.FALSE);
                        }
                    }
                    if (thread != null && rootMessage != null) {
                        MBSuspiciousActivity mbSuspiciousActivity = MBSuspiciousActivityLocalServiceUtil.createMBSuspiciousActivity(CounterLocalServiceUtil.increment(MBSuspiciousActivity.class.getName()));
                        mbSuspiciousActivity.setCompanyId(companyId);
                        mbSuspiciousActivity.setCreateDate(new Date());
                        //mbSuspiciousActivity.setMessageId(reportMessageId);
                        mbSuspiciousActivity.setThreadId(reportThreadId);
                        mbSuspiciousActivity.setGroupId(groupId);
                        mbSuspiciousActivity.setReason(selectedReason);
                        mbSuspiciousActivity.setUserName(user.getFullName());
                        MBSuspiciousActivityLocalServiceUtil.addMBSuspiciousActivity(mbSuspiciousActivity);

                        //FlagsEntryServiceUtil.addEntry(MBMessage.class.getName(), rootMessage.getTrashEntryClassPK(), user.getEmailAddress(), userId, "", "", selectedReason, serviceContext);
                        //MBThreadFlagLocalServiceUtil.addThreadFlag(userId, thread, serviceContext);
                        SessionMessages.add(resourceRequest, "reportSubmitted");
                        jsonMessageObject.put("status", Boolean.TRUE);
                    }
                }
            } else if ("likeMessage".equals(cmd)) {
                String className = MBMessage.class.getName();
                double score = ParamUtil.getDouble(resourceRequest, "score");
                score = Math.round(score);
                RatingsEntry newLike = null;
                if (score == -1) {
                    RatingsEntryServiceUtil.deleteEntry(className, messageId);
                    jsonMessageObject.put("like", "unliked");
                } else {
                    newLike = RatingsEntryServiceUtil.updateEntry(className, messageId, score);
                    jsonMessageObject.put("like", "liked");
                }

                RatingsStats stats = RatingsStatsLocalServiceUtil.fetchStats(
                        className, messageId);

                double averageScore = 0.0;
                int totalEntries = 0;
                double totalScore = 0.0;

                if (stats != null) {
                    averageScore = stats.getAverageScore();
                    totalEntries = stats.getTotalEntries();
                    totalScore = stats.getTotalScore();
                }
                totalScore = Math.round(totalScore);
                jsonMessageObject.put(
                        "averageScore", averageScore
                ).put(
                        "score", score
                ).put(
                        "totalEntries", totalEntries
                ).put(
                        "totalScore", totalScore
                );
                jsonMessageObject.put("status", Boolean.TRUE);

                if (score != -1) {
                    AvanisComunidadUtil.sendLikeNotification(newLike, resourceRequest);
                    MBMessage likedMsg = MBMessageLocalServiceUtil.getMBMessage(messageId);
                    if (likedMsg.getMessageId() == likedMsg.getRootMessageId()) {
                        AvanisComunidadUtil.sendAchievementInteractionNotification(likedMsg, resourceRequest);
                    }
                }
            }
            JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonMessageObject);
        }
    }

    @Reference
    private Portal _portal;

}
