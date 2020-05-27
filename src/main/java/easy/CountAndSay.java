package easy;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "1";
        for (int i = 2; i <= n; ++i) {
            result = transform(result);
        }
        return result;
    }

    private static String transform(String s) {
        int count = 0;
        int sLength = s.length();
        char prev = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= sLength; ++i) {
            if (i == sLength) {
                sb.append(count);
                sb.append(prev);
                break;
            }
            char c = s.charAt(i);
            if (c == prev) {
                ++count;
            } else {
                sb.append(count);
                sb.append(prev);
                count = 1;
                prev = c;
            }
        }
        return sb.toString();
    }
}
