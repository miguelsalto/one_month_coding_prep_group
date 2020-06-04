package strings.easy;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 2);
        sb.append(s);
        sb.append(s);
        return sb.substring(1, sb.length() - 1).contains(s);
    }

}
