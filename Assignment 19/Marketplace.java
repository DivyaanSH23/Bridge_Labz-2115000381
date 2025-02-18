class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

class BookCategory { public String toString() { return "Book"; } }
class ClothingCategory { public String toString() { return "Clothing"; } }
class GadgetCategory { public String toString() { return "Gadget"; } }
class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 500, new GadgetCategory());

        applyDiscount(book, 10);
        applyDiscount(shirt, 5);
        applyDiscount(phone, 15);

        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
