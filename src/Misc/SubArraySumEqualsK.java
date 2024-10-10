package Misc;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubArraySumEqualsK {
    //the k and k-1 wont work here is due to the fact that numbers can be
    //concept of prefix sum
    //[1, -1, 1, 1, 1, 1], k = 3
    //A prefix sum is a cumulative sum of a sequence of numbers where each element in the prefix
    //sum array represents the sum of all elements from the beginning of the original array up to a specific index.
    // The logic is if we can find a runningSum - k in the map it means that we can discard, that prefix from the current sum
    // to obtain the sum k.
    //so we store the prefix sum in the map with the number of times the  prefix sum appeared, so when we check
    // runningSum - k  in the map it will give us the count of prefixes we can remove to get to k so that many
    //sub-arrays, add the count to result, also add a (0,1) which will help in excluding no prefixes.
    //2962
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int runningSum = 0, ans = 0;
        for (int i : nums){
            runningSum+=i;
            Integer count = map.get(runningSum - k);
            if(count!=null){
                ans+=count;
            }
            map.put(runningSum, map.getOrDefault(runningSum,0) + 1);

        }
        return ans;
    }
}
