package RecursionAndBT;

public class ValidSudoku {
    // O(n^2)
    // space O(n^2)
    public boolean isValidSudoku(char[][] board) {
        boolean row[][] = new boolean[9][9],
                col[][] = new boolean[9][9],
                box[][] = new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j] - '1', boxIdx = (i/3) * 3 + j/3;
                    if(row[i][num] || col[j][num] || box[boxIdx][num]) return false;

                    row[i][num] = col[j][num] = box[boxIdx][num] = true;
                }
            }
        }
        return true;
    }
}
