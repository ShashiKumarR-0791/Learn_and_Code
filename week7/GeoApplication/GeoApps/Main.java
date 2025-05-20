package GeoApplication.GeoApps;

import GeoApplication.GeoApps.controller.GeocodingController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GeocodingController controller = new GeocodingController();

        System.out.print("Enter place name: ");
        String place = scanner.nextLine();

        controller.getCoordinates(place);
    }
}

