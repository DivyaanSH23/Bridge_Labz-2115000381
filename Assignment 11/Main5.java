import java.util.ArrayList;

class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayFacultyDetails() {
        System.out.println("  Faculty: " + name + " | Specialization: " + specialization);
    }
}

class Department {
    private String departmentName;
    private ArrayList<Faculty> facultyMembers;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void displayDepartmentDetails() {
        System.out.println("Department: " + departmentName);
        for (Faculty faculty : facultyMembers) {
            faculty.displayFacultyDetails();
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

class University {
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> facultyList; 

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyList = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public void addFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department department : departments) {
            if (departmentName.equals(department.getDepartmentName())) { 
                department.addFaculty(faculty);
            }
        }
    }

    public void displayUniversityDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        for (Department department : departments) {
            department.displayDepartmentDetails();
        }
        System.out.println("\nIndependent Faculty Members:");
        for (Faculty faculty : facultyList) {
            faculty.displayFacultyDetails();
        }
    }
}

public class Main5 {
    public static void main(String[] args) {
        University university = new University("Harvard University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

       Faculty faculty1 = new Faculty("Dr. Smith", "Artificial Intelligence");
        Faculty faculty2 = new Faculty("Dr. Johnson", "Mechanical Design");
        Faculty faculty3 = new Faculty("Dr. Brown", "Data Science");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);

        university.addFacultyToDepartment("Computer Science", faculty1);
        university.addFacultyToDepartment("Computer Science", faculty3);
        university.addFacultyToDepartment("Mechanical Engineering", faculty2);

        university.displayUniversityDetails();

        System.out.println("\nUniversity is deleted. All departments are removed, but faculty members still exist.");
    }
}
