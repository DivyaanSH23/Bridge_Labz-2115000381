import java.util.*;
class random{
   public double[] generate4DigitRandomArray(){
	double arr[]=new double[5];
	for(int i=0;i<5;i++){
	arr[i]=1000+(int)(Math.random()*9000);
}
return arr;
}
public double[] findAverageMinMax(double[] numbers){
	double arr[]=new double[3];
	double sum=0;
	for(int i=0;i<5;i++){
	sum=sum+numbers[i];
}
arr[0]=sum/5;
 int max=Integer.MIN_VALUE; 
for(int i=0;i<5;i++){
	max=(int)Math.max(numbers[i],max);
}
arr[1]=max;
int min=Integer.MAX_VALUE;
for(int i=0;i<5;i++){
        min=(int)Math.min(numbers[i],min);
}
arr[2]=min;
return arr;
}
public static void main(String args[]){
 random obj=new random(); 
double arr[]=obj.generate4DigitRandomArray();
double brr[]=obj. findAverageMinMax(arr);
 for (int i=0;i<5;i++){ 
System.out.println(arr[i]+" ");
}
System.out.printf("THE AVERAGE OF THE ARRAY IS %.2f AND MINIMUM IS %.2f AND MAXIMUM IS %.2f",brr[0],brr[1],brr[2]);
}
}
