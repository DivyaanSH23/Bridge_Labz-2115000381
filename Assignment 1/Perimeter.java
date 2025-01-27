import java.util.*;
class Perimeter{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter length: ");
		int l=sc.nextInt();
		System.out.println("Enter width: ");
		int w=sc.nextInt();
		int p=2*(l+w);
        System.out.println("The perimeter is "+p);
	}
}
