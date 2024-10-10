package BS;
//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class MedianOf2SortedArrays {
    public static void main(String[] args) {

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        //impl 1
        int m = nums1.length, n = nums2.length;
        int totalLength = m + n;
        int midIndex = totalLength / 2;

        int i = 0, j = 0, current = 0, prev = 0;


        for (int k = 0; k <= midIndex; k++) {
            prev = current;

            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                current = nums1[i];
                i++;
            } else {
                current = nums2[j];
                j++;
            }
        }

        // If the total length is even, return the average of the two middle elements
        if (totalLength % 2 == 0) {
            return (prev + current) / 2.0;
        }

        // If the total length is odd, return the middle element
        return current;
    }
    public double findMedianSortedArraysOptimal(int[] nums1, int[] nums2){
        if(nums1.length>nums2.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length, m = nums2.length;

        if(n==0 && m ==0) return 0.0;

        int leftHalf = (n + m)/2, size = n + m;

        int l = 0, r = n-1;
        while(true){
            int mid = (l + r) < 0 ? -1: (l+r)/2;
            int i = leftHalf - mid - 2;

            int l1 = mid < 0 ? Integer.MIN_VALUE : nums1[mid];
            int l2 = i < 0 ? Integer.MIN_VALUE : nums2[i];
            int r1 = mid + 1 >= n ? Integer.MAX_VALUE : nums1[mid + 1];
            int r2 = i + 1 >=m ? Integer.MAX_VALUE : nums2[i+1];

            if(l1<=r2 && l2<=r1){
                if(size%2==0) return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                else return Math.min(r1,r2);
            } else if (l1>r2) {
                r = mid - 1;
            }else l = mid + 1;

        }
    }
}
