package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.*;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component(immediate = true, service = SendReminderEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendReminder"})
public class SendReminderEmailUseCase {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Reference
private HubspotService hubspotService;

    public void sendReminder(){
        System.out.println("sendReminder");
    }

    void execute(String userEmail,
                 String name,
                 String urlPost,
                 String publicationTitle,
                 String publicationMsg,
                 String hashtags) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108201933284";

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", userEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail( "name", name),
                        new CustomPropertyEmail("messageUrl", urlPost),
                        new CustomPropertyEmail("hashtags", hashtags),
                        new CustomPropertyEmail("publicationTitle", publicationTitle),
                        new CustomPropertyEmail("publicationMsg",  publicationMsg)
                ));

        hubspotService.sendMail(email);
    }
}
