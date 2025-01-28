import java.util.Random;

public class StudentScores {

    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 50 + rand.nextInt(51);
            scores[i][1] = 50 + rand.nextInt(51);
            scores[i][2] = 50 + rand.nextInt(51);
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 150.0) * 100;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t\t%d\t\t%d\t%d\t%.2f\t%.2f%%\n", 
                i + 1, scores[i][0], scores[i][1], scores[i][2], 
                (int) results[i][0], results[i][1], results[i][2]);
        }
    }

    public static void main(String[] args) {
        int numStudents = 5;
        int[][] scores = generateScores(numStudents);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
    }
}
