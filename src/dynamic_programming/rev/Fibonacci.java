package dynamic_programming.rev;

import java.util.Arrays;

//0 1 1 2 3 5
public class Fibonacci {


    public static void main(String[] args) {
//        int []dp = new int[6];
//        dp[0] = 0;dp[1] = 1;
//        for (int i = 2;i <= 5;i++){
//            dp[i] = dp[i - 1] + dp[i -2];
//        }
//        System.out.println(dp[5]);
        //here only prev two states are required
          int n1 = 0, n2 = 1;
          int n = 5;
          while (n != 0){
              int temp = n1 + n2;
              n1 = n2;
              n2 = temp;
              n--;
          }
        System.out.println(n1+" "+ n2);
    }
    public static int fib(int n, int[]dp){
        if(n <= 1) return dp[n] =  n;
        if(dp[n] != -1){
            System.out.println("stored dp of" + n);
            return dp[n];}
        return dp[n] = fib(n - 1,dp) + fib(n - 2, dp);
    }
}
