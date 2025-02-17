import java.util.HashSet;
import java.util.TreeSet;

public class SearchComparison {

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = 99999;

        long startTime = System.nanoTime();
        linearSearch(array, target);
        long endTime = System.nanoTime();
        long arrayTime = endTime - startTime;

        startTime = System.nanoTime();
        hashSet.contains(target);
        endTime = System.nanoTime();
        long hashSetTime = endTime - startTime;

        startTime = System.nanoTime();
        treeSet.contains(target);
        endTime = System.nanoTime();
        long treeSetTime = endTime - startTime;

        System.out.println("Array Search Time: " + arrayTime / 1_000_000 + " ms");
        System.out.println("HashSet Search Time: " + hashSetTime / 1_000_000 + " ms");
        System.out.println("TreeSet Search Time: " + treeSetTime / 1_000_000 + " ms");
    }

    public static void linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return;
        }
    }
}
