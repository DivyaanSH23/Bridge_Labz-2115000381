import java.util.*;

class UnioAndInterSet{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
	Set<Integer> set3 = new HashSet<>();
	Set<Integer> set4=new HashSet<>();

	
	set1.add(10);
        set1.add(20);
        set1.add(30);

        set2.add(30);
        set2.add(50);
        set2.add(100);

	set3.addAll(set1);
	set3.addAll(set2);

	set4.addAll(set1);
	set4.retainAll(set2);

System.out.println("THE UNION IS " + set3);
System.out.println("THE INTERSECTION IS "+ set4);
    }
}
