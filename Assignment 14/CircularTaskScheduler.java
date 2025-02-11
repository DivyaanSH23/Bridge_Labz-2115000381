import java.util.*;

public class CircularTaskScheduler {
    Node head;
    Node tail;
    
    class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;
        
        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }
    
    public void addFirst(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }
    
    public void addLast(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            addFirst(taskId, taskName, priority, dueDate);
            return;
        }
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        Node temp = head;
        for (int i = 1; temp != tail && i < position; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
    }
    
    public void removeByTaskId(int taskId) {
        if (head == null) return;
        Node temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + " (ID: " + head.taskId + ")");
        head = head.next;
    }
    
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
    
    public static void main(String[] args) {
        CircularTaskScheduler scheduler = new CircularTaskScheduler();
        scheduler.addFirst(1, "Task A", 2, "2025-02-15");
        scheduler.addLast(2, "Task B", 1, "2025-02-16");
        scheduler.addAtPosition(3, "Task C", 3, "2025-02-17", 1);
        scheduler.displayTasks();
        System.out.println("\nViewing current task:");
        scheduler.viewCurrentTask();
        System.out.println("\nAfter removing Task ID 2:");
        scheduler.removeByTaskId(2);
        scheduler.displayTasks();
        System.out.println("\nSearching for tasks with priority 3:");
        scheduler.searchByPriority(3);
    }
}
