import java.util.*;

public class NumberChecker5 {

    public static int[] findFactors(int num) {
        int[] factors = new int[num]; 
        int count = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                factors[count] = i;
                count++;
            }
        }
        factors[count] = num;  
        return Arrays.copyOf(factors, count + 1);  
    }

    public static int greatestFactor(int num) {
        int[] factors = findFactors(num);
        return factors[factors.length - 1];  
    }

    public static int sumOfFactors(int num) {
        int[] factors = findFactors(num);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int productOfFactors(int num) {
        int[] factors = findFactors(num);
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double productOfCubesOfFactors(int num) {
        int[] factors = findFactors(num);
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfect(int num) {
        int sum = sumOfFactors(num) - num; 
        return sum == num;
    }

    public static boolean isAbundant(int num) {
        int sum = sumOfFactors(num) - num; 
        return sum > num;
    }

    public static boolean isDeficient(int num) {
        int sum = sumOfFactors(num) - num; 
        return sum < num;
    }

    public static boolean isStrong(int num) {
        int temp = num;
        int sum = 0;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int[] factors = findFactors(num);
        
        System.out.println("Factors of " + num + ": " + Arrays.toString(factors));
        
        System.out.println("Greatest factor of " + num + ": " + greatestFactor(num));
        
        System.out.println("Sum of factors of " + num + ": " + sumOfFactors(num));
        
        System.out.println("Product of factors of " + num + ": " + productOfFactors(num));
        
        System.out.println("Product of cubes of factors of " + num + ": " + productOfCubesOfFactors(num));
        
        if (isPerfect(num)) {
            System.out.println(num + " is a Perfect number.");
        } else {
            System.out.println(num + " is not a Perfect number.");
        }

        if (isAbundant(num)) {
            System.out.println(num + " is an Abundant number.");
        } else {
            System.out.println(num + " is not an Abundant number.");
        }

        if (isDeficient(num)) {
            System.out.println(num + " is a Deficient number.");
        } else {
            System.out.println(num + " is not a Deficient number.");
        }

        if (isStrong(num)) {
            System.out.println(num + " is a Strong number.");
        } else {
            System.out.println(num + " is not a Strong number.");
        }
    }
}
