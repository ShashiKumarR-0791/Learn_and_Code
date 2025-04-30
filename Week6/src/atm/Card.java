package atm;

class Card {
    private int pin;
    private int attempts;
    private boolean isBlocked;

    public Card(int pin) {
        this.pin = pin;
        this.attempts = 0;
        this.isBlocked = false;
    }

    public void validatePin(int inputPin) throws CardBlockedException {
        if (isBlocked) {
            throw new CardBlockedException("Card is blocked due to multiple invalid attempts.");
        }

        if (this.pin == inputPin) {
            attempts = 0; 
        } else {
            attempts++;
            if (attempts >= 3) {
                isBlocked = true;
                throw new CardBlockedException("Card is blocked after 3 invalid PIN attempts.");
            } else {
                throw new CardBlockedException("Invalid PIN. Attempts left: " + (3 - attempts));
            }
        }
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
