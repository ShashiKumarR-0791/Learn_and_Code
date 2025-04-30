package atm;

class Account {
    private double balance;
    private double dailyLimit;
    private double withdrawnToday;

    public Account(double balance, double dailyLimit) {
        this.balance = balance;
        this.dailyLimit = dailyLimit;
        this.withdrawnToday = 0;
    }

    public void withdraw(double amount) throws InsufficientFundsException, DailyLimitExceededException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in account.");
        }
        if ((withdrawnToday + amount) > dailyLimit) {
            throw new DailyLimitExceededException("Daily withdrawal limit exceeded.");
        }
        balance -= amount;
        withdrawnToday += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void resetDailyLimit() {
        withdrawnToday = 0;
    }
}