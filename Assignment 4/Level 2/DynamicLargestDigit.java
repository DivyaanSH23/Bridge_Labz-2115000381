
import java.util.*;
class DynamicLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (num > 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            digits[index++] = num % 10;
            num /= 10;
        }

        int largest = 0, secondLargest = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
    }
}



