import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ReadJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = ReadJson.class.getClassLoader().getResourceAsStream("data.json");

        if (inputStream == null) {
            System.out.println("File not found!");
            return;
        }

        JsonNode node = objectMapper.readTree(inputStream);
        System.out.println("Name: " + node.get("name").asText());
        System.out.println("Email: " + node.get("email").asText());
    }
}
