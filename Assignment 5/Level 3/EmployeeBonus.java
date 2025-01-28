import java.util.*;

public class EmployeeBonus {

    public static void main(String[] args) {
        Random rand = new Random();
        int totalOldSalary = 0, totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Employee Data (Old Salary, Years of Service, New Salary, Bonus):");

        for (int i = 0; i < 10; i++) {
            int oldSalary = 10000 + rand.nextInt(90000); 
            int yearsOfService = 1 + rand.nextInt(20);  

            double bonus = (yearsOfService >= 5) ? 0.05 * oldSalary : 0.02 * oldSalary;
            double newSalary = oldSalary + bonus;

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("Employee %d | Old Salary: %d | Years of Service: %d | New Salary: %.2f | Bonus: %.2f%n", 
                              i + 1, oldSalary, yearsOfService, newSalary, bonus);
        }

        System.out.printf("Total Old Salary: %d%n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
        System.out.printf("Total Bonus Paid: %.2f%n", totalBonus);
    }
}
