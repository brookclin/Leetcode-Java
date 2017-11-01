import java.util.*;

public class TrieNode {
    public boolean isEnd;
    private char c;
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {

    }
    public TrieNode(char c) {
        this.c = c;
    }
}