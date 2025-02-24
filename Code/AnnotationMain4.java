import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectTasks {
    @Todo(task = "Implement authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticationFeature() {
        System.out.println("Authentication feature pending");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending");
    }
}

public class AnnotationMain4 {
    public static void main(String[] args) throws Exception {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task() + ", Assigned To: " + annotation.assignedTo() + ", Priority: " + annotation.priority());
            }
        }
    }
}
