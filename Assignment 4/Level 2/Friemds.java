import java.util.*;
class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height for " + names[i] + ": ");
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }

        int youngest = (ages[0] < ages[1]) ? (ages[0] < ages[2] ? 0 : 2) : (ages[1] < ages[2] ? 1 : 2);
        int tallest = (heights[0] > heights[1]) ? (heights[0] > heights[2] ? 0 : 2) : (heights[1] > heights[2] ? 1 : 2);

        System.out.println("Youngest: " + names[youngest]);
        System.out.println("Tallest: " + names[tallest]);
    }
}

