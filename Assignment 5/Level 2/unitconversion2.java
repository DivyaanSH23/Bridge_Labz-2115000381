import java.util.*;
class unitconversion2{
public static double p2kg = 0.453592;
public static double kg2p =2.20462;
public static double gal2lit=3.78541; 
public static double lit2gal= 0.264172; 

public static double faren2cel(double f){
return (f-32)*(5.0/9);
} 
public static double cel2faren(double c){
return (c*(9/5))+32;
}
public static double p2kg(double pound){
return  pound*p2kg;
}
public static double kg2p(double kg){
return kg*kg2p;
}
public static  double gal2lit(double gal){
return gal*gal2lit;
}
public static double lit2gal(double lit){
return lit*lit2gal;
}
public static void main(String args[]){
Scanner sc=new Scanner (System.in);
System.out.println("ENTER POUNDS");
double p=sc.nextDouble();
System.out.println("IN KG IT IS :"+p2kg(p));
System.out.println("ENTER kg");
double kg=sc.nextDouble();
System.out.println("IN POUNDS IT IS :"+kg2p(kg));

System.out.println("ENTER gallons");
double g=sc.nextDouble();
System.out.println("IN LITRES IT IS :"+gal2lit(g));

System.out.println("ENTER LITERS");
double l=sc.nextDouble();
System.out.println("IN KG IT IS :"+lit2gal(l));

System.out.println("ENTER FAHREN");
double f=sc.nextDouble();
System.out.println("IN CELSIUS IT IS :"+faren2cel(f));

System.out.println("ENTER CELSIUS");
double c=sc.nextDouble();
System.out.println("IN FAREN IT IS :"+cel2faren(c));


}
}
