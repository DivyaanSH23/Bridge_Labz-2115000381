import java.util.Scanner;

public class Grades {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks for Chemistry: ");
        double chemistry = sc.nextDouble();
        System.out.print("Enter marks for Physics: ");
        double physics = sc.nextDouble();
        System.out.print("Enter marks for Maths: ");
        double maths = sc.nextDouble();

        double percent = ((chemistry + physics + maths) / 300.0) * 100.0;
        char grade;

        if (percent >= 80) {
            grade = 'A';
        } else if (percent >= 70) {
            grade = 'B';
        } else if (percent >= 60) {
            grade = 'C';
        } else if (percent >= 50) {
            grade = 'D';
        } else if (percent >= 40) {
            grade = 'E';
        } else {
            grade = 'R'; 
        }

        System.out.println("The average marks are " + percent + " and the grade is " + grade);
    }
}

