package atm;

class ATMException extends Exception {
    public ATMException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends ATMException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class ServerConnectionException extends ATMException {
    public ServerConnectionException(String message) {
        super(message);
    }
}

class CardBlockedException extends ATMException {
    public CardBlockedException(String message) {
        super(message);
    }
}

class DailyLimitExceededException extends ATMException {
    public DailyLimitExceededException(String message) {
        super(message);
    }
}

