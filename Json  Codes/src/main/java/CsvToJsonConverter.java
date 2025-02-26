import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        // Read CSV
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"))) {
            List<String[]> rows = reader.readAll();
            String[] headers = rows.get(0);

            for (int i = 1; i < rows.size(); i++) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], rows.get(i)[j]);
                }
                jsonArray.add(jsonObject);
            }
        }

        // Write JSON file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter("src/main/resources/data.json"), jsonArray);

        System.out.println("CSV converted to JSON successfully!");
    }
}
