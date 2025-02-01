class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount();
        savings.accountNumber = "9876543210";
        savings.accountHolder = "Alice Smith";
        savings.setBalance(1500.75);

        savings.displayAccountInfo();
        System.out.println("Balance: $" + savings.getBalance());
    }
}
