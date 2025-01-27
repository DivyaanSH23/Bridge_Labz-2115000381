
import java.util.*;
class LargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int largest = 0, secondLargest = 0;

        while (num > 0) {
            int digit = num % 10;
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
            num /= 10;
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
    }
}

