public class FibonacciComparion {

    public static void main(String[] args) {
        int n = 40;

        long startTime = System.nanoTime();
        fibonacciRecursive(n);
        long endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        startTime = System.nanoTime();
        fibonacciIterative(n);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        System.out.println("Recursive Fibonacci Time: " + recursiveTime / 1_000_000 + " ms");
        System.out.println("Iterative Fibonacci Time: " + iterativeTime / 1_000_000 + " ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
