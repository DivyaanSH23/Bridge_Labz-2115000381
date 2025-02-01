class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public void modifySalary(double newSalary) {
        salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public void accessDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

public class Employees {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.employeeID = 123;
        emp.department = "Sales";
        emp.modifySalary(50000);

        Manager mgr = new Manager();
        mgr.employeeID = 456;
        mgr.department = "HR";
        mgr.modifySalary(75000);

        mgr.accessDetails();
        System.out.println("Manager's Salary: " + mgr.getSalary());
    }
}
