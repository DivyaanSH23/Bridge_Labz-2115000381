import java.util.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    public static void main(String[] args) {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();
        Map<String, Integer> policyCount = new HashMap<>();

        List<Policy> policies = Arrays.asList(
                new Policy("P1001", "Alice", new Date(2025, 6, 10), "Health", 500.0),
                new Policy("P1002", "Bob", new Date(2025, 5, 5), "Auto", 800.0),
                new Policy("P1003", "Charlie", new Date(2025, 4, 20), "Home", 1200.0),
                new Policy("P1001", "Alice", new Date(2025, 6, 10), "Health", 500.0)
        );

        for (Policy policy : policies) {
            hashSet.add(policy);
            linkedHashSet.add(policy);
            treeSet.add(policy);
            policyCount.put(policy.policyNumber, policyCount.getOrDefault(policy.policyNumber, 0) + 1);
        }

        System.out.println("All Unique Policies:");
        hashSet.forEach(System.out::println);

        System.out.println("\nPolicies Expiring Soon:");
        Date now = new Date();
        for (Policy policy : treeSet) {
            if ((policy.expiryDate.getTime() - now.getTime()) / (1000 * 60 * 60 * 24) <= 30) {
                System.out.println(policy);
            }
        }

        System.out.println("\nPolicies with Coverage Type: Auto");
        for (Policy policy : hashSet) {
            if (policy.coverageType.equals("Auto")) {
                System.out.println(policy);
            }
        }

        System.out.println("\nDuplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey());
            }
        }

        long start, end;

        start = System.nanoTime();
        hashSet.add(new Policy("P1004", "David", new Date(2025, 7, 15), "Health", 600.0));
        end = System.nanoTime();
        System.out.println("\nHashSet Add Time: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.add(new Policy("P1005", "Eve", new Date(2025, 8, 25), "Home", 900.0));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start));

        start = System.nanoTime();
        treeSet.add(new Policy("P1006", "Frank", new Date(2025, 3, 30), "Auto", 1100.0));
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start));

        start = System.nanoTime();
        hashSet.contains(new Policy("P1001", "", new Date(), "", 0));
        end = System.nanoTime();
        System.out.println("\nHashSet Search Time: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.contains(new Policy("P1001", "", new Date(), "", 0));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start));

        start = System.nanoTime();
        treeSet.contains(new Policy("P1001", "", new Date(), "", 0));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start));
    }
}
