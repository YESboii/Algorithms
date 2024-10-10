package BS;
//https://leetcode.com/problems/split-array-largest-sum/description/
//[7,2,5,10,8], k = 2
//Intuition is that we have minimize the sum of the largest subarray??
//Instead of splitting the subarray and then calculating the sum we take the sum and see
//if we can create k sub-arrays, if for any given sum we can create k sub-arrays
// We can conclude that  for any array the max sum would be the sum of the array at k =1
// min  Max sum would be max of the array at k = arr.length
public class ArraySplitSum {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
    }
    public static int splitArray(int[] nums, int k) {
        int s = -1,e = 0;
        for (int i : nums){
            e += i;
            if(i>s) s = i;
        }
        while (s<=e){
            int m = s + (e -s)/2;

            int parts = calculateParts(m,nums);

            if(parts > k){
                //sum for each sub-array is less
                s = m + 1;
            }
            else {
                e = m - 1;
            }

        }
        return s;
    }

    private static int calculateParts(int maxSumEachPart, int[] nums) {
        int parts = 1;
        int runningSum = 0;
        for (int i : nums){
            if(runningSum + i <=maxSumEachPart){
                runningSum +=i;
            }
            else {
                parts++;
                runningSum = i;
            }
        }
        return parts;
    }
}
