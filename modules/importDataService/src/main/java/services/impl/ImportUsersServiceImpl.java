package services.impl;


import com.liferay.expando.kernel.model.*;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import services.ImportUserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component(service = ImportUserService.class)
public class ImportUsersServiceImpl implements ImportUserService {

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void importUsers() {
        System.out.println("***Importing users...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "users.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appUserArray = jsonObject.getJSONArray("app_user");


            for (int i = 0; i < appUserArray.length(); i++) {

                JSONObject userObject = appUserArray.getJSONObject(i);
                boolean isDeleted = userObject.getBoolean("deleted");

                if (!isDeleted && !userAlreadyExist(userObject.getString("username"))) {

                    String externalCodeReference = userObject.getString("id");
                    long creatorUserId = 20122;
                    long companyId = PortalUtil.getDefaultCompanyId();
                    boolean autoPassword = false;
                    String password1 = userObject.getString("password");

                    if (password1 == null || password1.isBlank()) {
                        password1 = userObject.getString("google_id");
                    }

                    String password2 = password1;
                    boolean autoScreenName = false;
                    String screenName = userObject.getString("alias").replace(" ", "_");
                    String emailAddress = userObject.getString("username");
                    Locale locale = LocaleUtil.getDefault();
                    String firstName = userObject.getString("name");
                    String middleName = null;
                    String lastName = userObject.getString("surnames", "_");
                    long prefixListTypeId = 0;
                    long suffixListTypeId = 0;
                    boolean male = true;
                    // Fecha irreal porque no puede ser null
                    Calendar cal = Calendar.getInstance();
                    cal.set(1600, Calendar.JANUARY, 1);
                    int birthdayMonth = cal.get(Calendar.MONTH);
                    int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
                    int birthdayYear = cal.get(Calendar.YEAR);
                    String jobTitle = null;
                    boolean sendEmail = false;

                    ServiceContext serviceContext = new ServiceContext();

                    User user = UserLocalServiceUtil.addOrUpdateUser(
                            externalCodeReference,
                            creatorUserId,
                            companyId,
                            autoPassword,
                            password1,
                            password2,
                            autoScreenName,
                            screenName,
                            emailAddress,
                            locale,
                            firstName,
                            middleName,
                            lastName,
                            prefixListTypeId,
                            suffixListTypeId,
                            male,
                            birthdayMonth,
                            birthdayDay,
                            birthdayYear,
                            jobTitle,
                            sendEmail,
                            serviceContext
                    );


                    System.out.println("***User " + screenName + " added with ID: " + user.getUserId());

                    if ("local".equals(ENVIRONMENT)) {
                        user.setAgreedToTermsOfUse(true);
                        Date date = new Date();
                        user.setLastLoginDate(date);
                        user.setModifiedDate(date);
                        user.setNew(false);
                        user.setPasswordModified(true);
                        user.setModifiedDate(date);
                        user.setPasswordReset(false);
                        UserLocalServiceUtil.updateUser(user);
                    } else if ("production".equals(ENVIRONMENT)) {

                    }

                    updatePhone(user, userObject, serviceContext);
                    updateCustomFields(user, userObject);

                }


            }

            System.out.println("***Users imported");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }


    private void updateCustomFields(User user, JSONObject userObject) throws PortalException {


        User adminUser = UserLocalServiceUtil.getUser(20122);
        PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUser);

        try {
            // Set the necessary thread locals
            PrincipalThreadLocal.setName(adminUser.getUserId());
            PermissionThreadLocal.setPermissionChecker(permissionChecker);

            ExpandoBridge expandoBridge = user.getExpandoBridge();

            expandoBridge.setAttribute("dedication_level", userObject.getString("dedication_level"));
            expandoBridge.setAttribute("province", userObject.getString("province"));
            expandoBridge.setAttribute("location", userObject.getString("location"));
            expandoBridge.setAttribute("country", userObject.getString("country"));
            expandoBridge.setAttribute("visibility", "public");
        } finally {
            // Clear the thread locals to avoid any potential issues
            PrincipalThreadLocal.setName(null);
            PermissionThreadLocal.setPermissionChecker(null);
        }


    }

    private boolean userAlreadyExist(String email) {
        boolean res = false;
        try {
            User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), email);
            res = user != null;
        } catch (PortalException ignored) {

        }

        if (res) {
            System.out.println("***User " + email + " already exist");
        }
        return res;
    }

    private void updatePhone(User user, JSONObject userObject, ServiceContext serviceContext) {
        long userId = user.getUserId();
        String className = "com.liferay.portal.kernel.model.Contact";
        long classPK = user.getContactId();
        String number = userObject.getString("phone");
        String extension = null;
        long listTypeId = 30; //Personal number
        boolean primary = true;

        try {
            if (number != null && number != "") {
                PhoneLocalServiceUtil.addPhone(
                        userId,
                        className,
                        classPK,
                        number,
                        extension,
                        listTypeId,
                        primary,
                        serviceContext
                );
            }
        } catch (PortalException e) {
            System.out.println("***Error adding phone " + number + " of user " + user.getExternalReferenceCode());
            e.printStackTrace();

        }

    }
}