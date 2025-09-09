package hubspot.model.mails;

public class PasswordResetMailProperties {
    String userEmail;
    String resetUrl;
    String name;

    public String getUserEmail() {
        return userEmail;
    }

    public String getResetUrl() {
        return resetUrl;
    }

    public String getName() {
        return name;
    }
}
