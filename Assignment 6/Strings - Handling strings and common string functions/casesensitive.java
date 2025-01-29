import java.util.Scanner;

public class csesensitive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();         
        sc.close();
        
        StringBuilder toggledString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
              if (Character.isUpperCase(ch)) {
                toggledString.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggledString.append(Character.toUpperCase(ch));
            } else {
                toggledString.append(ch); 
  }
        }

        System.out.println("Toggled case string: " + toggledString);
    }
}
