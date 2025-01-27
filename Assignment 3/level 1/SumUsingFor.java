import java.util.*;
public class SumUsingFor{
        public static void main(String args[]){
                Scanner sc = new Scanner(System.in);
                int n=sc.nextInt();
                int Total=0;
                int sum=0;
                if(n>0){
                int temp=n;
                for(;n>0;n--){
                Total=Total+n;
                }
                 sum=(temp*(temp+1))/2;
                }
                else{
                System.out.println("Not a natural number");
                }
                if(sum==Total){
                System.out.println("The sum is "+Total);
}
}
}
