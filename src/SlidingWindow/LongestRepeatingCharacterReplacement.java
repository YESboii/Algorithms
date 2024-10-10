package SlidingWindow;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    //optimised but still not optimal
//    public int characterReplacement(String s, int k) {
//        int[] freq = new int[26];
//        int l = 0, r = 0, maxSubStr = 0;
//
//        while (r < s.length()) {
//            int idx = s.charAt(r) - 'A';
//            freq[idx] += 1;
//            int max = 0, maxIdx = 0;
//            for (int x = 0; x < 26; x++) {
//                if (freq[x] > max) {
//                    maxIdx = x;
//                    max = freq[x];
//                }
//            }
//            int freqOfOtherCharacters = (r - l + 1) - max;
//            if (freqOfOtherCharacters > k) {
//                idx = s.charAt(l) - 'A';
//                freq[idx] -= 1;
//                if (idx != maxIdx) {
//                    freqOfOtherCharacters--;
//                } else {
//                    for (int x = 0; x < 26; x++) {
//                        if (freq[x] > max) {
//                            maxIdx = x;
//                            max = freq[x];
//                        }
//                    }
//                    freqOfOtherCharacters = (r - l + 1) - max;
//                }
//                l++;
//            }
//            if(freqOfOtherCharacters<=k){
//                maxSubStr = Math.max(maxSubStr, r - l + 1);
//            }
//            r++;
//        }
//        return maxSubStr;
//    }
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0, maxSubStr = 0;
        int maxFreq = 0;

        while (r < s.length()) {
            int idx = s.charAt(r) - 'A';
            freq[idx] += 1;


            maxFreq = Math.max(maxFreq, freq[idx]);

            int charsToChange = (r - l + 1) - maxFreq;

            if (charsToChange > k) {
                // Shrink the window. Even if the character being removed is the most frequent character,
                // we do not need to recompute maxFreq. This is because:
                // 1. A smaller window will never contribute to a larger valid substring compared to
                //    the previous window (when it was larger).
                // 2. The largest valid substring will be formed when the most frequent character
                //    dominates the window, and this value of maxFreq will be preserved or increased
                //    in future iterations as the window expands.
                // 3. Recomputing maxFreq is inefficient because a smaller max frequency value
                //    (after shrinking the window) will never contribute to a valid larger substring.
                //    If maxFreq decreases, it would always result in charsToChange > k,
                //    which means the current window is invalid for forming a larger valid substring.
                //    Therefore, we only care about when maxFreq increases in the future as the window expands.
                freq[s.charAt(l) - 'A'] -= 1;
                l++;
            }

            if (charsToChange <= k) {
                maxSubStr = Math.max(maxSubStr, r - l + 1);
            }

            r++;
        }

        return maxSubStr;
    }
}
