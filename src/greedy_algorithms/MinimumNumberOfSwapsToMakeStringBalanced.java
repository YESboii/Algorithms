package greedy_algorithms;
//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
public class MinimumNumberOfSwapsToMakeStringBalanced {
    public static void main(String[] args) {
        System.out.println(minSwaps("[]][][[]"));
    }
    public static int minSwaps(String s) {
        int swaps = 0, open = 0, closed = 0, n = s.length()/2;
        for(char ch : s.toCharArray()){
            if(open == closed && ch == ']'){
                open++;
                swaps++;
            }else if(ch == '[' && open < n) open ++;
            else closed++;
            System.out.println("open: %s, closed: %s".formatted(open, closed));
        }
        return swaps;
    }
}
