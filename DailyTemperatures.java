import java.util.Stack;

/***
 Using Monotonic stack
 TC - O(n)
 SC - O(n)
 */
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
            return new int[]{};

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                result[st.peek()] = i - st.peek();
                st.pop();
            }

            st.push(i);
        }

        return result;

    }
}