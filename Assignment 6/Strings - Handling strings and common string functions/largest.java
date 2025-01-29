import java.util.*;
class largest{
public static void main(String[] args){
Scanner sc=new Scanner (System.in);
String s=sc.nextLine();
s.trim();
int q=-1;
s=s+" ";
int t=0;
int c=0;
int max=Integer.MIN_VALUE;
for(int i=0;i<s.length();i++){
if(s.charAt(i)!=' '){
c++;
}
else{
max=Math.max(max,c);
c=0;
}
}
for(int i=0;i<s.length();i++){
if(s.charAt(i)==' '){
if((i-q-1)==max){
System.out.println("THE LARGEST WORD  IS :"+s.substring(q,i));
}
else{
q=i;
}
}
}
}
}

