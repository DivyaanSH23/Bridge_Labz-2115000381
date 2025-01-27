import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;

        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println("The result of " + number + " raised to the power " + power + " is " + result);
    }
}
