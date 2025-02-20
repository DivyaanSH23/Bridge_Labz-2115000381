import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedItems = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
            sortedItems.put(productPrices.get(product), product);
        }
    }

    public Map<String, Integer> getCartItems() {
        return cartItems;
    }

    public Map<Double, String> getSortedItems() {
        return sortedItems;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.8);
        cart.addProduct("Orange", 1.2);
        
        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 3);
        cart.addToCart("Orange", 1);
        
        System.out.println("Cart Items: " + cart.getCartItems());
        System.out.println("Sorted Items by Price: " + cart.getSortedItems());
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}
