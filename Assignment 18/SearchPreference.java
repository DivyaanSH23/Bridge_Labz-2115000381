import java.util.Arrays;
import java.util.Random;

public class SearchPreference {
    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};

        for (int size : datasetSizes) {
            int[] arr = new int[size];


            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }


            Random random = new Random();
            int target = random.nextInt(size);


            long startTime = System.nanoTime();
            linearSearch(arr, target);
            long linearTime = (System.nanoTime() - startTime) / 1_000_000; 


            startTime = System.nanoTime();
            binarySearch(arr, target);
            long binaryTime = (System.nanoTime() - startTime) / 1_000_000; 


            System.out.printf("%12d | %22d | %21d%n", size, linearTime, binaryTime);
        }
    }


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
