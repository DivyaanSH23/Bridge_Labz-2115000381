
import java.util.*;
class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " (Physics, Chemistry, Maths): ");
            
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
                if (marks[i][j] < 0) {
                    System.out.println("Invalid marks! Enter positive values.");
                    j--;
                }
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3.0;

            if (percentages[i] >= 90) grades[i] = "A";
            else if (percentages[i] >= 80) grades[i] = "B";
            else if (percentages[i] >= 70) grades[i] = "C";
            else if (percentages[i] >= 60) grades[i] = "D";
            else grades[i] = "F";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.2f%%\n", i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}



