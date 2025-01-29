import java.util.Scanner;

public class anagram {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

       System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();


        if (areAnagrams(str1, str2)) {
            System.out.println("The two strings are anagrams.");
        } else {
            System.out.println("The two strings are not anagrams.");
        }
    }


    public static boolean areAnagrams(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }


        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();


        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);


        return java.util.Arrays.equals(arr1, arr2);
    }
}

