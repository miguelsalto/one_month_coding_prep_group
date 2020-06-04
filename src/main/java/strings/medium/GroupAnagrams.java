package strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String counters = createStringOfCounters(s);
            List<String> words = map.computeIfAbsent(counters, k -> new ArrayList<>());
            words.add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String createStringOfCounters(String s) {
        int[] counters = new int[26];
        int sLength = s.length();
        for (int i = 0; i < sLength; ++i) {
            ++counters[s.charAt(i) - 'a'];
        }
        StringBuilder sb = new StringBuilder(26);
        for (int i = 0; i < sLength; ++i) {
            sb.append(counters[i]);
        }
        return sb.toString();
    }
}
