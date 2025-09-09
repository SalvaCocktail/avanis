package avanis.comunidad.portlet.util;

import avanis.comunidad.model.AnswerResults;
import avanis.comunidad.model.Answers;
import avanis.comunidad.model.AnswersUser;
import avanis.comunidad.model.Surveys;
import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import avanis.comunidad.portlet.exceptions.ForbiddenMessageException;
import avanis.comunidad.portlet.hubspot.HubspotServiceHttp;
import avanis.comunidad.service.AnswersLocalServiceUtil;
import avanis.comunidad.service.AnswersUserLocalServiceUtil;
import avanis.comunidad.service.SurveysLocalServiceUtil;
import avanis.social.follow.sb.model.SocialFollow;
import avanis.social.follow.sb.service.SocialFollowLocalServiceUtil;
import avanis.tu.explotacion.sb.model.Explotacion;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.push.notifications.constants.PushNotificationsPortletKeys;
import com.liferay.ratings.kernel.model.RatingsEntry;
import com.liferay.ratings.kernel.service.RatingsEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataSourceFactory;

import javax.naming.InitialContext;
import javax.portlet.PortletRequest;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AvanisComunidadUtil {


    private static final Log _log = LogFactoryUtil.getLog(AvanisComunidadUtil.class);

    private static final Integer MAX_CHARACTER_OF_BODY_NOTIFICATIONS = 20;
    private static final Integer MAX_CHARACTER_OF_BODY_EMAIL = 100;

    public static List<AssetCategory> getGlobalCategory(String vocabularyName) {
        AssetVocabulary vocabulary = null;
        try {
            long groupId = 20119;
            vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, vocabularyName);
            return AssetCategoryLocalServiceUtil.getVocabularyCategories(
                    vocabulary.getVocabularyId(), 0, Integer.MAX_VALUE, null
            );

        } catch (PortalException e) {
            return new ArrayList<>();
        }

    }

    public static List<AssetCategory> getGlobalSubcategories(String externalReferenceCode) {

        try {
            long groupId = 20119; //Global group
            long parentCategoryId = AssetCategoryLocalServiceUtil.getAssetCategoryByExternalReferenceCode(externalReferenceCode, groupId).getCategoryId();

            return AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);


        } catch (PortalException e) {
            return new ArrayList<>();
        }

    }

    public static long[] getCategoriesIds(List<AssetCategory> categories) {
        long[] categoriesIds = new long[categories.size()];

        for (int i = 0; i < categories.size(); i++) {
            categoriesIds[i] = categories.get(i).getCategoryId();
        }
        return categoriesIds;
    }

    public static List<AssetCategory> getAssetCategoryGlobalList(long companyId, long groupId) {
        List<AssetCategory> assetCategoryList = new ArrayList<AssetCategory>();
        AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(groupId, "avanis");
        if (vocabulary == null) {
            List<AssetVocabulary> vocabularyList = AssetVocabularyLocalServiceUtil.getCompanyVocabularies(companyId);
            for (AssetVocabulary assetVocabulary : vocabularyList) {
                if (assetVocabulary.getName().equals("avanis")) {
                    vocabulary = assetVocabulary;
                    break;
                }
            }
        }
        if (vocabulary != null) {
            OrderByComparator<AssetCategory> categoryOrderByComparator = OrderByComparatorFactoryUtil.create("AssetCategory", "name", true);
            assetCategoryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, categoryOrderByComparator);
        }
        return assetCategoryList;
    }

    public static Surveys deleteSurvey(long surveyId) {
        Surveys survey = null;
        try {
            survey = SurveysLocalServiceUtil.getSurveys(surveyId);
        } catch (PortalException e) {
            _log.error("Not survey with id " + surveyId + " finded for delete", e);
            throw new RuntimeException(e);
        }
        if (Validator.isNotNull(survey)) {
            List<AnswersUser> answersUser = AnswersUserLocalServiceUtil.getAnswersUserBySurveyId(surveyId);
            List<Answers> answers = AnswersLocalServiceUtil.getAnswersBySurveyId(surveyId);
            for (AnswersUser answerUser : answersUser) {
                AnswersUserLocalServiceUtil.deleteAnswersUser(answerUser);
            }
            for (Answers answer : answers) {
                AnswersLocalServiceUtil.deleteAnswers(answer);
            }
            SurveysLocalServiceUtil.deleteSurveys(survey);
        }
        return survey;
    }


    public static void sendMentionNotification(User mentionedUser, MBMessage newMessage, PortletRequest portletRequest) {

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), portletRequest);


            String commentNotificationSetting = getNotificationSetting(mentionedUser, "mentions");

            if (isNotificationAppActivated(commentNotificationSetting)) {
                String title = "nueva comment notification title"; // podemos dejarlo vacío si está en la plantilla
                String body = "nueva comment notification body"; // podemos dejarlo vacío si está en la plantilla
                String articleTitle = "mentionnotification"; // En la plantilla se reemplazará [$TITLE$] por title y [$BODY$] por body
                String entryURL = serviceContext.getPortalURL() + "/comunidad/-/publicaciones/" + newMessage.getMessageId();

                sendNotification(serviceContext, newMessage.getMessageId(), mentionedUser.getUserId(), title, body, articleTitle, entryURL);
            }

            if (isNotificationEmailActivaded(commentNotificationSetting)) {
                //TODO: Enviar email
            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        }

    }


    public static void sendFollowNotification(SocialFollow socialFollow, PortletRequest portletRequest) {

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Surveys.class.getName(), portletRequest);

            User followed = UserLocalServiceUtil.getUser(socialFollow.getFollowsTo());
            User userWhoFollowed = UserLocalServiceUtil.getUser(socialFollow.getUserId());


            String followersNotificationSetting = getNotificationSetting(followed, "followers");

            if (isNotificationAppActivated(followersNotificationSetting)) {

                String articleTitle = "followernotification";
                String entryURL = serviceContext.getPortalURL() + "/mi-perfil-publico?focusedTab=followers";


                JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
                notificationEventJSONObject.put("userId", serviceContext.getUserId());
                notificationEventJSONObject.put("userFullName", userWhoFollowed.getFullName());
                notificationEventJSONObject.put("username", userWhoFollowed.getScreenName());
                notificationEventJSONObject.put("classPK", socialFollow.getSocialFollowId());
                notificationEventJSONObject.put("entryURL", entryURL);
                notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
                notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
                notificationEventJSONObject.put("articleTitle", articleTitle);

                sendNotification(followed.getUserId(), notificationEventJSONObject);
            }

            if (isNotificationEmailActivaded(followersNotificationSetting)) {
                //TODO: Enviar email
            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        }


    }


    public static void sendFollowRequestAcceptedNotification(SocialFollow socialFollow, PortletRequest portletRequest) {

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Surveys.class.getName(), portletRequest);

            User followed = UserLocalServiceUtil.getUser(socialFollow.getFollowsTo());
            User userWhoFollowed = UserLocalServiceUtil.getUser(socialFollow.getUserId());


            String followersNotificationSetting = getNotificationSetting(userWhoFollowed, "followers");

            if (isNotificationAppActivated(followersNotificationSetting)) {

                String articleTitle = "followRequestNotification";
                String entryURL = serviceContext.getPortalURL() + "/mi-perfil-publico?focusedTab=following";


                JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
                notificationEventJSONObject.put("userId", userWhoFollowed.getUserId());
                notificationEventJSONObject.put("userFullName", followed.getFullName());
                notificationEventJSONObject.put("username", followed.getScreenName());
                notificationEventJSONObject.put("classPK", socialFollow.getSocialFollowId());
                notificationEventJSONObject.put("entryURL", entryURL);
                notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
                notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
                notificationEventJSONObject.put("articleTitle", articleTitle);

                sendNotification(userWhoFollowed.getUserId(), notificationEventJSONObject);
            }

            if (isNotificationEmailActivaded(followersNotificationSetting)) {
                //TODO: Enviar email
            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        }


    }


    public static void sendSurveyResultsNotification(Surveys survey) {

        try {
            ServiceContext serviceContext = new ServiceContext();

            User surveryAuthor = UserLocalServiceUtil.getUser(survey.getUserId());

            PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(surveryAuthor);
            PrincipalThreadLocal.setName(surveryAuthor.getUserId());
            PermissionThreadLocal.setPermissionChecker(permissionChecker);

            String surveysNotificationSetting = getNotificationSetting(surveryAuthor, "surveys_results");


            String entryURL = PropsUtil.get("avanis.portal.url") + "/comunidad/-/publicaciones/" + AssetEntryServiceUtil.getEntry(survey.getAssetId()).getClassPK();

            if (isNotificationAppActivated(surveysNotificationSetting)) {
                String articleTitle = "surveryresultsnotification";


                JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
                notificationEventJSONObject.put("userId", serviceContext.getUserId());
                notificationEventJSONObject.put("body", getBodyForNotification(survey.getQuestion()));
                notificationEventJSONObject.put("classPK", survey.getSurveyId());
                notificationEventJSONObject.put("entryURL", entryURL);
                notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
                notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
                notificationEventJSONObject.put("articleTitle", articleTitle);

                sendNotification(surveryAuthor.getUserId(), notificationEventJSONObject);
            }

            if (isNotificationEmailActivaded(surveysNotificationSetting)) {
                List<Answers> answers = AnswersLocalServiceUtil.getAnswersBySurveyId(survey.getSurveyId());
                Answers winnerAnswer = null;
                long numVotes = 0;
                int numOption = 0;
                long allVotes = 0;
                int i = 0;

                for (Answers answer : answers) {
                    i++;

                    DynamicQuery numVotesQuery = AnswersUserLocalServiceUtil.dynamicQuery();
                    numVotesQuery.setProjection(ProjectionFactoryUtil.rowCount());
                    numVotesQuery.add(RestrictionsFactoryUtil.eq("answerId", answer.getAnswerId()));
                    numVotesQuery.add(RestrictionsFactoryUtil.eq("surveyId", answer.getSurveyId()));
                    List<Long> result = AnswersUserLocalServiceUtil.dynamicQuery(numVotesQuery);
                    long currentAnswerVotes = 0;
                    if (!result.isEmpty()) {
                        currentAnswerVotes = result.get(0);
                    }


                    if (winnerAnswer == null) {
                        winnerAnswer = answer;
                        numVotes = currentAnswerVotes;
                        numOption = 1;
                    } else if (numVotes < currentAnswerVotes) {
                        winnerAnswer = answer;
                        numVotes = currentAnswerVotes;
                        numOption = i;
                    }
                    allVotes += currentAnswerVotes;

                }

                HubspotServiceHttp.sendPollResultsEmailUseCase(surveryAuthor.getEmailAddress(), surveryAuthor.getFullName(), numVotes, survey.getQuestion(), numOption, allVotes != 0 ? (double) Math.round((float) (numVotes / allVotes) * 10000) / 100 : 0, winnerAnswer.getAnswer(), entryURL);
            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        } finally {
            PrincipalThreadLocal.setName(null);
            PermissionThreadLocal.setPermissionChecker(null);
        }


    }


    public static void sendCommentNotification(MBMessage newMessage, PortletRequest portletRequest) {

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), portletRequest);
            ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(
                    WebKeys.THEME_DISPLAY);

            MBMessage parentMessage = MBMessageLocalServiceUtil.getMessage(newMessage.getParentMessageId());
            User authorParentMessage = UserLocalServiceUtil.getUser(parentMessage.getUserId());
            User userWhoCommented = UserLocalServiceUtil.getUser(newMessage.getUserId());
            long rootMessageId = parentMessage.getRootMessageId();

            String commentNotificationSetting = getNotificationSetting(authorParentMessage, "comments");
            String entryURL = serviceContext.getPortalURL() + "/comunidad/-/publicaciones/" + rootMessageId;

            if (isNotificationAppActivated(commentNotificationSetting)) {
                String articleTitle = "commentnotification";


                JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
                notificationEventJSONObject.put("userId", serviceContext.getUserId());
                notificationEventJSONObject.put("userFullName", userWhoCommented.getFullName());
                notificationEventJSONObject.put("username", userWhoCommented.getScreenName());
                notificationEventJSONObject.put("body", getBodyForNotification(parentMessage.getBody()));
                notificationEventJSONObject.put("classPK", parentMessage.getClassPK());
                notificationEventJSONObject.put("entryURL", entryURL);
                notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
                notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
                notificationEventJSONObject.put("articleTitle", articleTitle);


                sendNotification(authorParentMessage.getUserId(), notificationEventJSONObject);
            }

            if (isNotificationEmailActivaded(commentNotificationSetting)) {

                Integer interactions = countInteractions(parentMessage);
                boolean isFirstInteraction = interactions == 1;

                if (isFirstInteraction) {
                    HubspotServiceHttp.sendFirstInteractionComunidadEmailUseCase(authorParentMessage.getEmailAddress(), parentMessage.getBody(), authorParentMessage.fetchPortraitURL(themeDisplay),
                            authorParentMessage.getScreenName(), newMessage.getBody(), authorParentMessage.getFirstName(), entryURL);
                }

            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        }


    }

    public static void sendLikeNotification(RatingsEntry newLike, PortletRequest portletRequest) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), portletRequest);

            MBMessage message = MBMessageLocalServiceUtil.getMessage(newLike.getClassPK());
            User authorParentMessage = UserLocalServiceUtil.getUser(message.getUserId());
            User userWhoLiked = UserLocalServiceUtil.getUser(newLike.getUserId());
            long rootMessageId = message.getRootMessageId();

            String likeNotificationSetting = getNotificationSetting(authorParentMessage, "likes");

            if (isNotificationAppActivated(likeNotificationSetting)) {
                String articleTitle = "likenotification";
                String entryURL = serviceContext.getPortalURL() + "/comunidad/-/publicaciones/" + rootMessageId;


                JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
                notificationEventJSONObject.put("userId", serviceContext.getUserId());
                notificationEventJSONObject.put("userFullName", userWhoLiked.getFullName());
                notificationEventJSONObject.put("username", userWhoLiked.getScreenName());
                notificationEventJSONObject.put("body", getBodyForNotification(message.getBody()));
                notificationEventJSONObject.put("classPK", newLike.getClassPK());
                notificationEventJSONObject.put("entryURL", entryURL);
                notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
                notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
                notificationEventJSONObject.put("articleTitle", articleTitle);


                sendNotification(authorParentMessage.getUserId(), notificationEventJSONObject);
            }

            if (isNotificationEmailActivaded(likeNotificationSetting)) {
                //TODO: Enviar email
            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        }

    }

    public static void sendPlotsNotification(Explotacion explotacion, PortletRequest portletRequest, String warningPhenomenon,
                                             String location, String warningDescription, String warningProb) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), portletRequest);

            if (explotacion.getAllowNotifications()) {

                String title = warningPhenomenon + " en tu explotación de " + location; // podemos dejarlo vacío si está en la plantilla
                String body = warningDescription + ", Probabilidad " + warningProb; // podemos dejarlo vacío si está en la plantilla

                String articleTitle = "meteoalert"; // En la plantilla se reemplazará [$TITLE$] por title y [$BODY$] por body
                String entryURL = serviceContext.getPortalURL() + "/explotacion";

                // Verificar notificaciones duplicadas
                List<UserNotificationEvent> duplicates = findDuplicateNotifications(explotacion.getUserId());
                for (UserNotificationEvent duplicate : duplicates) {
                    if (isDuplicateNotification(duplicate, explotacion.getExplotacionId(), title, body, articleTitle, entryURL)) {
                        _log.info("Duplicate notification found. Skipping sending notification.");
                        return; // Salir si se encuentra una notificación duplicada
                    }
                }

                sendNotification(serviceContext, explotacion.getExplotacionId(), explotacion.getUserId(), title, body, articleTitle, entryURL);
            }
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendAchievementFollowerNotification(User user, Integer followers, PortletRequest portletRequest) {
        final Integer NEW_FOLLOWERS_TO_NOTIFY = 10;
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), portletRequest);

            ExpandoBridge expandoBridge = user.getExpandoBridge();
            Integer lastFollowersNotification = (Integer) expandoBridge.getAttribute("last_followers_notification");

            if (followers > lastFollowersNotification && followers % NEW_FOLLOWERS_TO_NOTIFY == 0) {

                expandoBridge.setAttribute("last_followers_notification", followers);
                String achievementsNotificationSetting = getNotificationSetting(user, "achievements");

                if (isNotificationAppActivated(achievementsNotificationSetting)) {

                    String articleTitle = "achievementFollowers";
                    String entryURL = serviceContext.getPortalURL() + "/mi-perfil-publico?focusedTab=followers";


                    JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
                    notificationEventJSONObject.put("userId", user.getUserId());
                    notificationEventJSONObject.put("achievementNumber", followers);

                    notificationEventJSONObject.put("entryURL", entryURL);
                    notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
                    notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
                    notificationEventJSONObject.put("articleTitle", articleTitle);

                    sendNotification(user.getUserId(), notificationEventJSONObject);
                }

                if (isNotificationEmailActivaded(achievementsNotificationSetting)) {
                    HubspotServiceHttp.sendAchievementFollowerEmailUseCase(user.getEmailAddress(), user.getFullName(), followers);
                }

            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        }


    }


    public static void sendAchievementInteractionNotification(MBMessage rootMessage, PortletRequest portletRequest) {
        final Integer NEW_INTERACTIONS_TO_NOTIFY = 10;
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), portletRequest);
            Integer interactions = countInteractions(rootMessage);
            User user = UserLocalServiceUtil.getUser(rootMessage.getUserId());

            ExpandoBridge expandoBridge = rootMessage.getExpandoBridge();
            Integer lastFollowersNotification = (Integer) expandoBridge.getAttribute("last_interactions_notification");

            if (interactions > lastFollowersNotification && interactions % NEW_INTERACTIONS_TO_NOTIFY == 0) {

                expandoBridge.setAttribute("last_interactions_notification", interactions);
                String achievementsNotificationSetting = getNotificationSetting(user, "achievements");
                String entryURL = serviceContext.getPortalURL() + "/comunidad/-/publicaciones/" + rootMessage.getMessageId();

                if (isNotificationAppActivated(achievementsNotificationSetting)) {

                    String articleTitle = "achievementInteractions";


                    JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
                    notificationEventJSONObject.put("userId", user.getUserId());
                    notificationEventJSONObject.put("achievementNumber", interactions);
                    notificationEventJSONObject.put("body", getBodyForNotification(rootMessage.getBody()));
                    notificationEventJSONObject.put("entryURL", entryURL);
                    notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
                    notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
                    notificationEventJSONObject.put("articleTitle", articleTitle);

                    sendNotification(user.getUserId(), notificationEventJSONObject);
                }

                if (isNotificationEmailActivaded(achievementsNotificationSetting)) {

                    Integer likes = RatingsEntryLocalServiceUtil.getEntriesCount(MBMessage.class.getName(), rootMessage.getMessageId(), 1d);
                    Integer comments = MBMessageLocalServiceUtil.getChildMessagesCount(rootMessage.getMessageId(), WorkflowConstants.STATUS_APPROVED);
                    HubspotServiceHttp.sendAchievementInteractionEmailUseCase(user.getEmailAddress(), user.getFullName(), getBodyForMails(rootMessage.getBody()), interactions, rootMessage.getCreateDate().toInstant(), likes, comments, entryURL);
                }

            }


        } catch (PortalException e) {
            _log.error("ERROR notification could not be sent " + e.getMessage());
        }


    }

    private static void sendNotification(ServiceContext serviceContext, long classPK, long userId, String title, String body, String articleTitle, String entryURL) {
        String portletId = PortletProviderUtil.getPortletId(PushNotificationsPortletKeys.PUSH_NOTIFICATIONS, PortletProvider.Action.VIEW);

        User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
        JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
        notificationEventJSONObject.put("title", title);
        notificationEventJSONObject.put("body", body);
        notificationEventJSONObject.put("userId", serviceContext.getUserId());
        notificationEventJSONObject.put("fullName", user.getFullName());
        notificationEventJSONObject.put("classPK", classPK);
        notificationEventJSONObject.put("entryURL", entryURL);
        notificationEventJSONObject.put("fromHost", serviceContext.getPortalURL());
        notificationEventJSONObject.put("portletId", serviceContext.getPortletId());
        notificationEventJSONObject.put("articleTitle", articleTitle);
        //notificationEventJSONObject.put("context", serviceContext.getAttributes().toString());

        sendNotification(userId, notificationEventJSONObject);
    }

    private static void sendNotification(long userId, JSONObject notificationEventJSONObject) {
        ServiceContext serviceContext = new ServiceContext();
        String type = notificationEventJSONObject.getString("portletId");

        try {
            UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId,
                    AvanisComunidadPortletKeys.AVANISCOMUNIDAD, // type
                    (new Date()).getTime(),
                    UserNotificationDeliveryConstants.TYPE_WEBSITE,
                    0,
                    notificationEventJSONObject.toString(),
                    false,
                    serviceContext);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getNotificationSetting(User principal, String notificationName) {
        ExpandoBridge expandoBridge = principal.getExpandoBridge();
        String notificationSetting;
        String[] notificationSettings = (String[]) expandoBridge.getAttribute(notificationName + "_notification");

        if (notificationSettings != null && notificationSettings.length > 0) {
            notificationSetting = notificationSettings[0];
        } else {
            notificationSetting = "none";
        }
        return notificationSetting;
    }

    private static Boolean isNotificationAppActivated(String notificationSetting) {
        return "all".equals(notificationSetting) || "app".equals(notificationSetting);
    }

    private static Boolean isNotificationEmailActivaded(String notificationSetting) {
        return "all".equals(notificationSetting) || "email".equals(notificationSetting);
    }

    private static String getBodyForNotification(String body) {
        if (body.length() <= MAX_CHARACTER_OF_BODY_NOTIFICATIONS) {
            return body;
        } else {
            return body.substring(0, MAX_CHARACTER_OF_BODY_NOTIFICATIONS).trim() + "...";
        }
    }

    private static String getBodyForMails(String body) {
        if (body.length() <= MAX_CHARACTER_OF_BODY_EMAIL) {
            return body;
        } else {
            return body.substring(0, MAX_CHARACTER_OF_BODY_EMAIL).trim() + "...";
        }
    }

    private static List<UserNotificationEvent> findDuplicateNotifications(long userId) {
        return UserNotificationEventLocalServiceUtil.getUserNotificationEvents(userId);
    }

    private static boolean isDuplicateNotification(UserNotificationEvent notification, long classPK, String title, String body, String articleTitle, String entryURL) throws JSONException {
        String payloadString = notification.getPayload();
        JSONObject payload = JSONFactoryUtil.createJSONObject(payloadString);

        return payload.getLong("classPK") == classPK &&
                title.equals(payload.getString("title")) &&
                body.equals(payload.getString("body")) &&
                articleTitle.equals(payload.getString("articleTitle")) &&
                entryURL.equals(payload.getString("entryURL"));
    }


    public static String getVisibility(MBMessage message) {
        ExpandoBridge expandoBridge = message.getExpandoBridge();
        String visibility;
        String[] visibilities = (String[]) expandoBridge.getAttribute("visibility");

        if (visibilities != null && visibilities.length > 0) {
            visibility = visibilities[0];
        } else {
            visibility = "registered";
        }
        return visibility;
    }

    public static void checkVisibility(String visibility, Boolean isSignedIn, User principal, MBMessage message) throws ForbiddenMessageException {
        User author = UserLocalServiceUtil.fetchUser(message.getUserId());
        if (author == null) {
            throw new ForbiddenMessageException();
        } else if (visibility.equals("registered") && !isSignedIn) {
            throw new ForbiddenMessageException();
        } else if (visibility.equals("followers") && (!isSignedIn || !checkFollow(principal, author))) {
            throw new ForbiddenMessageException();
        }
    }

    public static Boolean checkFollow(User principal, User userProfile) {
        boolean res = true;

        if (principal.getUserId() != userProfile.getUserId()) {
            SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(principal.getUserId(), userProfile.getUserId());

            if (socialFollow == null || !socialFollow.getAccepted()) {
                res = false;
            }
        }

        return res;

    }

    public static Integer countInteractions(MBMessage message) {

        Integer likes = RatingsEntryLocalServiceUtil.getEntriesCount(MBMessage.class.getName(), message.getMessageId(), 1d);
        Integer comments = MBMessageLocalServiceUtil.getChildMessagesCount(message.getMessageId(), WorkflowConstants.STATUS_APPROVED);

        return likes + comments;
    }

    //Método que por medio de una query evita el recuento de los votos por medio de bucles anidados
    // Mucho más eficiente
    public static List<AnswerResults> executeSurveyResultsQuery(long surveyId) {
        List<AnswerResults> resultsList = new ArrayList<>();
        String sql = "SELECT a.answerId, a.answer, COUNT(au.answerId) AS countAnswers, " +
                "CASE " +
                "   WHEN SUM(COUNT(au.answerId)) OVER() = 0 THEN 0 " +
                "   ELSE (COUNT(au.answerId) * 100.0 / SUM(COUNT(au.answerId)) OVER()) " +
                "END AS percentage " +
                "FROM public.avanis_comunidad_answers a " +
                "LEFT JOIN public.avanis_comunidad_answersuser au ON a.answerId = au.answerId " +
                "WHERE a.surveyId = ? " +
                "GROUP BY a.answerId, a.answer";

        try (Connection con = DataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Establecemos el parámetro de la consulta (surveyId)
            ps.setLong(1, surveyId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long answerId = rs.getLong("answerId");
                    String answer = rs.getString("answer");
                    int countAnswers = rs.getInt("countAnswers");
                    float percentage = rs.getFloat("percentage");

                    AnswerResults answerResults = new AnswerResults(answerId, answer, countAnswers, percentage);
                    resultsList.add(answerResults);
                }
            }

        } catch (SQLException e) {
            _log.error("Error al ejecutar la consulta de resultados de encuesta", e);
            throw new RuntimeException(e);
        }

        return resultsList;
    }








}
