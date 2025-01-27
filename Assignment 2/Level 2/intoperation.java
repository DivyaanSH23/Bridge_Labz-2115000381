import java.util.*;
class intoperation{
public static void main(String args[])
{
Scanner sc=new Scanner (System.in);
int a=sc.nextDouble();
int b=sc.nextDouble();
int c=sc.nextDouble();
int result1=a+b*c;
int result2=a*b+c;
int result3=c+a/b;
int result4=a%b+c;
System.out.println("THE RESULT OF INTOPERATIONS ARE :"+result1+" , "+result2+" , "+result3+" , "+result4);
}
}
