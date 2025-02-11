import java.util.*;

public class TextEditorUndoRedo {
    class Node {
        String text;
        Node prev, next;
        
        Node(String text) {
            this.text = text;
            this.prev = this.next = null;
        }
    }
    
    private Node head, tail, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;
    
    public void addTextState(String text) {
        Node newNode = new Node(text);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            tail = newNode;
        }
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }
    
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }
    
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
    
    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.addTextState("Hello World!");
        
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
