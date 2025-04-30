package atm;

class ATM {
    private double cashAvailable;
    private BankServer server;

    public ATM(double initialCash, BankServer server) {
        this.cashAvailable = initialCash;
        this.server = server;
    }

    public void withdraw(Card card, Account account, int inputPin, double amount)
            throws ATMException {
        if (!server.isConnected()) {
            throw new ServerConnectionException("Unable to connect to bank server.");
        }

        card.validatePin(inputPin);

        if (amount > cashAvailable) {
            throw new InsufficientFundsException("ATM has insufficient cash.");
        }

        account.withdraw(amount);
        cashAvailable -= amount;

        System.out.println("Withdrawal successful. Please collect your cash.");
    }

    public double getCashAvailable() {
        return cashAvailable;
    }
}
