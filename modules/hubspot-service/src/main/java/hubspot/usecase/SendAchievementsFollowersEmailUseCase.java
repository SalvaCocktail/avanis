package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.*;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(immediate = true, service = SendAchievementsFollowersEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendAchievementsFollowers"})
public class SendAchievementsFollowersEmailUseCase {

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Reference
private HubspotService hubspotService;

    public void sendAchievementsFollowers(){
        System.out.println("sendAchievementsFollowers");
        AchievementFollowersMailProperties achievementFollowersMailProperties = new AchievementFollowersMailProperties();
        achievementFollowersMailProperties.setName("Jose");
        achievementFollowersMailProperties.setNumberFollowersOrIterations(10);
        achievementFollowersMailProperties.setUserEmail("jose.hermo@the-cocktail.com");
        execute(achievementFollowersMailProperties);
    }

    void execute(AchievementFollowersMailProperties achievementFollowersMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108203783918";

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", achievementFollowersMailProperties.getUserEmail()),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("numberFollowers", achievementFollowersMailProperties.getNumberFollowersOrIterations().toString()),
                        new CustomPropertyEmail( "name", achievementFollowersMailProperties.getName())

                ));

        hubspotService.sendMail(email);
    }
}
