import java.util.*;
class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        System.out.print("Reversed Number: ");
        while (num > 0) {
            System.out.print(num % 10);
            num /= 10;
        }
    }
}

