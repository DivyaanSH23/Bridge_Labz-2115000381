import java.util.*;

public class BankingSystem {
    private Map<String, Double> accountBalances = new HashMap<>();
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void createAccount(String accountNumber, double balance) {
        accountBalances.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double newBalance = accountBalances.get(accountNumber) + amount;
            sortedAccounts.remove(accountBalances.get(accountNumber));
            accountBalances.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        }
    }

    public void requestWithdrawal(String accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accountBalances.get(accountNumber) >= amount) {
                double newBalance = accountBalances.get(accountNumber) - amount;
                sortedAccounts.remove(accountBalances.get(accountNumber));
                accountBalances.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber);
                System.out.println("Withdrawal of $" + amount + " processed for account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account: " + accountNumber);
            }
        }
    }

    public Map<String, Double> getAccounts() {
        return accountBalances;
    }

    public Map<Double, String> getSortedAccounts() {
        return sortedAccounts;
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount("A001", 5000);
        bank.createAccount("A002", 3000);
        bank.createAccount("A003", 7000);
        
        bank.deposit("A002", 2000);
        
        bank.requestWithdrawal("A001");
        bank.requestWithdrawal("A003");
        
        bank.processWithdrawals(1000);
        
        System.out.println("All Accounts: " + bank.getAccounts());
        System.out.println("Sorted Accounts by Balance: " + bank.getSortedAccounts());
    }
}
