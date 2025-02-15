import java.util.*;
class SB2{
public static void main(String args[]){
StringBuilder sb=new StringBuilder();
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
HashSet<Character> set=new HashSet<>();


for(int i=0;i<s.length();i++){
if(!set.contains(s.charAt(i))){
set.add(s.charAt(i));
sb.append(s.charAt(i));
}
}

String uni=sb.toString();
System.out.println(uni);
}
}

