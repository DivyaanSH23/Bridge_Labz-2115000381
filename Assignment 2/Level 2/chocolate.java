import java.util.*;
class chocolate{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int noofchocolate=sc.nextInt();
int noofchildren=sc.nextInt();
int net=noofchocolate/noofchildren;
int remain =noofchocolate%noofchildren;
System.out.println("TH4E NO. OF CHOCOLATE EACH STUDENTS WILL GET ARE :"+net+" AND THE REMAINING CHOCOLATE ARE :"+remain);
}
}
