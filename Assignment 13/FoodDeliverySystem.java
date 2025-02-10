abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return itemName + " - Price: $" + price + ", Quantity: " + quantity;
    }

    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

interface Discountable {
    double applyDiscount(double totalPrice);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.90;
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Items!";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_SURCHARGE = 1.2;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * NON_VEG_SURCHARGE;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.95;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Items!";
    }
}

class OrderProcessor {
    public static void processOrder(FoodItem item) {
        double totalPrice = item.calculateTotalPrice();
        System.out.println(item.getItemDetails());

        if (item instanceof Discountable) {
            Discountable discountable = (Discountable) item;
            System.out.println(discountable.getDiscountDetails());
            totalPrice = discountable.applyDiscount(totalPrice);
        }

        System.out.println("Final Price after discount: $" + totalPrice);
        System.out.println("--------------------------------------");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegBurger = new VegItem("Veg Burger", 5.0, 2);
        FoodItem chickenPizza = new NonVegItem("Chicken Pizza", 8.0, 1);

        OrderProcessor.processOrder(vegBurger);
        OrderProcessor.processOrder(chickenPizza);
    }
}
