package avanis.custom.login.modelo;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.Serializable;
import java.util.Locale;

public class Usuario  {
    private long creatorUserId;
    private long companyId;
    boolean autoPassword;
    private String password1;
    private String password2;
    private boolean autoScreenName;
    private String screenName;
    private String emailAddress;
    private Locale locale;
    private String firstName;
    private String middleName;
    private String lastName;
    private long prefixListTypeId;
    private long suffixListTypeId;
    private boolean male;
    private int birthdayMonth;
    private int birthdayDay;
    private int birthdayYear;
    private String jobTitle;
    private int type;
    private long[] groupIds;
    private long[] organizationIds;
    private long[] roleIds;
    private long[] userGroupIds;
    private boolean sendEmail;
    private ServiceContext serviceContext;
    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public boolean isAutoPassword() {
        return autoPassword;
    }

    public void setAutoPassword(boolean autoPassword) {
        this.autoPassword = autoPassword;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public boolean isAutoScreenName() {
        return autoScreenName;
    }

    public void setAutoScreenName(boolean autoScreenName) {
        this.autoScreenName = autoScreenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPrefixListTypeId() {
        return prefixListTypeId;
    }

    public void setPrefixListTypeId(long prefixListTypeId) {
        this.prefixListTypeId = prefixListTypeId;
    }

    public long getSuffixListTypeId() {
        return suffixListTypeId;
    }

    public void setSuffixListTypeId(long suffixListTypeId) {
        this.suffixListTypeId = suffixListTypeId;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(int birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public int getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(int birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getDisplayURL(ThemeDisplay themeDisplay) throws PortalException {
        return "";
    }

    public long[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(long[] groupIds) {
        this.groupIds = groupIds;
    }

    public long[] getOrganizationIds() {
        return organizationIds;
    }

    public void setOrganizationIds(long[] organizationIds) {
        this.organizationIds = organizationIds;
    }

    public long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(long[] roleIds) {
        this.roleIds = roleIds;
    }

    public long[] getUserGroupIds() {
        return userGroupIds;
    }

    public void setUserGroupIds(long[] userGroupIds) {
        this.userGroupIds = userGroupIds;
    }

    public boolean isSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public ServiceContext getServiceContext() {
        return serviceContext;
    }

    public void setServiceContext(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
    }



    public long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }
}
