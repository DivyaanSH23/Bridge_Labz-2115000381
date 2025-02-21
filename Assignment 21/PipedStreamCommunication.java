import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            String message = "Hello from WriterThread!";
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println("Error writing to pipe: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
            String message = reader.readLine();
            System.out.println("Reader received: " + message);
            pis.close();
        } catch (IOException e) {
            System.out.println("Error reading from pipe: " + e.getMessage());
        }
    }
}

public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);
            
            writer.start();
            reader.start();
        } catch (IOException e) {
            System.out.println("Error setting up piped streams: " + e.getMessage());
        }
    }
}
