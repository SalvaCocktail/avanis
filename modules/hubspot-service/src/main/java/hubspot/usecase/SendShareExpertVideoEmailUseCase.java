package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.CustomPropertyEmail;
import hubspot.model.mails.EmailProperties;
import hubspot.model.mails.HubspotEmail;
import hubspot.model.mails.ShareExpertVideoMailProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component(immediate = true, service = SendShareExpertVideoEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendShareExpertVideo"})
public class SendShareExpertVideoEmailUseCase {

    @Reference
private HubspotService hubspotService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    public void sendShareExpertVideo(){
        System.out.println("sendShareExpertVideo");
    }

    void execute(String videoTitle,
                 String videoSubtitle,
                 Instant datePublishes,
                 String imgUrl,
                 String videoUrl,
                 String message,
                 String userEmail,
                 String senderEmail) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "100223720904";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", userEmail),
        Arrays.asList(
        new CustomPropertyEmail("environment", subjectPrefix),
        new CustomPropertyEmail( "TituloNoticia", videoTitle),
        new CustomPropertyEmail( "SubtituloNoticia",  videoSubtitle),
        new CustomPropertyEmail( "FechaNoticia",  dateFormatter.format(datePublishes.atZone(ZoneId.of("Europe/Madrid")))),
        new CustomPropertyEmail( "urlImagen",  imgUrl),
        new CustomPropertyEmail( "EnlaceNoticia",  videoUrl),
        new CustomPropertyEmail( "CorreoMensaje", message),
        new CustomPropertyEmail( "correoEnvio", senderEmail)
        ));

        hubspotService.sendMail(email);

    }
}
