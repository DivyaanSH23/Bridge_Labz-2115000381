import java.util.*;

public class NumberChecker4 {
    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;
        while (square != 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }
    
    public static boolean isSpy(int num) {
        int sum = 0, product = 1;
        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }
        return sum == product;
    }
    
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        int length = (int) Math.log10(num) + 1;
        int lastDigits = square % (int) Math.pow(10, length);
        return lastDigits == num;
    }
    
    public static boolean isBuzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (isPrime(num)) {
            System.out.println(num + " is a Prime number.");
        } else {
            System.out.println(num + " is not a Prime number.");
        }
        
        if (isNeon(num)) {
            System.out.println(num + " is a Neon number.");
        } else {
            System.out.println(num + " is not a Neon number.");
        }
        
        if (isSpy(num)) {
            System.out.println(num + " is a Spy number.");
        } else {
            System.out.println(num + " is not a Spy number.");
        }
        
        if (isAutomorphic(num)) {
            System.out.println(num + " is an Automorphic number.");
        } else {
            System.out.println(num + " is not an Automorphic number.");
        }
        
        if (isBuzz(num)) {
            System.out.println(num + " is a Buzz number.");
        } else {
            System.out.println(num + " is not a Buzz number.");
        }
    }
}
