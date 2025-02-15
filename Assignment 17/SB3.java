import java.util.*;
class SB3{
public static void main(String args[]){
StringBuffer sb=new StringBuffer();
Scanner sc=new Scanner(System.in);
System.out.println("ENTER THE SIZE");
int n=sc.nextInt();
System.out.println("Enter the String in array");
char a[]=new char[n];

for(int i=0;i<n;i++){
a[i]=sc.next().charAt(0);
}


for(int i=0;i<n;i++){
sb.append(a[i]);
}

String join=sb.toString();
System.out.println(join);
}
}

