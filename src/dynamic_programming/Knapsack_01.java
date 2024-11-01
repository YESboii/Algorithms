package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class Knapsack_01 {
    public static void main(String[] args) {
        int capacity = 8;
        int[] val = {2, 3, 1, 4};
        int[] wt = {3, 4, 6, 5};

        // Calling knapSack function and printing output
        int maxProfit = knapSack(capacity, val, wt);
        System.out.println("Output: " + maxProfit);
    }
    static int knapSack(int w, int val[], int wt[]) {
        int n = val.length;
        // dp[i][wj] represents that starting from this ith item what is the maximum
        // maximum profit that we can get, the ith item can be include/ excluded
        int [][]dp = new int[n][w + 1];
        for(int i = 0;i <= w;i++){
            if(wt[n - 1] <= i){
                dp[n - 1][i] = val[n - 1];
            }
        }
        for(int i = n - 2;i>=0;i--){
            for(int j = w;j >= 0;j--){
                if(wt[i] > j){
                    dp[i][j] = dp[i + 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], val[i] + dp[i + 1][j - wt[i]]);
                }
            }
        }

        for(int []arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        List<Integer> items = new ArrayList<>();
        int remW = w, profit = dp[0][w];
        for(int i = 0;i < n - 1 && profit > 0;i++){
            if(dp[i][remW] != dp[i + 1][remW]){
                items.add(i);
                remW-= wt[i];
                profit -= val[i];
            }
        }
        if(profit > 0) items.add(n - 1);
        System.out.println(items);
        return dp[0][w];
    }
}
