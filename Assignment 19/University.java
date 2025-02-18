import java.util.*;

abstract class CourseType {
    String courseName;
    CourseType(String courseName) {
        this.courseName = courseName;
    }
    String getCourseName() {
        return courseName;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName) {
        super(courseName);
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();
    void addCourse(T course) {
        courses.add(course);
    }
    List<T> getCourses() {
        return courses;
    }
}

class University {
    static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName());
        }
    }
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Math Exam"));
        examCourses.addCourse(new ExamCourse("Physics Exam"));
        
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("History Assignment"));
        
        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research"));
        
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.addAll(examCourses.getCourses());
        allCourses.addAll(assignmentCourses.getCourses());
        allCourses.addAll(researchCourses.getCourses());
        
        displayCourses(allCourses);
    }
}
