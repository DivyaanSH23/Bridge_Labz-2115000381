import java.util.*;

public class bmi {
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    public static void status(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            double bmi = calculateBMI(arr[i][0], arr[i][1]);

            if (bmi >= 40)
                System.out.println("Person " + (i + 1) + " is obese (BMI: " + bmi + ")");
            else if (bmi >= 25)
                System.out.println("Person " + (i + 1) + " is overweight (BMI: " + bmi + ")");
            else if (bmi >= 18.5)
                System.out.println("Person " + (i + 1) + " is normal (BMI: " + bmi + ")");
            else
                System.out.println("Person " + (i + 1) + " is underweight (BMI: " + bmi + ")");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double arr[][] = new double[10][2];
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter height (in meters) and weight (in kg) for person " + (i + 1) + ":");
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        }

        status(arr);
        sc.close(); 
    }
}
