public class ConcatPreference {
    public static void main(String[] args) {
        int N = 1_000_000;
        
        long start, end;
        
        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
        end = System.nanoTime();
        System.out.println("String Concatenation Time: " + (end - start) / 1_000_000 + " ms");
        
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Concatenation Time: " + (end - start) / 1_000_000 + " ms");
        
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Concatenation Time: " + (end - start) / 1_000_000 + " ms");
    }
}
