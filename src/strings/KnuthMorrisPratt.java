package strings;
//https://leetcode.com/problems/longest-happy-prefix/description/

import java.util.Arrays;

//O(m + n)
public class KnuthMorrisPratt {
    //O(len(pattern))
    public static int[] buildLPS(String pattern){
        int n = pattern.length(), i = 1, prevLPS = 0;
        int[] lps = new int[n];
        while(i < n){
            if(pattern.charAt(i) == pattern.charAt(prevLPS)){
                prevLPS++; //extend the current prefix suffix
                lps[i] = prevLPS;
                i++;
            } else if (prevLPS == 0) {
                i++;
            }else{
                prevLPS = lps[prevLPS - 1];// if not then try to extend prev longest
            }
        }
        return lps;
    }
    public static int strStr(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;
        int n = text.length(), m = pattern.length();
        if(m > n) return -1;
        while (i < n){
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            }else {
                j = lps[j - 1];
            }
            if(j == m) return i - m;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildLPS("abcdab")));
    }
}
