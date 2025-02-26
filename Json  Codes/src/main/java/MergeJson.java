import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String json1 = "{\"name\": \"Alice\", \"age\": 28}";
        String json2 = "{\"email\": \"alice@example.com\", \"city\": \"New York\"}";

        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        ObjectNode mergedNode = objectMapper.createObjectNode();
        mergedNode.setAll((ObjectNode) node1);
        mergedNode.setAll((ObjectNode) node2);

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));
    }
}
