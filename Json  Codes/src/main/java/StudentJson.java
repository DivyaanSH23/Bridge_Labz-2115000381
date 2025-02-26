import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

class Student {
    public String name;
    public int age;
    public String[] subjects;

    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}

public class StudentJson {
    public static void main(String[] args) throws Exception {
        Student student = new Student("John", 20, new String[]{"Math", "Science"});

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(student);

        System.out.println(jsonString);
    }
}
