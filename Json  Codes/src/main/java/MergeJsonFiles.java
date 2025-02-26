import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON files
        JsonNode json1 = objectMapper.readTree(new File("src/main/resources/file1.json"));
        JsonNode json2 = objectMapper.readTree(new File("src/main/resources/file2.json"));

        // Merge into a single ObjectNode
        ObjectNode mergedJson = objectMapper.createObjectNode();
        mergedJson.setAll((ObjectNode) json1);
        mergedJson.setAll((ObjectNode) json2);

        // Write to merged.json
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/merged.json"), mergedJson);

        System.out.println("Merged JSON file created successfully!");
    }
}
