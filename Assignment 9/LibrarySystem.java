class Book {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Book {
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook();
        ebook.ISBN = "123-456-789";
        ebook.title = "Java Programming";
        ebook.setAuthor("John Doe");

        ebook.displayDetails();
        System.out.println("Author: " + ebook.getAuthor());
    }
}
