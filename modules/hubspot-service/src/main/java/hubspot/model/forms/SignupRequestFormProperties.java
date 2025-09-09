package hubspot.model.forms;

public class SignupRequestFormProperties {
    String username;
    String password;
    String alias;
    String name;
    String surnames;
    String phone;
    boolean allowNewsLetter;
    String signUpUrl;

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAllowNewsLetter() {
        return allowNewsLetter;
    }

    public void setAllowNewsLetter(boolean allowNewsLetter) {
        this.allowNewsLetter = allowNewsLetter;
    }
}
