package dynamic_programming.strings;
//https://leetcode.com/submissions/detail/1442007630/
import java.util.*;

public class WildCardMatching {

    static Map<String, Integer> callCount = new HashMap<>();

    public static boolean isMatch(String s, String p) {
        callCount.clear();
        return match(s, p, 0, 0);
    }

    private static boolean match(String s, String p, int i, int j) {
        String key = i + "," + j;
        callCount.put(key, callCount.getOrDefault(key, 0) + 1);

        if (i == s.length() && j == p.length()) return true;
        if (j == p.length()) return false;

        if (i == s.length()) {
            // Remaining pattern must be all '*'
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        char sc = s.charAt(i);
        char pc = p.charAt(j);

        if (pc == '?' || pc == sc) {
            return match(s, p, i + 1, j + 1);
        } else if (pc == '*') {
            return match(s, p, i, j + 1) || match(s, p, i + 1, j);
        } else {
            return false;
        }
    }

    public static void printOverlappingCalls() {
        System.out.println("Subproblems called more than once:");
        for (Map.Entry<String, Integer> entry : callCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("State (" + entry.getKey() + ") called " + entry.getValue() + " times");
            }
        }
    }

    public static void main(String[] args) {
        String s = "abefcdgiescdfimde";
        String p = "ab****cd?i*de";

        boolean result = isMatch(s, p);
        System.out.println("Match result: " + result);
        printOverlappingCalls();

        // Add another test case
        System.out.println("\n---\n");

        s = "aade";
        p = "*a**dde";
        result = isMatch(s, p);
        System.out.println("Match result: " + result);
        printOverlappingCalls();
    }
}