import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Marks: %.2f", id, name, age, marks);
    }
}

public class CSVToObjectExample {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "students.csv").toString();
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            records.remove(0);

            for (String[] row : records) {
                if (row.length < 4) continue;

                int id = Integer.parseInt(row[0].trim());
                String name = row[1].trim();
                int age = Integer.parseInt(row[2].trim());
                double marks = Double.parseDouble(row[3].trim());

                studentList.add(new Student(id, name, age, marks));
            }

            System.out.println("Student List:");
            studentList.forEach(System.out::println);

        } catch (IOException | CsvException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
