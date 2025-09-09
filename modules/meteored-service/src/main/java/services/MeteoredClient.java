package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MeteoredClient {
    private static final String DOMAIN = "https://api.meteored.com";
    private static final String API_KEY = "5d8c39fb7ba6c45fb1408aaf5b4d76ecb77f509e6385d2851d0505272a592ef6";

    private static Log _log = LogFactoryUtil.getLog(MeteoredClient.class);

    public static HttpResponse<String> sendGetRequest(String path) {
        HttpClient client = HttpClient.newHttpClient();

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(DOMAIN + path))
                    .header("x-api-key", API_KEY)
                    .GET()
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException | URISyntaxException e) {
            _log.error(e);
            return null;
        }


    }
}
