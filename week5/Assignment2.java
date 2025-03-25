/***
 * Yes, there is a better way to write the Customer class and its interaction with the Wallet. 
 * The main concern with the current design is that it exposes the Wallet directly to the client code, which violates the principle of encapsulation
 ***/
// Customer.java
public class Customer {
    private String firstName;
    private String lastName;
    private Wallet myWallet;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.myWallet = new Wallet();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean canMakePayment(float amount) {
        return myWallet.getTotalMoney() >= amount;
    }

    public void makePayment(float amount) {
        if (canMakePayment(amount)) {
            myWallet.subtractMoney(amount);
        } else {
            System.out.println("Insufficient funds! Come back later.");
        }
    }

    public void addMoneyToWallet(float amount) {
        myWallet.addMoney(amount);
    }

    public float checkWalletBalance() {
        return myWallet.getTotalMoney();
    }
}

// Wallet.java
public class Wallet {
    private float value;

    public Wallet() {
        this.value = 0.0f; 
    }

    public float getTotalMoney() {
        return value;
    }

    public void setTotalMoney(float newValue) {
        value = newValue;
    }

    public void addMoney(float deposit) {
        value += deposit;
    }

    public void subtractMoney(float debit) {
        value -= debit;
    }
}

// Main.java
public class Main {

    public static void main(String[] args) {
        Customer myCustomer = new Customer("John", "Doe");
        
        myCustomer.addMoneyToWallet(5.00f);  
        
        float payment = 2.00f; 

        if (myCustomer.canMakePayment(payment)) {
            myCustomer.makePayment(payment); 
            System.out.println("Payment of " + payment + " made successfully!");
        } else {
            System.out.println("Insufficient funds! Come back later.");
        }
    }
}
//now the changes gives better encapsulation to the code, now the Customer class no longer exposes the Wallet directly to external code.
//the addMoneyToWallet(float amount) is providing to allow adding money to the wallet and checkWalletBalance() allows checking the wallet balance but does not expose the Wallet directly.
// makePayment is also checking whether there is enough amount as well