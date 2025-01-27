import java.util.Scanner;

public class CountdownFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter countdown value: ");
        int counter = sc.nextInt();
        
        for (; counter >= 1; counter--) {
            System.out.println("T-" + counter + " seconds");
        }
        
        System.out.println("Launch!");
    }
}
