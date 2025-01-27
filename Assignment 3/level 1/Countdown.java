import java.util.Scanner;

public class Countdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter countdown value: ");
        int counter = sc.nextInt();
        while (counter >= 1) {
            System.out.println("T-" + counter + " seconds");
            counter--;
        }
        System.out.println("Launch!");
    }
}
