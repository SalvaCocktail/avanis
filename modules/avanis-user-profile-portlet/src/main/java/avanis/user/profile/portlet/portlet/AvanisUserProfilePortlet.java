package avanis.user.profile.portlet.portlet;

import avanis.comunidad.portlet.util.AvanisComunidadUtil;
import avanis.eventos.follow.sb.model.EventFollow;
import avanis.eventos.follow.sb.service.EventFollowLocalServiceUtil;
import avanis.social.follow.sb.model.SocialFollow;
import avanis.social.follow.sb.service.SocialFollowLocalService;
import avanis.social.follow.sb.service.SocialFollowLocalServiceUtil;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import avanis.tu.explotacion.sb.service.persistence.ExplotacionPersistence;
import avanis.user.profile.portlet.constants.AvanisUserProfilePortletKeys;

import avanis.user.profile.portlet.exceptions.ForbiddenProfileException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalService;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.portlet.annotations.ServeResourceMethod;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author angelperez
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AvanisUserProfile",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AvanisUserProfilePortletKeys.AVANISUSERPROFILE,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AvanisUserProfilePortlet extends MVCPortlet {

    @Reference
    private MBMessageLocalService mbMessageLocalService;
    @Reference
    private AssetCategoryLocalService assetCategoryLocalService;
    @Reference
    private UserLocalService userLocalService;
    @Reference
    private ExplotacionPersistence explotacionPersistence;

    private Long expandoColumnVisibilityId;
    private Long expandoTableMessageId;
    private Long messageClassId;
    private static final String FOLLOWED_STATE = "followed";
    private static final String FOLLOW_REQUESTED_STATE = "requested";

    private static final Integer FOLLOWERS_PER_PAGE = 50;

    private static final long MAX_FILE_SIZE_MB = 5 * 1024 * 1024; // 5 MB
    private static final String[] ALLOWED_EXTENSIONS = {"jpg", "jpeg", "png"};

    private static Log _log = LogFactoryUtil.getLog(AvanisUserProfilePortlet.class);

    private static final String VISIBILITY_CUSTOM_FIELD_NAME = "visibility";

    private Long getExpandoColumnVisibilityId() {
        if (expandoColumnVisibilityId != null) {
            return expandoColumnVisibilityId;
        } else {
            try {
                DynamicQuery dynamicQuery = ExpandoColumnLocalServiceUtil.dynamicQuery();
                dynamicQuery.add(RestrictionsFactoryUtil.eq("tableId", this.getExpandoTableMessageId()));
                dynamicQuery.add(RestrictionsFactoryUtil.eq("name", VISIBILITY_CUSTOM_FIELD_NAME));

                List<ExpandoColumn> expandoColumns = ExpandoColumnLocalServiceUtil.dynamicQuery(dynamicQuery);

                this.expandoColumnVisibilityId = expandoColumns.get(0).getColumnId();
                return this.expandoColumnVisibilityId;
            } catch (Exception e) {
                _log.error("Error getting expando column of message " + e.getMessage());
                return 0L;
            }
        }
    }

    private Long getExpandoTableMessageId() {
        if (expandoTableMessageId != null) {
            return expandoTableMessageId;
        } else {
            try {
                DynamicQuery dynamicQuery = ExpandoTableLocalServiceUtil.dynamicQuery();
                dynamicQuery.add(RestrictionsFactoryUtil.eq("classNameId", this.getMessageClassId()));

                List<ExpandoTable> expandoTables = ExpandoTableLocalServiceUtil.dynamicQuery(dynamicQuery);

                this.expandoTableMessageId = expandoTables.get(0).getTableId();
                return this.expandoTableMessageId;
            } catch (Exception e) {
                _log.error("Error getting expando table of message " + e.getMessage());
                return 0L;
            }
        }
    }

    private Long getMessageClassId() {
        if (messageClassId != null) {
            return messageClassId;
        } else {
            this.messageClassId = PortalUtil.getClassNameId(MBMessage.class.getName());
            return this.messageClassId;
        }
    }


    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            User user = getUserOrPrincipal(httpReq, themeDisplay, renderRequest);

            loadProfile(user, renderRequest, themeDisplay);
            loadFocusedTab(user, themeDisplay, httpReq, renderRequest);

        } catch (ForbiddenProfileException exception) {
            String idParam = getUserIdParam(httpReq, renderRequest);
            User user = userLocalService.fetchUser(parseId(idParam));
            loadProfile(user, renderRequest, themeDisplay);
        }

        super.doView(renderRequest, renderResponse);
    }

    private void loadFocusedTab(User user, ThemeDisplay themeDisplay, HttpServletRequest httpReq, PortletRequest portletRequest) {
        String focusedTab = getFocusedTab(httpReq, portletRequest);

        switch (focusedTab) {
            case "followers":
                loadFollowers(user, themeDisplay, portletRequest);
                break;
            case "following":
                loadFollowings(user, portletRequest);
                break;
            case "publications":
                loadPublications(user, portletRequest);
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

    private User getUserOrPrincipal(HttpServletRequest httpReq, ThemeDisplay themeDisplay, PortletRequest portletRequest) throws PortletException {
        String idParam = getUserIdParam(httpReq, portletRequest);
        User user = null;
        Boolean isSignedIn = themeDisplay.isSignedIn();

        if (idParam != null && !idParam.isEmpty()) {
            user = userLocalService.fetchUser(parseId(idParam));
            String visibility = getVisibility(user);
            Boolean me = user.getUserId() == themeDisplay.getUserId();

            if (user == null) {
                throw new NoSuchElementException("User does not exist");
            } else if (me) {
                setOwnProfileAttributes(user, themeDisplay, portletRequest);
            } else {
                setAnotherProfileAttributes(user, themeDisplay, portletRequest);
                checkVisibility(visibility, isSignedIn, themeDisplay.getUser(), user, portletRequest);

            }

        } else {
            user = themeDisplay.getUser();
            setOwnProfileAttributes(user, themeDisplay, portletRequest);
        }

        portletRequest.setAttribute("userId", user.getUserId());
        return user;
    }

    private String getUserIdParam(HttpServletRequest httpReq, PortletRequest portletRequest) {
        try {
            String idParam = httpReq.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                idParam = portletRequest.getAttribute("userId").toString();
            }
            return idParam;
        } catch (Exception e) {
            return null;
        }
    }

    private void checkVisibility(String visibility, Boolean isSignedIn, User principal, User userProfile, PortletRequest portletRequest) throws ForbiddenProfileException {
        if (visibility.equals("registered") && !isSignedIn) {
            portletRequest.setAttribute("visibilityError", "registered");
            throw new ForbiddenProfileException();
        } else if (visibility.equals("followers") && (!isSignedIn || !checkFollow(principal, userProfile))) {
            portletRequest.setAttribute("visibilityError", "followers");
            portletRequest.setAttribute("userId", userProfile.getUserId());
            throw new ForbiddenProfileException();
        }
    }

    private Boolean checkFollow(User principal, User userProfile) {
        boolean res = true;

        SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(principal.getUserId(), userProfile.getUserId());

        if (socialFollow == null || !socialFollow.getAccepted()) {
            res = false;
        }

        return res;

    }

    private void setOwnProfileAttributes(User user, ThemeDisplay themeDisplay, PortletRequest portletRequest) {
        String visibility = getVisibility(user);

        portletRequest.setAttribute("me", themeDisplay.isSignedIn());
        portletRequest.setAttribute("visibility", visibility);
        portletRequest.setAttribute("signedIn", true);
        portletRequest.setAttribute("principalId", user.getUserId());
    }

    private void setAnotherProfileAttributes(User user, ThemeDisplay themeDisplay, PortletRequest portletRequest) {
        boolean signedIn = themeDisplay.isSignedIn();
        if (signedIn) {
            User principal = themeDisplay.getUser();

            SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(principal.getUserId(), user.getUserId());

            String follow = socialFollow != null ? socialFollow.getAccepted() ? FOLLOWED_STATE : FOLLOW_REQUESTED_STATE : null;

            portletRequest.setAttribute("follow", follow);
            portletRequest.setAttribute("principalId", principal.getUserId());
        }
        portletRequest.setAttribute("signedIn", signedIn);
    }

    private String getVisibility(User user) {
        ExpandoBridge expandoBridge = user.getExpandoBridge();
        String visibility;
        String[] visibilities = (String[]) expandoBridge.getAttribute("visibility");

        if (visibilities != null && visibilities.length > 0) {
            visibility = visibilities[0];
        } else {
            visibility = "public";
        }
        return visibility;
    }

    @ServeResourceMethod(portletNames = AvanisUserProfilePortletKeys.AVANISUSERPROFILE)
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
        String resourceID = resourceRequest.getResourceID();
        _log.info("resourceID: " + resourceID);

        if ("uploadNewPortraitResource".equals(resourceID)) {
            _log.info("uploadNewPortraitResource enter");
            ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
            User principal = themeDisplay.getUser();

            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

            File profilePicture = uploadRequest.getFile("portrait");
            try {
                checkFile(profilePicture, resourceRequest);
                byte[] fileBytes = castFileToBytes(profilePicture);

                if (fileBytes != null) {
                    UserLocalServiceUtil.updatePortrait(principal.getUserId(), fileBytes);
                    resourceResponse.getWriter().write("Imagen subida correctamente.");
                }
            } catch (Exception e) {
                resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, String.valueOf(500)); //Errorcode
                resourceResponse.getWriter().write("Error al subir la imagen.");
            }
        } else if ("getTab".equals(resourceID)) {
            _log.info("getTab enter");
            HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
            ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String tab = httpReq.getParameter("tab");
            User user = getUserOrPrincipal(httpReq, themeDisplay, resourceRequest);
            int start = parseInteger(httpReq.getParameter("shownFollowers"), 0);
            String filterName = httpReq.getParameter("filterName");

            try {
                switch (tab) {
                    case "about":
                        loadAboutMe(user, resourceRequest);
                        include("/aboutMe.jsp", resourceRequest, resourceResponse);
                        break;
                    case "followers":
                        loadFollowers(user, themeDisplay, resourceRequest);
                        include("/followersTab.jsp", resourceRequest, resourceResponse);
                        break;
                    case "following":
                        loadFollowings(user, resourceRequest);
                        include("/followingTab.jsp", resourceRequest, resourceResponse);
                        break;
                    case "publications":
                        loadPublications(user, resourceRequest);
                        include("/publications.jsp", resourceRequest, resourceResponse);
                        break;
                    case "events":
                        loadEvents(user, resourceRequest);
                        include("/events.jsp", resourceRequest, resourceResponse);
                        break;
                    case "loadMoreFollowers":
                        loadFollowers(user, start, filterName, themeDisplay, resourceRequest);
                        include("/followersList.jsp", resourceRequest, resourceResponse);
                        break;
                    case "filterFollowers":
                        loadFollowers(user, 0, filterName, themeDisplay, resourceRequest);
                        include("/followersList.jsp", resourceRequest, resourceResponse);
                        break;
                    case "loadMoreFollowings":
                        loadFollowings(user, start, filterName, resourceRequest);
                        include("/followersList.jsp", resourceRequest, resourceResponse);
                        break;
                    case "filterFollowings":
                        loadFollowings(user, 0, filterName, resourceRequest);
                        include("/followersList.jsp", resourceRequest, resourceResponse);
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
/*
        //Mi código añadido
        // Obteniendo el valor del atributo personalizado "banner"
        String bannerUrl = (String) expandoBridge.getAttribute("banner");

        // Estableciendo el valor en el request
        actionRequest.setAttribute("bannerUrl", bannerUrl);
*/

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


    @ProcessAction(name = "setUserVisibility")
    public void setUserVisibility(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();

        String visibility = ParamUtil.getString(actionRequest, "visibilityOptions", "public");

        ExpandoBridge expandoBridge = principal.getExpandoBridge();
        expandoBridge.setAttribute("visibility", visibility);


    }

    @ProcessAction(name = "follow")
    public void follow(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = Long.parseLong(ParamUtil.getString(actionRequest, "userId"));

        long focusOnUser = parseId(ParamUtil.getString(actionRequest, "focusOnUser"));
        actionRequest.setAttribute("userId", focusOnUser != 0 ? focusOnUser : userId);

        if (themeDisplay.isSignedIn()) {
            User principal = themeDisplay.getUser();

            Boolean successfulFollow = SocialFollowLocalServiceUtil.follows(principal.getUserId(), userId);

            if (successfulFollow) {
                User followUser = UserLocalServiceUtil.getUser(userId);
                actionRequest.setAttribute("followUserName", followUser.getFullName());

                AvanisComunidadUtil.sendFollowNotification(SocialFollowLocalServiceUtil.getFollow(principal.getUserId(), userId), actionRequest);
            }

        } else {
            throw new PortletException("Unauthorized");
        }

        SessionMessages.add(actionRequest, "message.follow");
    }

    @ProcessAction(name = "unfollow")
    public void unfollow(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        System.out.println("NOTIFICACION unfollow");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();
        long userId = parseId(ParamUtil.getString(actionRequest, "userId"));
        long focusOnUser = parseId(ParamUtil.getString(actionRequest, "focusOnUser"));
        actionRequest.setAttribute("userId", focusOnUser != 0 ? focusOnUser : userId);

        SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(principal.getUserId(), userId);

        if (socialFollow != null) {
            User unfollowUser = UserLocalServiceUtil.getUser(userId);
            actionRequest.setAttribute("unfollowUserName", unfollowUser.getFullName());

            SocialFollowLocalServiceUtil.deleteSocialFollow(socialFollow);
        }

        SessionMessages.add(actionRequest, "message.unfollow");
    }

    @ProcessAction(name = "cancelFollowReq")
    public void cancelFollowReq(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();
        long userId = parseId(ParamUtil.getString(actionRequest, "userId"));

        SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(userId, principal.getUserId());


        if (socialFollow != null) {
            User ignoredUser = UserLocalServiceUtil.getUser(userId);
            actionRequest.setAttribute("ignoredUserName", ignoredUser.getFullName());

            SocialFollowLocalServiceUtil.deleteSocialFollow(socialFollow);
        }

        SessionMessages.add(actionRequest, "message.cancelFollowReq");


    }

    @ProcessAction(name = "acceptFollowReq")
    public void acceptFollowReq(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User principal = themeDisplay.getUser();
        long userId = parseId(ParamUtil.getString(actionRequest, "userId"));

        SocialFollow socialFollow = SocialFollowLocalServiceUtil.acceptFollow(userId, principal.getUserId());

        if (socialFollow != null) {
            User acceptedUser = UserLocalServiceUtil.getUser(userId);
            actionRequest.setAttribute("acceptedUserName", acceptedUser.getFullName());

            AvanisComunidadUtil.sendFollowRequestAcceptedNotification(socialFollow, actionRequest);
            AvanisComunidadUtil.sendAchievementFollowerNotification(principal, SocialFollowLocalServiceUtil.countFollowers(principal.getUserId()), actionRequest);
        }
        SessionMessages.add(actionRequest, "message.acceptFollowReq");

    }

    private void loadFollowers(User user, int start, String filterName, ThemeDisplay themeDisplay, PortletRequest portletRequest) {
        User principal = themeDisplay.getUser();
        long userId = user.getUserId();

        if (principal.getUserId() == userId && start == 0) {
            Integer count = SocialFollowLocalServiceUtil.countFollowRequests(userId);
            List<User> followRequests = SocialFollowLocalServiceUtil.getFollowRequests(userId, 0, count);

            portletRequest.setAttribute("followRequests", followRequests);
        }

        List<User> followers = SocialFollowLocalServiceUtil.getFollowers(userId, filterName, start, start + FOLLOWERS_PER_PAGE);

        if (filterName != null && !filterName.isEmpty()) {
            portletRequest.setAttribute("filterName", filterName);
            portletRequest.setAttribute("followersCount", SocialFollowLocalServiceUtil.countFollowers(userId, filterName));
        } else {
            portletRequest.setAttribute("followersCount", SocialFollowLocalServiceUtil.countFollowers(userId));
        }

        portletRequest.setAttribute("shownFollowers", start + FOLLOWERS_PER_PAGE);
        portletRequest.setAttribute("loadMoreResourceName", "loadMoreFollowers");

        portletRequest.setAttribute("focusedTab", "followers");

        portletRequest.setAttribute("followers", followers);

    }


    private void loadFollowers(User user, ThemeDisplay themeDisplay, PortletRequest portletRequest) {
        this.loadFollowers(user, 0, null, themeDisplay, portletRequest);

    }

    private void loadFollowings(User user, int start, String filterName, PortletRequest portletRequest) {
        long userId = user.getUserId();

        List<User> followers = SocialFollowLocalServiceUtil.getFollowings(userId, filterName, start, start + FOLLOWERS_PER_PAGE);

        if (filterName != null && !filterName.isEmpty()) {
            portletRequest.setAttribute("filterName", filterName);
            portletRequest.setAttribute("followersCount", SocialFollowLocalServiceUtil.countFollowing(userId, filterName));
        } else {
            Integer followersCount = SocialFollowLocalServiceUtil.countFollowing(userId);
            portletRequest.setAttribute("followersCount", followersCount);
        }

        portletRequest.setAttribute("shownFollowers", start + FOLLOWERS_PER_PAGE);

        portletRequest.setAttribute("followers", followers);
        portletRequest.setAttribute("focusedTab", "following");
        portletRequest.setAttribute("loadMoreResourceName", "loadMoreFollowings");

    }


    private void loadFollowings(User user, PortletRequest portletRequest) {
        this.loadFollowings(user, 0, null, portletRequest);

    }

    private void loadProfile(User user, RenderRequest renderRequest, ThemeDisplay themeDisplay) {
        if (user == null) {
            throw new NoSuchElementException();
        }


        long userId = user.getUserId();

        List<AssetCategory> userCategories = getUserCategories(user);

        List<AssetTag> userInterests = new ArrayList<>(getInterests(user));

        renderRequest.setAttribute("name", user.getFullName());
        renderRequest.setAttribute("apellidos", user.getLastName());
        renderRequest.setAttribute("profileImage", getPortraitUrl(user, themeDisplay));
        renderRequest.setAttribute("bannerImage", getBannerUrl(user));
        renderRequest.setAttribute("publicationsNumber", countMessage(userId));
        renderRequest.setAttribute("likes", getLikes(userId));
        renderRequest.setAttribute("plots", ExplotacionLocalServiceUtil.countByUserId(userId));
        renderRequest.setAttribute("interestSize", userInterests.size());
        renderRequest.setAttribute("countFollowersProfile", SocialFollowLocalServiceUtil.countFollowers(userId));
        renderRequest.setAttribute("countFollowingsProfile", SocialFollowLocalServiceUtil.countFollowing(userId));
        renderRequest.setAttribute("dedication_level", getDedicationLevel(user));
        renderRequest.setAttribute("dedications", getUserDetails(userCategories));
    }

    private void loadAboutMe(User user, PortletRequest renderRequest) {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        MBMessageLocalServiceUtil.getChildMessagesCount(1, 0);

        String aboutMe = (String) expandoBridge.getAttribute("about");
        String location = (String) expandoBridge.getAttribute("location");
        String province = (String) expandoBridge.getAttribute("province");
        String country = (String) expandoBridge.getAttribute("country");
        String profession = (String) expandoBridge.getAttribute("profession");

        List<Phone> phones = user.getPhones();
        String phone = null;

        if (!phones.isEmpty()) {
            phone = phones.get(0).getExtension() + phones.get(0).getNumber();
        }

        List<AssetTag> userInterests = new ArrayList<>(getInterests(user));
        List<AssetCategory> userCategories = getUserCategories(user);

        if (location.equals("") && province.equals("")) {
            location = "";
        } else if (location.equals("")) {
            location = province + ", " + country;

        } else if (province.equals("")) {
            location = location + ", " + country;

        } else {
            location = location + ", " + province + ", " + country;
        }

        renderRequest.setAttribute("interests", userInterests);
        renderRequest.setAttribute("aboutMe", aboutMe);
        renderRequest.setAttribute("professions", getUserDedications(userCategories));
        renderRequest.setAttribute("phone", phone);
        renderRequest.setAttribute("location", location);
        renderRequest.setAttribute("plotUsages", getPlotUsages(user.getUserId()));
        renderRequest.setAttribute("nombre", user.getFullName());

    }

    private void loadEvents(User user, PortletRequest renderRequest) {
        List<EventFollow> eventFollows = EventFollowLocalServiceUtil.getEventFollowsByUserId(user.getUserId());
        Set<Long> followedEventsId = eventFollows.stream().map(EventFollow::getEventId).collect(Collectors.toSet());

        DynamicQuery dynamicQuery = CalendarBookingLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.in("calendarBookingId", followedEventsId));

        renderRequest.setAttribute("events", CalendarBookingLocalServiceUtil.dynamicQuery(dynamicQuery));
    }


    private void loadPublications(User user, PortletRequest renderRequest) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);


            renderRequest.setAttribute("publications", getVisiblePublications(user.getUserId(), themeDisplay.getUserId(), themeDisplay.isSignedIn(), 0));
            renderRequest.setAttribute("name", user.getFullName());
            renderRequest.setAttribute("lastName", user.getLastName());

            renderRequest.setAttribute("profileImage", user.getPortraitURL(themeDisplay));
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
    }


    private List<MBMessage> getAllPublications(long userProfileId, int offset) {
        DynamicQuery messageQuery = mbMessageLocalService.dynamicQuery();
        messageQuery.add(RestrictionsFactoryUtil.eq("userId", userProfileId));
        messageQuery.add(RestrictionsFactoryUtil.eq("parentMessageId", 0L));
        messageQuery.addOrder(OrderFactoryUtil.desc("createDate"));


        return new ArrayList<>(mbMessageLocalService.dynamicQuery(messageQuery));

    }


    private List<MBMessage> getVisiblePublications(long userProfileId, long principalId, boolean isSignedIn, int offset) {


        SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(principalId, userProfileId);
        boolean followed = socialFollow != null && socialFollow.getAccepted();

        if (principalId == userProfileId || followed) {
            return getAllPublications(userProfileId, offset);
        } else {
            DynamicQuery userMessageIdQuery = mbMessageLocalService.dynamicQuery();
            userMessageIdQuery.setProjection(ProjectionFactoryUtil.property("messageId"));
            userMessageIdQuery.add(RestrictionsFactoryUtil.eq("userId", userProfileId));
            userMessageIdQuery.add(RestrictionsFactoryUtil.eq("parentMessageId", 0L));

            List<Long> userMessageIds = MBMessageLocalServiceUtil.dynamicQuery(userMessageIdQuery);

            DynamicQuery visibleMessageIdsQuery = ExpandoValueLocalServiceUtil.dynamicQuery();
            visibleMessageIdsQuery.setProjection(ProjectionFactoryUtil.property("classPK"));
            visibleMessageIdsQuery.add(RestrictionsFactoryUtil.eq("columnId", this.getExpandoColumnVisibilityId()));
            visibleMessageIdsQuery.add(RestrictionsFactoryUtil.eq("tableId", this.getExpandoTableMessageId()));
            visibleMessageIdsQuery.add(RestrictionsFactoryUtil.in("classPK", userMessageIds));
            visibleMessageIdsQuery.add(RestrictionsFactoryUtil.in("data", isSignedIn ? new String[]{"public", "registered"} : new String[]{"public"}));

            List<Long> visibleMessageIds = ExpandoValueLocalServiceUtil.dynamicQuery(visibleMessageIdsQuery);

            DynamicQuery visibleMessagesQuery = MBMessageLocalServiceUtil.dynamicQuery();
            visibleMessagesQuery.add(RestrictionsFactoryUtil.in("messageId", visibleMessageIds));
            visibleMessagesQuery.addOrder(OrderFactoryUtil.desc("createDate"));

            return MBMessageLocalServiceUtil.dynamicQuery(visibleMessagesQuery);

        }

    }

    private List<AssetCategory> getPlotUsages(long userId) {

        List<Long> categoryIds = this.getIdCategoriesOfOwnedPlots(userId);

        DynamicQuery dynamicQuery = AssetCategoryLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.in("categoryId", categoryIds));

        return AssetCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);


    }

    private List<Long> getIdCategoriesOfOwnedPlots(long userId) {
        List<Long> categoryIds = new ArrayList<>();

        String getIdsOfOwnedPlotsSQL = "select distinct(a.categoryid) from assetcategory a " +
                "join assetentryassetcategoryrel a2 on a.categoryid  = a2.assetcategoryid  " +
                "join assetentry a3 on a3.entryid = a2.assetentryid " +
                "where a3.classnameid = ? " +
                "and a3.userid = ? ";

        try (Connection con = DataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(getIdsOfOwnedPlotsSQL)) {

            ps.setLong(1, PortalUtil.getClassNameId(Explotacion.class.getName()));
            ps.setLong(2, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    categoryIds.add(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            _log.error(e);
        }

        return categoryIds;
    }

    private Long countMessage(long userId) {
        DynamicQuery dynamicQuery = mbMessageLocalService.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
        dynamicQuery.add(RestrictionsFactoryUtil.eq("parentMessageId", 0L));

        return mbMessageLocalService.dynamicQueryCount(dynamicQuery);
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


    private Long getLikes(long userId) {
        long res = 0L;
        String sql = "select COUNT(*) from ratingsentry r " +
                "join mbmessage m on " +
                "r.classnameid = ? and " +
                "m.userid = ? and " +
                "r.classpk = m.messageid";


        try (Connection con = DataAccess.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, PortalUtil.getClassNameId(MBMessage.class.getName()));
            ps.setLong(2, userId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    res = rs.getLong(1);
                }
            }

        } catch (SQLException e) {
            _log.error(e);
        }

        return res;
    }

    private String getDedicationLevel(User user) {
        ExpandoBridge expandoBridge = user.getExpandoBridge();
        String[] dedicationLevels = (String[]) expandoBridge.getAttribute("dedication_level");

        if (dedicationLevels != null && dedicationLevels.length > 0) {
            return dedicationLevels[0];
        } else {
            return null;
        }

    }

    private List<AssetCategory> getUserCategories(User user) {
        DynamicQuery dynamicQuery = mbMessageLocalService.dynamicQuery();

        return assetCategoryLocalService.getCategories(User.class.getName(), user.getUserId());
    }

    private List<AssetCategory> getUserDedications(List<AssetCategory> categories) {
        String userDedications = "user dedications";
        long globalGroupId = 20119;
        long vocabularyId = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(globalGroupId, userDedications).getVocabularyId();

        return categories.stream().filter(category -> category.getVocabularyId() == vocabularyId).collect(Collectors.toList());
    }

    private List<AssetCategory> getUserDetails(List<AssetCategory> categories) {
        String userDedications = "avanis";
        long globalGroupId = 20119;
        long vocabularyId = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(globalGroupId, userDedications).getVocabularyId();

        return categories.stream().filter(category -> category.getVocabularyId() == vocabularyId).collect(Collectors.toList());
    }

    private List<AssetTag> getInterests(User user) {
        return AssetTagLocalServiceUtil.getTags(User.class.getName(), user.getUserId());
    }

    private long parseId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private Integer parseInteger(String id, Integer defaultValue) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}