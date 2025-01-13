package com.tumblr;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
 
public class TumblrApi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Asking user for Tumblr blog name, start and end range values
            System.out.print("Enter the Tumblr blog name: ");
            String blogName = scanner.nextLine().trim();
 
            System.out.print("Enter the range start: ");
            int start = scanner.nextInt();
 
            System.out.print("Enter the range end: ");
            int end = scanner.nextInt();
 
            if (start >= end || start < 0) {
                System.out.println("Invalid range. Make sure start is less than end and non-negative.");
                return;
            }
 
            int num = end - start; 
            // Construct the Tumblr API URL using the blog name and the start and end range
            String tumblrApiUrl = "https://" + blogName + ".tumblr.com/api/read/json?type=photo&num=" + num + "&start=" + start;
 
            try {
                // Used to Fetch the API response as a string
                String jsonResponse = fetchAPIResponse(tumblrApiUrl);
 
                // Cleaning the response string to extract the actual JSON data
                String json = jsonResponse.replace("var tumblr_api_read = ", "").replaceAll(";$", "");
 
                // Parsingg the cleaned-up JSON data
                JSONObject tumblrApiResponse = new JSONObject(json);
 
                displayTumblrApiResponse(start, tumblrApiResponse);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("An error occurred while fetching data from the API. Please check the blog name or range and try again.");
            }
        }
    }
 
    private static void displayTumblrApiResponse(int start, JSONObject tumblrApiResponse) {
        JSONObject tumblelog = tumblrApiResponse.getJSONObject("tumblelog");
        System.out.println("\nTitle: " + tumblelog.getString("title"));
        System.out.println("Name: " + tumblelog.getString("name"));
        System.out.println("Description: " + tumblelog.getString("description"));
        System.out.println("No of posts: " + tumblrApiResponse.getInt("posts-total"));
 
        JSONArray posts = tumblrApiResponse.getJSONArray("posts");
        for (int i = 0; i < posts.length(); i++) {
            JSONObject post = posts.getJSONObject(i);
            System.out.println("\nPost " + (start + i) + ":");
            if (post.has("photos")) {
                JSONArray photos = post.getJSONArray("photos");
                for (int j = 0; j < photos.length(); j++) {
                    JSONObject photo = photos.getJSONObject(j);
                    System.out.println(photo.getString("photo-url-1280"));
                }
            } else {
                System.out.println("No images available.");
            }
        }
    }
 
    private static String fetchAPIResponse(String apiUrl) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
 
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Failed to fetch data. HTTP response code: " + responseCode);
        }
 
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }
}
