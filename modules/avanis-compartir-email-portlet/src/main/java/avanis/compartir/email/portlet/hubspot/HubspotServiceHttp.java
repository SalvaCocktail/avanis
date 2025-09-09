package avanis.compartir.email.portlet.hubspot;

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

    private final String HUBSPOT_API_KEY = PropsUtil.get("hubspot.apiKey");
    private final ObjectMapper jacksonMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    private final Log _log = LogFactoryUtil.getLog(HubspotServiceHttp.class);
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");
    private final String FORMS_URL = PropsUtil.get("hubspot.formsUrl");
    private final String BASE_URL = PropsUtil.get("hubspot.baseUrl");

    public void sendMail(HubspotEmail email) {
        try {
            String url = BASE_URL + "/email/public/v1/singleEmail/send";
            String data = jacksonMapper.writeValueAsString(email);

            String filteredData = data.replaceAll(",\"\\w+\":null", "");
            String filteredData2 = filteredData.replaceAll("\\{\"\\w+\":null,", "{");
            HttpResponse<String>  response = sendPostRequest(url, filteredData2);
        } catch (Exception e) {
            _log.error("There was an error while sending a mail", e);
        }
    }

    public void sendShareNewsEmailUseCase(String newsTitle,
                                          String newsSubtitle,
                                          Instant datePublishes,
                                          String imgUrl,
                                          String newsUrl,
                                          String message,
                                          String userEmail,
                                          String sendEmail) {

        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String principalEmail = "";
        String emailId = "100223720904";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", sendEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("TituloNoticia", newsTitle),
                        new CustomPropertyEmail("SubtituloNoticia", newsSubtitle),
                        new CustomPropertyEmail("FechaNoticia", dateFormatter.format(datePublishes.atZone(ZoneId.of("Europe/Madrid")))),
                        new CustomPropertyEmail("urlImagen", imgUrl),
                        new CustomPropertyEmail("EnlaceNoticia", newsUrl),
                        new CustomPropertyEmail("CorreoMensaje", message),
                        new CustomPropertyEmail("correoEnvio", userEmail)


                ));

        sendMail(email);


    }

    public void sendShareCommentsEmailUseCase(String replyUsername,
                                              String replyMessage,
                                              String messageProfileImage,
                                              String messageUrl,
                                              String message,
                                              String userEmail,
                                              String sendEmail) {

        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "111417381349";


        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", sendEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("replyUserName", replyUsername),
                        new CustomPropertyEmail("replyMsg", replyMessage),
                        new CustomPropertyEmail("profileImg", messageProfileImage),
                        new CustomPropertyEmail("messageUrl", messageUrl),

                        new CustomPropertyEmail("CorreoMensaje", message),
                        new CustomPropertyEmail("correoEnvio", userEmail)


                ));

        sendMail(email);


    }

    public void sendShareEventEmailUseCase(String eventName,
                                            String eventDay,
                                            String eventHour,
                                            String eventType,
                                            String eventUrl,
                                            String eventLocation,
                                            String shareMsg,
                                            String userEmail,
                                            String sendEmail) {

        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String principalEmail = "";
        String emailId = "108977530825";

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", sendEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("eventName", eventName),
                        new CustomPropertyEmail("eventDay", eventDay),
                        new CustomPropertyEmail("eventHour", eventHour),
                        new CustomPropertyEmail("eventType", eventType),
                        new CustomPropertyEmail("eventUrl", eventUrl),
                        new CustomPropertyEmail("eventLocation", eventLocation),
                        new CustomPropertyEmail("shareMsg", shareMsg),
                        new CustomPropertyEmail("senderMail", userEmail),
                        new CustomPropertyEmail("receiverMail", sendEmail)
                ));

        sendMail(email);
    }

    public void sendShareSubsidyEmailUseCase(String subsidyName,
                                             String subsidyDate,
                                            String subsidyAmount,
                                            String subsidyCategories,
                                            String subsidyOrg,
                                            String subsidyUrl,
                                            String message,
                                            String userEmail,
                                            String sendEmail) {

        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String principalEmail = "";
        String emailId = "114711656124";

        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", sendEmail),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("subsidyName", subsidyName),
                        new CustomPropertyEmail("subsidyDate", subsidyDate),
                        new CustomPropertyEmail("subsidyAmount", subsidyAmount),
                        new CustomPropertyEmail("subsidyCategories", subsidyCategories),
                        new CustomPropertyEmail("subsidyOrg", subsidyOrg),
                        new CustomPropertyEmail("subsidyUrl", subsidyUrl),
                        new CustomPropertyEmail("shareMsg", message),
                        new CustomPropertyEmail("senderMail", userEmail),
                        new CustomPropertyEmail("receiverMail", sendEmail)
                ));

        sendMail(email);
    }

    private HttpResponse<String> sendPostRequest(String uri, String body) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        if (_log.isDebugEnabled()) {
            _log.debug("uri : " + uri);
            _log.debug("body : " + body);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers("Content-Type", "application/json", "authorization", "Bearer " + HUBSPOT_API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
