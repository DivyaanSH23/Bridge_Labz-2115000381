import java.util.*;

 class random {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int low = 1, high = 100;
        boolean guessedCorrectly = false;
        
        System.out.println("Think of a number between 1 and 100. The computer will try to guess it.");
        
        while (!guessedCorrectly && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter: 'H' for high, 'L' for low, 'C' for correct)");
            
            char response = scanner.next().toUpperCase().charAt(0);
            
            if (response == 'C') {
                guessedCorrectly = true;
            } else if (response == 'H') {
                high = guess - 1;
            } else if (response == 'L') {
                low = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'H', 'L', or 'C'.");
            }
        }
        
        System.out.println("Hooray! The computer guessed your number correctly!");
        scanner.close();
    }
    
    public static int generateGuess(int low, int high) {
        if (low > high) return low;  
        return low + (int)(Math.random() * (high - low + 1));
    }
}
