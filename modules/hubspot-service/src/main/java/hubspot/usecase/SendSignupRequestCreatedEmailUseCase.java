package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.CustomPropertyEmail;
import hubspot.model.mails.EmailProperties;
import hubspot.model.mails.HubspotEmail;
import hubspot.model.mails.SignupRequestMailProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(immediate = true, service = SendSignupRequestCreatedEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendSignupRequestCreated"})
public class SendSignupRequestCreatedEmailUseCase {
    @Reference
private HubspotService hubspotService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    public void sendSignupRequestCreated(){
        System.out.println("sendSignupRequestCreated");
        SignupRequestMailProperties signupRequestMailProperties = new SignupRequestMailProperties();
        signupRequestMailProperties.setName("Jose");
        signupRequestMailProperties.setUserEmail("jose.hermo@the-cocktail.com");
        signupRequestMailProperties.setSignupUrl("https://url");
        //execute(signupRequestMailProperties);
    }

    public void execute(String userEmail,
    String name,
    String signupUrl) {

        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "96339984073";

        HubspotEmail sendNewAccountEmail = new HubspotEmail(
            emailId,
            new EmailProperties( "Avanis <hola@avanis.es>", userEmail),

        Arrays.asList(
        new CustomPropertyEmail( "environment",  subjectPrefix),
        new CustomPropertyEmail( "name",  name),
        new CustomPropertyEmail( "signUpUrl",  signupUrl)

        ));
        hubspotService.sendMail(sendNewAccountEmail);
    }
}
