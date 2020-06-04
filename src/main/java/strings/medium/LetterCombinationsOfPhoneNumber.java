package strings.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    private static final char[][] CODES = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        appendCombinations(digits, 0, new ArrayDeque<>(), result);
        return result;
    }

    private static void appendCombinations(String digits, int idx, Deque<Character> soFar, List<String> result) {
        if (idx == digits.length()) {
            result.add(convertToString(soFar));
            return;
        }
        int idxCode = digits.charAt(idx) - '2';
        for (char c : CODES[idxCode]) {
            soFar.push(c);
            appendCombinations(digits, idx + 1, soFar, result);
            soFar.pop();
        }
    }

    private static String convertToString(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = stack.descendingIterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
