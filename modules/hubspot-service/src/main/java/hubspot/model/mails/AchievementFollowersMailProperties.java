package hubspot.model.mails;

public class AchievementFollowersMailProperties {

    String userEmail;
    String name;
    Integer numberFollowersOrIterations;

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberFollowersOrIterations() {
        return numberFollowersOrIterations;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberFollowersOrIterations(Integer numberFollowersOrIterations) {
        this.numberFollowersOrIterations = numberFollowersOrIterations;
    }
}
