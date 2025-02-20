import java.util.*;

class SymmetricDefSet{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();


        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

	for(int i :set1){
	if(!set2.contains(i)) set3.add(i);
	}

	for(int i :set2){
	if(!set1.contains(i)) set3.add(i);
	}

	System.out.println(set3);
}
}
