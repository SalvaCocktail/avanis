package avanis.my.account.portlet.portlet;

import avanis.my.account.portlet.clients.GoogleClient;
import avanis.my.account.portlet.constants.AvanisMyAccountPortletKeys;
import avanis.my.account.portlet.utils.PasswordValidator;
import avanis.social.follow.sb.service.SocialFollowLocalServiceUtil;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import avanis.utils.api.util.AvanisUtils;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.auth.Authenticator;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.security.sso.openid.connect.persistence.model.OpenIdConnectSession;
import com.liferay.portal.security.sso.openid.connect.persistence.service.OpenIdConnectSessionLocalServiceUtil;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import javax.portlet.annotations.ServeResourceMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.*;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * @author angelperez
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                /*"com.liferay.portlet.header-portlet-css=/css/selects/select2.min.css",*/
                "com.liferay.portlet.header-portlet-javascript=/js/index.js",
                /*"com.liferay.portlet.header-portlet-javascript=/js/select2.min.js",*/
                /*"com.liferay.portlet.header-portlet-javascript=/js/jquery.min.js",*/
                /*"com.liferay.portlet.header-portlet-javascript=/js/jquery-3.6.0.min.js",*/
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AvanisMyAccount",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AvanisMyAccountPortletKeys.AVANISMYACCOUNT,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AvanisMyAccountPortlet extends MVCPortlet {

    private static Log _log = LogFactoryUtil.getLog(AvanisMyAccountPortlet.class);

    private static final String AGRICULTURE_CATEGORY_ERC = "430e1e1e-7616-44ad-a676-9ff31364353c";
    private static final String STOCKBREADING_CATEGORY_ERC = "942f8363-2b82-45ab-95c7-0a5d1a63c2e4";
    private static final String HUBSPOT_SUBSCRIPTION_ID = "318144747";

    private static final long MAX_FILE_SIZE_MB = 5 * 1024 * 1024; // 5 MB
    private static final String[] ALLOWED_EXTENSIONS = {"jpg", "jpeg", "png"};

    @Reference
    private AvanisUtils _avanisUtils;
    
    @Reference
    private HubspotService hubspotService;

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();


        loadMenuData(user, themeDisplay, renderRequest);
        loadFocusedTab(user, httpReq, renderRequest);


//        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(renderResponse);
//        httpResponse.setHeader("Content-Security-Policy", "default-src 'self'");
//        httpResponse.setHeader("X-Content-Type-Options", "nosniff");

        super.doView(renderRequest, renderResponse);
    }


    private void loadFocusedTab(User user, HttpServletRequest httpReq, PortletRequest portletRequest) {
        String focusedTab = getFocusedTab(httpReq, portletRequest);

        switch (focusedTab) {
            case "preferences":
                loadPreferences(user, portletRequest);

                break;
            case "plots":
                loadPlots(user, portletRequest);

                break;
            case "security":
                loadSecurity(user, portletRequest);
                break;
            case "account":
                loadAccount(user, portletRequest);
                break;
            case "faq":

                break;
            case "notifications":
                loadNotifications(user, portletRequest);
                break;
            default:
                loadAboutMe(user, portletRequest);

                break;

        }
    }


    private String getFocusedTab(HttpServletRequest httpReq, PortletRequest portletRequest) {
        try {
            String tab = ParamUtil.getString(portletRequest, "focusedTab");

            if (tab == null || tab.isBlank()) {
                tab = httpReq.getParameter("focusedTab");
            }
            tab = tab != null && !tab.isBlank() ? tab : "about";

            portletRequest.setAttribute("focusedTab", tab);
            return tab;
        } catch (Exception e) {
            return "about";
        }
    }

    @ServeResourceMethod(portletNames = AvanisMyAccountPortletKeys.AVANISMYACCOUNT, resourceID = "getTab")
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        String tab = httpReq.getParameter("tab");


        String checkType = ParamUtil.getString(resourceRequest, "check_type");
        String outputMsg = "";


        if (checkType != null) {
            if (checkType.equals("nombreUsuario")) {
                outputMsg = checkScreenName(resourceRequest);
                // Configura la respuesta como JSON
                JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
                jsonResponse.put("outputMsg", outputMsg);

                resourceResponse.setContentType("application/json");
                PrintWriter out = resourceResponse.getWriter();
                out.print(jsonResponse.toString());
                out.flush();


            }

        }


        try {
            switch (tab) {
                case "about":
                    loadAboutMe(user, resourceRequest);
                    include("/aboutMe.jsp", resourceRequest, resourceResponse);
                    break;
                case "preferences":
                    loadPreferences(user, resourceRequest);
                    include("/preferences.jsp", resourceRequest, resourceResponse);
                    break;
                case "plots":
                    loadPlots(user, resourceRequest);
                    include("/plots.jsp", resourceRequest, resourceResponse);
                    break;
                case "security":
                    loadSecurity(user, resourceRequest);
                    include("/security.jsp", resourceRequest, resourceResponse);
                    break;
                case "account":
                    loadAccount(user, resourceRequest);
                    include("/account.jsp", resourceRequest, resourceResponse);
                    break;
                case "faq":
                    include("/faq.jsp", resourceRequest, resourceResponse);
                    break;
                case "notifications":
                    loadNotifications(user, resourceRequest);
                    include("/notifications.jsp", resourceRequest, resourceResponse);
                    break;
                case "userData":
                    downloadUserData(user, resourceRequest, resourceResponse);
                    loadAccount(user, resourceRequest);
                    resourceRequest.setAttribute("focusedTab", "account");
                    break;


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        super.serveResource(resourceRequest, resourceResponse);
    }


    private void downloadUserData(User principal, ResourceRequest request, ResourceResponse response) {
        long userId = principal.getUserId();

        List<MBMessage> messages = getOwnMessages(userId);
        List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(principal.getUserId());
        List<AssetCategory> dedications = getGlobalCategory("user dedications");
        List<AssetCategory> categories = getUserCategories(principal);
        List<BlogsEntry> blogs = getOwnBlogs(userId);
        List<String> userAssetTags = AssetTagLocalServiceUtil.getTags(User.class.getName(), principal.getUserId()).stream().map(AssetTag::getName).map(String::toLowerCase).collect(Collectors.toList());
        List<User> followers = SocialFollowLocalServiceUtil.getFollowers(userId, null, 0, SocialFollowLocalServiceUtil.countFollowers(userId));
        List<User> followings = SocialFollowLocalServiceUtil.getFollowings(userId, null, 0, SocialFollowLocalServiceUtil.countFollowing(userId));

        response.setContentType("application/zip");
        response.setProperty("Content-Disposition", "attachment; filename=\"" + principal.getFullName().replace(" ", "_") + ".zip" + "\"");

        try (ZipOutputStream zos = new ZipOutputStream(response.getPortletOutputStream())) {

            zos.putNextEntry(new ZipEntry("personal_data/user.csv"));
            writePersonalDataToCSV(zos, principal);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("personal_data/interests.csv"));
            writeInterestsToCSV(zos, userAssetTags);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("personal_data/dedications.csv"));
            writeAssetCategoryToCSV(zos, dedications);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("personal_data/details.csv"));
            writeAssetCategoryToCSV(zos, categories);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("social/followers.csv"));
            writeSocialFollowToCSV(zos, followers);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("social/followings.csv"));
            writeSocialFollowToCSV(zos, followings);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("social/givenLikes.csv"));
            writeSocialGivenLikesToCSV(zos, userId);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("social/receivedLikes.csv"));
            writeSocialReceivedLikesToCSV(zos, userId);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("plots/plots.csv"));
            writePlotsToCSV(zos, explotaciones);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("message_boards/message_board_posts.csv"));
            writeMessageBoardPostsToCSV(zos, messages);
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("blogs/blogs.csv"));
            writeBlogPostsToCSV(zos, blogs);
            zos.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private String checkScreenName(ResourceRequest resourceRequest) {
        Long companyId = PortalUtil.getCompanyId(resourceRequest);
        String screenName = ParamUtil.getString(resourceRequest, "username");
        String currentUserScreenName = null;
        User user = null;

        try {
            // Obtén el usuario actual
            User currentUser = PortalUtil.getUser(resourceRequest);
            if (currentUser != null) {
                currentUserScreenName = currentUser.getScreenName();
            }

            // Intenta obtener el usuario por su screenName
            user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);

            // Verifica si el usuario obtenido es el mismo que el usuario actual
            if (user != null && !screenName.equals(currentUserScreenName)) {
                _log.error("ERROR, este usuario ya está registrado: " + screenName);
                return "nombre_usuario_ERROR"; // Usuario ya registrado
            } else {
                _log.info("Este usuario NO está registrado o es el usuario actual: " + screenName);
                return "nombre_usuario_OK"; // Usuario no registrado o es el usuario actual
            }
        } catch (PortalException | SystemException e) {
            _log.info("Este usuario NO está registrado: " + screenName);
            return "nombre_usuario_OK"; // Usuario no registrado
        }
    }


    private void writeSocialReceivedLikesToCSV(ZipOutputStream zos, long userId) throws IOException {
        String sql = "select m.subject, r.username, m.body  from ratingsentry r " +
                "join mbmessage m on " +
                "r.classnameid = ? and " +
                "m.userid = ? and " +
                "r.classpk = m.messageid";


        try (Connection con = DataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, PortalUtil.getClassNameId(MBMessage.class.getName()));
            ps.setLong(2, userId);

            try (ResultSet rs = ps.executeQuery()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Subject,likedBy\n");
                while (rs.next()) {
                    sb.append(rs.getString(1)).append(",");
                    sb.append(rs.getString(2)).append("\n");
                }
                zos.write(sb.toString().getBytes());
            }

        } catch (SQLException e) {
            _log.error(e);
        }


    }


    private void writeSocialGivenLikesToCSV(ZipOutputStream zos, long userId) throws IOException {
        String sql = "select m.subject, m.username, m.body  from ratingsentry r " +
                "join mbmessage m on " +
                "r.classnameid = ? and " +
                "r.userid = ? and " +
                "r.classpk = m.messageid";


        try (Connection con = DataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, PortalUtil.getClassNameId(MBMessage.class.getName()));
            ps.setLong(2, userId);

            try (ResultSet rs = ps.executeQuery()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Subject,author\n");
                while (rs.next()) {
                    sb.append(rs.getString(1)).append(",");
                    sb.append(rs.getString(2)).append("\n");
                }
                zos.write(sb.toString().getBytes());
            }

        } catch (SQLException e) {
            _log.error(e);
        }


    }

    private void writeSocialFollowToCSV(ZipOutputStream zos, List<User> users) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Name,ScreenName\n");
        for (User user : users) {
            sb.append(user.getFullName()).append(",");
            sb.append(user.getScreenName()).append("\n");
        }
        zos.write(sb.toString().getBytes());
    }

    private void writeMessageBoardPostsToCSV(ZipOutputStream zos, List<MBMessage> messageBoardMessages) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("ID,Subject,Body,CreateDate\n");
        for (MBMessage message : messageBoardMessages) {
            sb.append(message.getMessageId()).append(",");
            sb.append(message.getSubject()).append(",");
            sb.append(message.getBody()).append(",");
            sb.append(message.getCreateDate()).append("\n");
        }
        zos.write(sb.toString().getBytes());
    }

    private void writeAssetCategoryToCSV(ZipOutputStream zos, List<AssetCategory> categories) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Name\n");
        for (AssetCategory category : categories) {
            sb.append(category.getName()).append("\n");
        }
        zos.write(sb.toString().getBytes());
    }

    private void writeInterestsToCSV(ZipOutputStream zos, List<String> userAssetTags) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("InterestName\n");
        for (String interest : userAssetTags) {
            sb.append(interest).append("\n");
        }
        zos.write(sb.toString().getBytes());
    }

    private void writePlotsToCSV(ZipOutputStream zos, List<Explotacion> plots) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("ID,Name,Province,Longitude,Altitude,Latitude,Location,Size,SizeUnit,MeteoredId,isMain,AllowNotifications,CreatedDate\n");
        for (Explotacion plot : plots) {
            sb.append(plot.getExplotacionId()).append(",");
            sb.append(plot.getName()).append(",");
            sb.append(plot.getProvincia()).append(",");
            sb.append(plot.getLongitude()).append(",");
            sb.append(plot.getHeight()).append(",");
            sb.append(plot.getLatitude()).append(",");
            sb.append(plot.getLocation()).append(",");
            sb.append(plot.getSize()).append(",");
            sb.append(plot.getSizeUnit()).append(",");
            sb.append(plot.getMeteoredid()).append(",");
            sb.append(plot.getIsMain()).append(",");
            sb.append(plot.getAllowNotifications()).append(",");
            sb.append(plot.getCreateDate()).append("\n");
        }
        zos.write(sb.toString().getBytes());
    }

    private void writeBlogPostsToCSV(ZipOutputStream zos, List<BlogsEntry> blogEntries) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("ID,Title,Content,CreateDate\n");
        for (BlogsEntry entry : blogEntries) {
            sb.append(entry.getEntryId()).append(",");
            sb.append(entry.getTitle()).append(",");
            sb.append(entry.getContent()).append(",");
            sb.append(entry.getCreateDate()).append("\n");
        }
        zos.write(sb.toString().getBytes());
    }

    private void writePersonalDataToCSV(ZipOutputStream zos, User user) throws IOException {
        StringBuilder sb = new StringBuilder();
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        sb.append("ID,Name,ScreenName,Email,DedicationLevel,Location,Province,AboutMe,CreatedDate\n");

        sb.append(user.getUserId()).append(",");
        sb.append(user.getFullName()).append(",");
        sb.append(user.getScreenName()).append(",");
        sb.append(user.getEmailAddress()).append(",");
        sb.append(getDedicationLevel(expandoBridge)).append(",");
        sb.append(expandoBridge.getAttribute("location")).append(",");
        sb.append(expandoBridge.getAttribute("province")).append(",");
        sb.append(expandoBridge.getAttribute("about")).append(",");
        sb.append(user.getCreateDate()).append("\n");

        zos.write(sb.toString().getBytes());
    }

    @ProcessAction(name = "saveAboutMe")
    public void saveAboutMe(ActionRequest actionRequest, ActionResponse actionResponse)  throws PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();
        String aboutMe = _avanisUtils.sanitizeInput(ParamUtil.getString(actionRequest, "about"));
        String name = _avanisUtils.sanitizeInput(ParamUtil.getString(actionRequest, "name"));
        String lastName = _avanisUtils.sanitizeInput(ParamUtil.getString(actionRequest, "lastName"));
        String screenName = _avanisUtils.sanitizeInput(ParamUtil.getString(actionRequest, "username"));
        String dedicationLevel = ParamUtil.getString(actionRequest, "dedicationLevel");
        String[] selectedDedications = ParamUtil.getStringValues(actionRequest, "selectedDedications");
        String[] selectedAgricultureCategories = ParamUtil.getStringValues(actionRequest, "selectedAgricultureCategories");
        String[] selectedStockbreadingCategories = ParamUtil.getStringValues(actionRequest, "selectedStockbreadingCategories");

        List<AssetCategory> dedicationCategories = getGlobalCategory("user dedications");
        List<AssetCategory> agricultureCategories = getGlobalSubcategories(AGRICULTURE_CATEGORY_ERC);
        List<AssetCategory> stockbreadingCategories = getGlobalSubcategories(STOCKBREADING_CATEGORY_ERC);

        List<Long> selectedDedicationCategoryIds = new ArrayList();
        for (AssetCategory category: dedicationCategories) {
            if (IntStream.range(0, selectedDedications.length).anyMatch(i -> category.getName().equalsIgnoreCase(selectedDedications[i]))) {
                selectedDedicationCategoryIds.add(category.getCategoryId());
            }
        }
        List<Long> selectedAgricultureCategoryIds = new ArrayList();
        for (AssetCategory category: agricultureCategories) {
            if (IntStream.range(0, selectedAgricultureCategories.length).anyMatch(i -> category.getName().equalsIgnoreCase(selectedAgricultureCategories[i]))) {
                selectedAgricultureCategoryIds.add(category.getCategoryId());
            }
        }
        List<Long> selectedStockbreadingCategoryIds = new ArrayList();
        for (AssetCategory category: stockbreadingCategories) {
            if (IntStream.range(0, selectedStockbreadingCategories.length).anyMatch(i -> category.getName().equalsIgnoreCase(selectedStockbreadingCategories[i]))) {
                selectedStockbreadingCategoryIds.add(category.getCategoryId());
            }
        }

        Long[] userCategoryIds = Stream.of(
                        selectedDedicationCategoryIds,
                        selectedAgricultureCategoryIds,
                        selectedStockbreadingCategoryIds
                ).flatMap(Collection::stream)
                .collect(Collectors.toList())
                .toArray(Long[]::new);

        String location = _avanisUtils.sanitizeInput(ParamUtil.getString(actionRequest, "locationName"));
        String province = _avanisUtils.sanitizeInput(ParamUtil.getString(actionRequest, "provinceName"));
        String phone = ParamUtil.getString(actionRequest, "phone");


        if (province.equals("Seleccionar")) {
            province = "";
        }
        if (location.equals("Seleccionar")) {
            location = "";
        }

        principal.setFirstName(name);
        principal.setLastName(lastName);
        principal.setScreenName(screenName);

        UserLocalServiceUtil.updateUser(principal);

        ExpandoBridge expandoBridge = principal.getExpandoBridge();

        expandoBridge.setAttribute("dedication_level", dedicationLevel);


        expandoBridge.setAttribute("location", location);


        expandoBridge.setAttribute("province", province);


        expandoBridge.setAttribute("about", aboutMe);

        updatePhone(principal, phone);

        UserLocalServiceUtil.updateAsset(principal.getUserId(), principal, ArrayUtil.toArray(userCategoryIds), null);


        try {
            processFormAboutMe(principal.getEmailAddress(), dedicationLevel, selectedDedications, selectedDedications,
                    selectedStockbreadingCategories);

        } catch (Exception e) {
            _log.error("Error sending form to hubspot", e);

        }
        SessionMessages.add(actionRequest, "message.success.aboutme");
    }

    @ProcessAction(name = "saveNotifications")
    public void saveNotifications(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        savePlotNotificationsSettings(principal, actionRequest);
        saveNotificationSetting(principal, "comments", actionRequest);
        saveNotificationSetting(principal, "likes", actionRequest);
        saveNotificationSetting(principal, "surveys_results", actionRequest);
        saveNotificationSetting(principal, "followers", actionRequest);
        saveNotificationSetting(principal, "mentions", actionRequest);
        saveNotificationSetting(principal, "achievements", actionRequest);
        saveNotificationSetting(principal, "ayudas_nuevas", actionRequest);
        saveNotificationSetting(principal, "ayudas_porvencer", actionRequest);
        saveNotificationSetting(principal, "ayudas_reactivacion", actionRequest);

        Boolean allowNewsLetter = ParamUtil.getBoolean(actionRequest, "allowNewsLetter");

        if (allowNewsLetter) {
            hubspotService.subscribeNewsletter(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
        } else {
            hubspotService.unsubscribeNewsletter(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
        }

        SessionMessages.add(actionRequest, "message.success.notificaciones");
    }

    private void savePlotNotificationsSettings(User principal, PortletRequest portletRequest) {
        List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(principal.getUserId());

        for (Explotacion plot : explotaciones) {
            Boolean inputNotificationSetting = ParamUtil.getBoolean(portletRequest, "plot_" + plot.getExplotacionId());

            if (plot.getAllowNotifications() != inputNotificationSetting) {
                plot.setAllowNotifications(inputNotificationSetting);
                ExplotacionLocalServiceUtil.updateExplotacion(plot);
            }
        }

    }

    private void saveNotificationSetting(User principal, String notificationName, PortletRequest portletRequest) {
        ExpandoBridge expandoBridge = principal.getExpandoBridge();

        Boolean notificationMail = ParamUtil.getBoolean(portletRequest, notificationName + "_email");
        Boolean notificationApp = ParamUtil.getBoolean(portletRequest, notificationName + "_app");

        if (notificationMail && notificationApp) {
            expandoBridge.setAttribute(notificationName + "_notification", "all");
        } else if (notificationMail) {
            expandoBridge.setAttribute(notificationName + "_notification", "email");
        } else if (notificationApp) {
            expandoBridge.setAttribute(notificationName + "_notification", "app");
        } else {
            expandoBridge.setAttribute(notificationName + "_notification", "none");
        }
    }

    @ProcessAction(name = "closeSessions")
    public void closeSessions(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        //TODO: Probar bien porque no parece hacer nada
        AuthenticatedSessionManagerUtil.signOutSimultaneousLogins(principal.getUserId());

    }

    @ProcessAction(name = "uploadPortrait")
    public void uploadPortrait(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        File profilePicture = uploadRequest.getFile("portrait");
        checkFile(profilePicture, actionRequest);
        byte[] fileBytes = castFileToBytes(profilePicture);

        if (fileBytes != null) {
            UserLocalServiceUtil.updatePortrait(principal.getUserId(), fileBytes);
        }
        SessionMessages.add(actionRequest, "message.imagenperfil");
    }

    @ProcessAction(name = "unlinkGoogle")
    public void unlinkGoogle(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();


        DynamicQuery dynamicQuery = OpenIdConnectSessionLocalServiceUtil.dynamicQuery();

        dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", principal.getUserId()));

        List<OpenIdConnectSession> openIdConnects = OpenIdConnectSessionLocalServiceUtil.dynamicQuery(dynamicQuery);

        if (!openIdConnects.isEmpty()) {

            OpenIdConnectSession openIdConnect = openIdConnects.get(0);
            String token = openIdConnect.getAccessToken().split(":")[1].replace("\"", "");
            HttpResponse<String> response = GoogleClient.sendPost("/revoke?token=" + token);

            if (response != null) {
                OpenIdConnectSessionLocalServiceUtil.deleteOpenIdConnectSessions(principal.getUserId());
            } else {
                SessionErrors.add(actionRequest, "googleUnlinkError");
            }
        } else {
            SessionErrors.add(actionRequest, "googleUnlinkError");
        }


    }


    private List<MBMessage> getOwnMessages(long userId) {
        DynamicQuery dynamicQuery = MBMessageLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));

        return MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);
    }


    private List<BlogsEntry> getOwnBlogs(long userId) {
        DynamicQuery dynamicQuery = BlogsEntryLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));

        return BlogsEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
    }

    @ProcessAction(name = "updatePasswordURL")
    public void updatePassword(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        String oldPassword = ParamUtil.getString(actionRequest, "oldPass");
        String newPassword = ParamUtil.getString(actionRequest, "newPass");


        if (Authenticator.SUCCESS != UserLocalServiceUtil.authenticateByUserId(principal.getCompanyId(), principal.getUserId(), oldPassword, new HashMap<String, String[]>(), new HashMap<String, String[]>(),
                new HashMap<String, Object>())) {
            SessionErrors.add(actionRequest, "wrongCurrentPassword");
        } else if (!PasswordValidator.validate(newPassword)) {
            SessionErrors.add(actionRequest, "wrongNewPassword");
        } else {
            UserLocalServiceUtil.updatePassword(principal.getUserId(), newPassword, newPassword, false);
            ExpandoBridge expandoBridge = principal.getExpandoBridge();
            expandoBridge.setAttribute("isPasswordSet", true);
            keepLogedInAfterChangePassword(principal, newPassword, actionRequest, actionResponse);


        }


    }

    private void keepLogedInAfterChangePassword(User principal, String password, PortletRequest portletRequest, PortletResponse portletResponse) throws PortalException {
        //TODO: Después de cambiar la contraseña se deslogea el usuario y se ve todo descuadrado

        HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);

        HttpSession session = request.getSession();

        session.setAttribute(WebKeys.USER, UserLocalServiceUtil.getUserById(principal.getUserId()));
        session.setAttribute(WebKeys.USER_PASSWORD, password);
    }


    @ProcessAction(name = "createPassword")
    public void createPassword(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        String newPassword = ParamUtil.getString(actionRequest, "newPass");
        if (hasPassword(principal)) {
            SessionErrors.add(actionRequest, "hasAlreadyPassword");

        } else if (!PasswordValidator.validate(newPassword)) {
            SessionErrors.add(actionRequest, "wrongNewPassword");

        } else {
            UserLocalServiceUtil.updatePassword(principal.getUserId(), newPassword, newPassword, false);
            ExpandoBridge expandoBridge = principal.getExpandoBridge();
            expandoBridge.setAttribute("isPasswordSet", true);
            keepLogedInAfterChangePassword(principal, newPassword, actionRequest, actionResponse);

        }


    }

    private Boolean hasPassword(User user) {
        ExpandoBridge expandoBridge = user.getExpandoBridge();


        return (Boolean) expandoBridge.getAttribute("isPasswordSet");

    }

    private Boolean isGoogleLinked(User user) {

        DynamicQuery dynamicQuery = OpenIdConnectSessionLocalServiceUtil.dynamicQuery();

        dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", user.getUserId()));

        return OpenIdConnectSessionLocalServiceUtil.dynamicQueryCount(dynamicQuery) > 0;

    }


    @ProcessAction(name = "uploadBanner")
    public void uploadBanner(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        File profilePicture = uploadRequest.getFile("banner");
        checkFile(profilePicture, actionRequest);

        byte[] fileBytes = castFileToBytes(profilePicture);
        String externalReferenceCode = null;
        long userId = principal.getUserId();
        long repositoryId = themeDisplay.getScopeGroupId();
        long folderId = 0;
        String sourceFileName = profilePicture.getName();
        String mimeType = uploadRequest.getContentType("banner");
        Date expirationDate = null;
        Date reviewDate = null;

        FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                externalReferenceCode,
                userId,
                repositoryId,
                folderId,
                sourceFileName,
                mimeType,
                fileBytes,
                expirationDate,
                reviewDate,
                new ServiceContext()
        );

        ExpandoBridge expandoBridge = principal.getExpandoBridge();

        String filePreviewUrl = DLURLHelperUtil.getImagePreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay);

        expandoBridge.setAttribute("banner", filePreviewUrl);
        SessionMessages.add(actionRequest, "message.imagenbanner");

    }

    private void checkFile(File file, PortletRequest portletRequest) throws PortletException {
        if (file == null || !file.exists()) {
            SessionErrors.add(portletRequest, "fileNullError");
            throw new PortletException("file null error");
        }

        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        if (file.length() > MAX_FILE_SIZE_MB) {
            SessionErrors.add(portletRequest, "fileWrongSize");
            throw new PortletException("fileWrongSize");
        }

        Optional<String> optionalExtension = Arrays.stream(ALLOWED_EXTENSIONS).filter(allowedExtension -> allowedExtension.equals(extension)).findFirst();

        if (optionalExtension.isEmpty()) {
            SessionErrors.add(portletRequest, "wrongExtension");
            throw new PortletException("wrongExtension");
        }
    }

    private byte[] castFileToBytes(File file) {
        if (file != null && file.exists()) {
            try (InputStream inputStream = new FileInputStream(file)) {
                return inputStream.readAllBytes();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    @ProcessAction(name = "savePreferences")
    public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        String[] userOtherCategoriesIds = ParamUtil.getStringValues(actionRequest, "selectedOtherCategories");
        String[] userAgricultureCategoryIds = ParamUtil.getStringValues(actionRequest, "selectedAgricultureCategories");
        String[] userStockbreadingCategoryIds = ParamUtil.getStringValues(actionRequest, "selectedStockbreadingCategories");

        String[] userInterests = Stream.concat(
                        Stream.concat(Stream.of(userOtherCategoriesIds), Stream.of(userAgricultureCategoryIds)),
                        Stream.of(userStockbreadingCategoryIds))
                .toArray(String[]::new);

        Boolean allowNewsLetter = ParamUtil.getBoolean(actionRequest, "allowNewsLetter");
        actionRequest.setAttribute("lastUserInputAllowNewsLetter", allowNewsLetter);

        UserLocalServiceUtil.updateAsset(principal.getUserId(), principal, null, userInterests);

        if (allowNewsLetter) {
            hubspotService.subscribeNewsletter(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
        } else {
            hubspotService.unsubscribeNewsletter(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
        }
        try{
            processFormInterests(principal.getEmailAddress(), userAgricultureCategoryIds,
                    userStockbreadingCategoryIds, userOtherCategoriesIds);
            SessionMessages.add(actionRequest, "message.success.preferences");
        }catch (Exception e){
            _log.error("Error sending form to hubspot");
        }
    }

    @ProcessAction(name = "deletePlot")
    public void deletePlot(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String id = ParamUtil.getString(actionRequest, "plotId");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        _log.info("Deleting explotacion: " + id);
        ExplotacionLocalServiceUtil.deleteExplotacion(parseId(id), principal);


    }

    private void updatePhone(User user, String phone) throws PortalException {
        long userId = user.getUserId();
        String className = "com.liferay.portal.kernel.model.Contact";
        long classPK = user.getContactId();
        String number = phone;
        String extension = null;
        long listTypeId = 30; //Personal number
        boolean primary = true;
        ServiceContext serviceContext = new ServiceContext();

        if (number != null && !number.isBlank()) {
            List<Phone> phones = user.getPhones();
            if (!phones.isEmpty()) {
                Phone userPhone = phones.get(0);

                userPhone.setNumber(phone);
                userPhone.setPrimary(primary);
                userPhone.setListTypeId(listTypeId);
                userPhone.setClassPK(classPK);

                PhoneLocalServiceUtil.updatePhone(userPhone);
            } else {

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
        }


    }

    private void loadMenuData(User principal, ThemeDisplay themeDisplay, PortletRequest portletRequest) {
        portletRequest.setAttribute("user", principal);
        portletRequest.setAttribute("profileImage", getPortraitUrl(principal, themeDisplay));
        portletRequest.setAttribute("bannerImage", getBannerUrl(principal));
    }

    private String getPortraitUrl(User user, ThemeDisplay themeDisplay) {
        try {
            return user.getPortraitURL(themeDisplay);
        } catch (PortalException e) {
            _log.error(e);
            return null;
        }
    }

    private String getBannerUrl(User user) {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        return (String) expandoBridge.getAttribute("banner");
    }

    private void loadAboutMe(User principal, PortletRequest portletRequest) {


        ExpandoBridge expandoBridge = principal.getExpandoBridge();

        String province = (String) expandoBridge.getAttribute("province");
        String location = (String) expandoBridge.getAttribute("location");
        String about = (String) expandoBridge.getAttribute("about");

        List<String> userCategories = getUserCategories(principal).stream().map(AssetCategory::getName).map(String::toLowerCase).collect(Collectors.toList());

        portletRequest.setAttribute("user", principal);
        portletRequest.setAttribute("province", province);
        portletRequest.setAttribute("location", location);
        portletRequest.setAttribute("about", about);
        portletRequest.setAttribute("phone", getPhone(principal));
        portletRequest.setAttribute("dedication_level", getDedicationLevel(expandoBridge));
        portletRequest.setAttribute("dedications", getGlobalCategory("user dedications"));
        portletRequest.setAttribute("agricultureCategories", getGlobalSubcategories(AGRICULTURE_CATEGORY_ERC));
        portletRequest.setAttribute("stockbreadingCategories", getGlobalSubcategories(STOCKBREADING_CATEGORY_ERC));
        portletRequest.setAttribute("userCategories", userCategories);
    }

    public void loadPreferences(User principal, PortletRequest portletRequest) {
        List<String> userAssetTags = AssetTagLocalServiceUtil.getTags(User.class.getName(), principal.getUserId()).stream().map(AssetTag::getName).map(String::toLowerCase).collect(Collectors.toList());
        List<AssetCategory> otherCategories = getGlobalCategory("avanis").stream().filter(assetCategory -> assetCategory.getParentCategoryId() == 0).collect(Collectors.toList());
        Boolean allowNewsLetter = hubspotService.isSubscribed(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);


        portletRequest.setAttribute("agricultureCategories", getGlobalSubcategories(AGRICULTURE_CATEGORY_ERC));
        portletRequest.setAttribute("stockbreadingCategories", getGlobalSubcategories(STOCKBREADING_CATEGORY_ERC));
        portletRequest.setAttribute("otherCategories", otherCategories);
        portletRequest.setAttribute("userInterests", userAssetTags);
        portletRequest.setAttribute("allowNewsLetter", allowNewsLetter);

    }

    public void loadSecurity(User principal, PortletRequest portletRequest) {

        portletRequest.setAttribute("userEmail", principal.getEmailAddress());
        portletRequest.setAttribute("hasPassword", hasPassword(principal));
        portletRequest.setAttribute("isGoogleLinked", isGoogleLinked(principal));
        portletRequest.setAttribute("googleSignInURL", PropsUtil.get("google.login.url"));

    }

    private void loadNotifications(User principal, PortletRequest portletRequest) {
        Boolean allowNewsLetter = hubspotService.isSubscribed(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
        List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(principal.getUserId());

        portletRequest.setAttribute("plots", explotaciones);
        portletRequest.setAttribute("allowNewsLetter", allowNewsLetter);
        portletRequest.setAttribute("surveyResultsNotification", getNotificationSetting(principal, "surveys_results"));
        portletRequest.setAttribute("achievementsNotification", getNotificationSetting(principal, "achievements"));
        portletRequest.setAttribute("followersNotification", getNotificationSetting(principal, "followers"));
        portletRequest.setAttribute("mentionsNotification", getNotificationSetting(principal, "mentions"));
        portletRequest.setAttribute("commentNotification", getNotificationSetting(principal, "comments"));
        portletRequest.setAttribute("likeNotification", getNotificationSetting(principal, "likes"));
        portletRequest.setAttribute("ayudas_nuevas", getNotificationSetting(principal, "ayudas_nuevas"));
        portletRequest.setAttribute("ayudas_porvencer", getNotificationSetting(principal, "ayudas_porvencer"));
        portletRequest.setAttribute("ayudas_reactivacion", getNotificationSetting(principal, "ayudas_reactivacion"));
    }

    private String getNotificationSetting(User principal, String notificationName) {
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

    public void loadAccount(User principal, PortletRequest portletRequest) {

        portletRequest.setAttribute("fileName", principal.getFullName().replace(" ", "_") + ".zip");

    }


    private void loadPlots(User principal, PortletRequest portletRequest) {
        List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(principal.getUserId());

        portletRequest.setAttribute("plots", explotaciones);

    }

    private String getDedicationLevel(ExpandoBridge expandoBridge) {
        String[] dedicationLevels = (String[]) expandoBridge.getAttribute("dedication_level");

        if (dedicationLevels != null && dedicationLevels.length > 0) {
            return dedicationLevels[0];
        } else {
            return null;
        }

    }

    private String getPhone(User user) {
        String className = "com.liferay.portal.kernel.model.Contact";

        long classPK = user.getContactId();
        long companyId = PortalUtil.getDefaultCompanyId();
        user.getContactId();

        List<Phone> phones = PhoneLocalServiceUtil.getPhones(companyId, className, classPK);

        if (phones != null && !phones.isEmpty()) {
            return phones.get(0).getNumber();
        } else {
            return "";
        }

    }

    private List<AssetCategory> getGlobalCategory(String vocabularyName) {
        long globalGroupId = 20119;
        AssetVocabulary vocabulary = null;
        try {
            vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, vocabularyName);
            return AssetCategoryLocalServiceUtil.getVocabularyCategories(
                    vocabulary.getVocabularyId(), 0, Integer.MAX_VALUE, null
            );

        } catch (PortalException e) {
            return new ArrayList<>();
        }

    }

    private List<AssetCategory> getGlobalSubcategories(String externalReferenceCode) {

        try {
            long groupId = 20119; //Global group
            long parentCategoryId = AssetCategoryLocalServiceUtil.getAssetCategoryByExternalReferenceCode(externalReferenceCode, groupId).getCategoryId();

            return AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);


        } catch (PortalException e) {
            return new ArrayList<>();
        }

    }

    private List<AssetCategory> getUserCategories(User user) {
        AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(User.class.getName(), user.getUserId());
        if (assetEntry != null) {
            return assetEntry.getCategories();
        } else {
            return new ArrayList<>();
        }
    }

    private Long parseId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    private void processFormAboutMe(String email, String dedicationLevel, String[] selectedDedications,
                                    String[] selectedAgricultureCategories, String[] selectedStockbreadingCategories) {
        String agriculture = Arrays.stream(selectedDedications).anyMatch(i -> i.equalsIgnoreCase("agricultura"))? "SI" : "NO";
        String stockBreeding = Arrays.stream(selectedDedications).anyMatch(i -> i.equalsIgnoreCase("ganaderia")) ? "SI" : "NO";
        String transforming = Arrays.stream(selectedDedications).anyMatch(i -> i.equalsIgnoreCase("industria transformadora")) ? "SI" : "NO";
        String other = Arrays.stream(selectedDedications).anyMatch(i -> i.equalsIgnoreCase("otros sectores")) ? "SI" : "NO";
        String startups = Arrays.stream(selectedDedications).anyMatch(i -> i.equalsIgnoreCase("startups")) ? "SI" : "NO";
        String techAgrotech = Arrays.stream(selectedDedications).anyMatch(i -> i.equalsIgnoreCase("tecnología y agrotech")) ? "SI" : "NO";
        String sales = Arrays.stream(selectedDedications).anyMatch(i -> i.equalsIgnoreCase("venta de productos o servicios")) ? "SI" : "NO";
        List<String> agricultureActivity = Arrays.asList(selectedAgricultureCategories);
        List<String> stockBreedingActivity = Arrays.asList(selectedStockbreadingCategories);
        hubspotService.formAboutMe(email, dedicationLevel,agriculture,stockBreeding,sales, transforming,techAgrotech,
                startups, other,agricultureActivity,stockBreedingActivity);
    }

    private void processFormInterests(String email, String[] userOtherAgricultureCategories, String[] userOtherStockbreadingCategories,
                                      String[] userOtherCategories) {
        List<String> agricultureInterest = Arrays.asList(userOtherAgricultureCategories);
        List<String> stockBreedingInterest = Arrays.asList(userOtherStockbreadingCategories);
        List<String> otherInterest = Arrays.asList(userOtherCategories);
        hubspotService.formInterest(email, agricultureInterest,stockBreedingInterest,otherInterest);
    }
}
