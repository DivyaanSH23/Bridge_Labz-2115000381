import java.util.*;
class vowels{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
int v=0;
int c=0;
for(int i=0;i<s.length();i++){
char ch=s.charAt(i);
if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
v++;
else 
c++;
}
System.out.println("THE NUMBER OF VOWELS ARE "+v+" AND THE NUMBERS OF CONSONETS ARE "+c+" IN THE STRING "+s);
}
}
