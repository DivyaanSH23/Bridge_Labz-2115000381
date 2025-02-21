import java.io.*;

public class FileCopy2 {
    public static void main(String[] args) {
        String sourceFile = "large_source.txt";
        String destinationFile = "large_destination.txt";
        
        copyUsingBufferedStreams(sourceFile, destinationFile);
        copyUsingUnbufferedStreams(sourceFile, "unbuffered_destination.txt");
    }

    private static void copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered copy completed in: " + (System.nanoTime() - startTime) / 1e6 + " ms");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("Unbuffered copy completed in: " + (System.nanoTime() - startTime) / 1e6 + " ms");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
