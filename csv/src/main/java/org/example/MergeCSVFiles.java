import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = Paths.get("src", "main", "resources", "students1.csv").toString();
        String file2 = Paths.get("src", "main", "resources", "students2.csv").toString();
        String outputFile = Paths.get("src", "main", "resources", "merged_students.csv").toString();

        Map<String, String[]> studentData = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            List<String[]> records1 = reader1.readAll();
            records1.remove(0);

            for (String[] row : records1) {
                if (row.length < 3) continue;
                studentData.put(row[0], new String[]{row[1], row[2]});
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading students1.csv: " + e.getMessage());
        }

        try (CSVReader reader2 = new CSVReader(new FileReader(file2))) {
            List<String[]> records2 = reader2.readAll();
            records2.remove(0);

            for (String[] row : records2) {
                if (row.length < 3) continue;
                if (studentData.containsKey(row[0])) {
                    String[] studentInfo = studentData.get(row[0]);
                    studentData.put(row[0], new String[]{studentInfo[0], studentInfo[1], row[1], row[2]});
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading students2.csv: " + e.getMessage());
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                String[] value = entry.getValue();
                if (value.length == 4) {
                    writer.writeNext(new String[]{entry.getKey(), value[0], value[1], value[2], value[3]});
                }
            }
            System.out.println("Merged CSV file created: merged_students.csv");

        } catch (IOException e) {
            System.out.println("Error writing merged_students.csv: " + e.getMessage());
        }
    }
}
