package com.company;

public class wildcards {
    public void match_wildcards(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i > 0; i--) {
            dp[i] = p.charAt(i) == '*' && dp[i + 1];
        }
        int pointer = n - 1;
        for (int j = m - 1; j > 0; j--) {
            if (s.charAt(j) == p.charAt(pointer) || p.charAt(pointer) == '?') {
                dp[pointer] = true;
            }else {

            }
        }
    }
}
