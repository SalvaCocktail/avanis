package avanis.comunidad.portlet.portlet;

import avanis.comunidad.model.Answers;
import avanis.comunidad.model.AnswersUser;
import avanis.comunidad.model.Surveys;
import avanis.comunidad.portlet.cache.ComunidadCacheUtil;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletConstants;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import avanis.comunidad.portlet.exceptions.ForbiddenMessageException;
import avanis.comunidad.portlet.usecases.ViewComunidadUseCase;
import avanis.comunidad.portlet.util.AvanisComunidadUtil;
import avanis.comunidad.service.AnswersLocalServiceUtil;
import avanis.comunidad.service.AnswersUserLocalServiceUtil;
import avanis.comunidad.service.SurveysLocalServiceUtil;
import avanis.social.follow.sb.service.SocialFollowLocalServiceUtil;
import com.liferay.asset.constants.AssetWebKeys;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.util.AssetHelper;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadFlagLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepository;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.TrashHelper;
import com.liferay.trash.util.TrashWebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import javax.portlet.annotations.ServeResourceMethod;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static avanis.comunidad.portlet.constants.AvanisComunidadPortletConstants.*;

/**
 * @author noemizarco
 */
@Component(
        property = {
                "com.liferay.portlet.css-class-wrapper=avanis-comunidad-portlet",
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=AvanisComunidad",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.init-param.config-template=/config/config.jsp",
                "javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-public-render-parameter=tag",
                "javax.portlet.version=3.0"
        },
        service = Portlet.class
)


public class AvanisComunidadPortlet extends MVCPortlet {

    private static final Log _log = LogFactoryUtil.getLog(AvanisComunidadPortlet.class);

    private static final String VIEW_TEMPLATE = "/view.jsp";
    private static final String VIEW_MESSAGE_CONTENT_RESOURCES = "/view_message_content_resources.jsp";
    private static final String EDIT_TEMPLATE = "/createOrUpdateMessage.jsp";
    private static final String VIEW_SURVEY_TEMPLATE = "/components/view_message_survey.jsp";
    private static final String VIEW_MESSAGE_REPLY_TEMPLATE = "/components/edit_message_reply.jsp";
    private static final String VIEW_MESSAGE_SHARE_TEMPLATE = "/components/view_message_share.jsp";
    private static final String CLOSE_POPUP_PUBLICATION_TEMPLATE = "/components/close_popup.jsp";

    private static final String VISIBILITY_CUSTOM_FIELD_NAME = "visibility";

    private Long expandoColumnVisibilityId;
    private Long expandoTableMessageId;
    private Long messageClassId;

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

    @Reference
    private PortletFileRepository _portletFileRepository;

    @Reference
    private AssetHelper _assetHelper;

    @Reference
    private TrashHelper _trashHelper;

    @Override
    public void render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        renderRequest.setAttribute(AssetWebKeys.ASSET_HELPER, _assetHelper);
        renderRequest.setAttribute(TrashWebKeys.TRASH_HELPER, _trashHelper);

        super.render(renderRequest, renderResponse);
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PortletSession portletSession = renderRequest.getPortletSession();
        String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
        String cmd_update = (String) portletSession.getAttribute("cmd_update");


        if ("UPDATE_OK".equals(cmd) || "UPDATE_OK".equals(cmd_update)) {
            renderRequest.setAttribute("isFromDetail", portletSession.getAttribute("isFromDetail"));
            portletSession.setAttribute("cmd_update", null);
            portletSession.setAttribute("isFromDetail", null);
            include(CLOSE_POPUP_PUBLICATION_TEMPLATE, renderRequest, renderResponse);
        } else if ("view_message_content_resource".equals(cmd)) {
            include(VIEW_MESSAGE_CONTENT_RESOURCES, renderRequest, renderResponse);
        } else if ("share_message".equals(cmd)) {
            String isFromDetail = ParamUtil.getString(renderRequest, "isFromDetail");
            renderRequest.setAttribute("isFromDetail", isFromDetail);
            include(VIEW_MESSAGE_SHARE_TEMPLATE, renderRequest, renderResponse);
        } else if ("edit_message_reply".equals(cmd)) {
            include(VIEW_MESSAGE_REPLY_TEMPLATE, renderRequest, renderResponse);
        } else if ("voteAnswerUser".equals(cmd)) {
            include(VIEW_SURVEY_TEMPLATE, renderRequest, renderResponse);
        } else if (Constants.UPDATE.equals(cmd)) {
            viewUpdateComunidad(renderRequest, renderResponse);
        } else {
            // Uso de caché en la obtención de mensajes
            String cacheKeyMessages = "comunidad_mensajes";
            List<MBMessage> mensajes = (List<MBMessage>) ComunidadCacheUtil.getFromCache(cacheKeyMessages);

            if (mensajes == null) {
                ViewComunidadUseCase viewComunidadUseCase = new ViewComunidadUseCase(
                        this.getExpandoColumnVisibilityId(),
                        this.getExpandoTableMessageId(),
                        0
                );
                viewComunidadUseCase.viewComunidad(renderRequest, renderResponse);

                mensajes = (List<MBMessage>) renderRequest.getAttribute("mensajes");
                ComunidadCacheUtil.addToCache(cacheKeyMessages, mensajes);
                _log.info("Mensajes almacenados en caché con clave: " + cacheKeyMessages);
            } else {
                _log.info("Mensajes obtenidos de la caché.");
                renderRequest.setAttribute("mensajes", mensajes);
            }

            include(VIEW_TEMPLATE, renderRequest, renderResponse);
        }
    }

    @ProcessAction(name = "deleteAttachment")
    public void deleteAttachment(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long messageId = ParamUtil.getLong(actionRequest, "messageId");
        String fileName = ParamUtil.getString(actionRequest, "fileName");
        try {
            MBMessage message = MBMessageLocalServiceUtil.fetchMBMessage(messageId);
            if (message != null) {
                if (message.getUserId() != themeDisplay.getUserId()) {
                    throw new ForbiddenMessageException();
                }
                MBMessageLocalServiceUtil.deleteMessageAttachment(messageId, fileName);

            }


        } catch (PortalException e) {
            _log.error("Delete not successful for id " + messageId + " and fileName " + fileName);
            SessionErrors.add(actionRequest, "Delete not successful");
            throw new PortletException(e);
        }
    }

    @ProcessAction(name = Constants.UPDATE)
    public void updateMessage(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        String inputPermissionsViewRolemessageId = ParamUtil.getString(actionRequest, "inputPermissionsViewRolemessageId");

        if (!"Guest".equals(inputPermissionsViewRolemessageId)) {
            throw new PortletException("Invalid input permission for message");
        }


        long groupId = themeDisplay.getScopeGroupId();
        long userId = themeDisplay.getUserId();
        String userName = themeDisplay.getUser().getFullName();
        long messageId = ParamUtil.getLong(actionRequest, "messageId");
        long parentMessageId = ParamUtil.getLong(actionRequest, "parentMessageId");
        long threadId = ParamUtil.getLong(actionRequest, "threadId");
        String subject = ParamUtil.getString(actionRequest, "subject");
        String body = ParamUtil.getString(actionRequest, "body");
        String messageFormat = ParamUtil.getString(actionRequest, "messageFormat");
        double priority = ParamUtil.getDouble(actionRequest, "priority");
        boolean anonymous = ParamUtil.getBoolean(actionRequest, "anonymous");
        boolean allowPingbacks = ParamUtil.getBoolean(actionRequest, "allowPingbacks");
        long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
        String visibility = ParamUtil.getString(actionRequest, "visibilityOptions", "registered");
        actionRequest.setAttribute(Constants.CMD, "UPDATE_OK");
        _log.debug("userId:" + userId + "; userName: " + userName + "; messageId: " + messageId);
        _log.debug("subject:" + subject + "; priority: " + priority + "; body: " + body);
        try {

            // Gestión adjuntos
            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            String[] fileNames = uploadPortletRequest.getFileNames("attachments");
            List<ObjectValuePair<String, InputStream>> inputStreamOVPs = new ArrayList<>();
            InputStream[] inputStreams = uploadPortletRequest.getFilesAsStream("attachments");
            if (Validator.isNotNull(fileNames) && Validator.isNotNull(fileNames[0])) {
                uploadPortletRequest.getFilesAsStream("attachments");
                for (int i = 0; i < fileNames.length; i++) {
                    inputStreamOVPs.add(new ObjectValuePair<>(fileNames[i], inputStreams[i]));
                }
            }

            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), actionRequest);

            // Recoger categorias
            String[] userOtherAgricultureCategories = ParamUtil.getParameterValues(actionRequest, "agricultureCategory");
            String[] userOtherStockbreadingCategories = ParamUtil.getParameterValues(actionRequest, "stockbreadingCategory");
            String[] userOtherCategories = ParamUtil.getParameterValues(actionRequest, "otherCategory");

            Long[] assetCategoryIds = Stream.of(
                            userOtherAgricultureCategories,
                            userOtherStockbreadingCategories,
                            userOtherCategories
                    )
                    .flatMap(Stream::of)
                    .map(Long::valueOf)
                    .toArray(Long[]::new);

            serviceContext.setAssetCategoryIds(ArrayUtil.toArray(assetCategoryIds));

            boolean isNewMessage = false;

            // Gestión publicación
            MBMessage message = MBMessageLocalServiceUtil.fetchMBMessage(messageId);
            if (message == null) {
                if (!themeDisplay.isSignedIn()) {
                    throw new ForbiddenMessageException();
                } else if (parentMessageId != 0) {
                    MBMessage parentMessage = MBMessageLocalServiceUtil.getMessage(parentMessageId);
                    MBMessage rootMessage = MBMessageLocalServiceUtil.getMessage(parentMessage.getRootMessageId());

                    AvanisComunidadUtil.checkVisibility(AvanisComunidadUtil.getVisibility(rootMessage), true, themeDisplay.getUser(), rootMessage);

                }
                // Nuevo mensage
                isNewMessage = true;
                message = MBMessageLocalServiceUtil.addMessage(
                        userId, userName, groupId, categoryId, threadId, parentMessageId, subject, body, messageFormat,
                        inputStreamOVPs, anonymous, priority, allowPingbacks, serviceContext);

                if (parentMessageId != 0) {
                    AvanisComunidadUtil.sendCommentNotification(message, actionRequest);
                    MBMessage rootMessage = MBMessageLocalServiceUtil.getMessage(message.getRootMessageId());
                    AvanisComunidadUtil.sendAchievementInteractionNotification(rootMessage, actionRequest);
                }

                SessionMessages.add(actionRequest, "messageAdded");
            }

            // Gestión categorias
            _log.debug("assetCategoryIds:" + Arrays.toString(serviceContext.getAssetCategoryIds()));

            // Update message
            if (!isNewMessage) {
                if (message.getUserId() != userId) {
                    throw new ForbiddenMessageException();
                }

                try {
                    message = MBMessageLocalServiceUtil.updateMessage(userId, messageId, subject, body, inputStreamOVPs, priority, allowPingbacks, serviceContext);
                } catch (Exception e) {
                    _log.error("An error occurred while update the message with messageId : " + messageId, e);
                }
                SessionMessages.add(actionRequest, "messageUpdated");
            }


            // Gestión encuesta
            manageSurvey(actionRequest, message);

            SessionMessages.add(actionRequest, "messageManaged");

            if (message.getMessageId() == message.getRootMessageId()) {
                ExpandoBridge expandoBridge = message.getExpandoBridge();
                expandoBridge.setAttribute("visibility", visibility);

                PortletSession portletSession = actionRequest.getPortletSession();
                portletSession.setAttribute("cmd_update", "UPDATE_OK");
                portletSession.setAttribute("isFromDetail", ParamUtil.getBoolean(actionRequest, "isFromDetail", false));

            } else if (isNewMessage && ParamUtil.getBoolean(actionRequest, "isFromDetail", false)) {
                actionResponse.sendRedirect("/comunidad/-/publicaciones/" + message.getRootMessageId());
            }
        } catch (PortalException e) {
            _log.error("An error occurred while adding the message: " + messageId);
            actionRequest.setAttribute("errorMessage", "An error occurred while adding the message: " + e.getMessage());
            throw new PortletException(e);
        }
    }

    private void manageSurvey(ActionRequest actionRequest, MBMessage message) throws PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getScopeGroupId();
        long userId = themeDisplay.getUserId();

        long surveyId = ParamUtil.getLong(actionRequest, SURVEY_ID);
        String question = ParamUtil.getString(actionRequest, QUESTION);
        String[] answersNews = ParamUtil.getStringValues(actionRequest, ANSWERS);
        int expireHours = ParamUtil.getInteger(actionRequest, EXPIRE_HOURS);

        Surveys survey = null;
        List<Answers> answersList = new ArrayList<>();
        List<AnswersUser> answersUserList = new ArrayList<>();
        if (Validator.isNotNull(surveyId)) {
            survey = SurveysLocalServiceUtil.fetchSurveys(surveyId);
        } else {
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(MBMessage.class.getName(), message.getMessageId());

            // Mirar si había una encuesta asociada a la publicación y borrarla
            List<Surveys> surveyList = SurveysLocalServiceUtil.getSurveysByAssetId(assetEntry.getEntryId());
            if (!surveyList.isEmpty()) {
                AvanisComunidadUtil.deleteSurvey(surveyList.get(0).getSurveyId());
                question = null;
            }
            if (Validator.isNotNull(question)) {
                survey = SurveysLocalServiceUtil.createSurveys(CounterLocalServiceUtil.increment(Surveys.class.getName()));
                survey.setCreateDate(new Date());
                survey.setAssetId(assetEntry.getEntryId());
                survey.setUserId(userId);
                survey.setGroupId(groupId);
            }
        }
        if (Validator.isNotNull(survey)) {
            answersList = AnswersLocalServiceUtil.getAnswersBySurveyId(surveyId);
            answersUserList = AnswersUserLocalServiceUtil.getAnswersUserBySurveyId(surveyId);
            surveyId = survey.getSurveyId();
            if (answersUserList.isEmpty()) {
                for (Answers answer : answersList) {
                    AnswersLocalServiceUtil.deleteAnswers(answer.getAnswerId());
                }
                for (String answerStr : answersNews) {
                    if (Validator.isNotNull(answerStr)) {
                        Answers answer = AnswersLocalServiceUtil.createAnswers(CounterLocalServiceUtil.increment(Answers.class.getName()));
                        answer.setAnswer(answerStr);
                        answer.setSurveyId(survey.getSurveyId());
                        answer.setCreateDate(new Date());
                        answer.setCounterAnswer(0);
                        AnswersLocalServiceUtil.addAnswers(answer);
                    }
                }
            }
            survey.setQuestion(question);
            survey.setExpireHours(expireHours);
            survey.setModifiedDate(new Date());
            if (Validator.isNotNull(expireHours)) {
                Calendar expireDate = GregorianCalendar.getInstance();
                expireDate.setTime(survey.getCreateDate());
                expireDate.add(Calendar.HOUR, expireHours);
                survey.setExpireDate(expireDate.getTime());
            } else {
                survey.setExpireDate(null);
            }

            Surveys surveys = SurveysLocalServiceUtil.updateSurveys(survey);

            Message cronSurveyMessage = new Message();
            cronSurveyMessage.put("surveyId", surveys.getSurveyId());

            // Obtener la fecha y hora actual + 3 minutos
            LocalDateTime fechaEjecucion = LocalDateTime.now().plusMinutes(3);

            // Crear la expresión cron usando segundos, minutos, horas, días, meses y días de la semana
            DateTimeFormatter cronFormatter = DateTimeFormatter.ofPattern("ss mm HH dd MM ? yyyy");

            Trigger trigger = TriggerFactoryUtil.createTrigger("survey" + surveys.getSurveyId(), "surveys", fechaEjecucion.format(cronFormatter));

            SchedulerEngineHelperUtil.schedule(
                    trigger, StorageType.MEMORY_CLUSTERED, "Notificaciones para encuesta finalizada", "finishedSurvey", cronSurveyMessage
            );


        }
    }

    @ProcessAction(name = "voteAnswerUser")
    public void voteAnswerUser(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        long messageId = ParamUtil.getLong(actionRequest, "messageId");
        long answerSelected = ParamUtil.getLong(actionRequest, "answerSelected");

        if (Validator.isNotNull(messageId) && Validator.isNotNull(answerSelected)) {
            actionRequest.setAttribute("messageId", messageId);
            MBMessage message = MBMessageLocalServiceUtil.fetchMBMessage(messageId);
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getScopeGroupId();
            long userId = themeDisplay.getUserId();

            AvanisComunidadUtil.checkVisibility(AvanisComunidadUtil.getVisibility(message), themeDisplay.isSignedIn(), themeDisplay.getUser(), message);


            actionRequest.setAttribute("messageId", messageId);

            Surveys survey = null;
            List<Answers> answersList = null;
            List<AnswersUser> answersUserList = null;
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(MBMessage.class.getName(), messageId);
            if (assetEntry != null) {
                List<Surveys> surveys = SurveysLocalServiceUtil.getSurveysByAssetId(assetEntry.getEntryId());
                if (!surveys.isEmpty()) {
                    survey = surveys.get(0);
                    answersList = AnswersLocalServiceUtil.getAnswersBySurveyId(survey.getSurveyId());
                    answersUserList = AnswersUserLocalServiceUtil.getAnswersUserBySurveyId(survey.getSurveyId());
                }
            }
            if (survey != null) {
                for (AnswersUser answersUser : answersUserList) {
                    if (answersUser.getUserId() == userId) {
                        try {
                            AnswersUserLocalServiceUtil.deleteAnswersUser(answersUser.getAnswerUserId());
                        } catch (PortalException e) {
                            _log.error("An error occurred while delete answersUser the messageId: " + messageId + ", userId: " + userId + " and answersId " + answersUser.getAnswerId());
                        }
                        break;
                    }
                }
                AnswersUser answerUser = AnswersUserLocalServiceUtil.createAnswersUser(CounterLocalServiceUtil.increment(AnswersUser.class.getName()));
                answerUser.setAnswerId(answerSelected);
                answerUser.setUserId(userId);
                answerUser.setSurveyId(survey.getSurveyId());
                answerUser.setCreateDate(new Date());

                AnswersUserLocalServiceUtil.updateAnswersUser(answerUser);
            }
        }
    }

    @ProcessAction(name = Constants.DELETE)
    public void deleteMessage(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        long messageId = ParamUtil.getLong(actionRequest, "messageId");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);


        try {
            MBMessage message = MBMessageLocalServiceUtil.getMBMessage(messageId);

            if (message.getUserId() != themeDisplay.getUserId()) {
                throw new ForbiddenMessageException();
            }

            // Delete Survey
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(MBMessage.class.getName(), messageId);
            List<Surveys> surveyList = SurveysLocalServiceUtil.getSurveysByAssetId(assetEntry.getEntryId());
            if (!surveyList.isEmpty()) {
                AvanisComunidadUtil.deleteSurvey(surveyList.get(0).getSurveyId());
            }

            List<MBMessage> mbMessageLevel1List = MBMessageLocalServiceUtil.getChildMessages(messageId, WorkflowConstants.STATUS_APPROVED);
            for (MBMessage mbMessageLevel1 : mbMessageLevel1List) {
                List<MBMessage> mbMessageLevel2List = MBMessageLocalServiceUtil.getChildMessages(mbMessageLevel1.getMessageId(), WorkflowConstants.STATUS_APPROVED);
                for (MBMessage mbMessageLevel2 : mbMessageLevel2List) {
                    MBMessageLocalServiceUtil.deleteMessage(mbMessageLevel2.getMessageId());
                }
                MBMessageLocalServiceUtil.deleteMessage(mbMessageLevel1.getMessageId());
            }
            MBMessageLocalServiceUtil.deleteMessage(messageId);

            SessionMessages.add(actionRequest, "messageDeleted");
        } catch (PortalException e) {
            _log.error("Error deleting message", e);
            SessionErrors.add(actionRequest, "error-delete-message");
            throw new PortletException(e);
        }
    }

    @ProcessAction(name = "editMessage")
    public void editMessage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long messageId = ParamUtil.getLong(actionRequest, "messageId");
        String subject = ParamUtil.getString(actionRequest, "subject");
        String body = ParamUtil.getString(actionRequest, "body");


        try {
            if (messageId > 0) {
                MBMessage message = MBMessageLocalServiceUtil.getMBMessage(messageId);
                if (message.getUserId() != themeDisplay.getUserId()) {
                    throw new ForbiddenMessageException();
                }

                message.setSubject(subject);
                message.setBody(body);
                MBMessageLocalServiceUtil.updateMBMessage(message);
                SessionMessages.add(actionRequest, "messageEdited");
            }
        } catch (PortalException e) {
            actionRequest.setAttribute("errorMessage", "An error occurred while editing the message: " + e.getMessage());
            throw new PortletException(e);
        }
        actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirect"));
    }

    @ProcessAction(name = "addReplyToMessageForm")
    public void addReplyToMessageForm(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getScopeGroupId();
        long userId = themeDisplay.getUserId();
        String userName = themeDisplay.getUser().getFullName();

        long messageId = ParamUtil.getLong(actionRequest, "messageId");
        String body = ParamUtil.getString(actionRequest, "addReplyToMessageBody" + messageId);
        _log.debug("userId:" + userId + "; userName: " + userName + "; messageId: " + messageId);
        _log.debug("body: " + body);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), actionRequest);
        try {
            MBMessage message = MBMessageLocalServiceUtil.getMessage(messageId);

            AvanisComunidadUtil.checkVisibility(AvanisComunidadUtil.getVisibility(message), themeDisplay.isSignedIn(), themeDisplay.getUser(), message);


            if (message != null) {
                message = MBMessageLocalServiceUtil.addMessage(
                        userId, userName, groupId, 0, message.getThreadId(), messageId, "", body, "html",
                        null, false, 0, false, serviceContext);
                SessionMessages.add(actionRequest, "addReplyToMessageAdded");
            }
        } catch (PortalException e) {
            _log.error("An error occurred while adding reply to message: " + messageId);
            actionRequest.setAttribute("errorMessage", "An error occurred while adding reply to message: " + e.getMessage());
            throw new PortletException(e);
        }
    }

    @ProcessAction(name = "reportMessage")
    public void reportMessage(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        long messageId = ParamUtil.getLong(actionRequest, "messageId");
        long threadId = ParamUtil.getLong(actionRequest, "threadId");
        String reportReason = ParamUtil.getString(actionRequest, "reportReason");

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();

            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

            MBThread thread = MBThreadLocalServiceUtil.fetchMBThread(threadId);
            if (thread == null) {
                _log.error("Thread not found for id " + threadId);
                SessionErrors.add(actionRequest, "threadNotFound");
                return;
            }

            MBMessage rootMessage = MBMessageLocalServiceUtil.fetchMBMessage(thread.getRootMessageId());
            if (rootMessage == null) {
                _log.error("Root message not found for thread id " + threadId);
                SessionErrors.add(actionRequest, "rootMessageNotFound");
                return;
            } else {
                AvanisComunidadUtil.checkVisibility(AvanisComunidadUtil.getVisibility(rootMessage), themeDisplay.isSignedIn(), themeDisplay.getUser(), rootMessage);
            }

            MBThreadFlagLocalServiceUtil.addThreadFlag(userId, thread, serviceContext);

            SessionMessages.add(actionRequest, "reportSubmitted");
        } catch (Exception e) {
            _log.error("Error reporting message", e);
            SessionErrors.add(actionRequest, "reportError");
        }

        actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirect"));
    }

    public void viewUpdateComunidad(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        if (!themeDisplay.isSignedIn()) {
            throw new ForbiddenMessageException();
        }


        long groupId = themeDisplay.getScopeGroupId();
        long companyId = themeDisplay.getCompanyId();
        long messageId = ParamUtil.getLong(renderRequest, "messageId", -1);
        String body = ParamUtil.getString(renderRequest, "body");
        Boolean isFromDetail = ParamUtil.getString(renderRequest, "redirect") != null && ParamUtil.getString(renderRequest, "redirect").contains("/publicaciones/");
        renderRequest.setAttribute("body", body);
        renderRequest.setAttribute("isFromDetail", isFromDetail);

        MBMessage message = MBMessageLocalServiceUtil.fetchMBMessage(messageId);


        List<AssetCategory> selectedCategories = new ArrayList<>();
        if (message != null) {
            if (message.getUserId() != themeDisplay.getUserId()) {
                throw new ForbiddenMessageException();
            }
            AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(MBMessage.class.getName(), messageId);
            if (assetEntry != null) {
                selectedCategories = assetEntry.getCategories();
            }

            renderRequest.setAttribute("visibility", AvanisComunidadUtil.getVisibility(message));

            // Cargar encuesta
            List<Surveys> surveysList = SurveysLocalServiceUtil.getSurveysByAssetId(assetEntry.getEntryId());
            if (!surveysList.isEmpty()) {
                Surveys survey = surveysList.get(0);
                if (Validator.isNotNull(survey.getSurveyId())) {
                    List<Answers> answersList = AnswersLocalServiceUtil.getAnswersBySurveyId(survey.getSurveyId());
                    List<AnswersUser> answersUserList = AnswersUserLocalServiceUtil.getAnswersUserBySurveyId(survey.getSurveyId());
                    renderRequest.setAttribute("survey", survey);
                    renderRequest.setAttribute("answers", answersList);
                    renderRequest.setAttribute("answersUsers", answersUserList);
                }
            }
        } else {
            renderRequest.setAttribute("visibility", "registered");
        }

        // Lista de categorías
        List<AssetCategory> agricultureCategories = AvanisComunidadUtil.getGlobalSubcategories(AvanisComunidadPortletConstants.AGRICULTURE_CATEGORY_ERC);
        List<AssetCategory> stockbreadingCategories = AvanisComunidadUtil.getGlobalSubcategories(AvanisComunidadPortletConstants.STOCKBREADING_CATEGORY_ERC);
        List<AssetCategory> otherCategories = AvanisComunidadUtil.getGlobalCategory("avanis").stream().filter(assetCategory -> assetCategory.getParentCategoryId() == 0).collect(Collectors.toList());

        renderRequest.setAttribute("agricultureCategories", agricultureCategories);
        renderRequest.setAttribute("stockbreadingCategories", stockbreadingCategories);
        renderRequest.setAttribute("otherCategories", otherCategories);

        List<AssetCategory> categories = AvanisComunidadUtil.getAssetCategoryGlobalList(companyId, groupId);
        long[] categoriesIds = AvanisComunidadUtil.getCategoriesIds(categories);
        long[] selectedCategoriesIds = AvanisComunidadUtil.getCategoriesIds(selectedCategories);
        List<String> userAssetCategoriesNames = selectedCategories.stream().map(AssetCategory::getName).map(String::toLowerCase).collect(Collectors.toList());
        List<String> userAssetCategoriesIds = selectedCategories.stream().map(AssetCategory::getCategoryId).map(String::valueOf).collect(Collectors.toList());

        List<String> agricultureCategoriesSelected = new ArrayList<>();
        List<String> stockbreadingCategoriesSelected = new ArrayList<>();
        List<String> otherCategoriesSelected = new ArrayList<>();
        for (AssetCategory selectedCategory : selectedCategories) {
            boolean encontradaCategory = false;
            for (AssetCategory agricultureCategory : agricultureCategories) {
                if (selectedCategory.getCategoryId() == agricultureCategory.getCategoryId()) {
                    agricultureCategoriesSelected.add(String.valueOf(agricultureCategory.getCategoryId()));
                    encontradaCategory = true;
                    break;
                }
            }
            if (encontradaCategory == false) {
                for (AssetCategory stockbreadingCategory : stockbreadingCategories) {
                    if (selectedCategory.getCategoryId() == stockbreadingCategory.getCategoryId()) {
                        stockbreadingCategoriesSelected.add(String.valueOf(stockbreadingCategory.getCategoryId()));
                        encontradaCategory = true;
                        break;
                    }
                }
                if (encontradaCategory == false) {
                    for (AssetCategory otherCategory : otherCategories) {
                        if (selectedCategory.getCategoryId() == otherCategory.getCategoryId()) {
                            otherCategoriesSelected.add(String.valueOf(otherCategory.getCategoryId()));
                            break;
                        }
                    }
                }
            }

        }

        renderRequest.setAttribute("agricultureCategoriesSelected", agricultureCategoriesSelected.stream().collect(Collectors.joining(",")));
        renderRequest.setAttribute("stockbreadingCategoriesSelected", stockbreadingCategoriesSelected.stream().collect(Collectors.joining(",")));
        renderRequest.setAttribute("otherCategoriesSelected", otherCategoriesSelected.stream().collect(Collectors.joining(",")));

        renderRequest.setAttribute("categories", categories);
        renderRequest.setAttribute("categoriesIds", Arrays.toString(categoriesIds));
        renderRequest.setAttribute("selectedCategories", selectedCategories);
        renderRequest.setAttribute("selectedCategoriesIds", Arrays.toString(selectedCategoriesIds));
        renderRequest.setAttribute("userAssetCategoriesNames", userAssetCategoriesNames);
        renderRequest.setAttribute("userAssetCategoriesIds", userAssetCategoriesIds);

        renderRequest.setAttribute("message", message);

        include(EDIT_TEMPLATE, renderRequest, renderResponse);
    }


}
