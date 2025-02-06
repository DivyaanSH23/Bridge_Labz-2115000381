import java.util.ArrayList;

class Patient {
    private String name;
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public Patient(String name) {
        this.name = name;
    }

    public void consultDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.consult(this);
    }

    public void displayDoctors() {
        System.out.println(name + " has consulted:");
        for (Doctor doctor : doctors) {
            System.out.println("  Doctor: " + doctor.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients = new ArrayList<>();

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        System.out.println("Doctor " + name + " is consulting Patient " + patient.getName());
    }

    public void displayPatients() {
        System.out.println(name + " has consulted:");
        for (Patient patient : patients) {
            System.out.println("  Patient: " + patient.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();

    public Hospital(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayHospital() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors in the hospital:");
        for (Doctor doctor : doctors) {
            System.out.println("  " + doctor.getName());
        }
        System.out.println("Patients in the hospital:");
        for (Patient patient : patients) {
            System.out.println("  " + patient.getName());
        }
    }
}

public class Main8 {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Dr. Smith");
        Doctor doctor2 = new Doctor("Dr. Johnson");

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        patient1.consultDoctor(doctor1);
        patient1.consultDoctor(doctor2);
        patient2.consultDoctor(doctor1);

        hospital.displayHospital();
        doctor1.displayPatients();
        doctor2.displayPatients();
        patient1.displayDoctors();
        patient2.displayDoctors();
    }
}
