import java.util.*;
class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of persons: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight (kg) and height (m): ");
            double weight = sc.nextDouble();
            double height = sc.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input, try again.");
                i--;
                continue;
            }

            double bmi = weight / (height * height);
            String status = (bmi < 18.5) ? "Underweight" :
                            (bmi < 24.9) ? "Normal" :
                            (bmi < 29.9) ? "Overweight" : "Obese";

            System.out.printf("Height: %.2f, Weight: %.2f, BMI: %.2f, Status: %s\n", height, weight, bmi, status);
        }
    }
}



