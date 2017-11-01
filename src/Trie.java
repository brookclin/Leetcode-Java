public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            if (p.children.containsKey(cur)) {
                p = p.children.get(cur);
            } else {
                TrieNode newNode = new TrieNode(cur);
                p.children.put(cur, newNode);
                p = newNode;
            }
            if (i == charArray.length - 1) {
                p.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode result = searchWordNodePos(word);
        if (result != null && result.isEnd == true) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode result = searchWordNodePos(prefix);
        if (result !=  null) {
            return true;
        }
        return false;
    }

    public TrieNode searchWordNodePos(String word) {
        TrieNode p = root;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            if (p.children.containsKey(cur)) {
                p = p.children.get(cur);
            } else {
                return null;
            }
        }
        return p;
    }
    public static void main(String[] args) {
        String word = "abcde";
        String prefix = "abc";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
