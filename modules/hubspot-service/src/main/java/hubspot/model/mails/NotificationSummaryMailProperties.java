package hubspot.model.mails;

import java.time.Instant;

public class NotificationSummaryMailProperties {

    String publicationTitle;
    String name;
    String userEmail;
    String messageUrl;
    Integer numComments;
    Integer numLikes;
    Instant publicationDate;

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public Instant getPublicationDate() {
        return publicationDate;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public String getMessageUrl() {
        return messageUrl;
    }


    public String getName() {
        return name;
    }

    public String getUserEmail() {
        return userEmail;
    }

}
