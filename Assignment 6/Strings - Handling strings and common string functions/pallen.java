import java.util.*;
class pallen{
public static void main(String args[]){
Scanner sc=new Scanner (System.in);
String s=sc.nextLine();
int q=0;
int size=s.length();
int rev=size-1;
for(int i=0;i<size/2;i++){
if(s.charAt(i)!=s.charAt(rev)){
q++;
}
else
rev--;
}
if(q==0)
System.out.println("PALLENDRONE STRING");
else
System.out.println("NOT PALLENDRONE STRING");

}
}
