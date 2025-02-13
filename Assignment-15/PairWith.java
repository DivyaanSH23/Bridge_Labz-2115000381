import java.util.HashSet;

class PairWith {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 8, 10};
        int target = 14;
        System.out.println(hasPairWithSum(nums, target));
    }
}
