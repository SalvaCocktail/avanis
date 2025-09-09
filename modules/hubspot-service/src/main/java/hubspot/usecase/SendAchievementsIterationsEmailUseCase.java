package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.*;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component(immediate = true, service = SendAchievementsIterationsEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendAchievementsIterations"})
public class SendAchievementsIterationsEmailUseCase {

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Reference
    private HubspotService hubspotService;

    public void sendAchievementsIterations(){
        System.out.println("sendAchievementsIterations");
        AchievementIterationsMailProperties achievementIterationsMailProperties = new AchievementIterationsMailProperties();
        achievementIterationsMailProperties.setName("Jose");
        achievementIterationsMailProperties.setNumIterations(10);
        achievementIterationsMailProperties.setNumComments(5);
        achievementIterationsMailProperties.setNumLikes(5);
        achievementIterationsMailProperties.setUserEmail("jose.hermo@the-cocktail.com");
        achievementIterationsMailProperties.setPublicationDate(Instant.now());
        achievementIterationsMailProperties.setPublicationTitle("Test publication");
        execute(achievementIterationsMailProperties);
    }

    void execute(AchievementIterationsMailProperties achievementIterationsMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108203806939";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", achievementIterationsMailProperties.getUserEmail()),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("publicationTitle", achievementIterationsMailProperties.getPublicationTitle()),
                        new CustomPropertyEmail("numberIterations", achievementIterationsMailProperties.getNumIterations().toString()),
                        new CustomPropertyEmail("numComments", achievementIterationsMailProperties.getNumComments().toString()),
                        new CustomPropertyEmail("numLikes", achievementIterationsMailProperties.getNumLikes().toString()),
                        new CustomPropertyEmail( "name", achievementIterationsMailProperties.getName()),
                        new CustomPropertyEmail("messageUrl", achievementIterationsMailProperties.getUrlPost()),
                        new CustomPropertyEmail( "publicationDate",  dateFormatter.format(achievementIterationsMailProperties.getPublicationDate().atZone(ZoneId.of("Europe/Madrid"))))
                ));

        hubspotService.sendMail(email);
    }
}
