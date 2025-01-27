import java.util.*;
class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] table = new int[10];

        for (int i = 0; i < 10; i++) {
            table[i] = number * (i + 1);
        }

        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < 10; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }

            }
}



