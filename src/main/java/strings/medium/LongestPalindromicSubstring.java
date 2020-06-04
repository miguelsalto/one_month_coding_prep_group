package strings.medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int sLength = s.length();
        WordInfo max = new WordInfo(0, 0);
        for (int i = 0; i < sLength; ++i) {
            WordInfo wi1 = getPalindromeInfo(s, sLength, i, i);
            WordInfo wi2 = getPalindromeInfo(s, sLength, i, i + 1);
            if (wi1.length > max.length) {
                max = wi1;
            }
            if (wi2.length > max.length) {
                max = wi2;
            }
        }
        return s.substring(max.start, max.start + max.length);
    }

    private static WordInfo getPalindromeInfo(String s, int sLength, int lo, int hi) {
        int length = lo == hi ? -1 : 0;
        int start = lo;
        while (lo >= 0 && hi < sLength) {
            if (s.charAt(lo) != s.charAt(hi)) {
                break;
            }
            start = lo;
            length += 2;
            --lo;
            ++hi;
        }
        return new WordInfo(start, length);
    }

    private static class WordInfo {
        final int start;
        final int length;

        WordInfo(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }
}
