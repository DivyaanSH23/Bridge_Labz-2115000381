import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String s = sc.next();

        System.out.print("Enter the substring to search: ");
        String sb = sc.next();

        sc.close(); 

        int count = 0;
        int sbLength = sb.length();

        for (int i = 0; i <= s.length() - sbLength; i++) {
            if (s.substring(i, i + sbLength).equals(sb)) {
                count++;
            }
        }

        System.out.println("The substring appears " + count + " times.");
    }
}
