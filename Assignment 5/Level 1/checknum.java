import java.util.*;
public class checknum {
    public int check(int n){
        if(n>0){
            return 1;
        }
        else if(n<0){
        return -1;
        }
        else 
        return 0;  
    } 

public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    checknum obj=new checknum();
    int q=obj.check(n);
    if(q==1)
    System.out.println("THE GIVEN NO. IS A POSITIVE NO.:"+n);
    else if(q==-1){
        System.out.println("THE GIVEN NO. IS A NEGATIVE NO.:"+n);
    }
    else
    System.out.println("THE GIVEN NO. IS A ZERO :"+n);
}    
}
