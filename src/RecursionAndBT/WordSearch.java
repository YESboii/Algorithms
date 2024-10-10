package RecursionAndBT;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for(int r = 0;r<board.length;r++){
            for(int c = 0; c<board[0].length;c++){
                if(helper(board,r,c,0,word)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][]board, int r,int c, int i,String word){
        if(i==word.length()) return true;
        if (r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]=='-') return false;
        boolean ansFromDfs = false;
        if(word.charAt(i)==board[r][c]){ //put this in the 2nd if
            board[r][c] = '-';
             ansFromDfs = helper(board,r-1,c,i+1,word) ||
                    helper(board,r+1,c,i+1,word) ||
                    helper(board,r,c-1,i+1,word) || helper(board,r,c+1,i+1,word) ;
            board[r][c] = word.charAt(i);
        }

        return ansFromDfs;
    }
}
