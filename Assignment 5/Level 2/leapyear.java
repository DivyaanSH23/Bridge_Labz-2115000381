import java.util.*;
 class leapyear{
 public Boolean year(int n){
	if(n<1582)
	return false;
if((n%4==0 && n%100!=0)||n%400==0)
	return true;
else
 return false;
}
 public static void main(String args[]){
 Scanner sc=new Scanner (System.in);
 int n=sc.nextInt();
leapyear obj=new leapyear();
 Boolean year=obj.year(n);
if(year)
System.out.println("THIS YEAR IS LEAP YEAR");
else
System.out.println("THIS YEAR IS NOT A LEAP YEAR");
}
}

