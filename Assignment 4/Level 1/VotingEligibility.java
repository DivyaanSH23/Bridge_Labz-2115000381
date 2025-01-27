import java.util.*;
class VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = input.nextInt();

            if (ages[i] < 0) {
                System.out.println("Invalid age! Enter a positive number.");
                i--;  
            }
        }

        for (int age : ages) {
            if (age >= 18) {
                System.out.println("Student with age " + age + " can vote.");
            } else {
                System.out.println("Student with age " + age + " cannot vote.");
            }
        }
       
    }
}



