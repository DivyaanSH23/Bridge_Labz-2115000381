import java.util.*;
public class athlete {
    public int calculate(int a1, int a2, int a3){
        int sum=a1+a2+a3;
        int sum2=0;
        int tot=0;
        while(sum2<=5000){
            tot++;
            sum2=sum2+sum;
        }
        
        return tot;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE SIDES OF TRANGLE");
        int a1=sc.nextInt();
        int a2=sc.nextInt();
        int a3=sc.nextInt();

        athlete obj=new athlete();
        int n=obj.calculate(a1,a2,a3);
        System.out.println("THE NO. OF ROUNDS NEENDED TO COMPLETE 5KM ARE :"+n);

    }
}
