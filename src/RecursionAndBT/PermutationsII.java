package RecursionAndBT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2,2}));
    }
    public static  List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public static  void helper(int i,int []nums,List<Integer>state,List<List<Integer>> ans){
        if(state.size()==nums.length){
            ans.add(new ArrayList<>(state));
            return;
        }
        for (int j=0;j<= state.size();j++){
            if(j!=0 && state.get(j-1) == nums[i]) break;
            state.add(j,nums[i]);
            helper(i+1,nums,state,ans);
            state.remove(j);
        }
    }
}
