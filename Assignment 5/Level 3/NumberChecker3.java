import java.util.*;

public class NumberChecker3 {
    
    public static int count(int digits) {
        int c = 0;
        while (digits != 0) {
            c++;
            digits = digits / 10;
        }
        return c;
    }
    
    public static int[] store(int digit, int c) {
        int a[] = new int[c];
        int i = 0;
        while (digit != 0) {
            a[i] = digit % 10;
            i++;
            digit = digit / 10;
        }
        return a;
    }
    
    public static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
    
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome(int[] arr) {
        int[] reversedArr = Arrays.copyOf(arr, arr.length);
        reverse(reversedArr);
        return compareArrays(arr, reversedArr);
    }
    
    public static boolean isDuckNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public static int sum(int[] d) {
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum = sum + d[i];
        }
        return sum;
    }
    
    public static int sumPow(int[] d) {
        int sumpow = 0;
        for (int i = 0; i < d.length; i++) {
            sumpow = sumpow + (int) Math.pow(d[i], 2);
        }
        return sumpow;
    }
    
    public static boolean harshad(int d, int sum) {
        return d % sum == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int digit = sc.nextInt();
        
        int count = count(digit);
        int[] store = store(digit, count);
        
        int sum = sum(store);
        int sumPow = sumPow(store);
        
        System.out.printf("The digit is %d, and its count is %d, sum of digits is %d, sum of squares of digits is %d%n", 
                          digit, count, sum, sumPow);
        
        if (harshad(digit, sum)) {
            System.out.println("It is a Harshad number.");
        } else {
            System.out.println("It is not a Harshad number.");
        }

        System.out.print("Digits of the number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(store[i] + " ");
        }
        System.out.println();

        if (isPalindrome(store)) {
            System.out.println("The number is a palindrome.");
        } else {
            System.out.println("The number is not a palindrome.");
        }

        if (isDuckNumber(store)) {
            System.out.println("The number is a Duck number.");
        } else {
            System.out.println("The number is not a Duck number.");
        }
        
        reverse(store);
        System.out.print("Reversed digits: ");
        for (int i = 0; i < count; i++) {
            System.out.print(store[i] + " ");
        }
        System.out.println();
    }
}
