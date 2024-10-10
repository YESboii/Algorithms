package BS;
//**
public class FindMinInRSAWithDuplicates {
    public static void main(String[] args) {

        System.out.println(findMin(new int []{1,2,1}));
    }
    static int findMin(int[] arr) {
        int s = 0, e = arr.length - 1;
        int n = arr.length;

        while (s < e) {
            int m = s + (e - s) / 2;

            if (m != 0 && arr[m] < arr[m - 1] && arr[m] <= arr[(m + 1) % n]) {
                return arr[m];
            }
            if (arr[s] == arr[m] && arr[m] == arr[e]) {
                s++;
                e--;
            }
            else if (arr[s] <= arr[m]) {

                if (arr[s] < arr[e]) {
                    return arr[s];
                } else {
                    s = m + 1;
                }
            }
            else {
                e = m - 1;
            }
        }
        return arr[s];
    }
}
