package avanis.compartir.email.portlet.hubspot;

import java.time.Instant;

public interface HubspotService {
    void sendShareNewsEmailUseCase(String newsTitle,
                                   String newsSubtitle,
                                   Instant datePublishes,
                                   String imgUrl,
                                   String newsUrl,
                                   String message,
                                   String userEmail,
                                   String sendEmail);

    void sendShareCommentsEmailUseCase(String replyUsername,
                                       String replyMessage,
                                       String messageProfileImage,
                                       String messageUrl,
                                       String message,
                                       String userEmail,
                                       String sendEmail);

    void sendShareEventEmailUseCase(String eventName,
                                    String eventDay,
                                    String eventHour,
                                    String eventType,
                                    String eventUrl,
                                    String eventLocation,
                                    String shareMsg,
                                    String userEmail,
                                    String sendEmail);

    void sendShareSubsidyEmailUseCase(String subsidyName,
                                      String subsidyDate,
                                      String subsidyAmount,
                                      String subsidyCategories,
                                      String subsidyOrg,
                                      String subsidyUrl,
                                      String message,
                                      String userEmail,
                                      String sendEmail);

}
