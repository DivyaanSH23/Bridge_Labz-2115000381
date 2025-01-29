import java.util.*;
class reverse{
public static void main(String args[]){
Scanner sc=new Scanner (System.in);
String s=sc.nextLine();
System.out.println("ORIGINAL STRING :"+s);
System.out.print("REVERSE STRING : ");
for(int i=s.length()-1;i>=0;i--){
System.out.print(s.charAt(i));
}
}
}
