import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.io.InputStream;
import java.util.Set;

public class ValidateJsonSchema {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream schemaStream = ValidateJsonSchema.class.getClassLoader().getResourceAsStream("schema.json");
        InputStream dataStream = ValidateJsonSchema.class.getClassLoader().getResourceAsStream("data.json");

        if (schemaStream == null || dataStream == null) {
            System.out.println("Schema or data file not found!");
            return;
        }

        JsonNode schemaNode = objectMapper.readTree(schemaStream);
        JsonNode dataNode = objectMapper.readTree(dataStream);

        JsonSchema schema = JsonSchemaFactory.getInstance().getSchema(schemaNode);
        Set<ValidationMessage> errors = schema.validate(dataNode);

        if (errors.isEmpty()) {
            System.out.println("Valid JSON!");
        } else {
            System.out.println("Validation Errors: " + errors);
        }
    }
}
