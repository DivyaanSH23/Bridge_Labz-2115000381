import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class CSVWriterExample {
    public static void main(String[] args) {
        // Define the file path
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();

        // Employee data
        String[][] employees = {
                {"ID", "Name", "Department", "Salary"},
                {"101", "Alice Johnson", "HR", "60000"},
                {"102", "Bob Smith", "IT", "75000"},
                {"103", "Charlie Brown", "Finance", "70000"},
                {"104", "Diana Prince", "Marketing", "68000"},
                {"105", "Ethan Hunt", "Operations", "72000"}
        };

        // Write data to CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (String[] employee : employees) {
                writer.writeNext(employee);
            }
            System.out.println("CSV file written successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
}
