import java.util.Scanner;
import java.util.Stack;

class Main{
    public static void stspan(Stack<Integer> stCount, int[] prices, int[] ans){
        
    }

    public static void print(int[] ans){
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totoalElem = in.nextInt();
        int[] prices = new int[totoalElem];
        int[] ans = new int[totoalElem];
        
        for (int i = 0; i < totoalElem; i++) {
            prices[i] = in.nextInt();
        }

		Stack<Integer> stCount = new Stack<Integer>();


		for (int i = 0; i < prices.length; i++) {
            if (i==0){
                stCount.push(i);
                ans[i] = 1;
                stCount.push(i);
            }
            else{
                while ( !stCount.isEmpty() && prices[stCount.peek()] <= prices[i]) stCount.pop();
                
                if (stCount.isEmpty()){
                    ans[i] = i + 1;
                }else{
                    ans[i] = i-stCount.peek();
                }

                stCount.push(i);
            }
        }
        
		for (int j = 0; j < ans.length; j++) {
            System.out.print(ans[j] + " ");
        }
        System.out.print("END");

		// System.out.print("1 2 3 1 1 END");
    }
}
