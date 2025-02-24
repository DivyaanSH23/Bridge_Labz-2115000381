import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class ExampleClass {
    public void display() {
        System.out.println("Example method in annotated class.");
    }
}

public class AnnotationRetriever {
    public static void main(String[] args) {
        Class<ExampleClass> obj = ExampleClass.class;

        if (obj.isAnnotationPresent(Author.class)) {
            Author author = obj.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No Author annotation present.");
        }
    }
}
