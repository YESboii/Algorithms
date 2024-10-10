package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("bba","ab"));
    }
    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        int start = -1, end = -1, i = 0, j = 0, min = s.length();
        boolean windowFound = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            // add to map
            Character key = t.charAt(k);
            map.put(key, map.getOrDefault(key,0)+1);
        }

        int counter = map.size(); // mistake I made
        //t.length() is incorrect since we need to keep track for each unique character
        // we have enough characters in s
        while (j < s.length()) {
            Character key = s.charAt(j);
            if (map.containsKey(key)) {
                Integer val = map.get(key);
                val--;
                map.put(key, val);
                if (val == 0) {
                    counter--;
                }
                // mistake I made
                //counter<=0 is incorrect since for same character we would have dec
                // the counter twice leading to in accurate results
            }
            if (counter==0) {
                // check if we can trim the window from left
                // and still have all characters from string t in the window
                while (true) {
                    Integer value = map.get(s.charAt(i));
                    if (value == null) {
                        i++;
                    } else if (value < 0) {
                        map.put(s.charAt(i), value + 1);
                        i++;
                    } else {
                        break;
                    }
                }
                if (j - i + 1 <= min) {
                    min = j - i + 1;
                    start = i;
                    end = j;
                }
            }
            j++;
        }
        if (counter!=0)
            return "";

        return s.substring(start, end + 1);
    }
}
