package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.CustomPropertyEmail;
import hubspot.model.mails.EmailProperties;
import hubspot.model.mails.HubspotEmail;
import hubspot.model.mails.LoginRequestEmailProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(immediate = true, service = SendLoginRequestCreatedEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendLoginRequestCreated"})
public class SendLoginRequestCreatedEmailUseCase {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Reference
private HubspotService hubspotService;

    public void sendLoginRequestCreated(){
        System.out.println("sendLoginRequestCreated");

    }

    void execute(LoginRequestEmailProperties loginRequestEmailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "101363915232";


        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", loginRequestEmailProperties.getUserEmail()),
        Arrays.asList(
        new CustomPropertyEmail("environment",  subjectPrefix),
        new CustomPropertyEmail("loginLink",  loginRequestEmailProperties.getLoginUrl()),
        new CustomPropertyEmail("name",  loginRequestEmailProperties.getName())


        ));
        hubspotService.sendMail(email);
    }

}
