import java.util.*;
class emp{
	String Name;
 	final int id;
 	String designation;
	static String CompanyName="DIVYANSH ENTERPRISES";
	static int totemp=0;
	public emp(int id,String designation,String Name){
		this.id=id;
		this.designation=designation;
		this.Name=Name;
		totemp++;
	}
	public static void displayTotalEmployees(){
	System.out.println("Total Number of Employees are :"+totemp);
	}
	public void Display(){
	System.out.println("Company Name is :"+CompanyName);
        System.out.println("Employee name is :"+Name);
        System.out.println("Employee ID is : "+id);
        System.out.println("Employee Designation is :"+designation);
}
}
public class Employee{
public static void main(String args[]){

emp obj1=new emp(8,"Div","Btech Cse");
emp obj2=new emp(9,"DIvi","CG Employee");

if(obj1 instanceof emp){
obj1.Display();
System.out.println();
}
else
System.out.println("obj 1 NOt a instance of emp");

if(obj2 instanceof emp){
obj2.Display();
System.out.println();
}
else
System.out.println("Obj 2 NOt a instance of emp");

emp.displayTotalEmployees();

}
}
