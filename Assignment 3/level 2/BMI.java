import java.util.*;
public class BMI{
public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	double weight = sc.nextInt();
	double heightInCm = sc.nextInt();
	double heightInmeter = heightInCm/100;
	double bmi = weight/(heightInmeter*heightInmeter);
	if(bmi <=18.4) System.out.println("underweight");
	else if((bmi>=18.5) && (bmi<=24.9)) System.out.println("normal");
	else if((bmi>=25.0) && (bmi<=39.9)) System.out.println("overweight");
	else{
	System.out.println("obese");
	}
}
}
