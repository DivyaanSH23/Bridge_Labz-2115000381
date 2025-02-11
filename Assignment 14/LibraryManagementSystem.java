import java.util.*;

public class LibraryManagementSystem {
    Node head, tail;
    
    class Node {
        String title, author, genre;
        int bookId;
        boolean isAvailable;
        Node next, prev;
        
        Node(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = this.prev = null;
        }
    }
    
    public void addFirst(String title, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void addLast(String title, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            addFirst(title, author, genre, bookId, isAvailable);
            return;
        }
        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        Node temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addLast(title, author, genre, bookId, isAvailable);
        } else {
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    
    public void removeByBookId(int bookId) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }
    
    public void searchByTitleOrAuthor(String query) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable + ")");
            }
            temp = temp.next;
        }
    }
    
    public void updateAvailability(int bookId, boolean isAvailable) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }
    
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }
    
    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }
    
    public int countBooks() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.addFirst("Book A", "Author X", "Fiction", 101, true);
        library.addLast("Book B", "Author Y", "Non-Fiction", 102, true);
        library.addAtPosition("Book C", "Author Z", "Sci-Fi", 103, false, 1);
        library.displayForward();
        System.out.println("\nDisplaying in Reverse:");
        library.displayReverse();
        System.out.println("\nTotal Books: " + library.countBooks());
        library.searchByTitleOrAuthor("Author X");
        library.updateAvailability(102, false);
        System.out.println("\nAfter updating availability:");
        library.displayForward();
    }
}
