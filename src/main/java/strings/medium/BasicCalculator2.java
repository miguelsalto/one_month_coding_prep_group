package strings.medium;

public class BasicCalculator2 {
    public int calculate(String s) {
        String input = s.replaceAll(" ", "");
        DigitInfo digitInfo = extractDigitInfo(input, 0);
        return calculate(input, digitInfo.endIdx, digitInfo.num, digitInfo.num);
    }

    private static int calculate(String s, int idx, int soFar, int rightSum) {
        if (idx == s.length()) {
            return soFar;
        }
        char op = s.charAt(idx);
        DigitInfo digitInfo = extractDigitInfo(s, idx + 1);
        int num = digitInfo.num;
        int endIdx = digitInfo.endIdx;
        if (op == '+') {
            return calculate(s, endIdx, soFar + num, num);
        }
        if (op == '-') {
            return calculate(s, endIdx, soFar - num, -num);
        }
        if (op == '*') {
            int mult = rightSum * num;
            return calculate(s, endIdx, soFar - rightSum + mult, mult);
        }
        int div = rightSum / num;
        return calculate(s, endIdx, soFar - rightSum + div, div);
    }

    private static DigitInfo extractDigitInfo(String s, int idx) {
        StringBuilder sb = new StringBuilder();
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            sb.append(s.charAt(idx++));
        }
        int num = Integer.parseInt(sb.toString());
        return new DigitInfo(num, idx);
    }

    private static class DigitInfo {
        final int num;
        final int endIdx;

        DigitInfo(int num, int endIdx) {
            this.num = num;
            this.endIdx = endIdx;
        }
    }

    public static void main(String[] args) {
        BasicCalculator2 sol = new BasicCalculator2();
        System.out.println(sol.calculate("12-3*4"));

    }
}
