package BS;
//https://www.naukri.com/code360/problems/aggressive-cows_1082559

import java.util.Arrays;

//6 4
//0 3 4 7 10 9
// So what possible maximum possible minimum distance we can choose so that we can place all cows in the stall
//The Minimum distance between any two cows will always be between consecutive cows.
public class AggressiveCows {
    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[]{4,2,1,3,6},2));
    }

    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls); //0 3 4 7 9 10

        int s = 0, e = stalls[stalls.length-1] - stalls[0];

        while (s<=e){
            int m = s + (e - s)/2;
            if (canPlace(m,stalls,k)){
                s = m + 1;
            }
            else {
                e = m-1;
            }
        }
       return e;
    }
    public static boolean canPlace(int minDis, int []stalls,int k){
        k-=1;
        int last = stalls[0];
        for(int i = 1;i<stalls.length;i++){
            if(stalls[i] - last >=minDis){
                k--;
                last = stalls[i];
            }
        }
        return k<=0;
    }

}
