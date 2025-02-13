import java.util.Stack;

class SimpleQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    void add(int x) {
        input.push(x);
    }

    int remove() {
        if (output.isEmpty()) while (!input.isEmpty()) output.push(input.pop());
        return output.isEmpty() ? -1 : output.pop();
    }

    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}

