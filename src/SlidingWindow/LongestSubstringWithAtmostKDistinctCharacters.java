package SlidingWindow;
//https://www.naukri.com/code360/problems/distinct-characters_2221410
public class LongestSubstringWithAtmostKDistinctCharacters {
    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int l = 0, r = 0, max = 0, countOfDistinctChars = 0;
        int []freq = new int[26];
        while(r < str.length()){
            int idx = str.charAt(r) - 'a';
            freq[idx]+=1;
            if(freq[idx]==1){
                countOfDistinctChars++;
            }
            if(countOfDistinctChars<=k){
                //possible answer
                max = Math.max(max, r - l + 1);
            }else{
                //shrink window
                idx = str.charAt(l) - 'a';
                freq[idx]-=1;
                if(freq[idx]==0) countOfDistinctChars--;
                l++;
            }
            r++;
        }
        return max;
    }

}
