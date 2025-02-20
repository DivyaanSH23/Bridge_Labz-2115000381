import java.util.*;
class StringFreq{
public static void main(String []args){
Scanner sc=new Scanner(System.in);
HashMap<String,Integer> map=new HashMap<>();
int n=10;
for(int i=0;i<n;i++){
	String s=sc.nextLine();
	map.put(s,map.getOrDefault(s,0)+1);
}

System.out.println(map);
}
}

