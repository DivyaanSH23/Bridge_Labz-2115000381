abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.15;
    }

    public String getTaxDetails() {
        return "Tax Rate: 15%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    public double calculateTax() {
        return getPrice() * 0.10;
    }

    public String getTaxDetails() {
        return "Tax Rate: 10%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return 0;
    }
}

class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics(101, "Laptop", 1000),
            new Clothing(102, "Jacket", 150),
            new Groceries(103, "Apple", 2)
        };

        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = 0;

            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                tax = taxableProduct.calculateTax();
                System.out.println(taxableProduct.getTaxDetails());
            }

            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Product: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println();
        }
    }
}
