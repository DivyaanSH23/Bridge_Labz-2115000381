import java.util.*;
public class HandShakes {
    public int hands(int n){
        int ans=(n*(n-1))/2;
        return n;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER NO. OF PEOPLE");
        int n=sc.nextInt();
        HandShakes obj=new HandShakes();
        int z=obj.hands(n);
        System.out.println("THE NO. OF HANDSHAKES ARE :"+z);
        

    }
}
