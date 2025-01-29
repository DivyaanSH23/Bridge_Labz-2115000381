import java.util.*;

class temp {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Is the temperature in Fahrenheit (F) or Celsius (C)? ");
        char scale = scanner.next().charAt(0);

        if (scale == 'F' || scale == 'f') {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit is " + celsius + " Celsius.");
        } else if (scale == 'C' || scale == 'c') {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius is " + fahrenheit + " Fahrenheit.");
        } else {
            System.out.println("Invalid input. Please enter 'F' for Fahrenheit or 'C' for Celsius.");
        }
    }
}
