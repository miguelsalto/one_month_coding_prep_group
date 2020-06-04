package strings.easy;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] counters = new int[26];
        int sLength = s.length();
        for (int i = 0; i < sLength; ++i) {
            ++counters[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < sLength; ++i) {
            if (counters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
