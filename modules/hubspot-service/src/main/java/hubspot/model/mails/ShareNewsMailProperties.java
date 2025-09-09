package hubspot.model.mails;

import java.time.Instant;

public class ShareNewsMailProperties {
    String newsTitle;
    String newsSubtitle;
    Instant datePublishes;
    String imgUrl;
    String newsUrl;
    String message;
    String userEmail;
    String senderEmail;

    public String getNewsTitle() {
        return newsTitle;
    }



    public String getNewsSubtitle() {
        return newsSubtitle;
    }



    public Instant getDatePublishes() {
        return datePublishes;
    }



    public String getImgUrl() {
        return imgUrl;
    }



    public String getNewsUrl() {
        return newsUrl;
    }



    public String getMessage() {
        return message;
    }



    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

}
