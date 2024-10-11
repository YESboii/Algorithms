package intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
public class SmallestUnoccupiedChair {
//    {3, 5}, {1,5}, {2, 6}}, 0
    //[0, 0, 0]
    public static int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int at = 0;
        at = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        Queue<int []> used = new PriorityQueue<>((a, b) -> a[1] - b[1] );//{chair, dept time};
        Queue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n ; i++){
            available.offer(i);
        }
        for (int []arr : times){
            while (!used.isEmpty() && used.peek()[1] <= arr[0]){
                available.offer(used.poll()[0]);
            }
            int chair = available.poll();
            used.offer(new int[]{chair, arr[1]});
            if(at == arr[0]) return chair;
        }
        return -1;
    }

    public static void main(String[] args) {
        int ch = smallestChair(new int[][]{{3, 5}, {1,5}, {2, 6}}, 0);
        System.out.println(ch);
    }
}
