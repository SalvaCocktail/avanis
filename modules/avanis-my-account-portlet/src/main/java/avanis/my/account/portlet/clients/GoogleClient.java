package avanis.my.account.portlet.clients;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoogleClient {

    private static final String DOMAIN = "https://oauth2.googleapis.com";
    private static Log _log = LogFactoryUtil.getLog(GoogleClient.class);


    public static HttpResponse<String> sendPost(String path) {
        HttpClient client = HttpClient.newHttpClient();

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(DOMAIN + path))
                    .header("content-type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException | URISyntaxException e) {
            _log.error(e);
            return null;
        }


    }
}
