package easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        int alphabetSize = 26;
        int[] countersS = new int[alphabetSize];
        int[] countersT = new int[alphabetSize];
        for (int i = 0; i < sLength; ++i) {
            char cs = s.charAt(i);
            ++countersS[cs - 'a'];
            char ct = t.charAt(i);
            ++countersT[ct - 'a'];
        }
        for (int i = 0; i < alphabetSize; ++i) {
            if (countersS[i] != countersT[i]) {
                return false;
            }
        }
        return true;
    }

}
