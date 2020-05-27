package easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Trie trie = new Trie();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i) {
            String s = strs[i];
            min = Math.min(min, trie.insert(s, i));
            if (min == 0) {
                return "";
            }
        }
        return strs[0].substring(0, min);
    }

    private static class Trie {
        TrieNode root = new TrieNode(' ');

        int insert(String s, int matches) {
            int sLength = s.length();
            TrieNode current = root;
            int count = 0;
            for (int i = 0; i < sLength; ++i) {
                char c = s.charAt(i);
                int idx = c - 'a';
                TrieNode child = current.children[idx];
                if (child == null) {
                    child = new TrieNode(c);
                    current.children[idx] = child;
                }
                if (child.matches != matches) {
                    break;
                }
                ++count;
                ++child.matches;
                current = child;
            }
            return count;
        }
    }

    private static class TrieNode {
        final char val;
        int matches;
        TrieNode[] children = new TrieNode[26];

        TrieNode(char val) {
            this.val = val;
        }
    }
}
