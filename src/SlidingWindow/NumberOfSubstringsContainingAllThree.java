package SlidingWindow;

//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

public class NumberOfSubstringsContainingAllThree {
    // if we found a string that has all three chars, then all substrings following it will also be valid.
    //abc abc
    // abca
    //abcab
    //abcabc so total = len - j;
    public int numberOfSubstrings(String s) {
        int []map = new int[3];
        int l = 0, r =0, totalCount = 0,charsInWindow=0;
        while(r < s.length()){
            int idx = s.charAt(r) - 'a';
            map[idx]+=1;
            if(map[idx]==1){
                charsInWindow++;
            }
            //shrink the window now
            // for this type of cases "aaacb" we have a while instead of if
            while(charsInWindow==3){
                totalCount += s.length() - r;
                map[s.charAt(l) - 'a']-=1;
                if(map[s.charAt(l) - 'a'] == 0) charsInWindow--;
                l++;
            }
            r++;
        }

        return totalCount;
    }
}
