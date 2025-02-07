import java.util.*;

class Animal {
    String name;
    int age;
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }
    void makeSound() {
        System.out.println(name + " barks.");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }
    void makeSound() {
        System.out.println(name + " meows.");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }
    void makeSound() {
        System.out.println(name + " chirps.");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Buddy", 3));
        animals.add(new Cat("Whiskers", 2));
        animals.add(new Bird("Tweety", 1));
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.name + ", Age: " + animal.age);
            animal.makeSound();
        }
    }
}
