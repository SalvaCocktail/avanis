package avanis.custom.login.utils;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;

import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_AUTO_SCREEN_NAME;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_BIRTH_DAY_DAY;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_BIRTH_DAY_MONTH;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_BIRTH_DAY_YEAR;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_FACEBOOK_ID;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_GROUP_IDS;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_JOBTITLE;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_MALE;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_ORGANIZATION_IDS;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_PREFIX_ID;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_ROLE_IDS;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_SEND_EMAIL;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_SUFFIX_ID;
import static avanis.custom.login.constants.RegisterAcountConstants.DEFAULT_USERGROUP_IDS;

public class RegisterUtil {

    private static Log _log = LogFactoryUtil.getLog(RegisterUtil.class);


    public static User createUser(UserService _userService,ActionRequest actionRequest, ThemeDisplay themeDisplay){

        boolean autoPassword = false;
        User user = null;
        String password1 = ParamUtil.getString(actionRequest, "password");
        String password2 = ParamUtil.getString(actionRequest, "password");
        String screenName = ParamUtil.getString(actionRequest, "alias");
        String emailAddress = ParamUtil.getString(actionRequest, "email");
        String firstName = ParamUtil.getString(actionRequest, "name");
        String middleName = ParamUtil.getString(actionRequest, "apellidos");
        String lastName = ParamUtil.getString(actionRequest, "apellidos");

        if(Validator.isBlank(middleName) && Validator.isBlank(lastName)){
            middleName = firstName;
            lastName = screenName;
        }

        try {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                User.class.getName(), actionRequest);

            user = _userService.addUser(
                    themeDisplay.getCompanyId(), autoPassword, password1, password2,
                    DEFAULT_AUTO_SCREEN_NAME, screenName, emailAddress, DEFAULT_FACEBOOK_ID,
                    StringPool.BLANK, themeDisplay.getLocale(), firstName, middleName,
                    lastName, DEFAULT_PREFIX_ID, DEFAULT_SUFFIX_ID, DEFAULT_MALE, DEFAULT_BIRTH_DAY_MONTH,
                    DEFAULT_BIRTH_DAY_DAY, DEFAULT_BIRTH_DAY_YEAR, DEFAULT_JOBTITLE, DEFAULT_GROUP_IDS, DEFAULT_ORGANIZATION_IDS, DEFAULT_ROLE_IDS, DEFAULT_USERGROUP_IDS,
                    DEFAULT_SEND_EMAIL, serviceContext);
        } catch (PortalException e) {
            _log.error("***ERROR: Imposible crear usuario: " + e.getMessage());
        }

        return user;
    }
}