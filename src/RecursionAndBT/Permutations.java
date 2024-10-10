package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        helper(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public static  void helper(int i,int []nums,List<Integer>state,List<List<Integer>> ans){
        if(state.size()==nums.length){
            ans.add(new ArrayList<>(state));
            return;
        }
        for (int j=0;j<= state.size();j++){
            state.add(j,nums[i]);
            helper(i+1,nums,state,ans);
            state.remove(j);
        }
    }
}
