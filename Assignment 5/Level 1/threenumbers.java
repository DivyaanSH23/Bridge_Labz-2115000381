import java.util.*;
public class threenumbers { 
    public static int[] findSmallestAndLargest(int number1, int number2, int number3)
        {
            int maxs=Math.max((Math.max(number1,number2)),number3);
            int mins=Math.min((Math.min(number1,number2)),number3);
            int a[]=new int[2];
            a[0]=mins;
            a[1]=maxs;

            return a;
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int Number1=sc.nextInt();
            int Number2=sc.nextInt();
            int Number3=sc.nextInt();
            
            int res[]=findSmallestAndLargest(Number1, Number2, Number3);
            System.out.println("The smallest and largest no. is :"+res[0]+","+res[1]);

        }
}
