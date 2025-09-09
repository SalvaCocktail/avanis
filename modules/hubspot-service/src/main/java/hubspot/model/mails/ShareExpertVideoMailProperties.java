package hubspot.model.mails;

import java.time.Instant;

public class ShareExpertVideoMailProperties {


   String videoTitle;
    String videoSubtitle;
    Instant datePublishes;
    String imgUrl;
    String videoUrl;
    String message;
    String userEmail;
    String senderEmail;

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoSubtitle() {
        return videoSubtitle;
    }

    public Instant getDatePublishes() {
        return datePublishes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getMessage() {
        return message;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
