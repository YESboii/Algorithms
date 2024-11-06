package dynamic_programming.strings;
//https://leetcode.com/problems/longest-increasing-subsequence/description/
//https://leetcode.com/problems/largest-divisible-subset/submissions/1442827308/
//https://leetcode.com/problems/longest-string-chain/
//https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

//using BS bacha h
public class LIS {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{1001,0,3,2,3});
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int length = 1;
        int []lisEndingAt = new int[n];
        int []prev = new int[n];
        int idx = 0;
        for(int i = 0;i < n;i++){
            lisEndingAt[i] = 1;
            prev[i]  = i;
            for(int j = 0;j < i;j++){
                if(nums[j] < nums[i] && 1 + lisEndingAt[j] > lisEndingAt[i]){
                    lisEndingAt[i] = 1 + lisEndingAt[j];
                    prev[i] = j;
                }
            }
            if(lisEndingAt[i] > length){
                length = lisEndingAt[i];
                idx = i;
            }
        }
        while (true){
            System.out.print(nums[idx] + " ");
            if (prev[idx] == idx) break;
            idx = prev[idx];

        }
        return length;
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