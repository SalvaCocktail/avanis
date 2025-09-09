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

@Component(immediate = true, service = SendPasswordResetEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendPasswordResetRequestCreated"})
public class SendPasswordResetEmailUseCase {

    @Reference
private HubspotService hubspotService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    public void SendPasswordResetRequestCreated(){
        System.out.println("sendPasswordResetRequestCreated");
    }

    public void execute(String destEmail, String name, String tempPassword) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "109291820754";


        HubspotEmail email = new HubspotEmail(
            emailId,
            new EmailProperties("Avanis <hola@avanis.es>", destEmail),

        Arrays.asList(
        new CustomPropertyEmail( "environment", subjectPrefix),
        new CustomPropertyEmail( "name", name),
        new CustomPropertyEmail( "tempPassword", tempPassword ))
          );
        hubspotService.sendMail(email);
    }
}
