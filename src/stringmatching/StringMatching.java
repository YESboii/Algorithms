package stringmatching;


import java.util.Arrays;

//Using Rolling Hash
//Rabin-Karp
//https://www.geeksforgeeks.org/problems/index-of-the-first-occurrence-of-pattern-in-a-text/1
public class StringMatching {
    static final int p = 31, MOD = 1000000007;
    public static int findMatching(String text, String pattern){
        int n = text.length(), m = pattern.length();
        if(m > n) return -1;
        long []pPowers = new long[m];
        compute(pPowers, m);
        long hash1 = hash(text, m, pPowers);
        long hash2 = hash(pattern, m, pPowers);
        for(int i = 0;i <= n - m;i++){
            if(hash1 == hash2 && check(text, pattern, i, m)){
                return i;
            }else if(i < n - m){
                hash1 = updateHash(hash1, text.charAt(i), text.charAt(i + m), pPowers);
            }
        }
        return -1;
    }
    private static void compute(long []pPowers, int m){
        pPowers[m - 1] = 1;
        for (int i = m - 2;i >= 0;i--){
            pPowers[i] = (p * pPowers[i + 1]) % MOD;
        }
        System.out.println(Arrays.toString(pPowers));
    }

    private static long updateHash(long hash, char old, char newChar, long []pPowers) {
//        hash = ((hash - (old - 'a' + 1) * pPowers[0]) + MOD) % MOD;
        hash = ((hash - (((old - 'a' + 1) * pPowers[0]) % MOD) + MOD))%MOD;
        hash = (hash * p) % MOD;
        hash = (hash + (newChar - 'a' + 1))% MOD;
        return hash;
    }

    private static long hash(String s, int len, long []pPowers){
        long hash = 0;
        for (int i = len - 1;i >= 0;i--){
            char ch = s.charAt(i);
            hash = (hash + (ch - 'a' + 1) * pPowers[i]) % MOD;
        }
        return hash;
    }
    private static boolean check(String text, String pattern, int i, int m){
        for (int j = 0;j < m;j++){
            if (text.charAt(i + j) != pattern.charAt(j)) return false;
        }return true;
    }

    public static void main(String[] args) {

        System.out.println(findMatching("qwertyuioooopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm", "wertyuioooopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm"));
        System.out.println("qwertyuioooopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm".indexOf("wertyuioooopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm"));
    }
}
