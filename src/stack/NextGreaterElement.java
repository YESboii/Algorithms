package stack;
import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/description/
//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElement {
//    Input: [2, 1, 2, 4, 3]
//    Output: [4, 2, 4, -1, -1]
    // Intuition: We maintain the decreasing order in LIFO manner as we traverse from the right.
    //Since we need the next greater element for each element, while traversing we will remove all elements
    //that are less than the current element as for the elements that are on the left of the array the next
    // greater
    //will be this current element as all the elements to the right of the current element are smaller than it.
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 4, 3};
        int[] result = nextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
    }
    static int[] nextGreaterElement(int []arr){
        Stack<Integer> stack = new Stack<>();
        int []ans = new int[arr.length];
        for(int i = arr.length - 1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();

            stack.push(arr[i]);
        }
        return ans;
    }
}
