package Misc;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/count-number-of-nice-subarrays/
public class CountNumberOfNiceSubArrays {
    //can be solves using <=k and <=k-1
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int runningSum = 0, ans = 0;
        for (int i : nums){
            runningSum+= i%2;
            //can we exclude prefixes to get the sum to k
            Integer count = map.get(runningSum - k);
            if(count!=null){
                ans+=count;
            }
            map.put(runningSum, map.getOrDefault(runningSum,0) + 1);
        }
        return ans;
    }
}
