import java.util.*;

public class TicketReservationSystem {
    Node head;
    
    class Node {
        int ticketId;
        String customerName, movieName, seatNumber, bookingTime;
        Node next;
        
        Node(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }
    
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Node newNode = new Node(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }
    
    public void removeTicket(int ticketId) {
        if (head == null) return;
        Node temp = head, prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else if (temp == head) {
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Node temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
    
    public void searchTicket(String query) {
        if (head == null) return;
        Node temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found: Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            }
            temp = temp.next;
        } while (temp != head);
    }
    
    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
    
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Interstellar", "B2", "12:00 PM");
        system.addTicket(3, "Charlie", "Dunkirk", "C3", "2:00 PM");
        
        System.out.println("\nAll Tickets:");
        system.displayTickets();
        
        System.out.println("\nTotal Tickets: " + system.countTickets());
        
        System.out.println("\nSearch for Bob:");
        system.searchTicket("Bob");
        
        system.removeTicket(2);
        System.out.println("\nAfter removing Ticket 2:");
        system.displayTickets();
    }
}
