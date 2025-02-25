import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class CSVFilterExample {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "students.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean headerSkipped = false;

            System.out.println("Students with Marks > 80:");
            while ((line = reader.readNext()) != null) {
                if (!headerSkipped) { // Skip the header row
                    headerSkipped = true;
                    continue;
                }

                int marks = Integer.parseInt(line[3]); // Assuming marks are in the 4th column (index 3)
                if (marks > 80) {
                    System.out.printf("ID: %s | Name: %s | Age: %s | Marks: %s%n",
                            line[0], line[1], line[2], line[3]);
                }
            }
        } catch (IOException | CsvValidationException | NumberFormatException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

