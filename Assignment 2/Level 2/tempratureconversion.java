import java.util.*;
class tempratureconversion{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
double faren=sc.nextDouble();
double celsius=(faren-32)*(5.0/9);
System.out.println("THE "+faren+" FARENHIET IN CELSIUS IS: "+celsius);
}
}
