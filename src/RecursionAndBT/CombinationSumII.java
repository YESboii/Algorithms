package RecursionAndBT;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//todo??
// cs III & IV
//140,212 [dp, bt+ trie]
public class CombinationSumII {
    public static void main(String[] args) {
    String s = "a"+"";
        System.out.println(s.substring(1,0));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        comn(0,candidates,target,list,result);
        return result;
    }
    public void comn(int start,int[]candidates,int target,List<Integer> list,List<List<Integer>> result){
        if(target==0) result.add(new ArrayList<>(list));
        if(start==candidates.length){
            return;
        }

        for(int i=start;i<candidates.length;i++){
            if(i>0 && i!= start && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]<=target){
                list.add(candidates[i]);
                comn(i+1,candidates,target-candidates[i],list,result);
                list.remove(list.size()-1);
            }else{
                break;
            }
        }

    }
}
