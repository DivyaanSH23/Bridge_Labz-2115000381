import java.util.*;
class fees2{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);

double fees=sc.nextDouble();
double discount=sc.nextDouble();
double discounted=(fees*discount)/100;
double finalfees=fees-discounted;
System.out.println("THE DISCOUNTED AMOUNT IS INR "+discounted+" AND THE FINAL FEES IS "+finalfees);
}
}

