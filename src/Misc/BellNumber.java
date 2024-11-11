package Misc;
/*
COUNT THE NUMBER OF WAYS IN WHICH YOU CAN PARTITION A SET INTO NON-EMPTY DISJOINT SUBSETS SUCH THAT THE UNION OF THESE
SUBSETS IS THE ORIGINAL SET
EX - {1, 2, 3}
- 1   2   3
- 1 2     3
- 1 3     2
- 2 3     1
- 1 2 3
=> 5
*/
//Bell Triangle method
public class BellNumber {
    public static long countWays(int n){
        long [][]bell = new long[n + 1][n + 1];
        bell[0][0] = 1;
        for(int i = 1;i <= n;i++){
            bell[i][0] = bell[i - 1][i - 1];
            for(int j = 1;j <= i;j++){
                bell[i][j] = bell[i][j - 1] + bell[i - 1][j - 1];
            }
        }
        return bell[n][0];
    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
}
