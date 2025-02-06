import java.util.ArrayList;

class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this); 
        }
    }

    public void displayStudents() {
        System.out.println("Course: " + courseName + " has the following students:");
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.getName());
        }
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void enrollInCourse(Course course) {
        course.enrollStudent(this);
    }

    public void displayEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}

class School {
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + schoolName + " has the following students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        school.addStudent(student1);
        school.addStudent(student2);

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");
        Course course3 = new Course("History");

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course2);
        student2.enrollInCourse(course3);

        school.displayStudents();
        System.out.println();
        
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();
        System.out.println();

        course1.displayStudents();
        course2.displayStudents();
        course3.displayStudents();
    }
}
