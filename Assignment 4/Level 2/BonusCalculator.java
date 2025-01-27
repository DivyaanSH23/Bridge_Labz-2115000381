import java.util.*;
public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;
        double[] salaries = new double[10], years = new double[10], bonuses = new double[10], newSalaries = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years of service for employee " + (i + 1));
            double salary = sc.nextDouble();
            double year = sc.nextDouble();

            if (salary <= 0 || year < 0) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            salaries[i] = salary;
            years[i] = year;
            totalOldSalary += salary;
        }

        for (int i = 0; i < 10; i++) {
            bonuses[i] = (years[i] > 5) ? salaries[i] * 0.05 : salaries[i] * 0.02;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}

