
import java.util.*;
class BMI2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] data = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) and height (m) for person " + (i + 1) + ": ");
            double weight = sc.nextDouble();
            double height = sc.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input! Enter positive values.");
                i--;
                continue;
            }

            double bmi = weight / (height * height);
            data[i][0] = weight;
            data[i][1] = height;
            data[i][2] = bmi;

            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 24.9) status[i] = "Normal";
            else if (bmi < 29.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", data[i][1], data[i][0], data[i][2], status[i]);
        }
    }
}

