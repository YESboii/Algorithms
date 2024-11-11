package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(generatePP("geeks"));
    }
    static List<List<String>> generatePP(String s){
        List<List<String>> ans = new ArrayList<>();
         helper(new ArrayList<>(),s,0,ans);
         return ans;

    }
    static void helper(List<String> state,String s,int j,List<List<String>> ans){
        if(s.length()==j){
            ans.add(new ArrayList<>(state));
        }
        //Worst case((n)*2^n) for strings such as "aaa" space O(n)excluding ans
        //or maintain an index j where i = j+1 then pass the original string base case will j==string.length
        for (int i = j+1;i<=s.length();i++){
            String substr = s.substring(j,i);
            if(isPalindrome(substr)){
                state.add(substr);
                helper(state,s,i,ans);
                state.removeLast();
            }
        }

    }

    private static boolean isPalindrome(String substr) {
        int i = 0, j =substr.length()-1;
        while (i<j){
            if(substr.charAt(i++)!=substr.charAt(j--)) return false;

        }
        return true;
    }
}
