package GeoApplication.GeoApps.controller;

import GeoApplication.GeoApps.model.Location;
import GeoApplication.GeoApps.service.GeocodingService;

public class GeocodingController {

    private final GeocodingService geocodingService;

    public GeocodingController() {
        this.geocodingService = new GeocodingService();
    }

    public void getCoordinates(String place) {
        try {
            Location location = geocodingService.fetchCoordinates(place);
            if (location != null) {
                System.out.println("Latitude: " + location.getLatitude());
                System.out.println("Longitude: " + location.getLongitude());
            } else {
                System.out.println("Location not found.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
