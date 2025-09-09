package services.impl;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.expando.kernel.model.*;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
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
import com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import services.ImportPublicationsService;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Component(service = ImportPublicationsService.class)
public class ImportPublicationsServiceImpl implements ImportPublicationsService {

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void importPublications() {
        System.out.println("***Importing publications...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "publications.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appPublicationsArray = jsonObject.getJSONArray("gorm_publication");
            long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();


            for (int i = 0; i < appPublicationsArray.length(); i++) {

                JSONObject publicationObject = appPublicationsArray.getJSONObject(i);
                boolean isDeleted = publicationObject.getBoolean("deleted");

                if (!isDeleted && !publicationAlreadyExists(publicationObject.getString("id"), groupId)) {

                    long userId = UserLocalServiceUtil.getUserByExternalReferenceCode(publicationObject.getString("author_id"), PortalUtil.getDefaultCompanyId()).getUserId();
                    String externalReferenceCode = publicationObject.getString("id");
                    String title = publicationObject.getString("title");
                    String subtitle = publicationObject.getString("subtitle");
                    String urlTitle = publicationObject.getString("slug");
                    String description = null;
                    String content = publicationObject.getString("body");

                    Calendar calendar = convertStringToCalendar(publicationObject.getString("publication_date") != null && publicationObject.getString("publication_date") != "" ?
                            publicationObject.getString("publication_date") :
                            publicationObject.getString("date_created"));

                    int displayDateMonth = calendar.get(Calendar.MONTH); // (Start in 0)
                    int displayDateDay = calendar.get(Calendar.DAY_OF_MONTH);
                    int displayDateYear = calendar.get(Calendar.YEAR);
                    int displayDateHour = calendar.get(Calendar.HOUR_OF_DAY);
                    int displayDateMinute = calendar.get(Calendar.MINUTE);
                    boolean allowPingbacks = true;
                    boolean allowTrackbacks = true;
                    String[] trackbacks = null;
                    String coverImageCaption = null;
                    //TODO: new ImageSelection (url) esperar a aclarar como vamos a guardar los vídeos e imágenes
                    ImageSelector coverImageImageSelector = null;
                    ImageSelector smallImageImageSelector = null;
                    //TODO: Añadir resto de campos de SEO

                    ServiceContext serviceContext = new ServiceContext();
                    serviceContext.setScopeGroupId(groupId);


                    BlogsEntry blog = BlogsEntryLocalServiceUtil.addEntry(
                            externalReferenceCode,
                            userId,
                            title,
                            subtitle,
                            urlTitle,
                            description,
                            content,
                            displayDateMonth,
                            displayDateDay,
                            displayDateYear,
                            displayDateHour,
                            displayDateMinute,
                            allowPingbacks,
                            allowTrackbacks,
                            trackbacks,
                            coverImageCaption,
                            coverImageImageSelector,
                            smallImageImageSelector,
                            serviceContext);


                    User adminUser = UserLocalServiceUtil.getUser(20122);
                    PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUser);

                    try {
                        // Set the necessary thread locals
                        PrincipalThreadLocal.setName(adminUser.getUserId());
                        PermissionThreadLocal.setPermissionChecker(permissionChecker);

                        ExpandoBridge expandoBridge = blog.getExpandoBridge();

                        expandoBridge.setAttribute("visibility", "public");
                    } finally {
                        // Clear the thread locals to avoid any potential issues
                        PrincipalThreadLocal.setName(null);
                        PermissionThreadLocal.setPermissionChecker(null);
                    }

                    System.out.println("***Publication " + title + " added with ID: " + blog.getEntryId());

                    boolean isDraft = !publicationObject.getBoolean("published") &&
                            (publicationObject.getString("publication_date") == null || publicationObject.getString("publication_date") == "");

                    if (isDraft) {
                        Map<String, Serializable> workflowContext = new HashMap<>();
                        BlogsEntryLocalServiceUtil.updateStatus(20122, blog.getEntryId(), WorkflowConstants.STATUS_DRAFT, serviceContext, workflowContext);
                    }

                }
            }


            System.out.println("***Publications imported");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }


    private static Calendar convertStringToCalendar(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = sdf.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    private boolean publicationAlreadyExists(String externalRegerenceCode, long groupId) {
        boolean res = false;
        try {
            BlogsEntry blog = BlogsEntryLocalServiceUtil.getBlogsEntryByExternalReferenceCode(externalRegerenceCode, groupId);
            res = blog != null;
        } catch (PortalException ignored) {

        }

        if (res) {
            System.out.println("***Publication " + externalRegerenceCode + " already exist");
        }
        return res;
    }


}