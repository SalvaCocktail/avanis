package services.impl;


import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import services.ImportUserImagesService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


@Component(service = ImportUserImagesService.class)
public class ImportUserImagesServiceImpl implements ImportUserImagesService {

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    private final static long GROUP_ID = 20117;
    private final static long FOLDER_ID = 169734;


    @Override
    public void importUserImages() {

        System.out.println("***Importing portraits...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "users.json")) {
            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appUserArray = jsonObject.getJSONArray("app_user");

            for (int i = 0; i < appUserArray.length(); i++) {

                JSONObject userObject = appUserArray.getJSONObject(i);
                String email = userObject.getString("username");
                String photoUrl = userObject.getString("photo_url");



                User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), email);
                String fileName = getFileName(photoUrl);

                if (user == null) {
                    System.out.println("***ERROR user " + email + " does not exist.");
                } else if (fileName == null) {
                    System.out.println("***ERROR user " + email + " has no image.");
                } else {
                    DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchFileEntry(GROUP_ID, FOLDER_ID, fileName);
                    UserLocalServiceUtil.updatePortrait(user.getUserId(), fileEntry.getContentStream().readAllBytes());
                    System.out.println("***Updated user " + email + " with  image " + fileName);
                }


            }
            System.out.println("Portraits imported");
        } catch (SystemException | IOException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }


    }


    private String getFileName(String url) {
        if (url == null || url.isBlank()) {
            return null;
        } else {
            String res = "";
            String[] splitedUrl = url.split("/");

            res = splitedUrl[splitedUrl.length - 1];

            return res;
        }
    }
}