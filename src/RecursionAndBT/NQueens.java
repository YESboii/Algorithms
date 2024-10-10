package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char [][]board = new char[n][n];
        for (int i=0;i<n;i++){
            for (int j = 0;j<n;j++)
                board[i][j] = '.';
        }
        helper(0, board,ans);
        return ans;
    }
    private void helper(int i, char[][]board, List<List<String>> ans){
        if (i==board.length){
            ans.add(convertBoard(board));
            return;
        }
        for (int col = 0; col<board.length; col++){
            if (canPlace(i,col,board)){
                board[i][col] = 'Q';
                helper(i+1,board,ans);
                board[i][col] = '.';
            }
        }
    }
    private boolean canPlace(int r,int c,char[][]board){

        for(int i=r-1;i>=0;i--){
            if(board[i][c]=='Q') return  false;
        }
        for (int i=r-1,j=c+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q') return  false;
        }
        for (int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return  false;
        }
        return true;
    }
    private List<String> convertBoard(char [][]board){
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            list.add(row);
        }
        return list;
    }
}
