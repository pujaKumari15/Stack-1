import java.util.Arrays;
import java.util.Stack;

/***
 Approach- Using Monotonic Stacks
 TC - O(n)
 SC - O(n)
 */
class NextGreaterEle2 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[]{};

        int n = nums.length;

        int result[] = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();

        for(int i =0; i < 2*n; i++) {
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                result[st.pop()] = nums[i%n];
            }

            //if this index has not been processed before
            if(i < n)
                st.push(i);
        }

        return result;

    }
}