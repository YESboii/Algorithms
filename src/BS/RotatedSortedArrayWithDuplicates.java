package BS;

public class RotatedSortedArrayWithDuplicates {


    public static void main(String[] args) {
        System.out.println(search(new int []{7,0,1,2,7},0));
    }
    //arr = [2, 2, 2, 2, 3, 4, 2, 2]
    static boolean search(int arr[],int target) {
        int ans = -1;
        int s = 0, e = arr.length-1;
        while (s<=e){
            int m = s + (e - s)/2;
            //arr = [2, 2, 2, 2, 3, 4, 2, 2]
            if(arr[m] == target) return true;

            if(arr[s]== arr[m] && arr[m] == arr[e]) {
                s++;
                e--;
                continue;
            }

            if(arr[s]<= arr[m]){
                if(arr[s]<= target && target<arr[m]) e = m - 1;

                else s = m + 1;

            }
            else {
                if(arr[m] < target && target<= arr[e]) s = m + 1;

                else e = m -1 ;
            }

        }
        return false;
    }
}
