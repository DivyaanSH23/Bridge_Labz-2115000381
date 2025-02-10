abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double loanAmount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class LoanAccount extends BankAccount implements Loanable {
    private double loanAmount;

    public LoanAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void applyForLoan(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000;
    }

    public double calculateInterest() {
        return 0;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SA101", "Alice", 5000),
            new CurrentAccount("CA102", "Bob", 2000),
            new LoanAccount("LA103", "Charlie", 3000)
        };

        for (BankAccount account : accounts) {
            System.out.println("\nAccount Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());

            account.deposit(1000);
            account.withdraw(500);

            double interest = account.calculateInterest();
            System.out.println("Interest: " + interest);

            if (account instanceof Loanable) {
                Loanable loanAccount = (Loanable) account;
                loanAccount.applyForLoan(1500);
                System.out.println("Loan Eligibility: " + loanAccount.calculateLoanEligibility());
            }
        }
    }
}
