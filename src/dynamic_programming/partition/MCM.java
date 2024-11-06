package dynamic_programming.partition;

import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
public class MCM {
    public static void main(String[] args) {
        System.out.println(matrixMultiplication(5, new int[]{4, 2, 3, 1, 3}));
    }
    static int matrixMultiplication(int N, int[] dim) {
        int[][] dp = new int[N][N];
        int[][] split = new int[N][N];  // To store the split points for the order

        for (int i = N - 2; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dim[i - 1] * dim[k] * dim[j] + dp[i][k] + dp[k + 1][j];
                    if (cost < min) {
                        min = cost;
                        split[i][j] = k;  // Store the split point for the optimal cost
                    }
                }
                dp[i][j] = min;
            }
        }

        // Print the optimal order
        for (int []row : split){
            System.out.println(Arrays.toString(row));
        }
        System.out.print("Optimal Parenthesization: ");
        printOptimalOrder(split, 1, N - 1);
        System.out.println();

        return dp[1][N - 1];
    }
    //another way to fill the table that is start from size 2 to N - 1
//    public static int matrixMultiplication(int N, int[] dim) {
//        int[][] dp = new int[N][N];
//
//        // length represents the subchain length (2 to N)
//        for (int length = 2; length < N; length++) {
//            for (int i = 1; i < N - length + 1; i++) {
//                int j = i + length - 1;
//                dp[i][j] = Integer.MAX_VALUE;
//
//                // Calculate minimum cost for multiplying matrices from i to j
//                for (int k = i; k < j; k++) {
//                    int cost = dp[i][k] + dp[k + 1][j] + dim[i - 1] * dim[k] * dim[j];
//                    dp[i][j] = Math.min(dp[i][j], cost);
//                }
//            }
//        }
//
//        return dp[1][N - 1];  // Final answer for the entire chain
//    }
    static void printOptimalOrder(int[][] split, int i, int j) {
        if (i == j) {
            System.out.print("M" + i);
            return;
        }
        System.out.print("(");
        printOptimalOrder(split, i, split[i][j]);
        printOptimalOrder(split, split[i][j] + 1, j);
        System.out.print(")");
    }


    //here (i, j) represents the min cost to multiply the matrices from i to j
    private static int helper(int i, int j, int []dim, int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k < j;k++){
            min = Math.min(
                    min, dim[i - 1]*dim[k]*dim[j] + helper(i, k, dim, dp)
                            + helper(k + 1, j, dim, dp)
            );
        }
        return dp[i][j] = min;
    }
}
