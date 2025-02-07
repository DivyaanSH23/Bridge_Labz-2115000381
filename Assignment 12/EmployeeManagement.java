import java.util.*;

class Employee {
    String name;
    int id;
    double salary;
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String college;
    Intern(String name, int id, double salary, String college) {
        super(name, id, salary);
        this.college = college;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("College: " + college);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("Alice", 101, 75000, 5));
        employees.add(new Developer("Bob", 102, 60000, "Java"));
        employees.add(new Intern("Charlie", 103, 20000, "XYZ University"));
        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }
}
