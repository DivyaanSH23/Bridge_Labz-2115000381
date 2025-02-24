import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

class IssueTracker {
    @BugReport(description = "Null pointer exception on edge case input")
    @BugReport(description = "Performance degradation in large data sets")
    public void processTask() {
        System.out.println("Processing task");
    }
}

public class AnnotationMain2 {
    public static void main(String[] args) throws Exception {
        Method method = IssueTracker.class.getMethod("processTask");
        BugReports bugReports = method.getAnnotation(BugReports.class);
        if (bugReports != null) {
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description());
            }
        }
    }
}
