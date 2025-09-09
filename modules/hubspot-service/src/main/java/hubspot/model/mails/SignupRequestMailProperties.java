package hubspot.model.mails;

public class SignupRequestMailProperties {

    String userEmail;
    String name;
    String signupUrl;

    public String getSignupUrl() {
        return signupUrl;
    }

    public String getName() {
        return name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSignupUrl(String signupUrl) {
        this.signupUrl = signupUrl;
    }
}
