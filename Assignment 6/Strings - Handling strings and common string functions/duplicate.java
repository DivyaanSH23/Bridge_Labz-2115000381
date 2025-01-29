import java.util.*;
class duplicate{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
StringBuilder str=new StringBuilder();
HashSet<Character> set=new HashSet<>();
for(int i=0;i<s.length();i++){
if(!set.contains(s.charAt(i)))
{
str.append(s.charAt(i));
set.add(s.charAt(i));
}
}
String ans=new String(str);
System.out.println("THE MODIFIED STRING IS :"+ans);
}
}
