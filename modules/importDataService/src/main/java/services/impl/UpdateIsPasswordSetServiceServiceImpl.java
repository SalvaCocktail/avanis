package services.impl;


import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import services.UpdateIsPasswordSetService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component(service = UpdateIsPasswordSetService.class)
public class UpdateIsPasswordSetServiceServiceImpl implements UpdateIsPasswordSetService {

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void updateIsPasswordSet() {
        System.out.println("***Updating password is set...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "users.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appUserArray = jsonObject.getJSONArray("app_user");


            for (int i = 0; i < appUserArray.length(); i++) {

                JSONObject userObject = appUserArray.getJSONObject(i);
                boolean isDeleted = userObject.getBoolean("deleted");


                if (!isDeleted) {
                    String password = userObject.getString("password");
                    String email = userObject.getString("username");
                    if (password != null && !password.isBlank()) {
                        User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), email);

                        updateIsPasswordSet(user);

                    } else {
                        System.out.println("*** User " + email + " has no password");
                    }

                }
            }

            System.out.println("***Users updated");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }


    private void updateIsPasswordSet(User user) throws PortalException {


        User adminUser = UserLocalServiceUtil.getUser(20122);
        PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUser);

        try {
            // Set the necessary thread locals
            PrincipalThreadLocal.setName(adminUser.getUserId());
            PermissionThreadLocal.setPermissionChecker(permissionChecker);

            ExpandoBridge expandoBridge = user.getExpandoBridge();

            expandoBridge.setAttribute("isPasswordSet", true);

            System.out.println("*** User " + user.getEmailAddress() + " updated with password");

        } finally {
            // Clear the thread locals to avoid any potential issues
            PrincipalThreadLocal.setName(null);
            PermissionThreadLocal.setPermissionChecker(null);
        }


    }


}