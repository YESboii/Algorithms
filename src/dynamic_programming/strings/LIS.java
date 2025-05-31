package dynamic_programming.strings;
//https://leetcode.com/problems/longest-increasing-subsequence/description/
//https://leetcode.com/problems/largest-divisible-subset/submissions/1442827308/
//https://leetcode.com/problems/longest-string-chain/
//https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

import java.util.Arrays;

//using BS bacha h
public class LIS {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{0,1,0,3,2,3});
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []lis = new int[n];// lis ending at i
        int []prev = new int[n];// store prev idx
        Arrays.fill(prev, -1);
        int maxLength = 1;
        int idx = 0;
        for (int i = 0;i < n;i++){
            lis[i] = 1;
            for (int j = 0;j < i;j++){
                if(nums[j] < nums[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
            if(lis[i] > maxLength){
                maxLength = lis[i];
                idx = i;
            }
        }
        System.out.println(idx);
        System.out.println(Arrays.toString(prev));
        while (true){
            System.out.println(nums[idx]);
            idx = prev[idx];
            if (idx == -1) break;
        }
        return maxLength;
    }
}
/*
*
[3, 2, 3, 0, 1, 0, 4]
[3, 2, 3, 0, 1, 0, 3]
[2, 2, 2, 0, 1, 0, 3]
[2, 2, 2, 0, 1, 0, 2]
[2, 2, 2, 0, 1, 0, 2]
[1, 1, 1, 0, 1, 0, 1]
[0, 0, 0, 0, 0, 0, 0]
*
* */