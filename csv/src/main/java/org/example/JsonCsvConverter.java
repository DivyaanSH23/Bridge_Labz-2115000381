import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonCsvConverter {
    public static void main(String[] args) {
        String jsonFilePath = Paths.get("src", "main", "resources", "students.json").toString();
        String csvFilePath = Paths.get("src", "main", "resources", "students.csv").toString();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                writer.writeNext(new String[]{"ID", "Name", "Age"}); // Header

                for (JsonNode node : rootNode) {
                    writer.writeNext(new String[]{
                            node.get("ID").asText(),
                            node.get("Name").asText(),
                            node.get("Age").asText()
                    });
                }
            }

            System.out.println("JSON successfully converted to CSV.");
        } catch (IOException e) {
            System.out.println("Error converting JSON to CSV: " + e.getMessage());
}
}
}
