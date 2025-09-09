package avanis.comunidad.portlet.hubspot;

import avanis.comunidad.portlet.hubspot.model.email.MentionsAndTagMailProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component(immediate = true, service = HubspotService.class)
public class HubspotServiceHttp implements HubspotService {

    private static final String HUBSPOT_API_KEY = PropsUtil.get("hubspot.apiKey");
    private static final ObjectMapper jacksonMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    private static final Log _log = LogFactoryUtil.getLog(HubspotServiceHttp.class);
    private static final String ENVIRONMENT = PropsUtil.get("portal.environment");
    private final String FORMS_URL = PropsUtil.get("hubspot.formsUrl");
    private static final String BASE_URL = PropsUtil.get("hubspot.baseUrl");

    public void sendMentionsAndTag(MentionsAndTagMailProperties mentionsAndTagMailProperties) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108188092884";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", mentionsAndTagMailProperties.getUserEmail()),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("publicationTitle", mentionsAndTagMailProperties.getPublicationTitle()),
                        new CustomPropertyEmail("userNameMentioning", mentionsAndTagMailProperties.getUsernameMentioning()),
                        new CustomPropertyEmail("publicationMsg", mentionsAndTagMailProperties.getPublicationMsg()),
                        new CustomPropertyEmail("profileImg", mentionsAndTagMailProperties.getMentionProfileImgUrl()),
                        new CustomPropertyEmail("name", mentionsAndTagMailProperties.getName()),
                        new CustomPropertyEmail("messageUrl", mentionsAndTagMailProperties.getUrlPost()),
                        new CustomPropertyEmail("hashtags", mentionsAndTagMailProperties.getHashtags()),
                        new CustomPropertyEmail("publicationDate", dateFormatter.format(mentionsAndTagMailProperties.getPublicationDate().atZone(ZoneId.of("Europe/Madrid"))))
                ));

        sendMail(email);
    }


    public static void sendAchievementFollowerEmailUseCase(String userEmail, String name, Integer numberFollowersOrIterations) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108203783918";

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", userEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("numberFollowers", numberFollowersOrIterations.toString()),
                        new CustomPropertyEmail("name", name)

                ));

        sendMail(email);
    }

    public static void sendFirstInteractionComunidadEmailUseCase(String userEmail, String publicationTitle, String profileImageUrl, String replyUsername, String replyMsg, String name, String messageUrl) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "102698031093";


        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", userEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("publicationTitle", publicationTitle),
                        new CustomPropertyEmail("profileImg", profileImageUrl),
                        new CustomPropertyEmail("replyUserName", replyUsername),
                        new CustomPropertyEmail("replyMsg", replyMsg),
                        new CustomPropertyEmail("name", name),
                        new CustomPropertyEmail("messageUrl", messageUrl)
                ));

        sendMail(email);
    }


    public static void sendAchievementInteractionEmailUseCase(String userEmail, String name, String publicationTitle, Integer numIterations, Instant publicationDate, Integer numLikes, Integer numComments, String urlPost) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108203806939";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", userEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("publicationTitle", publicationTitle),
                        new CustomPropertyEmail("numberIterations", numIterations.toString()),
                        new CustomPropertyEmail("numComments", numComments.toString()),
                        new CustomPropertyEmail("numLikes", numLikes.toString()),
                        new CustomPropertyEmail("name", name),
                        new CustomPropertyEmail("messageUrl", urlPost),
                        new CustomPropertyEmail("publicationDate", dateFormatter.format(publicationDate.atZone(ZoneId.of("Europe/Madrid"))))
                ));

        sendMail(email);

    }


    public static void sendPollResultsEmailUseCase(String userEmail, String name, Long numVotes, String pollTitle, Integer winnerOption, Double percentage, String winnerOptionText, String urlPoll) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "108204537325";

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", userEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("name", name),
                        new CustomPropertyEmail("numVotes", numVotes.toString()),
                        new CustomPropertyEmail("pollTitle", pollTitle),
                        new CustomPropertyEmail("winnerOption", winnerOption.toString()),
                        new CustomPropertyEmail("percentage", percentage.toString()),
                        new CustomPropertyEmail("winnerOptionText", winnerOptionText),
                        new CustomPropertyEmail("messageUrl", urlPoll)

                ));

        sendMail(email);

    }


    public static void sendMail(HubspotEmail email) {
        try {
            String url = BASE_URL + "/email/public/v1/singleEmail/send";
            String data = jacksonMapper.writeValueAsString(email);

            String filteredData = data.replaceAll(",\"\\w+\":null", "");
            String filteredData2 = filteredData.replaceAll("\\{\"\\w+\":null,", "{");
            sendPostRequest(url, filteredData2);
        } catch (Exception e) {
            _log.error("There was an error while sending a mail", e);
        }
    }

    private static HttpResponse<String> sendPostRequest(String uri, String body) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers("Content-Type", "application/json", "authorization", "Bearer " + HUBSPOT_API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
