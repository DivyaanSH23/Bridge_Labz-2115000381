import java.util.*;
public class FactorialUsingFor{
public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int fact=1;
        for(;n>0;n--){
        fact=fact*n;
        }
        System.out.println("The Factorial is "+fact);
}
}
