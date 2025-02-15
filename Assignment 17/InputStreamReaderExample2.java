import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderExample2 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java InputStreamReaderExample <output_filename>");
            return;
        }
        
        String filename = args[0];
        
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            
            System.out.println("Enter text (type 'exit' to stop):");
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            
            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("User input has been written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
