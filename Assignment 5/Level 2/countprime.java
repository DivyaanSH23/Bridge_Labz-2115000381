import java.util.*;
class countprime{
public static Boolean isPrime(int a){
if(a<2)
return false;

for(int i=2;i*i<=a;i++){
if(a%i==0){
return false;
}
}
return true;
}
public static void main(String args[])
{
Scanner sc=new Scanner (System.in);
int n=sc.nextInt();
int arr[]=new int[n];
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}
int count=0;
for(int i=0;i<n;i++){
int a=arr[i];
if(isPrime(a)){
count++;
}
}
System.out.println("THE NO. OF PRIME NUMBERS IN THE ARRAY ARE :"+count);
}
}
