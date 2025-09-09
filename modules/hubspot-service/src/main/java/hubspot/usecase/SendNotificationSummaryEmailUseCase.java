package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.CustomPropertyEmail;
import hubspot.model.mails.EmailProperties;
import hubspot.model.mails.HubspotEmail;
import hubspot.model.mails.NotificationSummaryMailProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component(immediate = true, service = SendNotificationSummaryEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendNotificationSummary"})
public class SendNotificationSummaryEmailUseCase {
    @Reference
private HubspotService hubspotService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    public void sendNotificationSummary(){
        System.out.println("sendNotificationSummary");
    }

    void execute(NotificationSummaryMailProperties notificationSummaryMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT)  ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "102697337056";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        HubspotEmail email = new HubspotEmail(
               emailId,
               new EmailProperties("Avanis <hola@avanis.es>", notificationSummaryMailProperties.getUserEmail()),
        Arrays.asList(
        new CustomPropertyEmail("environment", subjectPrefix),
        new CustomPropertyEmail("publicationTitle", notificationSummaryMailProperties.getPublicationTitle()),
        new CustomPropertyEmail("messageUrl", notificationSummaryMailProperties.getMessageUrl()),
        new CustomPropertyEmail( "numComments",  notificationSummaryMailProperties.getNumComments().toString()),
        new CustomPropertyEmail( "numLikes",  notificationSummaryMailProperties.getNumLikes().toString()),
        new CustomPropertyEmail( "name",  notificationSummaryMailProperties.getName()),
        new CustomPropertyEmail( "publicationDate",  dateFormatter.format(notificationSummaryMailProperties.getPublicationDate().atZone(ZoneId.of("Europe/Madrid"))))
        ));

        hubspotService.sendMail(email);
    }

}
