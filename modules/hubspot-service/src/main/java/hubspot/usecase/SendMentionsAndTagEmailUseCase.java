package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.*;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component(immediate = true, service = SendMentionsAndTagEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendMentionsAndTag"})
public class SendMentionsAndTagEmailUseCase {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Reference
private HubspotService hubspotService;

    public void sendMentionsAndTag(){
        System.out.println("sendMentionsAndTag");
    }

    void execute(MentionsAndTagMailProperties mentionsAndTagMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108188092884";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", mentionsAndTagMailProperties.getUserEmail()),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("publicationTitle", mentionsAndTagMailProperties.getPublicationTitle()),
                        new CustomPropertyEmail("userNameMentioning",  mentionsAndTagMailProperties.getUsernameMentioning()),
                        new CustomPropertyEmail("publicationMsg",  mentionsAndTagMailProperties.getPublicationMsg()),
                        new CustomPropertyEmail("profileImg",  mentionsAndTagMailProperties.getMentionProfileImgUrl()),
                        new CustomPropertyEmail( "name", mentionsAndTagMailProperties.getName()),
                        new CustomPropertyEmail("messageUrl", mentionsAndTagMailProperties.getUrlPost()),
                        new CustomPropertyEmail("hashtags", mentionsAndTagMailProperties.getHashtags()),
                        new CustomPropertyEmail( "publicationDate",  dateFormatter.format(mentionsAndTagMailProperties.getPublicationDate().atZone(ZoneId.of("Europe/Madrid"))))
                ));

        hubspotService.sendMail(email);
    }
}
