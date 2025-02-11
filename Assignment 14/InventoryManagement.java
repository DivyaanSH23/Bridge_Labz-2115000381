import java.util.*;

public class InventoryManagement {
    Node head;

    class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    public void addFirst(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 0) return;
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        int count = 0;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Node temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchItem(String searchKey) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(searchKey) || String.valueOf(temp.itemId).equals(searchKey)) {
                return;
            }
            temp = temp.next;
        }
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Node temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
        }
    }

    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                boolean condition = criteria.equalsIgnoreCase("name") ? ascending ? current.itemName.compareTo(current.next.itemName) > 0 : current.itemName.compareTo(current.next.itemName) < 0 : ascending ? current.price > current.next.price : current.price < current.next.price;
                if (condition) {
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQty = current.quantity;
                    double tempPrice = current.price;
                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;
                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQty;
                    current.next.price = tempPrice;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1: inventory.addFirst("Laptop", 101, 5, 1000); break;
                case 2: inventory.addLast("Mouse", 102, 10, 20); break;
                case 3: inventory.addAtPosition(1, "Keyboard", 103, 7, 50); break;
                case 4: inventory.removeById(102); break;
                case 5: inventory.updateQuantity(101, 8); break;
                case 6: inventory.searchItem("Mouse"); break;
                case 7: inventory.calculateTotalValue(); break;
                case 8: inventory.sortInventory("price", true); break;
                case 9: inventory.display(); break;
                case 10: break;
            }
        } while (choice != 10);
    }
}
