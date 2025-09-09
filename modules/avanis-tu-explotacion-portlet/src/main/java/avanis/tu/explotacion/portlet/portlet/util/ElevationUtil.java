package avanis.tu.explotacion.portlet.portlet.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElevationUtil {

    public static int getElevation(double latitude, double longitude) {
        int elevation = 0;
        try {
            // Construir la URL de la solicitud con los puntos decimales correctos
            String urlStr = "https://api.open-elevation.com/api/v1/lookup?locations=" + latitude + "," + longitude;

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            // Parsear la respuesta JSON
            JSONObject jsonResponse = new JSONObject(content.toString());
            JSONArray results = jsonResponse.getJSONArray("results");
            if (results.length() > 0) {
                elevation = results.getJSONObject(0).getInt("elevation");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return elevation;
    }
}
