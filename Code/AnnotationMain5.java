import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class ExecutionLogger {
    @LogExecutionTime
    public void processData() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++);
        long endTime = System.nanoTime();
        System.out.println("Execution time of processData: " + (endTime - startTime) + " ns");
    }

    @LogExecutionTime
    public void fetchData() {
        long startTime = System.nanoTime();
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        long endTime = System.nanoTime();
        System.out.println("Execution time of fetchData: " + (endTime - startTime) + " ns");
    }
}

public class AnnotationMain5 {
    public static void main(String[] args) throws Exception {
        ExecutionLogger logger = new ExecutionLogger();
        Method[] methods = ExecutionLogger.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                method.invoke(logger);
            }
        }
    }
}
