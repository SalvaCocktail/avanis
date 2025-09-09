package hubspot.usecase;

import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.*;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(immediate = true, service = SendPollResultsEmailUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendPollResults"})
public class SendPollResultsEmailUseCase {
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Reference
private HubspotService hubspotService;

    public void sendPollResults(){
        System.out.println("sendPollResults");
    }
    void execute(PollResultsMailProperties pollResultsMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108204537325";

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", pollResultsMailProperties.getUserEmail()),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("numVotes", pollResultsMailProperties.getNumVotes()),
                        new CustomPropertyEmail("pollTitle", pollResultsMailProperties.getPollTitle()),
                        new CustomPropertyEmail("percentage", pollResultsMailProperties.getPercentage().toString()),
                        new CustomPropertyEmail("winnerOption", pollResultsMailProperties.getWinnerOption()),
                        new CustomPropertyEmail( "name", pollResultsMailProperties.getName()),
                        new CustomPropertyEmail("winnerOptionText", pollResultsMailProperties.getWinnerOptionText()),
                        new CustomPropertyEmail("messageUrl", pollResultsMailProperties.getUrlPost())
                ));

        hubspotService.sendMail(email);
    }
}
