package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    static String []arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String s) {
        List<String> ans = new ArrayList<>();
        if (s.isEmpty()) return ans;
        helper(0,s,"",ans);
        return ans;
    }
    private  static  void helper(int i, String s, String state,List<String> ans){
        if(i==s.length()) {
            ans.add(state);
            return;
        }
        String mapping = arr[Integer.parseInt(s,i,i+1,10)];
        for (int j=0;j<mapping.length();j++){
            helper(i+1,s,state+mapping.charAt(j),ans);
        }
    }
}
