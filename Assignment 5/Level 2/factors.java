import java.util.*;
public class factors {
    public static int[] fact(int n){
        int c=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                c++;
            }
        }
        int a[]=new int[c];

       int ab=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                a[ab++]=i;
            }
        }
        return a;
    }
    public int sum(int a[]){
        int sum=0;
        for(int i:a){
            sum=sum+i;
        }
        return sum;
    }
    public int pro(int a[]){
        int pro=1;
        for(int i:a){
            pro=pro*i;
        }
        return pro;
    }
    public int sumSqa(int a[]){
        int sumSqa=0;
        for(int i:a){
            sumSqa=sumSqa + (int)Math.pow(i,2);
        }
        return sumSqa;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res[]=fact(n);

        factors obj=new factors();
        int sum=obj.sum(res);
        int pro=obj.pro(res);
        int sumSqa=obj.sumSqa(res);

        System.out.printf("THE SUM OF FACTORES ARE %d , PRODUCT OF FACTORS ARE %d AND THE SUM OF SQUATE OF FACTORS ARE %d%n",sum,pro,sumSqa);



    }
}
