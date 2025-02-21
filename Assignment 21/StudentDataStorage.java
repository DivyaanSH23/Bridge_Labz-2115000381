import java.io.*;

public class StudentDataStorage {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        storeStudentData();
        retrieveStudentData();
    }

    private static void storeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);
            
            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);
            
            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error storing student data: " + e.getMessage());
        }
    }

    private static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Retrieving Student Data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error retrieving student data: " + e.getMessage());
        }
    }
}
