package dynamic_programming.partition;

import java.util.Arrays;
//https://www.naukri.com/code360/problems/boolean-evaluation_1214650
public class EvaluateBooleanExpression {
    public static void main(String[] args) {
        System.out.println(evaluateExp("F^F^F^F&T|T|F|T|F|F|T|T|T|T&T|T|T&T|F&T|F|T|T|T^T|F^T|T&F^T|F|T|F|T&T|T^F|F^T&T^T&T^T&T^T&F&T^F|F^T|T|F|F^F|F&F|F|T&F&F"));
    }
    public static long evaluateExp(String exp) {
        int n = exp.length();
        int x = (n - 1) / 2;
        int y = (n + 1) / 2;
        char[] operators = new char[x];
        char[] operands = new char[y];
        int i = 0, j = 0;
        for (char ch : exp.toCharArray()) {
            if (ch == 'T' || ch == 'F') operands[i++] = ch;
            else operators[j++] = ch;
        }
        System.out.println(Arrays.toString(operands));
        System.out.println(Arrays.toString(operators));
        int[][][] dp = new int[y][y][2];
        return helper(0, y - 1, operands, operators, dp)[0];
    }

    private static int[] helper(int i, int j, char[] ope, char[] opr, int[][][] dp) {
        int MOD = 1000000007;
        if (i == j) {
            if (ope[i] == 'T') return new int[]{1, 0};
            else return new int[]{0, 1};
        }
        if (dp[i][j][0] != 0 || dp[i][j][1] != 0) return dp[i][j];
        long t = 0, f = 0;
        for (int k = i; k < j; k++) {
            int[] sp1 = helper(i, k, ope, opr, dp);
            int[] sp2 = helper(k + 1, j, ope, opr, dp);
            long t1 = sp1[0], f1 = sp1[1], t2 = sp2[0], f2 = sp2[1];
            if (opr[k] == '&') {
                t = (t + (t1 * t2) % MOD) % MOD;
                f = (f + (t1 * f2) % MOD + (f1 * t2) % MOD + (f1 * f2) % MOD) % MOD;
            } else if (opr[k] == '|') {
                t = (t + (t1 * t2) % MOD + (t1 * f2) % MOD + (f1 * t2) % MOD) % MOD;
                f = (f + (f1 * f2) % MOD) % MOD;
            } else {
                t = (t + (t1 * f2) % MOD + (f1 * t2) % MOD) % MOD;
                f = (f + (t1 * t2) % MOD + (f1 * f2) % MOD) % MOD;
            }
        }
        dp[i][j][0] = (int)t ;
        dp[i][j][1] = (int)f ;
        return dp[i][j];
    }

}
