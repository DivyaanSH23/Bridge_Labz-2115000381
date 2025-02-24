import java.lang.reflect.*;
import java.util.Scanner;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public String getName() {
        return name;
    }
}

public class Studies {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Student");
            Object student = cls.getDeclaredConstructor().newInstance();
            
            Method getNameMethod = cls.getMethod("getName");
            String name = (String) getNameMethod.invoke(student);
            
            System.out.println("Student Name: " + name);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
