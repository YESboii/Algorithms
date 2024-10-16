package graphs;

import java.util.HashSet;
import java.util.Set;
//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        countDistinctIslands(new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}});
    }
    //simple path serialization
    static int countDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        set.add("B");
        int count = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    StringBuilder path = new StringBuilder();
                    dfs(i, j, m, n, grid, visited, path, 'S');
                    String island = path.toString();
                    if(!set.contains(island)){
                        set.add(island);
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private static void dfs(int i, int j, int m, int n, int[][] grid, boolean [][]visited
            , StringBuilder island, char dir
    ){
        island.append(dir);
        visited[i][j] = true;
        int [][]directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};// l U R D
        char [] ch = {'L', 'U', 'R', 'D'};
        for(int x = 0;x < 4;x++){
            int r = i + directions[x][0], c = j + directions[x][1];
            if(r < m && r >= 0 && c < n && c >= 0 && grid[r][c] == 1 && !visited[r][c]){
                dfs(r, c, m, n, grid, visited, island, ch[x]);
            }
        }
        island.append('B');
    }
}
