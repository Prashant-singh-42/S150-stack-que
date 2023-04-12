import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
public class Main {
    public static void kTHSmallest(int[] elems, int n, int k){
        ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<Integer>();

        int[] ans = new int[n - k + 1];
        int start = 0;
        int end = k-1;
        int iterations = n-k+1;

        for (int i = 0; i < k; i++) {
            if(elems[i] < 0) container.add(i);
        }

        while (start < iterations) {
            if (container.isEmpty()) ans[start] = 0;
            else ans[start] = elems[container.peek()];

            start += 1;
            end += 1;

            if (!container.isEmpty() && container.peek()<start) container.poll();
            if (end < n && elems[end] < 0) container.add(end);
        }

        for (int i = 0; i < iterations; i++) {
            System.out.print(ans[i] + " ");
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] elems = new int[n];
            for (int j = 0; j < n; j++) {
                elems[j] = in.nextInt();
            }

            kTHSmallest(elems, n, k);
			System.out.println("");
			

        }
    }
}
