import java.util.*;

public class NumberCheck {
    
    static boolean isPositive(int num) {
        return num >= 0;
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    static int compare(int num1, int num2) {
        return Integer.compare(num1, num2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.print(num + " is Positive and ");
                if (isEven(num)) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println(num + " is Negative");
            }
        }

        int result = compare(numbers[0], numbers[4]);
        if (result > 0) {
            System.out.println("First number is Greater than Last number");
        } else if (result < 0) {
            System.out.println("First number is Less than Last number");
        } else {
            System.out.println("First and Last numbers are Equal");
        }
    }
}
