class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public void modifyCGPA(double newCGPA) {
        CGPA = newCGPA;
    }

    public double getCGPA() {
        return CGPA;
    }
}

class PostgraduateStudent extends Student {
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}

public class University
 {
    public static void main(String[] args) {
        Student student = new Student();
        student.rollNumber = 101;
        student.name = "John Doe";
        student.modifyCGPA(8.5);

        PostgraduateStudent pgStudent = new PostgraduateStudent();
        pgStudent.rollNumber = 102;
        pgStudent.name = "Jane Smith";
        pgStudent.modifyCGPA(9.2);

        pgStudent.displayDetails();
    }
}
