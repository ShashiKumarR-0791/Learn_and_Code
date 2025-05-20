package GeoApplication.GeoApps.service;

import GeoApplication.GeoApps.model.Location;
import GeoApplication.GeoApps.util.HttpUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GeocodingService {

    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/search?q=%s&format=json&limit=1";

    public Location fetchCoordinates(String place) throws Exception {
        String url = String.format(NOMINATIM_URL, place.replace(" ", "+"));
        String response = HttpUtil.sendGetWithUserAgent(url);

        JsonArray results = JsonParser.parseString(response).getAsJsonArray();
        if (!results.isEmpty()) {
            JsonObject location = results.get(0).getAsJsonObject();
            double lat = Double.parseDouble(location.get("lat").getAsString());
            double lon = Double.parseDouble(location.get("lon").getAsString());
            return new Location(lat, lon);
        }

        return null;
    }
}
