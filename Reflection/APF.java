import java.lang.reflect.*;
import java.util.Scanner;

class Person {
    private int age;
    
    public Person(int age) {
        this.age = age;
    }
}

public class APF {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            Class<?> cls = person.getClass();
            
            Field ageField = cls.getDeclaredField("age");
            ageField.setAccessible(true);
            
            System.out.println("Original Age: " + ageField.get(person));
            ageField.set(person, 30);
            System.out.println("Modified Age: " + ageField.get(person));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
