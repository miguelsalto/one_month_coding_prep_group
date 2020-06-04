package strings.easy;

public class ReverseString {
    public void reverseString(char[] s) {
        int lo = 0;
        int hi = s.length;
        while (lo < hi) {
            swap(s, lo++, --hi);
        }
    }
    private static void swap(char[] s, int i, int j) {
        char temp = s[j];
        s[j] = s[i];
        s[i] = temp;
    }

}
