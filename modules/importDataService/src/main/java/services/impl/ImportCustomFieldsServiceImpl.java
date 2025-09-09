package services.impl;


import com.liferay.blogs.model.BlogsEntry;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.expando.kernel.model.*;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
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
import services.ImportCustomFieldsService;
import services.ImportUserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component(service = ImportCustomFieldsService.class)
public class ImportCustomFieldsServiceImpl implements ImportCustomFieldsService {


    private static final String[] ACTION_IDS = {"VIEW"};
    private static final long COMPANY_ID = PortalUtil.getDefaultCompanyId();
    private static final long GUEST_ROLE_ID;

    static {
        try {
            GUEST_ROLE_ID = RoleLocalServiceUtil.getRole(COMPANY_ID, RoleConstants.GUEST).getRoleId();
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void importCustomFields() {
        System.out.println("***Creating custom fields...");

        String expandoTableClass = User.class.getName();
        try {
            System.out.println("***Creating users custom fields...");
            ExpandoTable expandoTable = getExpandoTable(expandoTableClass);


            createIntegerExpandoColumn(expandoTable, "last_followers_notification", 0, null);

            createDropdownExpandoColumn(expandoTable, "achievements_notification", new String[]{"none", "email", "app", "all"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createDropdownExpandoColumn(expandoTable, "followers_notification", new String[]{"none", "email", "app", "all"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createDropdownExpandoColumn(expandoTable, "surveys_results_notification", new String[]{"none", "email", "app", "all"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createDropdownExpandoColumn(expandoTable, "mentions_notification", new String[]{"none", "email", "app", "all"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createDropdownExpandoColumn(expandoTable, "comments_notification", new String[]{"none", "email", "app", "all"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createDropdownExpandoColumn(expandoTable, "likes_notification", new String[]{"none", "email", "app", "all"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");


            createDropdownExpandoColumn(expandoTable, "dedication_level", new String[]{"amateur", "professional"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");


            createDropdownExpandoColumn(expandoTable, "visibility", new String[]{"public", "registered", "followers"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createBooleanExpandoColumn(expandoTable, "isPasswordSet", "false", "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createStringExpandoColumn(expandoTable, "banner", null, null);
            createStringExpandoColumn(expandoTable, "province", null, null);
            createStringExpandoColumn(expandoTable, "location", null, null);
            createStringExpandoColumn(expandoTable, "country", null, null);
            createStringExpandoColumn(expandoTable, "about", null, "display-type=text-box\n" +
                    "height=150\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field=false\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n" +
                    "width=0");

            System.out.println("***Users custom fields created");

        } catch (PortalException e) {
            System.out.println("***Error with expando table " + expandoTableClass);
        }

        expandoTableClass = BlogsEntry.class.getName();
        try {

            System.out.println("***Creating publications custom fields...");
            ExpandoTable expandoTable = getExpandoTable(expandoTableClass);

            createDropdownExpandoColumn(expandoTable, "visibility", new String[]{"public", "registered", "followers"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createIntegerExpandoColumn(expandoTable, "shared", 0, null);
            createStringExpandoColumn(expandoTable, "source", null, null);

            System.out.println("***Publications custom fields created");

        } catch (PortalException e) {
            System.out.println("***Error with expando table " + expandoTableClass);
        }


        expandoTableClass = MBMessage.class.getName();
        try {

            System.out.println("***Creating message custom fields...");
            ExpandoTable expandoTable = getExpandoTable(expandoTableClass);

            createIntegerExpandoColumn(expandoTable, "last_interactions_notification", 0, null);

            createDropdownExpandoColumn(expandoTable, "visibility", new String[]{"public", "registered", "followers"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createIntegerExpandoColumn(expandoTable, "shared", 0, null);

            System.out.println("***Publications message fields created");

        } catch (PortalException e) {
            System.out.println("***Error with expando table " + expandoTableClass);
        }

        expandoTableClass = CalendarBooking.class.getName();
        try {

            System.out.println("***Creating event custom fields...");
            ExpandoTable expandoTable = getExpandoTable(expandoTableClass);

            createStringExpandoColumn(expandoTable, "event_website", null, null);
            createStringExpandoColumn(expandoTable, "event_image_url", null, null);
            createStringExpandoColumn(expandoTable, "event_organizer", null, null);
            createStringExpandoColumn(expandoTable, "event_url", null, null);

            createDropdownExpandoColumn(expandoTable, "event_type", new String[]{"all", "exhibition", "webinar", "training", "congress", "fair"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createDropdownExpandoColumn(expandoTable, "event_modality", new String[]{"all", "online", "person", "hybrid"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");

            createDropdownExpandoColumn(expandoTable, "event_value", new String[]{"undefined", "free", "paid", "past"}, "display-type=selection-list\n" +
                    "hidden=false\n" +
                    "index-type=2\n" +
                    "localize-field-name=true\n" +
                    "visible-with-update-permission=false\n");


            System.out.println("***Event custom fields created");

        } catch (PortalException e) {
            System.out.println("***Error with expando table " + expandoTableClass);
        }


        expandoTableClass = MBThread.class.getName();
        try {

            System.out.println("***Creating MbThread custom fields...");
            ExpandoTable expandoTable = getExpandoTable(expandoTableClass);

            createStringExpandoColumn(expandoTable, "resourceClassAndId", null, null);

            System.out.println("***MbThread  fields created");

        } catch (PortalException e) {
            System.out.println("***Error with expando table " + expandoTableClass);
        }


        System.out.println("***Custom fields created");


    }


    private ExpandoTable getExpandoTable(String className) throws PortalException {
        ExpandoTable expandoTable = null;
        try {
            expandoTable = ExpandoTableLocalServiceUtil.getTable(COMPANY_ID, className, ExpandoTableConstants.DEFAULT_TABLE_NAME);
        } catch (PortalException e) {
            expandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(COMPANY_ID, className);
        }
        return expandoTable;
    }

    private void createBooleanExpandoColumn(ExpandoTable expandoTable, String name, String defaultData, String settings) {
        try {
            ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), name, ExpandoColumnConstants.BOOLEAN);
            if (defaultData != null) {
                expandoColumn.setDefaultData("defaultData");
            }
            ExpandoColumnLocalServiceUtil.updateExpandoColumn(expandoColumn);
            if (settings != null) {
                ExpandoColumnLocalServiceUtil.updateTypeSettings(expandoColumn.getColumnId(), settings);
            }

            ResourcePermissionLocalServiceUtil.setResourcePermissions(
                    COMPANY_ID,
                    ExpandoColumn.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(expandoColumn.getColumnId()),
                    GUEST_ROLE_ID,
                    ACTION_IDS
            );

        } catch (PortalException e) {
            System.out.println("***Error with expando column " + name + " in expando table " + expandoTable.getClassName());
        }

    }

    private void createDropdownExpandoColumn(ExpandoTable expandoTable, String name, String[] dropdownOptions, String settings) {
        try {
            ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), name, ExpandoColumnConstants.STRING_ARRAY);

            expandoColumn.setDefaultData(String.join(",", dropdownOptions));

            ExpandoColumnLocalServiceUtil.updateExpandoColumn(expandoColumn);
            if (settings != null) {
                ExpandoColumnLocalServiceUtil.updateTypeSettings(expandoColumn.getColumnId(), settings);
            }

            ResourcePermissionLocalServiceUtil.setResourcePermissions(
                    COMPANY_ID,
                    ExpandoColumn.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(expandoColumn.getColumnId()),
                    GUEST_ROLE_ID,
                    ACTION_IDS
            );

        } catch (PortalException e) {
            System.out.println("***Error with expando column " + name + " in expando table " + expandoTable.getClassName());
        }

    }

    private void createStringExpandoColumn(ExpandoTable expandoTable, String name, String defaultData, String settings) {
        try {
            ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), name, ExpandoColumnConstants.STRING);
            if (defaultData != null) {
                expandoColumn.setDefaultData("defaultData");
            }
            ExpandoColumnLocalServiceUtil.updateExpandoColumn(expandoColumn);
            if (settings != null) {
                ExpandoColumnLocalServiceUtil.updateTypeSettings(expandoColumn.getColumnId(), settings);
            }

            ResourcePermissionLocalServiceUtil.setResourcePermissions(
                    COMPANY_ID,
                    ExpandoColumn.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(expandoColumn.getColumnId()),
                    GUEST_ROLE_ID,
                    ACTION_IDS
            );

        } catch (PortalException e) {
            System.out.println("***Error with expando column " + name + " in expando table " + expandoTable.getClassName());
        }


    }


    private void createIntegerExpandoColumn(ExpandoTable expandoTable, String name, Integer defaultData, String settings) {
        try {
            ExpandoColumn expandoColumn;
            if (defaultData != null) {
                expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), name, ExpandoColumnConstants.INTEGER, 0);
            } else {
                expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), name, ExpandoColumnConstants.INTEGER);
            }
            ExpandoColumnLocalServiceUtil.updateExpandoColumn(expandoColumn);
            if (settings != null) {
                ExpandoColumnLocalServiceUtil.updateTypeSettings(expandoColumn.getColumnId(), settings);
            }

            ResourcePermissionLocalServiceUtil.setResourcePermissions(
                    COMPANY_ID,
                    ExpandoColumn.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(expandoColumn.getColumnId()),
                    GUEST_ROLE_ID,
                    ACTION_IDS
            );

        } catch (PortalException e) {
            System.out.println("***Error with expando column " + name + " in expando table " + expandoTable.getClassName());
        }

    }


    private void createLongExpandoColumn(ExpandoTable expandoTable, String name, Long defaultData, String settings) {
        try {
            ExpandoColumn expandoColumn;
            if (defaultData != null) {
                expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), name, ExpandoColumnConstants.LONG, 0L);
            } else {
                expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), name, ExpandoColumnConstants.LONG);
            }
            ExpandoColumnLocalServiceUtil.updateExpandoColumn(expandoColumn);
            if (settings != null) {
                ExpandoColumnLocalServiceUtil.updateTypeSettings(expandoColumn.getColumnId(), settings);
            }

            ResourcePermissionLocalServiceUtil.setResourcePermissions(
                    COMPANY_ID,
                    ExpandoColumn.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(expandoColumn.getColumnId()),
                    GUEST_ROLE_ID,
                    ACTION_IDS
            );

        } catch (PortalException e) {
            System.out.println("***Error with expando column " + name + " in expando table " + expandoTable.getClassName());
        }

    }


}