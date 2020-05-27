package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        List<CharFreq> scfs = createCharFrequencies(S);
        int sCfSize = scfs.size();
        int count = 0;
        for (String word : words) {
            List<CharFreq> wcfs = createCharFrequencies(word);
            if (sCfSize != wcfs.size()) {
                continue;
            }
            boolean isStretchy = true;
            for (int i = 0; i < sCfSize; ++i) {
                CharFreq scf = scfs.get(i);
                CharFreq wcf = wcfs.get(i);
                if (scf.val != wcf.val || scf.freq < wcf.freq ||
                        (scf.freq > wcf.freq && scf.freq < 3)) {
                    isStretchy = false;
                    break;
                }
            }
            if (isStretchy) {
                ++count;
            }
        }
        return count;
    }

    private static List<CharFreq> createCharFrequencies(String S) {
        if (S.isEmpty()) {
            return Collections.emptyList();
        }
        List<CharFreq> charFreqs = new ArrayList<>();
        int prev = -1;
        int lastIdx = S.length() - 1;
        for (int i = 0; i <= lastIdx; ++i) {
            if (i == lastIdx || S.charAt(i) != S.charAt(i + 1)) {
                charFreqs.add(new CharFreq(S.charAt(i), i - prev));
                prev = i;
            }
        }
        return charFreqs;
    }

    private static class CharFreq {
        final char val;
        final int freq;

        CharFreq(char val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
}
