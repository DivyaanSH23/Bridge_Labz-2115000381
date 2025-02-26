import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class User {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJson2 {
    public static void main(String[] args) throws Exception {
        List<User> users = Arrays.asList(
                new User("John", 25),
                new User("Alice", 30)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(users);

        System.out.println(jsonArray);
    }
}
