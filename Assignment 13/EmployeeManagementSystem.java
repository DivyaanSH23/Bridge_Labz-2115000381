abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}
class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    public double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String department) {
        this.department = department;
    }
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, hourlyRate * hoursWorked);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    public void assignDepartment(String department) {
        this.department = department;
    }
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(101, "Alice", 50000);
        Employee emp2 = new PartTimeEmployee(102, "Bob", 200, 20);
        
        ((FullTimeEmployee) emp1).assignDepartment("IT");
        ((PartTimeEmployee) emp2).assignDepartment("HR");
        
        emp1.displayDetails();
        System.out.println(((FullTimeEmployee) emp1).getDepartmentDetails());
        
        System.out.println();
        emp2.displayDetails();
        System.out.println(((PartTimeEmployee) emp2).getDepartmentDetails());
    }
}
