package hubspot.model.mails;

public class ReplyMessageMailProperties {

     String publicationTitle;
     String name;
     String userEmail;
     String profileImgUrl;
     String replyUserName;

     String replyMsg;

     String messageUrl;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }



    public String getProfileImgUrl() {
        return profileImgUrl;
    }



    public String getReplyUserName() {
        return replyUserName;
    }



    public String getReplyMsg() {
        return replyMsg;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public void setReplyMsg(String replyMsg) {
        this.replyMsg = replyMsg;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }
}
