public class ExceptionPropagationExample {
    public static void method1() {
        throw new ArithmeticException("Division by zero");
    }

    public static void method2() {
        method1();
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
