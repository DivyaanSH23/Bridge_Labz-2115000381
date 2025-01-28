import java.util.*;
class twoarrays{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("ENTER THE SIZE");
int n=sc.nextInt();
int a[]=new int[n];
int b[]=new int[n];
System.out.println("ENTER THE ELEMENTS OF FIRST ARRAY");
for(int i=0;i<n;i++){
a[i]=sc.nextInt();
}
System.out.println("ENTER THE ELEMENTS OF SECOND ARRAY");
for(int i=0;i<n;i++){
b[i]=sc.nextInt();
}
HashSet<Integer> set=new HashSet<>();
for(int i=0;i<n;i++){
if(!set.contains(a[i])){
set.add(a[i]);
}
}
for(int i=0;i<n;i++){
if(set.contains(b[i])){
System.out.printf("%d ALREADY EXIST IN FIRST ARRAY %n",b[i]);
}
}
}
}



