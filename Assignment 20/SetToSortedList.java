import java.util.*;

class SymmetricDefSet{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
	set1.add(56);
        set1.add(2);
        set1.add(3);
	set1.add(89);


ArrayList<Integer> list=new ArrayList<>();

list.addAll(set1);
System.out.println("BEFORE SORT :"+list);

Collections.sort(list);

System.out.println("AFTER SORT :"+list);
}
}
