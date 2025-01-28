import java.util.*;
public class trigno {
    public double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] results = new double[3];
        results[0] = Math.sin(radians);
        results[1] = Math.cos(radians);
        results[2] = Math.tan(radians);
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        trigno obj = new trigno();

        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] results = obj.calculateTrigonometricFunctions(angle);
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
    }
}
