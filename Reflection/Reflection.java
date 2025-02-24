import java.lang.reflect.*;
import java.util.Scanner;

public class Reflection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        scanner.close();

        try {
            Class<?> cls = Class.forName(className);
            System.out.println("Class: " + cls.getName());

            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : cls.getConstructors()) {
                System.out.println(constructor);
            }

            System.out.println("\nMethods:");
            for (Method method : cls.getMethods()) {
                System.out.println(method);
            }

            System.out.println("\nFields:");
            for (Field field : cls.getFields()) {
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}
