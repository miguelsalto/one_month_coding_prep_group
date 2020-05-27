package medium;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodings(s, 0, memo);
    }

    private static int numDecodings(String s, int idx, int[] memo) {
        if (idx == s.length()) {
            return 1;
        }
        char current = s.charAt(idx);
        if (current == '0') {
            return 0;
        }
        if (idx == s.length() - 1) {
            return 1;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int sum = numDecodings(s, idx + 1, memo);
        char next = s.charAt(idx + 1);
        if (current == '1' || (current == '2' && (next >= '0' && next < '7'))) {
            sum += numDecodings(s, idx + 2, memo);
        }
        memo[idx] = sum;
        return sum;
    }
}
