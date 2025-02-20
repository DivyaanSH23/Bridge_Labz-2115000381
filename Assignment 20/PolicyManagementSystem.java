import java.util.*;
import java.time.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + expiryDate + " - " + coverageType + " - $" + premiumAmount;
    }
}

public class PolicyManagementSystem {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    TreeMap<LocalDate, Policy> sortedPolicyMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }

    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        for (Map.Entry<LocalDate, Policy> entry : sortedPolicyMap.entrySet()) {
            if (entry.getKey().isAfter(today) && entry.getKey().isBefore(threshold)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedPolicyMap.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
        policyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        orderedPolicyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
    }

    public static void main(String[] args) {
        PolicyManagementSystem manager = new PolicyManagementSystem();
        manager.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(20), "Health", 500.0));
        manager.addPolicy(new Policy("P002", "Alice Smith", LocalDate.now().plusDays(10), "Auto", 750.0));
        manager.addPolicy(new Policy("P003", "Bob Johnson", LocalDate.now().plusDays(40), "Home", 1000.0));
        
        System.out.println("Expiring Policies: " + manager.getExpiringPolicies());
        System.out.println("Policies for John Doe: " + manager.getPoliciesByHolder("John Doe"));
        
        manager.removeExpiredPolicies();
        System.out.println("All Policies After Removal: " + manager.policyMap.values());
    }
}
