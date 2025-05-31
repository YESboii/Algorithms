package dynamic_programming.strings;


//https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

//It is better to think it as extending the substring if we have a match that is
//move next character in both the strings add it to the current match.
public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static int longestPalindrome(String text1) {
        String text2 = new StringBuilder(text1).reverse().toString();
        int n = text1.length(), m = text2.length();
        int [][]dp = new int[n + 1][m + 1];
        int maxLength = 0;
        int x = 0;
        for(int i = n - 1;i >= 0;i--){
            for(int j = m - 1; j >= 0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        x = i;
                    }
                }
            }
        }
//        StringBuilder res = new StringBuilder();
//        while(maxLength-- > 0){
//            res.append(text1.charAt(x++));
//        }
//        System.out.println(res);

        return maxLength;
    }

    public int naiveLongestCommonSubstring(String text1, String text2) {
        return helper(text1, text2, text1.length(), text2.length(), 0);
    }
    //since in Longest common substring continuity matters whereas in subsequence continuity doesn't matter so when two charcter
    //matches it will always contribute to the length of the answer and the future calls will return the length of remaining LCS
    //but with substring this is not the case because in future the continuity might break and there will exist a longer substring
    //either in different combination of indices.
    //aabcd, abcd, even when characters at two indices match it is not contributing to the answer since in the next iteration
    // the continuity broke and the actual longest common substr existed in another combination unlike LCS where this would have
    //contributed to the answer due to the nature of LCS, so the same recurrence doesn't apply here that is 1 + lengthofremaningsubstr()
    //cant be applied here we would need to make further calls while maintaining a length of currsubtring and get the
    //length of the maximal common substring.
    //Unlike longest common subsequence, where matches can be added across breaks,
    // longest common substring requires contiguous matches to be tracked separately.
    private int helper(String text1, String text2, int i, int j, int currLen) {
        if (i == 0 || j == 0) {
            return currLen;
        }


        int matchLen = currLen;
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            matchLen = helper(text1, text2, i - 1, j - 1, currLen + 1);
        }


        int skipText1 = helper(text1, text2, i - 1, j, 0);
        int skipText2 = helper(text1, text2, i, j - 1, 0);

        return Math.max(matchLen, Math.max(skipText1, skipText2));
    }
}

