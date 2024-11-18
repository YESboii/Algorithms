package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.ca/all/616.html
public class AddBoldTagsInString {
    //[1, 4],[5,6]

    public static String addTags(String s, List<String> dict){
        List<int []> intervals = new ArrayList<>();
        for (String pat : dict){
            List<Integer> start = kmp(s, pat);//O(n + m)
            if(!start.isEmpty()){
                for (int st : start)
                    intervals.add(new int[]{st, st + pat.length()}); //O(n)
            }
        }
        intervals = mergeIntervals(intervals);
        final String open = "<b>";
        final String close = "</b>";
        intervals.forEach((x) -> System.out.println(Arrays.toString(x)));
        StringBuilder sb = new StringBuilder(s);
        int offset = 0;
        for (int [] interval : intervals){
            sb.insert(interval[0] + offset, open);
            offset += 3;
            sb.insert(interval[1] + offset, close);
            offset += 4;
        }
        return sb.toString();
    }
    private static List<int[]> mergeIntervals(List<int []>intervals){
        List<int []>merged = new ArrayList<>();
        if(intervals.isEmpty()) return merged;
        Collections.sort(intervals, (a, b) -> (a[0] - b[0]));
        int prevEnd = intervals.get(0)[1], start = intervals.get(0)[0];
        for (int i = 1;i <= intervals.size();i++){
            if(i == intervals.size()){
                merged.add(new int[]{start, prevEnd});

                break;
            }
            if(intervals.get(i)[0] <= prevEnd){
                prevEnd = Math.max(prevEnd, intervals.get(i)[1]);
            }else {
                merged.add(new int[]{start, prevEnd});
                start = intervals.get(i)[0];
                prevEnd = intervals.get(i)[1];
            }
        }
        return merged;
    }
    private static List<Integer> kmp(String text, String pattern){
        int n = text.length(), m = pattern.length();
        int[] lps = new int[m];
        int prevLps = 0;
        List<Integer> indices = new ArrayList<>();
        for (int i = 1;i < m;){
            if(pattern.charAt(i) == pattern.charAt(prevLps)){
                lps[i++] = ++prevLps;
            } else if (prevLps == 0) {
                //lps[i] = 0
                i++;
            }else{
                prevLps = lps[prevLps - 1];
            }
        }
        for (int i = 0,j = 0;i < n;){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else if (j == 0) {
                i++;
            }else{
                j = lps[j - 1];// lps[j - 1] characters in the pattern since it matches the suffix in the text....
            }
            if(j == m) {
                indices.add(i - m);
                j = lps[j - 1];
            }
        }
        return indices;
    }
    //O(nlogn) + O(k (m + 2n)) + O(n^2)   10^ 6 + 3*10^5
    //2.3 * 10^6
    public static void main(String[] args) {
        System.out.println(addTags("aabbaaccaa", List.of("aa")));
    }
}
