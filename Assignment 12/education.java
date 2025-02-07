class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double getFinalPrice() {
        return fee - (fee * discount / 100);
    }
}

public class education {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Programming", 6, "Udemy", true, 199.99, 20);
        System.out.println("Course Name: " + course.courseName);
        System.out.println("Duration: " + course.duration + " weeks");
        System.out.println("Platform: " + course.platform);
        System.out.println("Recorded: " + (course.isRecorded ? "Yes" : "No"));
        System.out.println("Final Price: $" + course.getFinalPrice());
    }
}
