package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.CustomPropertyEmail;
import hubspot.model.mails.EmailProperties;
import hubspot.model.mails.HubspotEmail;
import hubspot.model.mails.PasswordResetMailProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(immediate = true, service = SendPasswordResetRequestCreatedEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendPasswordResetRequestCreated"})
public class SendPasswordResetRequestCreatedEmailUseCase {

    @Reference
private HubspotService hubspotService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    public void SendPasswordResetRequestCreated(){
        System.out.println("sendPasswordResetRequestCreated");
    }

    void execute(PasswordResetMailProperties passwordResetMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "96345253881";


        HubspotEmail email = new HubspotEmail(
            emailId,
            new EmailProperties("Avanis <hola@avanis.es>", passwordResetMailProperties.getName()),

        Arrays.asList(
        new CustomPropertyEmail( "environment", subjectPrefix),
        new CustomPropertyEmail( "name", passwordResetMailProperties.getName()),
        new CustomPropertyEmail( "recoverUrl", passwordResetMailProperties.getResetUrl() ))
          );
        hubspotService.sendMail(email);
    }
}
