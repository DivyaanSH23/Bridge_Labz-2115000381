import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\SHIVA SHUKLA\\Documents\\AI tool that would be helpful for b.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
