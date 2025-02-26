import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.InputStream;

class Person {
    public String name;
    public int age;  // Expecting an integer
}

public class ValidateJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = ValidateJson.class.getClassLoader().getResourceAsStream("invalid.json");
            if (inputStream == null) {
                System.out.println("File not found!");
                return;
            }

            Person person = objectMapper.readValue(inputStream, Person.class);
            System.out.println("Valid JSON: " + person.name);
        } catch (MismatchedInputException e) {
            System.out.println("Invalid JSON structure: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
