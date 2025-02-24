import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        if (username.length() > getMaxAllowedLength()) {
            throw new IllegalArgumentException("Username exceeds maximum allowed length");
        }
        this.username = username;
    }

    private int getMaxAllowedLength() {
        try {
            Field field = this.getClass().getDeclaredField("username");
            MaxLength annotation = field.getAnnotation(MaxLength.class);
            return annotation != null ? annotation.value() : Integer.MAX_VALUE;
        } catch (NoSuchFieldException e) {
            return Integer.MAX_VALUE;
        }
    }
}

public class AnnotationMain6 {
    public static void main(String[] args) {
        try {
            User user1 = new User("ShortName");
            System.out.println("User created successfully");
            User user2 = new User("ThisIsTooLongUsername");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
