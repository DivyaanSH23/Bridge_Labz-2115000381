import java.util.*;

class fibo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int terms = getInput(scanner, "Enter the number of terms: ");
        generateFibonacci(terms);
        
        scanner.close();
    }
    
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;
        
        for (int i = 0; i < terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}
