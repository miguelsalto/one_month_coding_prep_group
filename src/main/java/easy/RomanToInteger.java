package easy;

import java.util.Hashtable;
import java.util.Map;

public class RomanToInteger {
    private static final Map<Character, Integer> ROMAN_TO_INT = createRomanToIntMapping();

    private static Map<Character, Integer> createRomanToIntMapping() {
        Map<Character, Integer> map = new Hashtable<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public int romanToInt(String s) {
        int prev = 0;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            int current = ROMAN_TO_INT.get(s.charAt(i));
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }
}
