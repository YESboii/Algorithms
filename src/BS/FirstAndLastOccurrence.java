package BS;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
    }

    public static int[] searchRange(int[] nums, int target){
        int f = searchRange(nums,target,true);
        int l =  searchRange(nums,target,false);
        return new int[]{f,l};
    }
    private static int searchRange(int[] nums, int target,boolean searchFirstOccurrence){
        int s = 0, e = nums.length-1;
        int ans = -1;
        while (s<=e){
            int m = s + (e - s)/2;

            if(target < nums[m]) e = m - 1;

            else if(target > nums[m]) s = m + 1;

            else {
                ans = m;
                if(searchFirstOccurrence){
                    e = m -1;
                }
                else {
                    s = m + 1;
                }
            }

        }
        return ans;
    }
//    public static int[] searchRange(int[] nums, int target){
//        int f = -1, l =-1;
//        for (int i = 0; i< nums.length;i++){
//            if(nums[i]==target){
//                l = i;
//                if(f==-1) f = i;
//            }
//        }
//        return new int [] {f,l};
//    }
}
