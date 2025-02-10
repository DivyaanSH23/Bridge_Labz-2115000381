import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private List<String> medicalRecords;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

class HospitalManagement {
    public static void processPatient(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Total Bill: $" + patient.calculateBill());
        
        if (patient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) patient;
            System.out.println("Medical Records: " + record.viewRecords());
        }

        System.out.println("--------------------------------------");
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("P1001", "John Doe", 45, 5, 200.0);
        inPatient.addRecord("Admitted for surgery.");
        inPatient.addRecord("Prescribed antibiotics.");

        OutPatient outPatient = new OutPatient("P2001", "Jane Smith", 30, 100.0);
        outPatient.addRecord("Routine check-up.");
        outPatient.addRecord("Prescribed vitamins.");

        HospitalManagement.processPatient(inPatient);
        HospitalManagement.processPatient(outPatient);
    }
}
