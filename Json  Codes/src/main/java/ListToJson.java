import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Employee {
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25),
                new Employee("Alice", 30)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(employees);

        System.out.println(jsonArray);
    }
}
