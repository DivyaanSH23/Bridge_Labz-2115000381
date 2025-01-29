import java.util.*;
class laxico
{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("ENTER TWO STRINGS");
String s=sc.next();
int q=0;
String s2=sc.next();
int l=Math.min(s.length(),s2.length());
for(int i=0;i<l;i++){
char ch=s.charAt(i);
char ch2=s2.charAt(i);
if((int)ch<(int)ch2){
System.out.println(s+" STRING COMES FIRST");
q++;
break;
}
else if((int)ch>(int)ch2){
System.out.println(s2+" STRING COMES FIRST");
q++;
break;
}
else
continue;
}
if(q==0){
if(s.length()==l)
System.out.println(s+"STRING COMES FIRST");
else
System.out.println(s2+"STRING COMES FIRST");
}
}
}

