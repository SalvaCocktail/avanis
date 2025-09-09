package services.impl;


import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.expando.kernel.model.*;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import services.CategoryService;
import services.ImportMessagesService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Component(service = ImportMessagesService.class)
public class ImportMessagesServiceImpl implements ImportMessagesService {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");
    @Reference
    private VocabularyService vocabularyService;
    @Reference
    private CategoryService categoryService;

    private static final String VOCABULARY_NAME = "message types";

    @Override
    public void importMessages() {
        System.out.println("***Importing messages...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "messages.json")) {


            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appPublicationsArray = jsonObject.getJSONArray("messages");
            long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();

            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId, VOCABULARY_NAME, "com.liferay.message.boards.model.MBMessage");


            for (int i = 0; i < appPublicationsArray.length(); i++) {

                JSONObject messageObject = appPublicationsArray.getJSONObject(i);
                Boolean isAResponse = messageObject.getString("answer_to") != null && messageObject.getString("answer_to") != "";


                boolean isDeleted = messageObject.getBoolean("deleted");
                if (!isDeleted && !messageAlreadyExist(messageObject.getString("id"), groupId)) {
                    if (!isAResponse) {

                        String externalCodeReference = messageObject.getString("id");
                        User author = UserLocalServiceUtil.getUserByExternalReferenceCode(messageObject.getString("author_id"), PortalUtil.getDefaultCompanyId());
                        long userId = author.getUserId();
                        String userName = author.getScreenName();
                        long categoryId = 0;
                        long threadId = 0L;
                        long parentMessageId = 0L;
                        String subject = messageObject.getString("title");
                        String body = messageObject.getString("body");
                        String format = "html"; // Formato del mensaje
                        List<ObjectValuePair<String, InputStream>> inputStreamOVPs = new ArrayList<>();
                        boolean anonymous = false;
                        double priority = 0.0;
                        boolean allowPingbacks = false;
                        ServiceContext serviceContext = new ServiceContext();

                        MBMessage message = MBMessageLocalServiceUtil.addMessage(
                                externalCodeReference,
                                userId,
                                userName,
                                groupId,
                                categoryId,
                                threadId,
                                parentMessageId,
                                subject,
                                body,
                                format,
                                inputStreamOVPs,
                                anonymous,
                                priority,
                                allowPingbacks,
                                serviceContext

                        );

                        message.setStatus(WorkflowConstants.STATUS_APPROVED);
                        message = MBMessageLocalServiceUtil.updateMBMessage(message);


                        User adminUser = UserLocalServiceUtil.getUser(20122);
                        PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUser);

                        try {
                            // Set the necessary thread locals
                            PrincipalThreadLocal.setName(adminUser.getUserId());
                            PermissionThreadLocal.setPermissionChecker(permissionChecker);

                            ExpandoBridge expandoBridge = message.getExpandoBridge();

                            expandoBridge.setAttribute("visibility", "public");
                        } finally {
                            // Clear the thread locals to avoid any potential issues
                            PrincipalThreadLocal.setName(null);
                            PermissionThreadLocal.setPermissionChecker(null);
                        }


                        updateDates(message, messageObject);
                        updateType(message, messageObject.getString("type"), vocabularyId);

                    } else {
                        //En caso de no poder sacar la query ordenada habrá que obtener el mensaje por código de referencia
                        MBMessage previousParentMessage = MBMessageLocalServiceUtil.fetchMBMessageByExternalReferenceCode(messageObject.getString("answer_to"), groupId);

                        if (previousParentMessage != null) {
                            String externalCodeReference = messageObject.getString("id");
                            User author = UserLocalServiceUtil.getUserByExternalReferenceCode(messageObject.getString("author_id"), PortalUtil.getDefaultCompanyId());
                            long userId = author.getUserId();
                            String userName = author.getScreenName();
                            long categoryId = 0;
                            long threadId = previousParentMessage.getThreadId();
                            long parentMessageId = previousParentMessage.getMessageId();
                            String subject = messageObject.getString("title");
                            String body = messageObject.getString("body");
                            String format = "html"; // Formato del mensaje
                            List<ObjectValuePair<String, InputStream>> inputStreamOVPs = new ArrayList<>();
                            boolean anonymous = false;
                            double priority = 0.0;
                            boolean allowPingbacks = false;
                            ServiceContext serviceContext = new ServiceContext();

                            MBMessage message = MBMessageLocalServiceUtil.addMessage(
                                    externalCodeReference,
                                    userId,
                                    userName,
                                    groupId,
                                    categoryId,
                                    threadId,
                                    parentMessageId,
                                    subject,
                                    body,
                                    format,
                                    inputStreamOVPs,
                                    anonymous,
                                    priority,
                                    allowPingbacks,
                                    serviceContext

                            );

                            message.setStatus(WorkflowConstants.STATUS_APPROVED);
                            message = MBMessageLocalServiceUtil.updateMBMessage(message);

                            System.out.println("***Message " + subject + " added with ID: " + message.getMessageId());

                            updateDates(message, messageObject);
                            updateType(message, messageObject.getString("type"), vocabularyId);
                        }
                    }

                }
            }


            System.out.println("***Messages imported");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void updateTypes() {
        System.out.println("***Updating message types...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "messages.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray messagesArray = jsonObject.getJSONArray("messages");
            long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();

            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId, VOCABULARY_NAME, "com.liferay.message.boards.model.MBMessage");


            for (int i = 0; i < messagesArray.length(); i++) {

                JSONObject messageObject = messagesArray.getJSONObject(i);
                boolean isDeleted = messageObject.getBoolean("deleted");
                if (!isDeleted) {
                    MBMessage message = MBMessageLocalServiceUtil.getMBMessageByExternalReferenceCode(messageObject.getString("id"), groupId);
                    updateType(message, messageObject.getString("type"), vocabularyId);
                }
            }

            System.out.println("***Message types updated");


        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }

    }

    private void updateType(MBMessage message, String type, long vocabularyId) throws PortalException {
        AssetCategory category = categoryService.getCategoryByLabel(type, vocabularyId);
        if (category != null) {
            long[] categoryIds = categoryService.addCategory(MBMessage.class.getName(), message.getMessageId(), category.getCategoryId());

            MBMessageLocalServiceUtil.updateAsset(message.getUserId(), message, categoryIds, null, null);
            System.out.println("***Message " + message.getExternalReferenceCode() + " associated with category " + type);
        } else {
            System.out.println("***Category " + type + " not found");
        }
    }


    private static Calendar convertStringToCalendar(String externalReferenceCode, String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            return calendar;
        } catch (ParseException e) {
            System.out.println("***Fail parsing date of message: " + externalReferenceCode);
            return null;
        }
    }

    private void updateDates(MBMessage message, JSONObject messageObject) {
        Calendar createdDate = convertStringToCalendar(message.getExternalReferenceCode(), messageObject.getString("date_created"));
        Calendar updateDate = convertStringToCalendar(message.getExternalReferenceCode(), messageObject.getString("last_updated"));
        if (createdDate != null) {
            message.setCreateDate(createdDate.getTime());
        }

        if (updateDate != null) {
            message.setModifiedDate(updateDate.getTime());
        }
        if (updateDate != null || createdDate != null) {
            MBMessageLocalServiceUtil.updateMBMessage(message);
        }
    }


    private boolean messageAlreadyExist(String externalRegerenceCode, long groupId) {
        boolean res = false;
        try {
            MBMessage message = MBMessageLocalServiceUtil.getMBMessageByExternalReferenceCode(externalRegerenceCode, groupId);
            res = message != null;
        } catch (PortalException ignored) {

        }

        if (res) {
            System.out.println("***Message " + externalRegerenceCode + " already exist");
        }
        return res;
    }

}