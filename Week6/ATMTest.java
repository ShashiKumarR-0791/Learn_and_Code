package atm;

import java.util.Scanner;

public class ATMTest {
    public static void main(String[] args) {
        BankServer server = new BankServer();
        ATM atm = new ATM(1000.0, server);
        Account account = new Account(500.0, 300.0);
        Card card = new Card(1234);

        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        boolean authenticated = false;

        while (attempts < 3 && !authenticated) {
            System.out.print("Enter your PIN: ");
            int inputPin = scanner.nextInt();

            try {
                card.validatePin(inputPin);
                authenticated = true;
            } catch (CardBlockedException e) {
                System.err.println(e.getMessage());
                attempts++;
                if (card.isBlocked()) {
                    System.out.println("Card blocked. Exiting.");
                    scanner.close();
                    return;
                }
            }
        }

        while (authenticated) {
            System.out.println("\n1. Withdraw\n2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 2) {
                System.out.println("Thank you for using the ATM.");
                break;
            }

            if (choice == 1) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();

                try {
                    atm.withdraw(card, account, 1234, amount);
                    System.out.println("Remaining account balance: $" + account.getBalance());
                } catch (ATMException e) {
                    System.err.println("Transaction failed: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}

