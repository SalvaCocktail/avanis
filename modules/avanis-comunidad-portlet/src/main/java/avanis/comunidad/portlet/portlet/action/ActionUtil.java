package avanis.comunidad.portlet.portlet.action;

import avanis.comunidad.portlet.security.permission.MBResourcePermission;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.message.boards.exception.NoSuchMessageException;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBMessageDisplay;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.*;
import com.liferay.message.boards.util.MBUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.model.RatingsEntry;
import com.liferay.ratings.kernel.service.RatingsEntryLocalServiceUtil;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Brian Wing Shun Chan
 */
public class ActionUtil {

	public static MBCategory getCategory(HttpServletRequest httpServletRequest)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String mvcRenderCommandName = ParamUtil.getString(
			httpServletRequest, "mvcRenderCommandName");

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		if (mvcRenderCommandName.equals(
				"/message_boards_admin/view_banned_users") &&
			!MBResourcePermission.contains(
				permissionChecker, themeDisplay.getScopeGroupId(),
				ActionKeys.BAN_USER)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, ActionKeys.BAN_USER);
		}

		MBBanLocalServiceUtil.checkBan(
			themeDisplay.getScopeGroupId(), themeDisplay.getUserId());

		long categoryId = ParamUtil.getLong(httpServletRequest, "mbCategoryId");

		MBCategory category = null;

		if (categoryId > 0) {
			category = MBCategoryServiceUtil.getCategory(categoryId);
		}
		else {
			MBResourcePermission.check(
				permissionChecker, themeDisplay.getScopeGroupId(),
				ActionKeys.VIEW);
		}

		return category;
	}

	public static MBCategory getCategory(PortletRequest portletRequest)
		throws Exception {

		return getCategory(PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static MBMessage getMessage(HttpServletRequest httpServletRequest)
		throws Exception {

		long messageId = ParamUtil.getLong(httpServletRequest, "messageId");

		MBMessage message = null;

		if (messageId > 0) {
			message = MBMessageServiceUtil.getMessage(messageId);
		}

		if ((message != null) && message.isInTrash()) {
			throw new NoSuchMessageException("{messageId=" + messageId + "}");
		}

		return message;
	}

	public static MBMessage getMessage(PortletRequest portletRequest)
		throws Exception {

		return getMessage(PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static MBMessageDisplay getMessageDisplay(
			HttpServletRequest httpServletRequest)
		throws PortalException {

		long messageId = ParamUtil.getLong(httpServletRequest, "messageId");

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		MBMessageDisplay messageDisplay = null;

		if (permissionChecker.isContentReviewer(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId())) {

			messageDisplay = MBMessageLocalServiceUtil.getMessageDisplay(
				themeDisplay.getUserId(), messageId,
				WorkflowConstants.STATUS_ANY);
		}
		else {
			messageDisplay = MBMessageServiceUtil.getMessageDisplay(
				messageId, WorkflowConstants.STATUS_APPROVED);
		}

		if (messageDisplay != null) {
			MBMessage message = messageDisplay.getMessage();

			if ((message != null) && message.isInTrash()) {
				throw new NoSuchMessageException(
					"{messageId=" + messageId + "}");
			}
		}

		return messageDisplay;
	}

	public static MBMessageDisplay getMessageDisplay(
			PortletRequest portletRequest)
		throws PortalException {

		return getMessageDisplay(
			PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static MBMessage getThreadMessage(
			HttpServletRequest httpServletRequest)
		throws Exception {

		long threadId = ParamUtil.getLong(httpServletRequest, "threadId");

		MBMessage message = null;

		if (threadId > 0) {
			MBThread thread = MBThreadLocalServiceUtil.getThread(threadId);

			message = MBMessageServiceUtil.getMessage(
				thread.getRootMessageId());
		}

		if ((message != null) && message.isInTrash()) {
			throw new NoSuchMessageException("{threadId=" + threadId + "}");
		}

		return message;
	}

	public static MBMessage getThreadMessage(PortletRequest portletRequest)
		throws Exception {

		return getThreadMessage(
			PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static String formatURLs(String msgBody) {
		Pattern urlPattern = Pattern.compile("(https?://[^\\s\"']+|www\\.[^\\s\"']+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = urlPattern.matcher(msgBody);
		StringBuffer result = new StringBuffer();

		while (matcher.find()) {
			String url = matcher.group();
			String formattedUrl;
			String cleanUrl = url.replaceAll("[^\\w\\-\\./:]", "");

			if (url.startsWith("www.")) {
				formattedUrl = "<a class=\"url-publicacion\" href=\"http://" + cleanUrl + "\">" + url + "</a>";
			} else if (url.startsWith("http://") || url.startsWith("https://")) {
				formattedUrl = "<a class=\"url-publicacion\" href=\"" + cleanUrl + "\">" + url + "</a>";
			} else {
				formattedUrl = url;
			}

			matcher.appendReplacement(result, Matcher.quoteReplacement(formattedUrl));
		}
		matcher.appendTail(result);
		return result.toString();
	}

	public static String truncateText(String text, int maxLength) {
		if (text.length() > maxLength) {
			return text.substring(0, maxLength) + "...";
		}
		return text;
	}

	public static int countLikes(long messageId) {
		try {
			List<RatingsEntry> ratingsEntries = RatingsEntryLocalServiceUtil.getEntries(MBMessage.class.getName(), messageId);
			double countLikesScore = 0;
			for (RatingsEntry ratingsEntry : ratingsEntries) {
				countLikesScore += ratingsEntry.getScore();
			}
			return (int) Math.round(countLikesScore);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean hasUserLiked(long messageId, long userId) {
		try {
			List<RatingsEntry> ratingsEntries = RatingsEntryLocalServiceUtil.getEntries(MBMessage.class.getName(), messageId);
			for (RatingsEntry ratingsEntry : ratingsEntries) {
				if (ratingsEntry.getUserId() == userId) {
					return true; // El usuario ha dado like
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // El usuario no ha dado like
	}

	// Método para contar mensajes hijos
	public static int getChildMessagesCount(long messageId) {
		try {
			// Incluye el estado del mensaje como segundo argumento
			return MBMessageLocalServiceUtil.getChildMessagesCount(messageId, WorkflowConstants.STATUS_APPROVED);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// Método para contar likes
	public static int getLikesCount(long messageId) {
		try {
			List<RatingsEntry> ratingsEntries = RatingsEntryLocalServiceUtil.getEntries(
					"com.liferay.message.boards.model.MBMessage", messageId);

			double countLikesScore = 0;
			for (RatingsEntry ratingsEntry : ratingsEntries) {
				countLikesScore += ratingsEntry.getScore();
			}

			return (int) Math.round(countLikesScore);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// Método para procesar el cuerpo del mensaje
	public static String processMessageBody(String msgBody, String pathThemeImages) {
		if (msgBody == null) {
			return "";
		}

		// Verificar si el mensaje contiene BBCode
		if (containsBBCode(msgBody)) {
			msgBody = MBUtil.getBBCodeHTML(msgBody, pathThemeImages);
		}

		// Detectar y convertir URLs en enlaces clicables
		Pattern urlPattern = Pattern.compile("(https?://[^\\s\"']+|www\\.[^\\s\"']+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = urlPattern.matcher(msgBody);
		StringBuffer result = new StringBuffer();

		while (matcher.find()) {
			String url = matcher.group();
			String formattedUrl;
			String cleanUrl = url.replaceAll("[^\\w\\-\\./:]", "");

			if (url.startsWith("www.")) {
				formattedUrl = "<a class=\"url-publicacion\" href=\"http://" + cleanUrl + "\">" + url + "</a>";
			} else if (url.startsWith("http://") || url.startsWith("https://")) {
				formattedUrl = "<a class=\"url-publicacion\" href=\"" + cleanUrl + "\">" + url + "</a>";
			} else {
				formattedUrl = url;
			}

			matcher.appendReplacement(result, Matcher.quoteReplacement(formattedUrl));
		}
		matcher.appendTail(result);

		return result.toString();
	}

	// Método para verificar si el mensaje contiene BBCode
	private static boolean containsBBCode(String msgBody) {
		// Busca patrones comunes de BBCode
		return msgBody.contains("[b]") || msgBody.contains("[/b]") ||
				msgBody.contains("[i]") || msgBody.contains("[/i]") ||
				msgBody.contains("[url]") || msgBody.contains("[/url]");
	}

	// Método para obtener la lista de nombres de usuarios que dieron like
	public static StringBuilder getUserNameList(long messageId) {
		StringBuilder userNameList = new StringBuilder();

		try {
			List<RatingsEntry> ratingsEntries = RatingsEntryLocalServiceUtil.getEntries(
					"com.liferay.message.boards.model.MBMessage", messageId);

			for (RatingsEntry ratingsEntry : ratingsEntries) {
				User userLikesScore = UserLocalServiceUtil.getUser(ratingsEntry.getUserId());
				userNameList.append(userLikesScore.getFullName());
				userNameList.append("&#10;");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userNameList;
	}

	public static List<AssetCategory> getThreadCategories(long messageId, long threadId) {
		List<AssetCategory> categoriesThread = new ArrayList();
		if (messageId == threadId) {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(MBMessage.class.getName(), threadId);
			categoriesThread = assetEntry.getCategories();
		}
		return categoriesThread;
	}

	public static String getMessageUserName(MBMessage message) {
		return message.getUserName();
	}

	public static String getMessageUserProfileURL(long userId) {
		return "/mi-perfil-publico?id=" + userId;
	}

	public static String getDisplayDateDescription(MBMessage message, HttpServletRequest request) {
		Date displayDate = message.getCreateDate();
		long timeDiff = System.currentTimeMillis() - displayDate.getTime();
		return LanguageUtil.getTimeDescription(request, timeDiff, true);
	}

	public static String getShareThreadURL(long messageId, long threadId) {
		return "javascript:functionShareThreadURL" + threadId + "(" + messageId + ");";
	}


}
