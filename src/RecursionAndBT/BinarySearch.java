package RecursionAndBT;

public class BinarySearch {

    static int binarySearch(int []arr,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int m = start + (end - start)/2;
        if(arr[m]==target) return m;
        else if (target < arr[m]) {
            end = m - 1;
        }else{
            start = m +1;
        }
        return binarySearch(arr,start,end,target);
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,5,66,210,999,1000};
        System.out.println(binarySearch(arr,0, arr.length-1,210));
    }
}
