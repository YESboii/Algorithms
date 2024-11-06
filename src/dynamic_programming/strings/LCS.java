package dynamic_programming.strings;
//https://leetcode.com/problems/longest-common-subsequence/
//https://leetcode.com/problems/longest-palindromic-subsequence/description/
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
//https://leetcode.com/problems/delete-operation-for-two-strings/description/
//https://leetcode.com/problems/shortest-common-supersequence/description/
public class LCS {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("mew", "xmye"));
    }
    public static String  longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int [][]dp = new int[n + 1][m + 1];
        for(int i = n - 1;i >= 0;i--){
            for(int j = m - 1; j >= 0;j--){
                if(text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1 + dp[i + 1][j + 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        //O(n + m)
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (dp[i][j] != 0){
            if(text1.charAt(i) == text2.charAt(j)){
                sb.append(text1.charAt(i));
                i++;
                j++;
            }else if(dp[i + 1][j] > dp[i][j + 1]) i++;
            else j++;
        }
        return sb.toString();
    }
    public static int minInsertions(String s) {
        int n = s.length();
        int []dp = new int[n ];
        for(int i = n - 1;i >= 0;i--){
            int []temp = new int[n];
            temp[i] = 1;
            for(int j = i + 1;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    temp[j] = dp[j - 1] + 2;
                }else {
                    temp[j] = Math.max(dp[j], temp[j - 1]);
                }
            }
            dp = temp;
        }
        return n - dp[n - 1];
    }
}
