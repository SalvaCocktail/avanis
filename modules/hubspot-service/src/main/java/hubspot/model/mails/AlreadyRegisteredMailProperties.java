package hubspot.model.mails;

public class AlreadyRegisteredMailProperties {

    String userEmail;
    String name;
    String loginUrl;
    String recoveryUrl;

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getRecoveryUrl() {
        return recoveryUrl;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }
}
