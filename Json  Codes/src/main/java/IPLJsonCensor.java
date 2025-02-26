import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.InputStream;

public class IPLJsonCensor {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Load JSON file from resources
        InputStream inputStream = IPLJsonCensor.class.getClassLoader().getResourceAsStream("ipl.json");

        if (inputStream == null) {
            System.out.println("File not found in resources!");
            return;
        }

        JsonNode matches = objectMapper.readTree(inputStream);

        for (JsonNode match : matches) {
            ObjectNode matchNode = (ObjectNode) match;
            matchNode.put("team1", match.get("team1").asText().split(" ")[0] + " ***");
            matchNode.put("team2", match.get("team2").asText().split(" ")[0] + " ***");
            matchNode.put("player_of_match", "REDACTED");
        }

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(matches));
    }
}
