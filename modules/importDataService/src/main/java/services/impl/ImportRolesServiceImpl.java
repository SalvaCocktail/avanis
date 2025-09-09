package services.impl;


import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import services.ImportRolesService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(service = ImportRolesService.class)
public class ImportRolesServiceImpl implements ImportRolesService {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void importRoles() {
        System.out.println("***Importing roles...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "roles.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appUserArray = jsonObject.getJSONArray("authority");


            for (int i = 0; i < appUserArray.length(); i++) {

                JSONObject rolObject = appUserArray.getJSONObject(i);
                String authority = rolObject.getString("authority");

                if (!rolAlreadyExist(authority) && !isUserRol(authority)) {

                    long userId = 20122;
                    String className = null;
                    long classPK = 0;
                    String name = authority;
                    Locale defaultLocale = LocaleUtil.getDefault();
                    Map<Locale, String> titleMap = new HashMap<>();
                    titleMap.put(defaultLocale, rolObject.getString("authority"));
                    Map<Locale, String> descriptionMap = new HashMap<>();
                    descriptionMap.put(defaultLocale, rolObject.getString("description"));
                    int roleType = RoleConstants.TYPE_REGULAR;
                    String subtype = null;
                    ServiceContext serviceContext = new ServiceContext();

                    Role role = RoleLocalServiceUtil.addRole(
                            userId,
                            className,
                            classPK,
                            name,
                            titleMap,
                            descriptionMap,
                            roleType,
                            subtype,
                            serviceContext);

                    System.out.println("***Role " + authority + " added with ID: " + role.getRoleId());

                    assignPermissions(role, rolObject.getJSONArray("resourcePermissions"));

                } else if (isUserRol(authority)) {
                    Role role = RoleLocalServiceUtil.fetchRole(PortalUtil.getDefaultCompanyId(), "User");
                    assignObjectPermissions(role, rolObject.getJSONArray("objectPermissions"));
                }


            }

            System.out.println("***Roles imported");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }

    private void assignObjectPermissions(Role role, JSONArray permissions) {
        if (permissions != null) {
            for (int i = 0; i < permissions.length(); i++) {

                JSONObject permissionObject = permissions.getJSONObject(i);
                JSONArray actionsArray = permissionObject.getJSONArray("actions");
                try {

                    long companyId = PortalUtil.getDefaultCompanyId();
                    String resourcePermissionName = "com.liferay.object#" + ObjectDefinitionLocalServiceUtil.getObjectDefinitionByExternalReferenceCode(permissionObject.getString("externalReferenceCode"), companyId).getObjectDefinitionId();
                    int scope = ResourceConstants.SCOPE_COMPANY;
                    String primKey = String.valueOf(companyId);
                    long roleId = role.getRoleId();
                    String[] actionIds = new String[actionsArray.length()];
                    for (int j = 0; j < actionsArray.length(); j++) {
                        actionIds[j] = actionsArray.getString(j);
                    }


                    ResourcePermissionLocalServiceUtil.setResourcePermissions(
                            companyId,
                            resourcePermissionName,
                            scope,
                            primKey,
                            roleId,
                            actionIds
                    );

                    System.out.println("***Permissions of  " + resourcePermissionName + " added to rol: " + role.getName());
                } catch (PortalException e) {
                    System.out.println("***Error assigning permission " + permissionObject.getString("externalReferenceCode") + " to rol " + role.getName());
                    e.printStackTrace();
                }

            }
        }
    }

    public void setPermissions() {
        System.out.println("***Setting permissions");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "roles.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appUserArray = jsonObject.getJSONArray("authority");


            for (int i = 0; i < appUserArray.length(); i++) {


                JSONObject rolObject = appUserArray.getJSONObject(i);
                String authority = rolObject.getString("authority");
                Role role = RoleLocalServiceUtil.fetchRole(PortalUtil.getDefaultCompanyId(), authority);

                assignPermissions(role, rolObject.getJSONArray("resourcePermissions"));

            }

            System.out.println("***Permissions set");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }


    private void assignPermissions(Role role, JSONArray permissions) {
        if (permissions != null) {
            for (int i = 0; i < permissions.length(); i++) {

                JSONObject permissionObject = permissions.getJSONObject(i);
                JSONArray actionsArray = permissionObject.getJSONArray("actions");

                long companyId = PortalUtil.getDefaultCompanyId();
                String resourcePermissionName = permissionObject.getString("resourceName"); //"com.liferay.blogs.model.BlogsEntry"
                int scope = ResourceConstants.SCOPE_COMPANY;
                String primKey = String.valueOf(companyId); // Según el scope se aplica el ID (como el scope es de compañía se aplica el compañía si fuera individual se aplicaría el del rescurso)
                long roleId = role.getRoleId();
                String[] actionIds = new String[actionsArray.length()];
                for (int j = 0; j < actionsArray.length(); j++) {
                    actionIds[j] = actionsArray.getString(j);
                }


                try {
                    ResourcePermissionLocalServiceUtil.setResourcePermissions(
                            companyId,
                            resourcePermissionName,
                            scope,
                            primKey,
                            roleId,
                            actionIds
                    );

                    System.out.println("***Permissions of  " + resourcePermissionName + " added to rol: " + role.getName());
                } catch (PortalException e) {
                    System.out.println("***Error assigning permission " + resourcePermissionName + " to rol " + role.getName());
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void assignRolesToUsers() {
        System.out.println("***Assigning roles to users...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "user_roles.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray rolesUserArray = jsonObject.getJSONArray("user_roles");

            for (int i = 0; i < rolesUserArray.length(); i++) {

                JSONObject userRolObject = rolesUserArray.getJSONObject(i);
                String authority = getFinalAuthority(userRolObject.getString("authority"));

                if (!isUserRol(authority)) {

                    User user = UserLocalServiceUtil.fetchUserByExternalReferenceCode(userRolObject.getString("id"), PortalUtil.getDefaultCompanyId());
                    Role role = RoleLocalServiceUtil.fetchRole(PortalUtil.getDefaultCompanyId(), authority);

                    if (user == null) {
                        System.out.println("***User " + userRolObject.getString("id") + " does not exist");
                    } else if (role == null) {
                        System.out.println("***Role " + userRolObject.getString("authority") + " does not exist");
                    } else {
                        UserLocalServiceUtil.addRoleUser(role.getRoleId(), user.getUserId());
                        System.out.println("***Role " + userRolObject.getString("authority") + " added to user with ID: " + user.getUserId());
                    }
                }

            }


            System.out.println("***Roles assigned");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isUserRol(String authority) {
        return authority.equals("ROLE_USER") || authority.equals("User");
    }

    private String getFinalAuthority(String authority) {
        String res = authority;
        if (authority.equals("ROLE_SUPER_ADMIN")) {
            res = "Administrator";
        }

        return res;
    }

    private boolean rolAlreadyExist(String rolName) {
        boolean res = false;

        try {
            Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), rolName);
            res = role != null;
        } catch (PortalException ignored) {

        }

        if (res) {
            System.out.println("***Role " + rolName + " already exist");
        }

        return res;
    }

}
