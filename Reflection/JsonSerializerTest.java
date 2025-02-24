import java.lang.reflect.Field;
import java.util.*;

class JsonSerializer {
    public static String toJson(Object obj) {
        if (obj == null) return "null";

        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = clazz.getDeclaredFields();
        List<String> jsonFields = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                jsonFields.add("\"" + field.getName() + "\": " + formatValue(value));
            } catch (IllegalAccessException e) {
                jsonFields.add("\"" + field.getName() + "\": \"ERROR\"");
            }
        }

        json.append(String.join(", ", jsonFields)).append("}");
        return json.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) return "null";
        if (value instanceof String) return "\"" + value + "\"";
        if (value instanceof Number || value instanceof Boolean) return value.toString();
        return "\"" + value.toString() + "\"";
    }
}

class Person {
    private String name;
    private int age;
    private boolean active;

    public Person(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }
}

public class JsonSerializerTest {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25, true);
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}
