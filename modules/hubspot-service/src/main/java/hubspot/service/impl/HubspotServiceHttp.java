package hubspot.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsUtil;
import hubspot.model.mails.HubspotEmail;
import hubspot.model.forms.ResponseIsSubscribed;
import hubspot.model.forms.ResponseSearch;
import hubspot.model.forms.SubscriptionStatus;
import hubspot.service.api.HubspotService;
import hubspot.usecase.SendFormsUseCase;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component(immediate = true, service = HubspotService.class)
public class HubspotServiceHttp implements HubspotService {

    private final String HUBSPOT_API_KEY = PropsUtil.get("hubspot.apiKey");
    private final ObjectMapper jacksonMapper = new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final Log _log = LogFactoryUtil.getLog(HubspotServiceHttp.class);
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");
    private final String FORMS_URL = PropsUtil.get("hubspot.formsUrl");
    private final String BASE_URL = PropsUtil.get("hubspot.baseUrl");


    @Override
    public void sendFormData(String data, String portalId, String formGuid) {
        if ("production".equals(ENVIRONMENT)) {
            String url = FORMS_URL + "/" + portalId + "/" + formGuid;
            try {
                sendPostRequest(url, data);
            } catch (URISyntaxException | IOException | InterruptedException e) {
                _log.error("There was an error while sending a form data", e);
            }
        }
    }

    @Override
    public void subscribeNewsletter(String email, String subscriptionId) {
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


    @Override
    public void unsubscribeNewsletter(String email, String subscriptionId) {
        if ("production".equals(ENVIRONMENT)) {
            String url = BASE_URL + "/communication-preferences/v3/unsubscribe";
            String data = "{\n" +
                    "           \"emailAddress\": \" " + email + "\",\n" +
                    "          \"legalBasis\": \"LEGITIMATE_INTEREST_CLIENT\",\n" +
                    "          \"subscriptionId\": \"" + subscriptionId + "\",\n" +
                    "          \"legalBasisExplanation\": \"A petición del usuario\"\n" +
                    "}";
            try {
                sendPostRequest(url, data);
                invalidateRenewingForm(email);
            } catch (URISyntaxException | IOException | InterruptedException e) {
                _log.error("There was an error while sending a newsletter data", e);
                invalidateRenewingForm(email);
            }
        }
    }


    @Override
    public void sendMail(HubspotEmail email) {
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


    @Override
    public boolean isSubscribed(String email, String subscriptionId) {
        if ("production".equals(ENVIRONMENT)) {
            String url = BASE_URL + "/communication-preferences/v3/status/email/" + email;

            try {
                HttpResponse<String> response = sendGetRequest(url);
                ResponseIsSubscribed subscriptionStatus = jacksonMapper.readValue(response.body(), ResponseIsSubscribed.class);
                Optional<SubscriptionStatus> subsStats = subscriptionStatus.getSubscriptionStatuses().stream().filter(susStatus -> Objects.equals(susStatus.getId(), subscriptionId)).findFirst();

                return subsStats.isPresent() && Objects.equals(subsStats.get().getStatus(), "SUBSCRIBED") || this.isRenewingSubscription(email);
            } catch (URISyntaxException | IOException | InterruptedException e) {
                _log.error("there was an error while sending a newsletter data", e);
            }

        }
        return false;
    }


    @Override
    public boolean isRenewingSubscription(String email) {
        if ("production".equals(ENVIRONMENT)) {
            String url = BASE_URL + "/crm/v3/objects/contacts/search";
            String data = "{\n" +
                    "            \"filterGroups\":[\n" +
                    "            {\n" +
                    "                \"filters\":[\n" +
                    "                {\n" +
                    "                    \"propertyName\": \"email\",\n" +
                    "                        \"operator\": \"EQ\",\n" +
                    "                        \"value\": \"" + email + "\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"propertyName\": \"consentimiento_newsletter\",\n" +
                    "                        \"operator\": \"EQ\",\n" +
                    "                        \"value\": \"RESUSCRIBIR\"\n" +
                    "                }\n" +
                    "        ]\n" +
                    "            }\n" +
                    "    ]\n" +
                    "        }";

            try {
                HttpResponse<String> response = sendPostRequest(url, data);
                ResponseSearch responseSearch = jacksonMapper.readValue(response.body(), ResponseSearch.class);

                return responseSearch.getTotal() > 0;

            } catch (URISyntaxException | IOException | InterruptedException e) {
                _log.error("There was an error while sending a newsletter data", e);
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public void formAboutMe(String userEmail, String dedication, String agriculture, String stockBreeding, String sales,
                                     String transforming, String techAgrotech, String startups, String other, List<String> agricultureActivity, List<String> stockBreedingActivity) {
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
                "]" +
                "}";

        sendFormData(data,portalId,formGuid);
    }

    @Override
    public void formInterest(String userEmail, List<String> agricultureInterest, List<String> stockBreedingInterest, List<String> otherInterest) {
        String portalId = "144059530";
        String formGuid = "cf77fff7-f41f-4118-ab9f-e19fd8688df2";
        String data = "{" +
                "\"fields\":[" +
                addDataEmail(userEmail) +
                addDataString("agricultura___interes___all", String.join(",",agricultureInterest)) +
                addDataString("ganaderia___interes___all", String.join(",",stockBreedingInterest)) +
                addDataString("otros_interes___all", String.join(",",otherInterest)) +
                "]" +
                "}";

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

    private HttpResponse<String> sendGetRequest(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers("Content-Type", "application/json", "authorization", "Bearer " + HUBSPOT_API_KEY)
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }


    private void sendRenewingForm(String email) {
        String portalId = "144059530";
        String formGuid = "c8a77855-cc41-4756-823f-353bd4e18abd";
        String data = "{" +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("consentimiento_newsletter", "RESUSCRIBIR") +
                "]" +
                "}";
        this.sendFormData(data, portalId, formGuid);
    }

    private void invalidateRenewingForm(String email) {
        String portalId = "144059530";
        String formGuid = "c8a77855-cc41-4756-823f-353bd4e18abd";
        String data = "{" +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("consentimiento_newsletter", "DESUSCRITO") +
                "]" +
                "}";
        this.sendFormData(data, portalId, formGuid);
    }

    private String addDataEmail(String email) {
        return "{" +
                "\"objectTypeId\": \"0-1\"," +
                "\"name\": \"email\"," +
                "\"value\": \"" + email + "\"" +
                "}";
    }

    private String addDataString(String name, String value) {
        return value.isBlank() ? "" :
                ",{\n" +
                        "\"objectTypeId\": \"0-1\",\n" +
                        "\"name\": \"" + name + "\",\n" +
                        "\"value\": \"" + value + "\"\n" +
                        "}";
    }

}

