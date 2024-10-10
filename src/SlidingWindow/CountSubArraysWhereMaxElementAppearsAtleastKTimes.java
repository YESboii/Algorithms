package SlidingWindow;

public class CountSubArraysWhereMaxElementAppearsAtleastKTimes {

    //count freq of max element <=k
    //total - fewer than k
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long totalSubArrays = ((long)n*(n+1))/2;
        int max = 0;
        for(int i: nums){
            if(i>max) max = i;
        }
        return totalSubArrays - helper(nums,k-1,max);
    }
    public long helper(int[] nums, int k, int maxElement) {
        int l = 0, r = 0;
        long count = 0;
        while(r < nums.length){
            if(nums[r] == maxElement) k--;
            while(k<0){
                if(nums[l]==maxElement) k++;
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
