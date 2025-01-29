import java.util.*;
class freq
{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("ENTER THE STRINGS");
String s=sc.next();
HashMap<Character,Integer> map=new HashMap<>();
for(int i=0;i<s.length();i++){
char ch=s.charAt(i);
map.put(ch,map.getOrDefault(ch,0)+1);
}
int max=Integer.MIN_VALUE;
for(int i=0;i<s.length();i++){
char ch=s.charAt(i);
max=Math.max(max,map.get(ch));
}
for(Map.Entry<Character,Integer> entry:map.entrySet()){
if(entry.getValue()==max){
System.out.println("THE MAXIMUM OCCURENCE OF CHARACTERS IS : "+entry.getKey()+" AND OCCURE :"+entry.getValue()+" TIMES");
break;
}
}

}
}
