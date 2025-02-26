import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class FilterJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = FilterJson.class.getClassLoader().getResourceAsStream("people.json");
        if (inputStream == null) {
            System.out.println("File not found!");
            return;
        }

        JsonNode rootNode = objectMapper.readTree(inputStream);

        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}
