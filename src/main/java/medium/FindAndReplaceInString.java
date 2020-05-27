package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int inputs = indexes.length;
        Replacement[] replacements = new Replacement[inputs];
        for (int i = 0; i < inputs; ++i) {
            replacements[i] = new Replacement(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(replacements, Comparator.comparingInt(x -> x.index));
        List<Replacement> validReps = new ArrayList<>();
        for (Replacement replacement : replacements) {
            if (isValid(S, replacement)) {
                validReps.add(replacement);
            }
        }
        StringBuilder sb = new StringBuilder();
        int startIdx = 0;
        for (Replacement validRep : validReps) {
            sb.append(S.substring(startIdx, validRep.index));
            sb.append(validRep.target);
            startIdx = validRep.getNextIndex();
        }
        sb.append(S.substring(startIdx));
        return sb.toString();
    }

    private boolean isValid(String s, Replacement rep) {
        int nextIdx = rep.getNextIndex();
        if (s.length() < nextIdx) {
            return false;
        }
        String source = rep.source;
        int targetLen = source.length();
        for (int sIdx = rep.index, tIdx = 0; tIdx < targetLen; ++sIdx, ++tIdx) {
            if (s.charAt(sIdx) != source.charAt(tIdx)) {
                return false;
            }
        }
        return true;
    }

    private static class Replacement {
        final int index;
        final String source;
        final String target;

        Replacement(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }

        int getNextIndex() {
            return index + source.length();
        }
    }
}
