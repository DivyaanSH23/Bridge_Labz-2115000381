import java.util.*;
class Selection{
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
for(int i=0;i<n;i++){
	int small=Integer.MAX_VALUE;
	int k=-1;
        for(int  j=i;j<n;j++){
                if(a[j]<small){
                	small=a[j];
			k=j;
                }
        }
	int temp=a[i];
	a[i]=a[k];
	a[k]=temp;
}

for(int i=0;i<n;i++){
System.out.print(a[i]+" ");
}

}
}


