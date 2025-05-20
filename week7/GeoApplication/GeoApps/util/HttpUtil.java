package GeoApplication.GeoApps.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static String sendGetWithUserAgent(String urlStr) throws Exception {
        StringBuilder response = new StringBuilder();
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "GeocodeApp/1.0 (your_email@example.com)");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Server returned HTTP response code: " + responseCode + " for URL: " + urlStr);
        }

        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }
}
