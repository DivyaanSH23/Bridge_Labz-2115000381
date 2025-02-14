import java.util.*;

class Counting {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int min = 10, max = 18;
        int range = max - min + 1;

        int b[] = new int[range]; 
        int c[] = new int[n]; 

        for (int i = 0; i < n; i++) {
            b[a[i] - min]++;
        }


        for (int i = 1; i < range; i++) {
            b[i] += b[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            c[b[a[i] - min] - 1] = a[i];
            b[a[i] - min]--;
        }


        for (int i = 0; i < n; i++) {
            System.out.print(c[i] + " ");
        }
    }
}

