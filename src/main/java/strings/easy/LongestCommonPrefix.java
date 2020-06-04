package strings.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int nStrs = strs.length;
        if (nStrs == 0) {
            return "";
        }
        String minStr = strs[0];
        for (int i = 1; i < nStrs; ++i) {
            if (strs[i].length() < minStr.length()) {
                minStr = strs[i];
            }
        }
        int minStrLen = minStr.length();
        int idx = 0;
        for (int i = 0; i < minStrLen; i++) {
            char curr = minStr.charAt(i);
            for (String str : strs) {
                if (str.charAt(idx) != curr) {
                    return minStr.substring(0, idx);
                }
            }
            ++idx;
        }
        return minStr.substring(0, idx);
    }
}
