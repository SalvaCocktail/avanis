package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.AlreadyRegisteredMailProperties;
import hubspot.model.mails.CustomPropertyEmail;
import hubspot.model.mails.EmailProperties;
import hubspot.model.mails.HubspotEmail;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(immediate = true, service = SendUserIsAlreadyRegisteredEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendUserIsAlreadyRegistered"})
public class SendUserIsAlreadyRegisteredEmailUseCase {

    @Reference
    private HubspotService hubspotService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    public void sendUserIsAlreadyRegistered() {
        System.out.println("sendUserIsAlreadyRegistered");
    }

    void execute(String userEmail,
                 String name,
                 String loginUrl,
                 String recoveryUrl) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "96339997168";


        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", userEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("name", name),
                        new CustomPropertyEmail("loginUrl", loginUrl),
                        new CustomPropertyEmail("passRecoveryUrl", recoveryUrl)

                ));
        hubspotService.sendMail(email);
    }
}
