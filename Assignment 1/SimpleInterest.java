import java.util.*;
class SimpleInterest{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Priniciple value: ");
		int p=sc.nextInt();
		System.out.println("Enter rate value: ");
		int r=sc.nextInt();
		System.out.println("Enter time: ");
		int t=sc.nextInt();
		int s=(p*r*t)/100;
        System.out.println("The Simple Interest is "+s);
	}
}

