package avanis.custom.login.hubspot;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component(immediate = true, service = HubspotService.class)
public class HubspotServiceHttp implements HubspotService{

    private  final String HUBSPOT_API_KEY = PropsUtil.get("hubspot.apiKey");
    private  final ObjectMapper jacksonMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    private  final Log _log = LogFactoryUtil.getLog(HubspotServiceHttp.class);
    private  final String ENVIRONMENT = PropsUtil.get("portal.environment");
    private  final String FORMS_URL =PropsUtil.get("hubspot.formsUrl");
    private  final String BASE_URL = PropsUtil.get("hubspot.baseUrl");

    public  void sendMail(HubspotEmail email) {
        try {
            String url = BASE_URL+"/email/public/v1/singleEmail/send";
            String data = jacksonMapper.writeValueAsString(email);
            _log.info("Sending email to " + url);
            String filteredData = data.replaceAll(",\"\\w+\":null", "");
            String filteredData2 = filteredData.replaceAll("\\{\"\\w+\":null,", "{");
            sendPostRequest(url, filteredData2);
        } catch (Exception e) {
            _log.error("There was an error while sending a mail", e);
        }
    }

    @Override
    public void sendPasswordResetEmailUseCase(String destEmail, String name, String urlEmailResetPassToken) {
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "96345253881";


        HubspotEmail email = new HubspotEmail(
                emailId,
                new EmailProperties("Avanis <hola@avanis.es>", destEmail),

                Arrays.asList(
                        new CustomPropertyEmail( "environment", subjectPrefix),
                        new CustomPropertyEmail( "name", escapeHtml(name)),
                        new CustomPropertyEmail( "recoverUrl", urlEmailResetPassToken ))
        );
        sendMail(email);
    }

    @Override
    public void sendSignupRequestCreatedEmailUseCase(String userEmail,
                        String name,
                        String signupUrl) {

        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "96339984073";

        HubspotEmail sendNewAccountEmail = new HubspotEmail(
                emailId,
                new EmailProperties( "Avanis <hola@avanis.es>", userEmail),

                Arrays.asList(
                        new CustomPropertyEmail( "environment",  subjectPrefix),
                        new CustomPropertyEmail( "name",  escapeHtml(name)),
                        new CustomPropertyEmail( "signUpUrl",  signupUrl)

                ));

        sendMail(sendNewAccountEmail);
    }
    public void sendFormData(String data, String portalId, String formGuid) {
        if ("production".equals(ENVIRONMENT)) {
            String url = FORMS_URL+"/"+portalId+"/"+formGuid;
            try{
                sendPostRequest(url, data);
            } catch (URISyntaxException | IOException | InterruptedException e){
                _log.error("There was an error while sending a form data", e);
            }
        }

    }

    @Override
    public void formLoginUser(String email, String userId){
        String portalId = "144059530";
        String formGuid = "8e49d99f-6a5c-4e17-be66-a1797211dab4";
        String data = "{ " +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("id_usuario", userId) +
                addDataString("fecha_ultimo_login", getDateAsStringFormated(new Date()))+
                "]" +
                "}";
        sendFormData(data,portalId,formGuid);
    }

    @Override
    public void sendUserIsAlreadyRegistered(String userEmail,
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
                        new CustomPropertyEmail("name", escapeHtml(name)),
                        new CustomPropertyEmail("loginUrl", loginUrl),
                        new CustomPropertyEmail("passRecoveryUrl", recoveryUrl)

                ));
        sendMail(email);
    }

    @Override
    public void formSignupRequest(String email, String name, String surname, String phone, boolean allowNewsletter, String signupUrl){
        String portalId = "144059530";
        String formGuid = "c8a77855-cc41-4756-823f-353bd4e18abd";
        String data = "{" +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("firstname", escapeHtml(name)) +
                addDataString("lastname", escapeHtml(surname)) +
                addDataString("phone", phone) +
                addDataString("consentimiento_newsletter", allowNewsletter ? "SI" : "NO") +
                addDataString("crear_cuenta___formulario_1", "SI") +
                addDataString("enlace_univoco_de_registro", signupUrl) +
                addDataString("fecha_registro___paso_0", getDateAsStringFormated(new Date())) +
                "]" +
                "}";
        sendFormData(data,portalId,formGuid);
    }

    @Override
    public void subscribeNewsletter(String email) {
        String subscriptionId = "318144747";
        if ("production".equals(ENVIRONMENT)) {
            String url = BASE_URL + "/communication-preferences/v3/subscribe";

            String data = "{\n" +
                    "          \"emailAddress\": \"" + email + "\",\n" +
                    "          \"legalBasis\": \"LEGITIMATE_INTEREST_CLIENT\",\n" +
                    "          \"subscriptionId\": \"" + subscriptionId + "\",\n" +
                    "          \"legalBasisExplanation\": \"A petición del usuario\"\n" +
                    "}";
            try {
                HttpResponse<String> response = sendPostRequest(url, data);
                if (response.statusCode() >= 400) {
                    this.sendRenewingForm(email);
                }
            } catch (URISyntaxException | IOException | InterruptedException e) {
                _log.error("There was an error while sending a newsletter data", e);
                this.sendRenewingForm(email);
            }

        }
    }

    private void sendRenewingForm(String email) {
        String portalId = "144059530";
        String formGuid = "c8a77855-cc41-4756-823f-353bd4e18abd";
        String data = "{ " +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("consentimiento_newsletter", "RESUSCRIBIR") +
                "]" +
                "}";
        this.sendFormData(data, portalId, formGuid);
    }

    @Override
    public void formSignupUser(String email){
        String portalId = "144059530";
        String formGuid = "9d27296d-ff45-4d7a-82ba-50c5b02c5891";
        String data = "{ " +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("informacion_sobre_la_cuenta", "SI") +
                addDataString("fecha_validacion_cuenta", getDateAsStringFormated(new Date()))+
                "]" +
                "}";
        sendFormData(data,portalId,formGuid);
    }

    @Override
    public void formPreferencesSteps(String userEmail, String dedication, String agriculture, String stockBreeding, String sales,
                                     String transforming, String techAgrotech, String startups, String other, List<String> agricultureActivity, List<String> stockBreedingActivity, List<String> agricultureInterest, List<String> stockBreedingInterest, List<String> otherInterest) {
        String portalId = "144059530";
        String formGuid = "cf77fff7-f41f-4118-ab9f-e19fd8688df2";
        String data = "{" +
                "\"fields\":[" +
                addDataEmail(userEmail) +
                addDataString("rol_en_el_sector_agro", dedication) +
                addDataString("agricoltura___actividad", agriculture) +
                addDataString("ganaderia___actividad", stockBreeding) +
                addDataString("venta_de_productos_o_servicios___actividad", sales) +
                addDataString("industria_transformadora___actividad", transforming) +
                addDataString("startups__tecnologia_y_agrotech___actividad", techAgrotech) +
                addDataString("startups___actividad", startups) +
                addDataString("otro_sectores___actividad", other) +
                addDataString("subcategoria_agricultura___actividad___all", String.join(",",agricultureActivity)) +
                addDataString("subcategoria_ganaderia___actividad___all", String.join(",",stockBreedingActivity)) +
                addDataString("agricultura___interes___all", String.join(",",agricultureInterest)) +
                addDataString("ganaderia___interes___all", String.join(",",stockBreedingInterest)) +
                addDataString("otros_interes___all", String.join(",",otherInterest)) +
                "]" +
                "}";
        _log.info("Sending data to hubspot from interest: " + data);
        sendFormData(data,portalId,formGuid);
    }




    private HttpResponse<String> sendPostRequest(String uri, String body) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers("Content-Type", "application/json", "authorization", "Bearer " + HUBSPOT_API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
    private String addDataEmail(String email){
        return "{" +
                "\"objectTypeId\": \"0-1\"," +
                "\"name\": \"email\"," +
                "\"value\": \""+email+"\""+
                "}";
    }

    private String addDataString(String name, String value){
        return value.isBlank() ? "" :
                ",{\n" +
                        "\"objectTypeId\": \"0-1\",\n" +
                        "\"name\": \""+name+"\",\n" +
                        "\"value\": \""+value+"\"\n" +
                        "}";
    }
    private String getDateAsStringFormated(Date date ){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static String escapeHtml(String input) {
        return input.replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;");
    }


}
