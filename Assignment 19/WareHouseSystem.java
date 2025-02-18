import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}

class Electronics extends WarehouseItem { public Electronics(String name) { super(name); } }
class Groceries extends WarehouseItem { public Groceries(String name) { super(name); } }
class Furniture extends WarehouseItem { public Furniture(String name) { super(name); } }

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public List<T> getAllItems() { return items; }
}

class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) System.out.println(item);
    }
}

class WarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronics = new Storage<>();
        Storage<Groceries> groceries = new Storage<>();
        Storage<Furniture> furniture = new Storage<>();

        electronics.addItem(new Electronics("Laptop"));
        groceries.addItem(new Groceries("Apple"));
        furniture.addItem(new Furniture("Chair"));

        WarehouseUtility.displayItems(electronics.getAllItems());
        WarehouseUtility.displayItems(groceries.getAllItems());
        WarehouseUtility.displayItems(furniture.getAllItems());
    }
}
