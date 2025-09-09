package hubspot.model.mails;

import java.time.Instant;

public class AchievementIterationsMailProperties {

    String userEmail;
    String name;
    String publicationTitle;
    Integer numIterations;
    Instant publicationDate;
    Integer numLikes;
    Integer numComments;
    String urlPost;

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public String getUrlPost() {
        return urlPost;
    }

    public Instant getPublicationDate() {
        return publicationDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public Integer getNumIterations() {
        return numIterations;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public void setNumIterations(Integer numIterations) {
        this.numIterations = numIterations;
    }

    public void setPublicationDate(Instant publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setNumLikes(Integer numLikes) {
        this.numLikes = numLikes;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public void setUrlPost(String urlPost) {
        this.urlPost = urlPost;
    }
}
