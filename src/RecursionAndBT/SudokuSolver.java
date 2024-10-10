package RecursionAndBT;

public class SudokuSolver {
    public static void main(String[] args) {

    }
    public void solveSudoku(char[][] board) {

    }
    public boolean validSudoku(char [][]board, int i, int j){
        if(i==board.length) return true;
        for ( ;i<board.length;i++){
            for ( ;j<board.length;j++){
                if(board[i][j]=='.'){
                    for (char num = '1';num<='9'; num++){
                        if(canPlace(board,i,j,num)){
                            board[i][j] = num;
                            boolean ans = validSudoku(board,i,j);
                            if(ans){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
            j=0;
        }
        return true;
    }
    private boolean canPlace(char [][]board,int i,int j,char num){
        //convert to char while placing
        for (int k=0;k<9;k++){
            if(board[i][k]==num) return false;
            if(board[k][j]==num) return false;
            if(board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == num) return false;
        }
        return true;
    }

}
