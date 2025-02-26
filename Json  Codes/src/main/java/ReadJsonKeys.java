import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.Iterator;

public class ReadJsonKeys {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = ReadJsonKeys.class.getClassLoader().getResourceAsStream("data.json");

        if (inputStream == null) {
            System.out.println("File not found!");
            return;
        }

        JsonNode node = objectMapper.readTree(inputStream);
        Iterator<String> keys = node.fieldNames();

        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + ": " + node.get(key));
        }
    }
}
