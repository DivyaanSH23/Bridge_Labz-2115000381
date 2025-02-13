import java.util.*;

class ZeroSumSubarrays {
    public static void findSubarraysWithZeroSum(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cumulativeSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            
            if (cumulativeSum == 0) {
                System.out.println("Subarray found from index 0 to " + i);
            }
            
            if (map.containsKey(cumulativeSum)) {
                List<Integer> list = map.get(cumulativeSum);
                for (int index : list) {
                    System.out.println("Subarray found from index " + (index + 1) + " to " + i);
                }
            }
            
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, -1, 3, -2, 2, -3, 1, 4, -4};
        findSubarraysWithZeroSum(arr);
    }
}
