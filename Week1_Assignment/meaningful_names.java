//Please add the meaningful names to the given programs
//Assignment 1: The below program is to Roll the Diceimport java.util.Random;
import java.util.Scanner;

public class RollerDice{
    public static int generateRandomInteger(int count) {
        Random random = new Random();
        return random.nextInt(count) + 1; 
    }

    public static void main(String[] args) {
        int totalDiceFaces = 6;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while (flag) {
            System.out.print("Ready to roll? Enter Q to Quit: ");
            String userEntry = scanner.nextLine();

            if (!userEntry.equalsIgnoreCase("q")) {
                int n = generateRandomInteger(totalDiceFaces);
                System.out.println("You have rolled a " + n);
            } else {
                flag = false; 
            }
        }

        scanner.close();
    }
}


//Assignment 2: The below program is to guess the correct number between 1 to 100
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static boolean numberValidator(String guessedNumber) {
        try {
            int number = Integer.parseInt(guessedNumber);
            return number >= 1 && number <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 
        boolean gameNotOver = false;
        Scanner scanner = new Scanner(System.in);
        int numberOfGuesses = 0;
        
        System.out.print("Guess a number between 1 and 100: ");
        String guess = scanner.nextLine();

        while (!gameNotOver) {
            if (!numberValidator(guess)) {
                System.out.print("I won't count this one. Please enter a number between 1 and 100: ");
                guess = scanner.nextLine();
                continue;
            } else {
                numberOfGuesses++;
                int guessedNumber = Integer.parseInt(guess);

                if (guessedNumber < randomNumber) {
                    System.out.print("Too low. Guess again: ");
                } else if (guessedNumber > randomNumber) {
                    System.out.print("Too high. Guess again: ");
                } else {
                    System.out.println("You guessed it in " + numberOfGuesses + " guesses!");
                    gameNotOver = true; 
                }

                if (!gameNotOver) {
                    guess = scanner.nextLine();
                }
            }
        }

        scanner.close();
    }
}



//Assignment 3:The below program is to check whether the number is Armstrong number or not
import java.util.Scanner;

public class ArmstrongNumber {
    public static int validatorForArmstrong(int number) {
        int sumOfAllPowers = 0;
        int numberDigits = 0;

        int temporaryNumber = number;
        while (temporaryNumber > 0) {
            numberDigits++;
            temporaryNumber /= 10;
        }

        temporaryNumber = number;
        while (temporaryNumber > 0) {
            int reminder = temporaryNumber % 10;
            sumOfAllPowers += Math.pow(reminder, numberDigits);
            temporaryNumber /= 10;
        }
        return sumOfAllPowers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease Enter the Number to Check for Armstrong: ");
        int inputNumber = scanner.nextInt();

        if (inputNumber == validatorForArmstrong(inputNumber)) {
            System.out.println("\n" + inputNumber + " is an Armstrong Number.\n");
        } else {
            System.out.println("\n" + inputNumber + " is Not an Armstrong Number.\n");
        }

        scanner.close();  
    }
}
