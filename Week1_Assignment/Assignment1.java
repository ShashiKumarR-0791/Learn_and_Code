import java.util.Scanner;

public class CountryAdjacent {

    public static void main(String[] args) {
        String[][] countries = {
            {"IN", "Pakistan", "China", "Nepal", "Bangladesh", "Myanmar"},
            {"US", "Canada", "Mexico"},
            {"BR", "Suriname", "French Guiana", "Peru", "Bolivia", "Paraguay"},
            {"BT", "China", "India"},
            {"TJ", "Kyrgyzstan", "Uzbekistan", "Afghanistan", "China"},
            {"SO", "Djibouti", "Ethiopia", "Kenya"},
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the country code (e.g., IN, US, NZ): ");
        String countryCode = scanner.nextLine().toUpperCase().trim();

        boolean found = false;
        for (String[] country : countries) {
            if (country[0].equals(countryCode)) {
                found = true;
                System.out.println("Adjacent countries to " + countryCode + ":");
                for (int i = 1; i < country.length; i++) {
                    System.out.println(country[i]);
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Country code not found or no adjacent countries available.");
        }
        scanner.close();
    }
}
