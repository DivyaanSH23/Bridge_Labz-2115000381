import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // Read JSON file
        JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/data.json"));

        // Convert JSON to XML
        String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);

        // Save to file
        File xmlFile = new File("src/main/resources/output.xml");
        xmlMapper.writeValue(xmlFile, jsonData);

        System.out.println("Converted JSON to XML successfully!");
    }
}
