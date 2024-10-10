package BS;

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {

    }
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int n = arr1.length, m = arr2.length;
        if(n>m){
            kthElement(k,arr2,arr1);
        }
        int r = Math.min(k-1, n-1);
        int l = Math.max(0, k - m -1);
        while(true){
            int m1 = (l+r) < 0 ? -1 : (l+r) /2;
            int m2 = k - m1 - 2;

            int l1 = m1<0 ? Integer.MIN_VALUE : arr1[m1];
            int l2 = m2<0 ? Integer.MIN_VALUE : arr2[m2];
            int r1 = m1 + 1>=n ? Integer.MAX_VALUE : arr1[m1+1];
            int r2 = m2 + 1 >=m ? Integer.MAX_VALUE : arr2[m2+1];

            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                r = m1 - 1;
            }else{
                l = m1 + 1;
            }
        }
    }
}
