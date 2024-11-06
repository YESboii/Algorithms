package dynamic_programming.grids;
//https://www.geeksforgeeks.org/problems/geeks-training/1
public class PaintHouse {
    public static void main(String[] args) {
        maximumPoints(new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3 }},3);
    }
    public static int maximumPoints(int arr[][], int N) {
        int[][] dp = new int[N + 1][3];

        for (int day = N - 1; day >= 0; day--) {
            for (int task = 0; task < 3; task++) {
                for (int i = 0; i < 3; i++) {
                    if (i != task) {
                        dp[day][i] = Math.max(dp[day][i], arr[day][i] + dp[day + 1][task]);
                    }
                }
            }
        }
        return Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
    }
}
