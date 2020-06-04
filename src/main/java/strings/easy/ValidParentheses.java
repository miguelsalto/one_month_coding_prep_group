package strings.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int sLength = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sLength; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!validateAndPopIfValid(stack, '(')) {
                    return false;
                }
            } else if (c == '}') {
                if (!validateAndPopIfValid(stack, '{')) {
                    return false;
                }
            } else if (c == ']') {
                if (!validateAndPopIfValid(stack, '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean validateAndPopIfValid(Deque<Character> stack, char c) {
        if (stack.isEmpty() || stack.peek() != c) {
            return false;
        }
        stack.pop();
        return true;
    }
}
