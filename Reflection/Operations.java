import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();
        
        try {
            Class<?> cls = Class.forName("MathOperations");
            Object obj = cls.getDeclaredConstructor().newInstance();
            Method method = cls.getMethod(methodName, int.class, int.class);
            
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            int result = (int) method.invoke(obj, num1, num2);
            System.out.println("Result: " + result);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
