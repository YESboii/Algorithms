package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;

public class GenerateWellFormedParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    static public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,n,"",ans);
        return ans;
    }
    public static void helper(int l,int r,String state, List<String> ans){
        if(l==0 && r==0){
            ans.add(state);
            return;
        }
        if (l>0){
            helper(l-1,r,state+"(",ans);
        }
        //for closing one only insert it if we have more opening parenthesis might lead to cases
        //like (()) called left (())( when it returns it will call (())) which is incorrect
        if (r>l){
            helper(l,r-1,state+")",ans);
        }
    }
}
