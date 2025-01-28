import java.util.*;
class SimpleInterest{
    public double Si(int pi,int ra, int ti){
        double si=(pi*ra*ti*1.0)/100;
        return si;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("ENETR THE PRINCIPAL, RATE AND TIME");
        int p=sc.nextInt();
        int r=sc.nextInt();
        int t=sc.nextInt();

        SimpleInterest obj=new SimpleInterest();
        double SI=obj.Si(p,r,t);
        System.out.println("The Simple Interest is "+SI+" for Principal"+p+", Rate of Interest "+r+" and Time "+t);

        }
}