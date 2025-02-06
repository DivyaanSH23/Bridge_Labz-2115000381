import java.util.ArrayList;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void displayEmployeeDetails() {
        System.out.println("  Employee: " + name + " | Role: " + role);
    }
}

class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void displayDepartmentDetails() {
        System.out.println("Department: " + departmentName);
        for (Employee employee : employees) {
            employee.displayEmployeeDetails();
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName, String role) {
        for (Department department : departments) {
            if (departmentName.equals(department.getDepartmentName())) { 
                department.addEmployee(employeeName, role);
            }
        }
    }

    public void displayCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department department : departments) {
            department.displayDepartmentDetails();
        }
    }
}

class Main3 { 
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");

        company.addDepartment("Engineering");
        company.addDepartment("Marketing");

        company.addEmployeeToDepartment("Engineering", "Alice", "Software Engineer");
        company.addEmployeeToDepartment("Engineering", "Bob", "System Architect");
        company.addEmployeeToDepartment("Marketing", "Charlie", "Marketing Manager");

        company.displayCompanyDetails();

        System.out.println("\nCompany is deleted. All departments and employees are removed.");
    }
}
