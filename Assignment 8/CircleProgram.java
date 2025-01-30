import java.util.Scanner;

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
}

public class CircleProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        circle.display();
        scanner.close();
    }
}
