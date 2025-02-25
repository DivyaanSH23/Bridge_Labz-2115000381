import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class CSVRowCounter {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();
        int rowCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the first row (header) and ignore it
            reader.readNext();

            // Count remaining rows
            while (reader.readNext() != null) {
                rowCount++;
            }

            System.out.println("Total records (excluding header): " + rowCount);
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
