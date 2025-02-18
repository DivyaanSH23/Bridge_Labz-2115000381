import java.util.List;
import java.util.Arrays;

abstract class JobRole {
    abstract void processResume();
}

class SoftwareEngineer extends JobRole {
    void processResume() {
        System.out.println("Processing resume for Software Engineer.");
    }
}

class DataScientist extends JobRole {
    void processResume() {
        System.out.println("Processing resume for Data Scientist.");
    }
}

class ProductManager extends JobRole {
    void processResume() {
        System.out.println("Processing resume for Product Manager.");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void screenResume() {
        jobRole.processResume();
    }
}

class ResumeScreeningSystem {
    public static void screenMultipleResumes(List<? extends JobRole> resumes) {
        for (JobRole jobRole : resumes) {
            jobRole.processResume();
        }
    }
}

public class Main2 { 
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager());

        seResume.screenResume();
        dsResume.screenResume();
        pmResume.screenResume();

        List<JobRole> resumeList = Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());
        ResumeScreeningSystem.screenMultipleResumes(resumeList);
    }
}
