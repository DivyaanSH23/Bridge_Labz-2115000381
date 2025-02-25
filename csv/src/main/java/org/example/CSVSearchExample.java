import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class CSVSearchExample {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Name to Search: ");
        String searchName = scanner.nextLine().strip();

        boolean found = false;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean headerSkipped = false;

            while ((line = reader.readNext()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                String name = line[1].strip();
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.printf("Employee Found: %s | Department: %s | Salary: %s%n",
                            name, line[2], line[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
