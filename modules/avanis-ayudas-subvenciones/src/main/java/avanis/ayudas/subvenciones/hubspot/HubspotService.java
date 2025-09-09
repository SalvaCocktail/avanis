package avanis.ayudas.subvenciones.hubspot;

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


}
