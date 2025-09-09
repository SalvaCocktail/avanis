package hubspot.model.mails;

import java.time.Instant;

public class RemainderMailProperties {
    String userEmail;
    String name;
    String urlPost;
    String publicationTitle;
    String publicationMsg;
    String hashtags;

    public String getHashtags() {
        return hashtags;
    }


    public String getPublicationMsg() {
        return publicationMsg;
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


    public String getUrlPost() {
        return urlPost;
    }
}
