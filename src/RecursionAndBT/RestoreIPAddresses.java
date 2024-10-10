package RecursionAndBT;

import java.util.ArrayList;
import java.util.List;
// space :O(k⋅n), where
// k is the number of valid IP addresses and
// n is the length of the input string.
//Time : O(n*3^d here depth is also fixed d=3)

public class RestoreIPAddresses {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length()< 4 || s.length()>12) return ans;
        helper(0,s,"",ans,3);
        return ans;
    }

    private static void helper(int start, String ip,String state, List<String> ans,int dots){
        if(dots==0){
            if (isValidIp(ip,start,ip.length()-1)){
                ans.add(state + ip.substring(start, ip.length()));
            }
            return;
        }
        for (int i= start;i<ip.length() && i<start+3;i++){
            if(isValidIp(ip,start,i)){
                String possibleIp = state + ip.substring(start, i+ 1) +".";
                helper(i+1,ip,possibleIp,ans,dots-1);

            }
            if(ip.charAt(start)=='0') break;
        }
    }

    static private boolean isValidIp(String ip, int start, int end) {
        String part = ip.substring(start, end+1);
        //handle the case where we would have something like this 10.10.23. so here out part will be blank in the base case.
        if(part.length()==0 || part.length()>1 && part.charAt(0)=='0') return false;

        int octet = Integer.parseInt(part);

        return 0<=octet && octet<=255;
    }
}
