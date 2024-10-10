package BS;

public class MakeBouquet {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2},3,1));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;

        int s = Integer.MAX_VALUE, e = 0;

        for (int i : bloomDay){
            if(i < s) s = i;
            if (i > e) e = i;
        }
        while (s<=e){
            int mid = s + (e-s)/2;
            if (canMake(m,k,bloomDay,mid)){
                e = mid - 1;
            }else {
                s = mid + 1;
            }
        }
        return s;
    }

    private static boolean canMake(int m, int k, int[] bloomDay, int presentDay) {
        int bouquetsMade = 0;
        int adjFlowers = 0;

        for (int i : bloomDay){
            if(presentDay >=i){
                adjFlowers++;
            }else {
                adjFlowers = 0;
            }
            if (adjFlowers==k){
                bouquetsMade++;
                adjFlowers=0;
            }
        }

        return bouquetsMade>=m;
    }
}
