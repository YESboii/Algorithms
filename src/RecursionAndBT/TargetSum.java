package RecursionAndBT;

public class TargetSum {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int []{1,1,1,1,1},3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
    }
    private static int helper(int []nums,int target, int i,int currSum){
        if(i==nums.length){
            return target == currSum ? 1 : 0;
        }
        return helper(nums,target, i + 1,currSum+nums[i])
                + helper(nums, target,i+1,currSum-nums[i]);
    }
}
