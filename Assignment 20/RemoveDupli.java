import java.util.*;
class RemoveDupli{
public static void main(String []args){
Scanner sc=new Scanner(System.in);
HashSet<Integer> set=new HashSet<>();
int n=10;
ArrayList<Integer> list=new ArrayList<>();
for(int i=0;i<n;i++){
	int s=sc.nextInt();
	if(!set.contains(s)){
		set.add(s);
		list.add(s);
}
}
System.out.println(list);
}
}
