package BS;

//67 8 1 2345
public class RotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int []{4,5,6,7,0,1,2},0));
    }

    static int search(int []arr,int target){
        int ans = -1;

        int s = 0, e = arr.length-1;
        while (s<=e){
            int m = s + (e - s)/2;
            //arr = [1,0,1,1,1]
            if(arr[m] == target) return m;

            if(arr[s]<= arr[m]){
               if(arr[s]<= target && target<arr[m]) e = m - 1;

               else s = m + 1;
            }
            else {
                if(arr[m] < target && target<= arr[e]) s = m + 1;

                else e = m -1 ;
            }

        }

        return ans;
    }

}
