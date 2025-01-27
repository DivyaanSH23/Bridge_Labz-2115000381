import java.util.Scanner;

public class Total {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double userInput;

        while ((userInput = sc.nextDouble()) > 0) {
            total += userInput;
            System.out.print("Enter a number (0 or negative number to stop ): ");
        }

        System.out.println("The total is " + total);
    }
}
