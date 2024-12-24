import java.util.Random;
import java.util.Scanner;

public class numberGuessingGame {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static boolean validInput(String guessNumber) {
        try {
            int guessValue = Integer.parseInt(guessNumber);
            return guessValue >= MIN_VALUE && guessValue <= MAX_VALUE;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static int generateNumber() {
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
    }

    public static String getGuess(Scanner scanner) {
        System.out.print("Guess a number between " + MIN_VALUE + " and " + MAX_VALUE + ": ");
        return scanner.nextLine();
    }

    public static boolean processGuess(String guessedNumber, int generatedNumber, int retryCount) {
        int guess = Integer.parseInt(guessedNumber);
        
        if (guess < generatedNumber) {
            System.out.println("Too low. Guess again.");
            return false;
        } else if (guess > generatedNumber) {
            System.out.println("Too High. Guess again.");
            return false;
        } else {
            System.out.println("You guessed it in " + retryCount + " guesses!");
            return true;
        }
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        int generatedNumber = generateNumber();
        int retryCount = 0;
        boolean retryRequired = false;

        while (!retryRequired) {
            String guessNumber = getGuess(scanner);

            if (!validInput(guessNumber)) {
                System.out.println("I won't count this one. Please enter a number between 1 and 100.");
                continue;
            }

            retryRequired = processGuess(guessNumber, generatedNumber, retryCount);
            retryCount++;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        startGame();
    }
}