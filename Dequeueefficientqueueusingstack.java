import java.util.*;
public class Main {
    public static void push(Stack<Integer> mainn, Stack<Integer> helper, int data){
        while(!mainn.isEmpty()){
            helper.push(mainn.pop());
        }
        mainn.push(data);
        while(!helper.isEmpty()){
            mainn.push(helper.pop());
        }
    }

    public static void pop(Stack<Integer> mainn, Stack<Integer> helper){
           System.out.print(mainn.pop() + " ");
    }

    public static void main(String[] args) {
        Stack<Integer> mainn = new Stack<Integer>();
        Stack<Integer> helper = new Stack<Integer>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            push(mainn, helper, i);
        }

        while(!mainn.isEmpty()){
            pop(mainn, helper);
        }
        
    }
}
