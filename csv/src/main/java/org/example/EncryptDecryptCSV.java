import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    private static String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    public static void writeEncryptedCSV(String filePath) {
        String[][] data = {
                {"ID", "Name", "Email", "Salary"},
                {"1", "Alice", "alice@example.com", "50000"},
                {"2", "Bob", "bob@example.com", "60000"},
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                row[2] = encrypt(row[2]);
                row[3] = encrypt(row[3]);
                writer.writeNext(row);
            }
            System.out.println("Encrypted CSV written successfully.");
        } catch (Exception e) {
            System.out.println("Error writing encrypted CSV: " + e.getMessage());
        }
    }

    public static void readDecryptedCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                line[2] = decrypt(line[2]);
                line[3] = decrypt(line[3]);
                System.out.println(String.join(", ", line));
            }
        } catch (Exception e) {
            System.out.println("Error reading encrypted CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "encrypted_employees.csv";
        writeEncryptedCSV(filePath);
        readDecryptedCSV(filePath);
}
}
