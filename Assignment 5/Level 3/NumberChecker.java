import java.util.*;
public class NumberChecker {
    public static int count(int digits){
        int c=0;
        while(digits!=0){
            c++;
            digits=digits/10;
        }
        return c;
    }
    public static int[] store(int digit,int c){
        int a[]=new int[c];
        int i=0;
        while(digit!=0)
        {
            a[i]=digit%10;
            i++;
            digit =digit/10;
        }
        return a;
    }
    public static boolean arms(int d,int c){
        int sum=0;
        int temp=d;
        while(temp!=0){
            sum=sum+(int)Math.pow(temp%10,c);
            temp=temp/10;
        }
        if(sum==d)
        return true;
        else
        return false;
    }
    public static int largest(int []d){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<d.length;i++){
            max=Math.max(max,d[i]);
        }
        return max;

    }
    public static int smallest(int []d){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<d.length;i++){
            min=Math.min(min,d[i]);
        }
        return min;

    }
    public static boolean duck(int []d){
        for(int i=0;i<d.length;i++){
            if(d[i]==0)
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int digit=sc.nextInt();
    int count=count(digit);
    int store[]=store(digit,count);
    boolean arms=arms(digit,count);
    int largest=largest(store);
    int smallest=smallest(store);
    System.out.printf("THE DIGIT IS %d AND ITS COUNT IS %d  AND ITS LARGEST IS %d AND ITS SMALLEST IS %d%n",digit,count,largest,smallest);
    if(duck(store)){
        System.out.println("Duck number");
    }
    else{
        System.out.println("Not a duck number");
    }
    if(arms)
        System.out.println("IT IS A ARMSTRONG NUMBER");
    else 
    System.out.println("NOT ARMSTRONG NUMBER");
    for(int i=0;i<count;i++){
        System.out.print(store[i]+" ");
    }
}
}
