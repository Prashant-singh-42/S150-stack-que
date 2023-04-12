import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
	public static int ImpOfTime(ConcurrentLinkedQueue<Integer> calling, ConcurrentLinkedQueue<Integer> ideal) {
        int ans = 0;

        while (!calling.isEmpty()){
            if ( calling.peek() == ideal.peek() ) {
                calling.poll();
                ideal.poll();
                ans++;
            }else{
                calling.add( calling.poll());
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ConcurrentLinkedQueue<Integer> calling = new ConcurrentLinkedQueue<Integer>();
        ConcurrentLinkedQueue<Integer> ideal = new ConcurrentLinkedQueue<Integer>();
        for (int i = 0; i < n; i++) {
            calling.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            ideal.add(in.nextInt());
        }
        System.out.println( ImpOfTime(calling, ideal));
    }
}
