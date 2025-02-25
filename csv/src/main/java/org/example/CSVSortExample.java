import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVSortExample {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            String[] header = records.remove(0);

            List<String[]> sortedRecords = records.stream()
                    .sorted((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])))
                    .limit(5)
                    .collect(Collectors.toList());

            System.out.println("Top 5 Highest Paid Employees:");
            System.out.println(Arrays.toString(header));

            for (String[] row : sortedRecords) {
                System.out.println(Arrays.toString(row));
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
