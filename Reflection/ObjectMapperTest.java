import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field;
                try {
                    field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(instance, entry.getValue());
                } catch (NoSuchFieldException e) {
                   
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object", e);
        }
    }
}

class Person {
    private String name;
    private int age;

    public String getName() { return name; }
    public int getAge() { return age; }
}

public class ObjectMapperTest {
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of(
            "name", "John Doe",
            "age", 30
        );

        Person person = ObjectMapper.toObject(Person.class, properties);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
