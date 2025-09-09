package hubspot.model.forms;

public class IsSubscribedFormProperties {
    private String email;
    private boolean allowNewsletter;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAllowNewsletter() {
        return allowNewsletter;
    }

    public void setAllowNewsletter(boolean allowNewsletter) {
        this.allowNewsletter = allowNewsletter;
    }
}
