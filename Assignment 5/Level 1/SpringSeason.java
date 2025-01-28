import java.util.Scanner;
public class SpringSeason {
    public boolean spring(int m,int d){
        if(m==3 && d>=20){
            return true;
        }
        else if(m>3 && m<6){
            return true;
        }
        else if(m==6 && d<=20)
        return true;
        else 
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int d=sc.nextInt();
        SpringSeason obj=new SpringSeason();
        Boolean ans=obj.spring(m, d);
        if(ans)
        System.out.println("IT IS A SPRING SEASON");
        else
        System.out.println("NOT A SPRING SEASON");
    }
}
