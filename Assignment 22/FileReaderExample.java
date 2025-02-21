import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\SHIVA SHUKLA\\Documents\\AI tool that would be helpful for info.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
