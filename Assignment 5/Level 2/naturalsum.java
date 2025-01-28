import java.util.*;
 class naturalsum{
 public static int sum(int n){
	if(n==0)
	return 0;
return n+sum(n-1);
}
 public static void main(String args[]){
 Scanner sc=new Scanner(System.in);
 int n=sc.nextInt();
 int res=sum(n);
 int formula=(n*(n+1))/2;
	if(formula==res){

	System.out.printf("THE sum of natural no. %d is %d%n",n,res);
	System.out.println("BOTH ARE CORRECT");

}
else
System.out.println("THEY BOTH ARE WRONG");
}
}
