import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        
        String maxKey = findKeyWithMaxValue(map);
        System.out.println("Key with Maximum Value: " + maxKey);
    }

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
