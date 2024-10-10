package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3},0,new ArrayList<Integer>()));
    }
    public static  List<List<Integer>> subsets(int []nums,int i, List<Integer> state){
        if(i==nums.length) {
            List<Integer> temp = new ArrayList<>(state);
            List<List<Integer>> l = new ArrayList<>();
            l.add(temp);
            return l;
        }
            state.add(nums[i]);
            List<List<Integer>> left = subsets(nums,i+1,state);
            state.removeLast();
            List<List<Integer>> right = subsets(nums,i+1,state);
             left.addAll(right);
             return left;
    }
}
