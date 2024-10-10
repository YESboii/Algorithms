package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarrays-with-k-different-integers/description/
public class SubarraysWithkDifferentIntegers {

    // find number of subarrays where
    // we have distinct integers <=k and then find <=k-1 then
    //helper(k) - helper(k-1);
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    public int helper(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0,r = 0, count = 0;
        while(r < nums.length){
            freq.put(nums[r], freq.getOrDefault(nums[r],0) + 1);
            while(freq.size() > k ){
                int c = freq.get(nums[l]) - 1;
                if(c == 0){
                    freq.remove(nums[l]);
                }else freq.put(nums[l], c);
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
