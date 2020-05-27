package medium;

public class StringToInteger {
    public int myAtoi(String str) {
        int idx = 0;
        int sLen = str.length();
        while (idx < sLen && str.charAt(idx) == ' ') {
            ++idx;
        }
        if (idx == sLen) {
            return 0;
        }
        char first = str.charAt(idx);
        if (first != '+' && first != '-' && !Character.isDigit(first)) {
            return 0;
        }
        long sign = first == '-' ? -1 : 1;
        long num = 0;
        if (!Character.isDigit(first)) {
            ++idx;
        }
        while (idx < sLen && Character.isDigit(str.charAt(idx))) {
            num = num * 10 + (str.charAt(idx) - '0');
            if (num > Integer.MAX_VALUE) {
                return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ++idx;
        }
        return (int) (num * sign);
    }
}
