import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "large_students.csv").toString();
        int batchSize = 100;
        int totalRecords = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean headerSkipped = false;
            int batchCount = 0;

            while ((line = reader.readNext()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                totalRecords++;
                batchCount++;

                if (batchCount == batchSize) {
                    System.out.println("Processed: " + totalRecords + " records");
                    batchCount = 0;
                }
            }

            System.out.println("Total Records Processed: " + totalRecords);

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
