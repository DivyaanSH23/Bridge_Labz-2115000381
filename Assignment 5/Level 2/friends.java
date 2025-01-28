import java.util.*;
 class friends{
 public static int highestage(int a[]){
int max=0;
for(int i=0;i<3;i++){
	max=Math.max(max,a[i]);
}
return max;
}
public static int highestheight(int a[]){ 
int  max=Integer.MIN_VALUE;
for(int i=0;i<3;i++){
	max=Math.max(max,a[i]);
}

return max;
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in); 
int age[]=new int[3];
 int height[]=new int [3];
 for(int i=0;i<3;i++){
 System.out.println("ENTER THE AGE AND HEIGHT OF THE 3 STUDENTS");
 age[i]=sc.nextInt(); 
height[i]=sc.nextInt();
}
int ha=highestage(age);
 int hh=highestheight(height);

System.out.printf("THE HIGEST AGE OF 3 PERSON IS %d AND HEIGHT IS %d",ha,hh);
}
}
