import java.lang.reflect.*;
import java.util.Scanner;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class Cal {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Class<?> cls = calculator.getClass();
            
            Method multiplyMethod = cls.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
