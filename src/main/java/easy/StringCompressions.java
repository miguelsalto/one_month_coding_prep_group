package easy;

public class StringCompressions {
    public int compress(char[] chars) {
        int endIdx = chars.length;
        int writeIdx = endIdx - 1;
        int idx = endIdx - 1;
        for (; idx >= 0; --idx) {
            char c = chars[idx];
            if (idx == 0) {
                writeIdx = writeNumWithFreq(idx, endIdx, chars, writeIdx, c);
                break;
            }
            if (c == chars[idx - 1]) {
                continue;
            }
            writeIdx = writeNumWithFreq(idx, endIdx, chars, writeIdx, c);
            endIdx = idx;
        }
        idx = writeIdx + 1;
        writeIdx = 0;
        while (idx < chars.length) {
            chars[writeIdx++] = chars[idx++];
        }
        return writeIdx;
    }

    private static int writeNumWithFreq(int idx, int endIdx, char[] chars, int writeIdx, char c) {
        int count = endIdx - idx;
        if (count > 1) {
            while (count > 0) {
                chars[writeIdx--] = (char) ((count % 10) + '0');
                count /= 10;
            }
        }
        chars[writeIdx--] = c;
        return writeIdx;
    }
}
