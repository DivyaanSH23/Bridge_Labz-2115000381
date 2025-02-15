import java.io.*;
import java.nio.charset.StandardCharsets;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilders();
        compareFileReaders("largefile.txt");
    }

    private static void compareStringBuilders() {
        String text = "hello";
        int iterations = 1_000_000;
        
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");
        
        startTime = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void compareFileReaders(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            long wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            bufferedReader.close();
            System.out.println("FileReader word count: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            long wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            bufferedReader.close();
            System.out.println("InputStreamReader word count: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
