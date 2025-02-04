import java.util.*;
class Library{
	public static String LibraryName="Div Library";
	String Auther;
	String Title;
	final int isbn;

	Library(String Auther,String Title,int isbn){
	this.Auther=Auther;
	this.Title=Title;
	this.isbn=isbn;
	}
	public static void displayLibraryName(){
	System.out.println("THE LIBRARY NAME IS : "+LibraryName);
	}
	public void Display(){
        System.out.println("Auther Name is :"+Auther);
        System.out.println("Title is : "+Title);
        System.out.println("ISBN iS : "+isbn);
	}
}
public class Book{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
String Auther=sc.nextLine();
String Title=sc.nextLine();
int isbn=sc.nextInt();

Library obj1=new Library(Auther,Title,isbn);
if(obj1 instanceof Library){
obj1.Display();
obj1.displayLibraryName();
}
else
System.out.println("THE OBJECT IS NOT A INSTANCEOF LIBRARY CLASS");
sc.close();
}
}

