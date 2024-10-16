package graphs;
import java.util.Arrays;
import java.util.Stack;
public class Rotten {

        //multisource bfs
        //why bfs? because it can be thought of as processing all the neighbors
        //that will get rotten in the same time to be in the same level
        //problem can be worded differently, but hint is level
        //use a duplicate array if modifying the grid is not allowed;
        public static void main(String[] args) {
            System.out.println(orangesRotting(new int[][]{{2, 1,1}, {1,1,1},{0, 1, 2}}));
        }
        public static int orangesRotting(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] time = new int[rows][cols];
            for (int[] row : time) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            Stack<int[]> stack = new Stack<>();
            int freshOranges = 0;

            // Initialize stack with all rotten oranges and count fresh oranges
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 2) {
                        stack.push(new int[]{r, c, 0});
                        time[r][c] = 0;
                    } else if (grid[r][c] == 1) {
                        freshOranges++;
                    }
                }
            }

            // Directions for 4-directional movement
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // Perform DFS
            while (!stack.isEmpty()) {
                int[] point = stack.pop();
                int row = point[0];
                int col = point[1];
                int currentTime = point[2];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        if (currentTime + 1 < time[newRow][newCol]) {
                            time[newRow][newCol] = currentTime + 1;
                            stack.push(new int[]{newRow, newCol, currentTime + 1});
                            freshOranges--;
                            for(int []arr: time){
                                System.out.println(Arrays.toString(arr));
                            }
                            System.out.println("---------------------------------------------------");
                        }
                    }
                }
            }


            int maxTime = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1 && time[r][c] == Integer.MAX_VALUE) {
                        return -1; // There are still fresh oranges left
                    }
                    if (time[r][c] != Integer.MAX_VALUE) {
                        maxTime = Math.max(maxTime, time[r][c]);
                    }
                }
            }

            return maxTime;
        }


}
