class pro{
	public static int discount=10;
	public String ProductName;
	public int quantity;
	public final int id;
	public int price;

	pro(String ProductName,int id,int price,int quantity){
	this.ProductName=ProductName;
	this.quantity=quantity;
	this.id=id;
	this.price=price;
	}
	public static void updateDiscount(int quantity,int price){
	int p=(quantity*price)-((quantity*price*discount)/100);
 	System.out.println("THE NET PRICE AFTER THE DISCOUNT IS :"+p);
	}

	public void Display(){
	System.out.println("The Product name is : "+ProductName);
        System.out.println("The Quantity is : "+quantity);
        System.out.println("The Price is :"+price);
        System.out.println("The Product ID is : "+id);
	}

}
class Product{
public static void main(String args[]){
pro obj=new pro("Atta",459,30,10);
if(obj instanceof pro){
obj.Display();
System.out.println();
}
else
System.out.println("OBJ is not a instanceof pro");

obj.updateDiscount(10,30);
}
}
