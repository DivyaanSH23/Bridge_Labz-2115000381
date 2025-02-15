import java.io.*;

public class FileReaderExample2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileReaderExample <filename> <word>");
            return;
        }
        
        String filename = args[0];
        String targetWord = args[1];
        int count = 0;
        
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
            
            bufferedReader.close();
            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
