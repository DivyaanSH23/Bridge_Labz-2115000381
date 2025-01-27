import java.util.*;
class triangle{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
double base=sc.nextInt();
double height=sc.nextInt();
double areaincm=0.5*base*height;
double areaininches=areaincm/2.54;
double areainfeets=areaininches/12;
System.out.println("YOUR AREA IN CM IS: "+areaincm+" while in inches is :"+areaininches+" amd im feets is:"+areainfeets);
}
}
