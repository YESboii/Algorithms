package Misc;
//https://en.wikipedia.org/wiki/Catalan_number
//1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, ...
//https://leetcode.com/problems/unique-binary-search-trees/description/
public class CatalanNumbers {


    public static int triangulate(int n) {

        if (n <= 3) {
            return 1;
        }


        int result = 0;
        for (int i = 2; i <= n - 1; i++) {
            result += triangulate(i) * triangulate(n - i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;  // For a rectangle (4-sided polygon)
        System.out.println("Number of ways to triangulate a polygon with " + n + " sides: " + triangulate(n));
    }
}
