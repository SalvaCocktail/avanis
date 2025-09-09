package services.impl;


import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.ratings.kernel.service.RatingsEntryLocalServiceUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import services.ImportLikesService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component(service = ImportLikesService.class)
public class ImportLikesServiceImpl implements ImportLikesService {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void importLikes() {


        System.out.println("***Importing likes...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "likes.json")) {
            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray likesArray = jsonObject.getJSONArray("likes");
            long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();

            for (int i = 0; i < likesArray.length(); i++) {
                JSONObject likeObject = likesArray.getJSONObject(i);

                User user = UserLocalServiceUtil.fetchUserByExternalReferenceCode(likeObject.getString("created_by_id"), PortalUtil.getDefaultCompanyId());
                MBMessage message = MBMessageLocalServiceUtil.fetchMBMessageByExternalReferenceCode(likeObject.getString("target_id"), groupId);

                if (user == null) {
                    System.out.println("***Error user " + likeObject.getString("created_by_id") + " does not exist.");
                } else if (message == null) {
                    System.out.println("***Error message " + likeObject.getString("target_id") + " does not exist.");
                } else {
                    long userId = user.getUserId();
                    String className = MBMessage.class.getName();
                    long classPK = message.getMessageId();
                    double score = 1d;
                    ServiceContext serviceContext = new ServiceContext();

                    RatingsEntryLocalServiceUtil.updateEntry(userId, className, classPK, score, serviceContext);

                    System.out.println("***Like to message id + " + classPK + " by user id " + userId);
                }

            }


        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }
}