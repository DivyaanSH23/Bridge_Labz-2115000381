import java.util.*;
public class windchill {
    
    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        windchill obj = new windchill();

        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the wind speed: ");
        double windSpeed = scanner.nextDouble();

        double windChill = obj.calculateWindChill(temperature, windSpeed);
        System.out.println("The wind chill temperature is: " + windChill);

    }
}
