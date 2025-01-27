ximport java.util.Scanner;

public class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ageAmar = sc.nextInt();
        int ageAkbar = sc.nextInt();
        int ageAnthony = sc.nextInt();

        double heightAmar = sc.nextDouble();
        double heightAkbar = sc.nextDouble();
        double heightAnthony = sc.nextDouble();

        String youngest = "Amar";
        int youngestAge = ageAmar;
        if (ageAkbar < youngestAge) {
            youngest = "Akbar";
            youngestAge = ageAkbar;
        }
        if (ageAnthony < youngestAge) {
            youngest = "Anthony";
            youngestAge = ageAnthony;
        }

        String tallest = "Amar";
        double tallestHeight = heightAmar;
        if (heightAkbar > tallestHeight) {
            tallest = "Akbar";
            tallestHeight = heightAkbar;
        }
        if (heightAnthony > tallestHeight) {
            tallest = "Anthony";
            tallestHeight = heightAnthony;
        }

        System.out.println(youngest + " is the youngest with age " + youngestAge + ".");
        System.out.println(tallest + " is the tallest with height " + tallestHeight + ".");
    }
}

