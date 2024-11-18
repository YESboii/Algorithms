import java.util.*;

public class Test {
    //aacecaaa$aaacecaa
    public static String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder rev = new StringBuilder(s).reverse();
        sb.append('$');
        sb.append(rev);
        int []lps = new int[sb.length()];
        int prevLps = 0;
        for(int i = 1;i <= 2 * n;){
            if(sb.charAt(i) == sb.charAt(prevLps)){
                prevLps++;
                lps[i++] = prevLps;
            }else if(prevLps == 0) i++;
            else prevLps = lps[prevLps - 1];
        }
        if(lps[n - 1] == n) return s;
        System.out.println(Arrays.toString(lps));
        return rev.substring(0, n - lps[sb.length() - 1]) + s;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }
}
