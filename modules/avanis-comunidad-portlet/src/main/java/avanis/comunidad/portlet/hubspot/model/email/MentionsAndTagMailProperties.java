package avanis.comunidad.portlet.hubspot.model.email;

import java.time.Instant;

public class MentionsAndTagMailProperties {

    String userEmail;
    String name;
    String usernameMentioning;
    String urlPost;
    String publicationTitle;
    String publicationMsg;
    String mentionProfileImgUrl;
    Instant publicationDate;
    String hashtags;

    public String getHashtags() {
        return hashtags;
    }

    public Instant getPublicationDate() {
        return publicationDate;
    }

    public String getPublicationMsg() {
        return publicationMsg;
    }

    public String getMentionProfileImgUrl() {
        return mentionProfileImgUrl;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public String getUsernameMentioning() {
        return usernameMentioning;
    }

    public String getUrlPost() {
        return urlPost;
    }
}
