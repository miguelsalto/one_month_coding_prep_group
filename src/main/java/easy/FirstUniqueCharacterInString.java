package easy;

import java.util.Arrays;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] flags = new int[26];
        Arrays.fill(flags, -2);
        int sLength = s.length();
        for (int i = 0; i < sLength; ++i) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (flags[idx] == -2) {
                flags[idx] = idx;
            } else if (flags[idx] > -1) {
                flags[idx] = -1;
            }
        }
        for (int i = 0; i < sLength; ++i) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (flags[idx] > -1) {
                return i;
            }
        }
        return -1;
    }

}
