package BS;

public class BinarySearch {

    // s , m , e
    //O(log n)
    // T(n) = T(n/2) + c
    //Max comparisons = ceil(log2(n))
    static int binarySearch(int []nums,int target){
        int s = 0, e= nums.length-1;

        while (s<=e){
            int m = s + (e-s)/2;

            if(nums[m] == target) return m;

            else if (target < nums[m]) e = m -1;

            else  s = m + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4,5,6,7,8,9,100};
        System.out.println(binarySearch(arr, 100));
    }
}
