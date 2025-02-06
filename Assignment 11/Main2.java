import java.util.ArrayList;
import java.util.HashMap;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
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

    public double getBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalances() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            account.displayAccountDetails();
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}

class Bank {
    private String bankName;
    private HashMap<String, Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    public void openAccount(Customer customer, String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        customer.addAccount(account);
    }

    public void displayAllCustomers() {
        System.out.println("Bank: " + bankName);
        for (String customerName : customers.keySet()) {
            System.out.println("Customer: " + customerName);
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        Bank bank = new Bank("XYZ Bank");

        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        bank.openAccount(customer1, "A12345", 1000);
        bank.openAccount(customer1, "A67890", 1500);
        bank.openAccount(customer2, "B98765", 500);

        customer1.viewBalances();
        System.out.println();
        customer2.viewBalances();

        customer1.getAccounts().get(0).deposit(200);
        customer2.getAccounts().get(0).withdraw(50);

        System.out.println("\nUpdated Balances:");
        customer1.viewBalances();
        System.out.println();
        customer2.viewBalances();
    }
}
