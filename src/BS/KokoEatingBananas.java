package BS;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},6));
        ;
    }


    public static int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = -1;
        for(int i : piles){
            if(i>e){
                e = i;
            }
        }

        while(s<=e){
            int m = s + (e-s)/2;
            long count = findCount(m,piles);

            if (count > h){
                s = m  + 1;
            }
            else {
                e = m-1;
            }
        }
        return s;
    }
    //n log
    private static long findCount(int m, int[] piles) {
        long total = 0;
        for (int i : piles){
            total += (int)Math.ceil((i*1.0)/m);
        }
//        [3,6,7,11] m = 4
//            (3/4) = 1
        return total;
    }
}
