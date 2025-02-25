import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class CSVModifyExample {
    public static void main(String[] args) {
        String inputFilePath = Paths.get("src", "main", "resources", "employees.csv").toString();
        String outputFilePath = Paths.get("src", "main", "resources", "updated_employees.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            List<String[]> records = reader.readAll();
            boolean headerSkipped = false;

            for (String[] row : records) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    writer.writeNext(row);
                    continue;
                }

                if (row[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(row[3]);
                    salary *= 1.10;
                    row[3] = String.format("%.2f", salary);
                }

                writer.writeNext(row);
            }

            System.out.println("Salaries updated. New file saved as updated_employees.csv");

        } catch (IOException | CsvException e) {
            System.out.println("Error processing CSV file: " + e.getMessage());
        }
    }
}
