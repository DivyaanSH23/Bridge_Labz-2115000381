import java.util.*;
class FirstNegative{
public static void main(String args[]){
StringBuffer sb=new StringBuffer();
Scanner sc=new Scanner(System.in);
System.out.println("ENTER THE SIZE");
int n=sc.nextInt();
System.out.println("Enter the Number in array");
int a[]=new int[n];
int c=0;

for(int i=0;i<n;i++){
a[i]=sc.nextInt();
}

for(int i=0;i<n;i++){
int x=a[i];
if(x<0){
System.out.println("THE FIRST NEGATIVE NUMBER IS : "+x+" AND AT INDEX :"+i);
c=1;
break;
}
}
if(c==0)
System.out.println(-1);
}
}
