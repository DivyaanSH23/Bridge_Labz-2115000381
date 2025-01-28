import java.util.*;

public class CollinearPoints {

    public static boolean areCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (double) (y2 - y1) / (x2 - x1);
        double slopeBC = (double) (y3 - y2) / (x3 - x2);
        double slopeAC = (double) (y3 - y1) / (x3 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    public static boolean areCollinearUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1: ");
        int x1 = sc.nextInt();
        System.out.print("Enter y1: ");
        int y1 = sc.nextInt();
        System.out.print("Enter x2: ");
        int x2 = sc.nextInt();
        System.out.print("Enter y2: ");
        int y2 = sc.nextInt();
        System.out.print("Enter x3: ");
        int x3 = sc.nextInt();
        System.out.print("Enter y3: ");
        int y3 = sc.nextInt();

        boolean isCollinearSlope = areCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
        boolean isCollinearArea = areCollinearUsingArea(x1, y1, x2, y2, x3, y3);

        if (isCollinearSlope && isCollinearArea) {
            System.out.println("The points are collinear.");
        } else {
            System.out.println("The points are not collinear.");
        }
    }
}
