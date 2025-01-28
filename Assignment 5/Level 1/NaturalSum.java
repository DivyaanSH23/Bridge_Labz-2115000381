import java.util.*;
class NaturalSum{
    public int sum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        NaturalSum obj=new NaturalSum();
        int z=obj.sum(n);
        System.out.println("The sum of "+n+" natural numbers are :"+z);
    }
}