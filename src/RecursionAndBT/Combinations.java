package RecursionAndBT;
import java.util.*;
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,new ArrayList<>(),ans,n,k);
        return ans;
    }
    private void helper(int i, List<Integer> state,List<List<Integer>> ans,int n,int k){
        if(state.size()==k){
            ans.add(new ArrayList<>(state));
            return;
        }
        if(i>n){
            return;
        }
        for(int start = i;start<=n;start++){
            state.add(start);
            helper(start + 1, state, ans, n, k);
            state.removeLast();
        }
    }
}
