abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemDetails() {
        return "Item ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem {
    private boolean isAvailable;

    public Book(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The book has been reserved.");
        } else {
            System.out.println("The book is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem {
    private boolean isAvailable;

    public Magazine(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    public int getLoanDuration() {
        return 7; 
    }

    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The magazine has been reserved.");
        } else {
            System.out.println("The magazine is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem {
    private boolean isAvailable;

    public DVD(String itemId, String title, String author, boolean isAvailable) {
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    public int getLoanDuration() {
        return 5; 
    }

    public void reserveItem() {
        if (isAvailable) {
            System.out.println("The DVD has been reserved.");
        } else {
            System.out.println("The DVD is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B101", "Java Programming", "John Doe", true),
            new Magazine("M102", "Tech Monthly", "Jane Smith", false),
            new DVD("D103", "The Matrix", "Wachowski Brothers", true)
        };

        for (LibraryItem item : items) {
            System.out.println("\nItem Details:");
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Availability: " + reservableItem.checkAvailability());
                reservableItem.reserveItem();
            }
        }
    }
}
