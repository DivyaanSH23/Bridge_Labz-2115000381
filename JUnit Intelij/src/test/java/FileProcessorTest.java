import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
public class FileProcessorTest {
    FileProcessor fileProcessor;
    String filename;

    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
        filename = "testfile.txt";
    }

    @Test
    public void testWriteToFile() throws IOException {
        String content = "Hello, world!";
        fileProcessor.writeToFile(filename, content);
        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testReadFromFile() throws IOException {
        String content = "Hello, world!";
        fileProcessor.writeToFile(filename, content);
        String readContent = fileProcessor.readFromFile(filename);
        assertEquals(content, readContent);
    }

    @Test
    public void testIOException() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistentfile.txt"));
    }

    @AfterEach
    public void tearDown() {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
}
