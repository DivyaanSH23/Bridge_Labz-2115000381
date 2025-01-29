import java.util.*;

public class remove {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the string: ");
        String inputString = sc.nextLine();
        
        System.out.print("Enter the character to remove: ");
        char charToRemove = sc.next().charAt(0); 
        String modifiedString = inputString.replaceAll(Character.toString(charToRemove), "");


        System.out.println("Modified String: " + modifiedString);
    }
}
