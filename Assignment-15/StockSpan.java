import java.util.Stack;

class StockSpan {
    int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = stockSpan.calculateSpan(prices);
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
