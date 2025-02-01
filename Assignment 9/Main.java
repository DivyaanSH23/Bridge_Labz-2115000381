class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "XYZ Institute";

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
}

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.courseName = "Java Programming";
        course1.duration = 3;
        course1.fee = 500.0;

        Course course2 = new Course();
        course2.courseName = "Data Science";
        course2.duration = 6;
        course2.fee = 800.0;

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        System.out.println("\nUpdating institute name...\n");
        Course.updateInstituteName("ABC Tech Academy");

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
