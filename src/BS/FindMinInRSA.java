package BS;
//***
public class FindMinInRSA {

    public static void main(String[] args) {
        System.out.println(findMin(new int []{3,1}));
    }
    public static int findMin(int[] arr) {
        // int pivot = findPivot(arr);
        // if(pivot == -1){
        //     return arr[0];
        // }
        // // else if(pivot == arr.length-1){
        // //     return arr[0];
        // // }
        // return arr[pivot+1];
        int s = 0, e = arr.length-1;
        int n = arr.length;

        while (s<e){
            int m = s + (e-s)/2;

            if (m!=0 && arr[m]<arr[m-1] && arr[m] < arr[(m+1) % n]){
                return arr[m];

            } else if (arr[s]<=arr[m]) {
                if(arr[s]<arr[e]){
                    e = m-1;
                }else{
                    s = m + 1;
                }
            }
            else {
                e = m -1;
            }
        }
        return arr[s];
    }
}
