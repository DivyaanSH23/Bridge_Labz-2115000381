import java.util.*;
class Insertion{
public static  void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int a[]=new int[n];

for(int i=0;i<n;i++){
a[i]=sc.nextInt();
}

for(int i=0;i<n;i++){
System.out.print(a[i]+" ");
}
System.out.println();

for(int i=1;i<n;i++){
	for(int  j=i;j>0;j--){
		if(a[j]<a[j-1]){
		int temp=a[j];
		a[j]=a[j-1];
		a[j-1]=temp;
		}
	}
}

for(int i=0;i<n;i++){
System.out.print(a[i]+" ");
}

}
}

