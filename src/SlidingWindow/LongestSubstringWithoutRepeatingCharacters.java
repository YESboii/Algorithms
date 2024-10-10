package SlidingWindow;public class LongestSubstringWithoutRepeatingCharacters {
    //O(n) O(1) - At max each character is processed twice

    public int lengthOfLongestSubstring(String s) {
        int []freq = new int[256];
        int max = 0, i = 0, j = 0;
        while(j<s.length()){
            int idx = s.charAt(j);
            if(freq[idx]==0){
                freq[idx] += 1;
                max = Math.max(max, j-i+1);
                j++;
            }else{
                //increment i till there are no duplicates in the window..
                //vdvj
                //bbbb
                //abcabcbb
                while(freq[idx]!=0){
                    freq[s.charAt(i)] -= 1;
                    i++;
                }
            }
        }
        return max;
    }
}
