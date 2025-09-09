package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.CustomPropertyEmail;
import hubspot.model.mails.EmailProperties;
import hubspot.model.mails.HubspotEmail;
import hubspot.model.mails.ReplyMessageMailProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(immediate = true, service = SendFirstInteractionEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendFirstInteraction"})
public class SendFirstInteractionEmailUseCase {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Reference
private HubspotService hubspotService;

public void sendFirstInteraction(){
    System.out.println("sendFirstInteraction");
    ReplyMessageMailProperties replyMessageMailProperties = new ReplyMessageMailProperties();
    replyMessageMailProperties.setPublicationTitle("Title");
    replyMessageMailProperties.setMessageUrl("https://google.es");
    replyMessageMailProperties.setReplyMsg("hola");
    replyMessageMailProperties.setReplyUserName("respondedor");
    replyMessageMailProperties.setProfileImgUrl("https://www.avanis.es/static/media/avanis-logo.c0183ed082b73dff50d89c313c0f2ee0.svg");
    replyMessageMailProperties.setName("Jose");
    replyMessageMailProperties.setUserEmail("jose.hermo@the-cocktail.com");
}

    void execute(ReplyMessageMailProperties replyMessageMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "102698031093";


        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", replyMessageMailProperties.getUserEmail()),

                Arrays.asList(
        new CustomPropertyEmail("environment", subjectPrefix),
        new CustomPropertyEmail("publicationTitle", replyMessageMailProperties.getPublicationTitle()),
        new CustomPropertyEmail("profileImg", replyMessageMailProperties.getProfileImgUrl()),
        new CustomPropertyEmail("replyUserName",  replyMessageMailProperties.getReplyUserName()),
        new CustomPropertyEmail("replyMsg",  replyMessageMailProperties.getReplyMsg()),
        new CustomPropertyEmail( "name", replyMessageMailProperties.getName()),
        new CustomPropertyEmail("messageUrl", replyMessageMailProperties.getMessageUrl())
                ));

        hubspotService.sendMail(email);
    }

}
