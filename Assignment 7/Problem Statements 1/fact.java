import java.util.*;

public class fact {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int num = scanner.nextInt();
        return num;
    }


    public static void displayResult(int num, int result) {
        System.out.println("The factorial of " + num + " is: " + result);
    }


    public static void main(String[] args) {
        int num = getInput(); 
        if (num < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            int result = factorial(num); 
            displayResult(num, result);  
        }
    }
}
