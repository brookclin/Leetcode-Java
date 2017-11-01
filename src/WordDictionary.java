import java.util.*;
public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */

    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TrieNode(c));
            }
            p = p.children.get(c);
        }
        p.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, root);
    }

    private boolean find(String word, int index, TrieNode now) {
        if (index == word.length()) {
            return now.isEnd;
        }
        char c = word.charAt(index);
        if (now.children.containsKey(c)) {
            return find(word, index + 1, now.children.get(c));
        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> child : now.children.entrySet()) {
                if (find(word, index + 1, child.getValue())) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        boolean result1 = w.search("bad");
        boolean result2 = w.search("b..");
        System.out.println(result1);
        System.out.println(result2);


    }
}