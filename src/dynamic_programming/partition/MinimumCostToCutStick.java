package dynamic_programming.partition;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
public class MinimumCostToCutStick {
    public static void main(String[] args) {
        minCost(7, new int[]{1,3,4,5});
    }
    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[][] dp = new int[m + 2][m + 2];
        int[] newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);
        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                int cost = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    cost = Math.min(cost, newCuts[j + 1] - newCuts[i - 1] + dp[i][k - 1] +
                            dp[k + 1][j]);
                }
                dp[i][j] = cost;
            }
        }
        for (int []arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[1][m];
    }
}
