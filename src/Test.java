import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insert(new int[][]{{3,5},{12, 15}},new int[]{6,6})));
}
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) return new int[][]{newInterval};
        int n = intervals.length;
        if(newInterval[1] < intervals[0][0]){
            //insert at beginning and copy rest;
            int [][]ans = new int[n+1][2];
            ans[0] = newInterval;
            for(int i = 1;i<n+1;i++){
                ans[i] = intervals[i-1];
            }
            return ans;
        }
        if(newInterval[0] > intervals[n-1][1]){
            //copy all and insert at last;
            int [][]ans = new int[n+1][2];
            ans[n] = newInterval;
            for(int i = 0;i<n;i++){
                ans[i] = intervals[i];
            }
            return ans;
        }
        int x = newInterval[0], y = newInterval[1];
        List<int []> temp = new ArrayList<>();
        int i =0;
        while(i < n){
            if(i!=0 && intervals[i-1][1] < x && intervals[i][0] > y){
                //insert it in between
                temp.add(newInterval);
            }else if((intervals[i][0]<=x && x<=intervals[i][1]) || (intervals[i][0]>=x && y>=intervals[i][0])){
                //overlap
                int newStart = Math.min(x, intervals[i][0]);
                while(i < n && y >= intervals[i][0]){
                    i++;
                }
                int newEnd = Math.max(y, intervals[i-1][1]);
                temp.add(new int[]{newStart, newEnd});

            }else{
                //add the current interval
                temp.add(intervals[i]);
                i++;
            }
        }
        int [][]ans = new int[temp.size()][2];
        for(int j = 0; j < temp.size() ; j++){
            ans[j] = temp.get(j);
        }
        return ans;

    }
}
