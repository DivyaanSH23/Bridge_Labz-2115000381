import java.util.*;
public class QandR {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int a[]=new int[2];
        a[0]=number/divisor;
        a[1]=number%divisor;
        return a;
    }
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int x1=sc.nextInt();
    int x2=sc.nextInt();

    int res[]=findRemainderAndQuotient(x1, x2);
    System.out.println("THE QUOTIENT AND REMAINDER IS :"+res[0]+","+res[1]);
    
 }   
}
