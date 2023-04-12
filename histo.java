class Solution {
    public static int solve(int[] h, int n) {
        Stack<Integer> st = new Stack<Integer>();
        int[] rightMin = new int[n];
        int[] leftMin = new int[n];
        int maxArea = 0;

        for (int i = n-1; i >=0 ; i--) {
            if (st.isEmpty() || h[st.peek()] >= h[i]){
                while(!st.isEmpty() && h[st.peek()] >= h[i] ){
                    st.pop();
                }
                if (st.isEmpty()){
                    rightMin[i] = n;
                }else{
                    rightMin[i] = st.peek();
                }
                st.push(i);
            }else{
                rightMin[i] = st.peek();
                st.push(i);
            }
        }

        while(!st.isEmpty()) st.pop();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || h[st.peek()] >= h[i]){
                while(!st.isEmpty() && h[st.peek()] >= h[i] ){
                    st.pop();
                }
                if (st.isEmpty()){
                    leftMin[i] = -1;
                }else{
                    leftMin[i] = st.peek();
                }
                st.push(i);
            }else{
                leftMin[i] = st.peek();
                st.push(i);
            }
        }

        for (int i = 0; i < n; i++) {
            // System.out.print(leftMin[i] + " ");
            int tempArea = ((rightMin[i]-1) - leftMin[i])*h[i];
            if (tempArea > maxArea) maxArea = tempArea;
        }

        return maxArea;

    }

    public int largestRectangleArea(int[] heights) {
        return solve(heights, heights.length);
    }
}
