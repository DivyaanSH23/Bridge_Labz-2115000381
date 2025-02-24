import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class ExpensiveComputation {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }
        System.out.println("Computing result for: " + number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}

public class AnnotationMain9 {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();
        Method method = ExpensiveComputation.class.getMethod("computeSquare", int.class);
        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println(computation.computeSquare(5));
            System.out.println(computation.computeSquare(5));
            System.out.println(computation.computeSquare(10));
            System.out.println(computation.computeSquare(10));
        }
    }
}
