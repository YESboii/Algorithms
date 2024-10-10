package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;

//Print all the possible combinations that sum upto the target when a die can be rolled infinitely times
public class DieSum {
    public static void main(String[] args) {
        System.out.println(dieSum(new ArrayList<>(),5));
    }
    static List<List<Integer>> dieSum(List<Integer> state, int target){
        if (target == 0){
            List<Integer> temp = new ArrayList<>(state);
            List<List<Integer>> l = new ArrayList<>();
            l.add(temp);
            return l;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=1;i<=6;i++){
            if(i<=target) {
                state.add(i);
                List<List<Integer>> ansFromBelowCalls = dieSum(state, target - i);
                ans.addAll(ansFromBelowCalls);
                state.removeLast();
            }
        }
        return ans;
    }
}
