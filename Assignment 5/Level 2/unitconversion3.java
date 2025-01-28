import java.util.Scanner;

public class unitconversion3 {
    static final double KM_TO_MILES = 0.621371;
    static final double MILES_TO_KM = 1.60934;
    static final double METERS_TO_FEET = 3.28084;
    static final double FEET_TO_METERS = 0.3048;
    private static final double YARDS_TO_FEET = 3;
    private static final double FEET_TO_YARDS = 0.333333;
    private static final double METERS_TO_INCHES = 39.3701;
    private static final double INCHES_TO_METERS = 0.0254;
    private static final double INCHES_TO_CM = 2.54;

    public static double convertKmToMiles(double km) {
        return km * KM_TO_MILES;
    }

    public static double convertMilesToKm(double miles) {
        return miles * MILES_TO_KM;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * METERS_TO_FEET;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * FEET_TO_METERS;
    }

    public static double convertYardsToFeet(double yards) {
        return yards * YARDS_TO_FEET;
    }

    public static double convertFeetToYards(double feet) {
        return feet * FEET_TO_YARDS;
    }

    public static double convertMetersToInches(double meters) {
        return meters * METERS_TO_INCHES;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * INCHES_TO_METERS;
    }

    public static double convertInchesToCm(double inches) {
        return inches * INCHES_TO_CM;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter kilometers to convert to miles: ");
        double km = scanner.nextDouble();
        System.out.println(km + " km to miles: " + convertKmToMiles(km));

        System.out.print("Enter miles to convert to kilometers: ");
        double miles = scanner.nextDouble();
        System.out.println(miles + " miles to km: " + convertMilesToKm(miles));

        System.out.print("Enter meters to convert to feet: ");
        double meters = scanner.nextDouble();
        System.out.println(meters + " meters to feet: " + convertMetersToFeet(meters));

        System.out.print("Enter feet to convert to meters: ");
        double feet = scanner.nextDouble();
        System.out.println(feet + " feet to meters: " + convertFeetToMeters(feet));

        System.out.print("Enter yards to convert to feet: ");
        double yards = scanner.nextDouble();
        System.out.println(yards + " yards to feet: " + convertYardsToFeet(yards));

        System.out.print("Enter feet to convert to yards: ");
        feet = scanner.nextDouble();
        System.out.println(feet + " feet to yards: " + convertFeetToYards(feet));

        System.out.print("Enter meters to convert to inches: ");
        meters = scanner.nextDouble();
        System.out.println(meters + " meters to inches: " + convertMetersToInches(meters));

        System.out.print("Enter inches to convert to meters: ");
        double inches = scanner.nextDouble();
        System.out.println(inches + " inches to meters: " + convertInchesToMeters(inches));

        System.out.print("Enter inches to convert to centimeters: ");
        inches = scanner.nextDouble();
        System.out.println(inches + " inches to cm: " + convertInchesToCm(inches));

        scanner.close();
    }
}
