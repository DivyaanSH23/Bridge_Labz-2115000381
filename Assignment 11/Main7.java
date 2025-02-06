	import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private ArrayList<Product> products = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getOrderId() {  // Getter method for orderId
        return orderId;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product product : products) {
            System.out.println("  Product: " + product.getName() + " | Price: $" + product.getPrice());
            total += product.getPrice();
        }
        System.out.println("  Total Price: $" + total);
    }
}

class Customer {
    private String name;
    private ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.getOrderId()); // Use getter method
    }

    public void displayCustomerOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

public class Main7 {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.0);
        Product product2 = new Product("Smartphone", 800.0);
        Product product3 = new Product("Headphones", 150.0);

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        Order order1 = new Order(101);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(102);
        order2.addProduct(product3);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        customer1.displayCustomerOrders();
        customer2.displayCustomerOrders();
    }
}
