package RecursionAndBT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//distinct elements
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,1},11));
    }
    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        helper(0,target, candidates, new ArrayList<>(), ans);
        return ans;
    }
//    (k*2^t) t is distributed, space- O(target) auxiliary space
    public static void helper(int i, int target, int []candidates,
                              List<Integer> state,List<List<Integer>>ans){
        if (target==0){
            ans.add(new ArrayList<>(state));
            return;
        }
        if (i==candidates.length || candidates[i]>target) return;

        state.add(candidates[i]);
        helper(i,target-candidates[i], candidates, state, ans);
        state.removeLast();

        helper(i+1,target, candidates, state, ans);


        //better to use a for-loop instead of two calls

//        for(int i=start;i<candidates.length;i++){
//            if(candidates[i]<=target){
//                list.add(candidates[i]);
//                comn(i,candidates,target-candidates[i],list,result);
//                list.remove(list.size()-1);   //.removeLast()
//            }
//        }
    }
}
