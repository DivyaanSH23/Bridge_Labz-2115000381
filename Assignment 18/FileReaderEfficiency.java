import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class FileReaderEfficiency {

    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt";

        long fileSize = new File(filePath).length();
        
        long startTime = System.nanoTime();
        FileReader fileReader = new FileReader(filePath);
        char[] buffer = new char[1024];
        while (fileReader.read(buffer) != -1);
        long endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;

        startTime = System.nanoTime();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        byte[] byteBuffer = new byte[1024];
        while (inputStreamReader.read(byteBuffer) != -1);
        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;

        System.out.println("File Size: " + fileSize + " bytes");
        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000 + " ms");
    }
}
