import java.util.*;
class price{
public static void main(String args[]){
Scanner sc=new Scanner (System.in);
int quantity=sc.nextInt();
double price=sc.nextDouble();
double net=price*quantity;
System.out.println("THE TOTAL PURCHASE PRICE IS :"+net+" AND THE QUANTITY IS :"+quantity+" AND THE UNIT PRICE IS :"+price);
}
}
