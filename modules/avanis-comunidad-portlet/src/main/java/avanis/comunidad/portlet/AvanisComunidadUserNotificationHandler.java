package avanis.comunidad.portlet;

import avanis.comunidad.portlet.constants.AvanisComunidadPortletKeys;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + AvanisComunidadPortletKeys.AVANISCOMUNIDAD},
        service = UserNotificationHandler.class
)
public class AvanisComunidadUserNotificationHandler extends BaseUserNotificationHandler {

    public AvanisComunidadUserNotificationHandler() {
        setPortletId(AvanisComunidadPortletKeys.AVANISCOMUNIDAD);
    }

    @Override
    protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
        String username = LanguageUtil.get(serviceContext.getLocale(), _UKNOWN_USER_KEY);

        // okay, we need to get the user for the event
        User user = _userLocalService.fetchUser(userNotificationEvent.getUserId());

        if (Validator.isNotNull(user)) {
            // get the company the user belongs to.
            Company company = _companyLocalService.fetchCompany(user.getCompanyId());

            // based on the company auth type, find the user name to display.
            // so we'll get screen name or email address or whatever they're using to log in.

            if (Validator.isNotNull(company)) {
                if (company.getAuthType().equals(CompanyConstants.AUTH_TYPE_EA)) {
                    username = user.getEmailAddress();
                } else if (company.getAuthType().equals(CompanyConstants.AUTH_TYPE_SN)) {
                    username = user.getScreenName();
                } else if (company.getAuthType().equals(CompanyConstants.AUTH_TYPE_ID)) {
                    username = String.valueOf(user.getUserId());
                }
            }
        }

        // we'll be stashing the client address in the payload of the event, so let's extract it here.
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
                userNotificationEvent.getPayload());

        String fromHost = jsonObject.getString("fromHost");

        // fetch our strings via the language bundle.

        String title = jsonObject.getString("title");
        String body = jsonObject.getString("body");
        String userFullName = jsonObject.getString("userFullName");
        String inputUsername = jsonObject.getString("username");
        String achievementNumber = jsonObject.getString("achievementNumber");

        String classPK = jsonObject.getString("classPK");
        String articleTitle = jsonObject.getString("articleTitle");
        String template = _BODY_TEMPLATE;
        if (Validator.isNotNull(articleTitle) && !"articleTitle".equals(articleTitle)) {
            String journalArticleTitle = jsonObject.getString("articleTitle");
            JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(serviceContext.getScopeGroupId(), articleTitle);
            DDMTemplate ddmTemplate = journalArticle.getDDMTemplate();
            template = ddmTemplate.getScript();
        }

        // build the html using our template.
        String html = StringUtil.replace(template, _BODY_REPLACEMENTS, new String[]{title, body, userFullName, inputUsername, achievementNumber});

        return html;
    }

    @Reference(unbind = "-")
    protected void setUserLocalService(final UserLocalService userLocalService) {
        _userLocalService = userLocalService;
    }

    @Reference(unbind = "-")
    protected void setCompanyLocalService(final CompanyLocalService companyLocalService) {
        _companyLocalService = companyLocalService;
    }

    private UserLocalService _userLocalService;
    private CompanyLocalService _companyLocalService;

    private static final String _TITLE_KEY = "title"; // ej.  "title.admin.login";
    private static final String _BODY_KEY = "body"; // ej. "body.admin.login";
    private static final String _UKNOWN_USER_KEY = "unknown.user";

    private static final String _BODY_TEMPLATE = "<div class=\"title\">[$TITLE$]</div><div class=\"body\">[$BODY$]</div>";
    private static final String[] _BODY_REPLACEMENTS = new String[]{"[$TITLE$]", "[$BODY$]", "[$USERFULLNAME$]", "[$USERNAME$]", "[$ACHIEVEMENT_NUMBER$]"};

    private static final Log _log = LogFactoryUtil.getLog(AvanisComunidadUserNotificationHandler.class);
}

