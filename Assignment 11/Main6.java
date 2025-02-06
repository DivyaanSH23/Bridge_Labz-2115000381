import java.util.ArrayList;

class Course {
    private String name;
    private Professor professor;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this);
    }

    public void enrollStudent(Student student) {
        students.add(student);
        student.addCourse(this);
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("  Professor: " + professor.getName());
        } else {
            System.out.println("  No professor assigned.");
        }
        System.out.println("  Enrolled Students:");
        for (Student student : students) {
            System.out.println("    - " + student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Professor {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Professor(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayProfessorCourses() {
        System.out.println("Professor: " + name + " teaches:");
        for (Course course : courses) {
            System.out.println("  - " + course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayStudentCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("  - " + course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class University {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void displayUniversity() {
        System.out.println("University: " + name);
        System.out.println("Professors:");
        for (Professor professor : professors) {
            System.out.println("  - " + professor.getName());
        }
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}

public class Main6 {
    public static void main(String[] args) {
        University university = new University("Tech University");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        university.addStudent(student1);
        university.addStudent(student2);
        university.addProfessor(professor1);
        university.addProfessor(professor2);

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");

        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);

        university.displayUniversity();
        student1.displayStudentCourses();
        student2.displayStudentCourses();
        professor1.displayProfessorCourses();
        professor2.displayProfessorCourses();
        course1.displayCourseInfo();
        course2.displayCourseInfo();
    }
}

