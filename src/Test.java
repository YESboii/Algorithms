public class Test {
    public static void traverseDiagonally(int[][] matrix) {
        int N = matrix.length;

        // Step 1: Start diagonals from the leftmost column, moving from bottom to top
        for (int row = N - 1; row >= 0; row--) {
            int i = row;
            int j = 0;
            while (i < N && j < N) {
                System.out.print(matrix[i][j] + " ");
                i++;
                j++;
            }
            System.out.println();
        }

        // Step 2: Start diagonals from the bottom row, moving from left to right
        for (int col = 1; col < N; col++) { // Start from 1 to avoid repeating (N-1, 0)
            int i = 0;
            int j = col;
            while (i < N && j < N) {
                System.out.print(matrix[i][j] + " ");
                i++;
                j++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        traverseDiagonally(matrix);
    }
}
