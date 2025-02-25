import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class CSVReaderExample {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "Student.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.printf("ID: %s | Name: %s | Age: %s | Marks: %s%n",
                        line[0], line[1], line[2], line[3]);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file: " + e.getMessage());
}
}
}