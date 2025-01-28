import java.util.*;

class Roots {
    public static double[] deltposi(double delta, int a, int b) {
        double arr[] = new double[2];
        arr[0] = (-b + Math.sqrt(delta)) / (2.0 * a);
        arr[1] = (-b - Math.sqrt(delta)) / (2.0 * a);
        return arr;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE THREE VARIABLES TO FIND ROOTS");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        double delta = b * b - (4 * a * c);
        if (delta > 0) {
            double arr[] = deltposi(delta, a, b);
            System.out.printf("THE TWO ROOTS ARE %f AND %f AND THE VALUE OF DELTA IS %f %n", arr[0], arr[1], delta);
        } else if (delta < 0) {
            System.out.println("SINCE DELTA IS NEGATIVE, SO IT HAS NO REAL ROOTS: DELTA = " + delta);
        } else {
            double x = (-b * 1.0) / (2.0 * a);
            System.out.printf("THE ROOT IS %f for delta %f%n", x, delta);
        }
    }
}
