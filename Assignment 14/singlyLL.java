import java.util.*;

public class singlyLL {
    Node head;

    class Node {
        String grade;
        int rollNo;
        String name;
        int age;
        Node next;

        Node(String grade, int rollNo, String name, int age) {
            this.grade = grade;
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.next = null;
        }
    }

    public void addFirst(String grade, int rollNo, String name, int age) {
        Node newNode = new Node(grade, rollNo, name, age);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String grade, int rollNo, String name, int age) {
        Node newNode = new Node(grade, rollNo, name, age);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void addAtPosition(int position, String grade, int rollNo, String name, int age) {
        if (position < 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(grade, rollNo, name, age);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head;
        int count = 0;

        while (currNode != null && count < position - 1) {
            currNode = currNode.next;
            count++;
        }

        if (currNode == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void deleteByRollNumber(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student with Roll No " + rollNo + " deleted.");
            return;
        }

        Node currNode = head, prev = null;

        while (currNode != null && currNode.rollNo != rollNo) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
            return;
        }

        prev.next = currNode.next;
        System.out.println("Student with Roll No " + rollNo + " deleted.");
    }

    public void searchByRollNumber(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found: Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void updateGrade(int rollNo, String newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll No " + rollNo + " to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void display() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        singlyLL studentList = new singlyLL();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student's Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade1 = sc.nextLine();
                    studentList.addFirst(grade1, roll1, name1, age1);
                    break;

                case 2:
                    System.out.print("Enter Roll No: ");
                    int roll2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade2 = sc.nextLine();
                    studentList.addLast(grade2, roll2, name2, age2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Roll No: ");
                    int roll3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade3 = sc.nextLine();
                    studentList.addAtPosition(pos, grade3, roll3, name3, age3);
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int delRoll = sc.nextInt();
                    studentList.deleteByRollNumber(delRoll);
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    int searchRoll = sc.nextInt();
                    studentList.searchByRollNumber(searchRoll);
                    break;

                case 6:
                    System.out.print("Enter Roll No to update grade: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Grade: ");
                    String newGrade = sc.nextLine();
                    studentList.updateGrade(updateRoll, newGrade);
                    break;

                case 7:
                    studentList.display();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}
