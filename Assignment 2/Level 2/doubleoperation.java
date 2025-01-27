import java.util.*;
class doubleoperation{
public static void main(String args[])
{
Scanner sc=new Scanner (System.in);
double a=sc.nextDouble();
double b=sc.nextDouble();
double c=sc.nextDouble();
double result1=a+b*c;
double result2=a*b+c;
double result3=c+a/b;
double result4=a%b+c;
System.out.println("THE RESULT OF INTOPERATIONS ARE :"+result1+" , "+result2+" , "+result3+" , "+result4);
}
}

