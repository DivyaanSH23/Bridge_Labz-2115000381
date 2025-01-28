import java.util.*;
public class NumberChecker2 {
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
   
    public static int sum(int []d){
        int sum=0;
        for(int i=0;i<d.length;i++){
            sum=sum+d[i];
        }
        return sum;

    }
    public static int sumpow(int []d){
        int sumpow=0;
        for(int i=0;i<d.length;i++){
           sumpow=sumpow+(int)Math.pow(d[i],2);
        }
        return sumpow;

    }
    public static boolean harshad(int d,int sum){
        if(d%sum==0)
         return true;
        else
        return false;
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int digit=sc.nextInt();
    int count=count(digit);
    int store[]=store(digit,count);
    int sum=sum(store);
    int sumpow=sumpow(store);
    System.out.printf("THE DIGIT IS %d AND ITS COUNT IS %d  AND ITS SUM OF DIGITS  IS %d AND ITS SUM OD SQUARE OF DIGITS IS %d%n",digit,count,sum,sumpow);
    if(harshad(digit,sum)){
        System.out.println("IS A HARSHAD NUMBER");
    }
    else{
        System.out.println("NOT A HARSHAD NUMBER");
    }
   
    for(int i=0;i<count;i++){
        System.out.print(store[i]+" ");
    }
    System.out.println();

    int a[][]=new int[count][2];
    for(int i=0;i<count;i++){
        a[i][0]=store[i];
    }
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<count;i++){
        map.put(store[i],map.getOrDefault(store[i],0)+1);                       
        }
    for(int i=0;i<count;i++){
        a[i][1]=map.get(store[i]);
    }
    for(int i=0;i<count;i++){
        System.out.print(a[i][0]+" ");
    }
    System.out.println();
    for(int i=0;i<count;i++){
        System.out.print(a[i][1]+" ");
    }
    System.out.println();

}
}
