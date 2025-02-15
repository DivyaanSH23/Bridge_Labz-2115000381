import java.util.*;
class SB1{
public static void main(String args[]){
StringBuilder sb=new StringBuilder();
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();

for(int i=s.length()-1;i>=0;i--){
sb.append(s.charAt(i));
}
String rev=sb.toString();
System.out.println(rev);
}
}

