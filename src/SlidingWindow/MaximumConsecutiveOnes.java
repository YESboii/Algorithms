package SlidingWindow;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class MaximumConsecutiveOnes {
    //count the number of zeros in the window if its <=k then valid window
    //update the size, if invalid then shrink from left to make it valid
    public int longestOnes(int[] nums, int k) {
        int l = 0,r =0, max = 0;
        while(r<nums.length){
            if(nums[r]==0) k--;
            if(k<0){
                if(nums[l]==0) k++;
                l++;
            }
            if(k>=0){
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        return max;
    }

}
