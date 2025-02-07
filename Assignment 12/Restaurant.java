import java.util.*;

class Person {
    String name;
    int id;
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    void display() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println(name + " is preparing food.");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println(name + " is serving customers.");
    }
}

public class Restaurant {
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Chef("John", 101));
        workers.add(new Waiter("Alice", 102));
        for (Worker worker : workers) {
            ((Person) worker).display();
            worker.performDuties();
        }
    }
}
