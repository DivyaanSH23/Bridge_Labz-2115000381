import java.util.*;

public class Subset {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3)); 
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4)); 

        System.out.println(set2.containsAll(set1)); 
    }
}

