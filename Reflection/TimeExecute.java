import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Timed {}

class MethodTimer {
    public static void executeTimedMethods(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Timed.class)) {
                long startTime = System.nanoTime();
                method.setAccessible(true);
                method.invoke(obj);
                long endTime = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) + " ns");
            }
        }
    }
}

class Example {
    @Timed
    public void testMethod() {
        for (int i = 0; i < 1000000; i++); 
    }
}

public class TimeExecute {
    public static void main(String[] args) throws Exception {
        Example example = new Example();
        MethodTimer.executeTimedMethods(example);
    }
}
