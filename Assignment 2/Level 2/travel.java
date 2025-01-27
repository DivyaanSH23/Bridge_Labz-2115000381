import java.util.*; 
class travel{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
String fromcity=sc.nextLine();
String viacity=sc.nextLine();
String tocity=sc.nextLine();
int tovia=sc.nextInt();
int tofinalcity=sc.nextInt();
int time1=sc.nextInt();
int time2=sc.nextInt();

int totaldistance=tovia+tofinalcity;
int tottime=time1+time2;

System.out.println("THE TOTAL DISTANCE TRAVEL FROM "+fromcity+" to "+tocity+" via "+viacity+" CITY IS :"+totaldistance+" AND THE TIME TAKEN IS :"+tottime);
}
}
