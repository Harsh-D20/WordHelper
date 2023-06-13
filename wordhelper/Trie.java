
/**
Code based on Source code from Baeldung
https://github.com/eugenp/tutorials/tree/master/data-structures

Edited by Chris Haver to make some of the implementation more familiar 
to Data Structure Students and to add count attribute to TrieNode.

Edited further by Harsh Desai to work with WordHelper class.
*/

package wordhelper;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        word = word.toUpperCase();
        TrieNode cur = root;

        for (char letter : word.toCharArray()) {
            Map<Character, TrieNode> kids = cur.getChildren();
            if (kids.containsKey(letter)) {
                cur = kids.get(letter);
                cur.incrementCount();
            } else {
                kids.put(letter, new TrieNode());
                cur = kids.get(letter);
            }
        }
        cur.setEndOfWord(true);
    }

    public boolean contains(String word) {
        word = word.toUpperCase();
        TrieNode cur = root;
        for (char letter : word.toCharArray()) {
            Map<Character, TrieNode> kids = cur.getChildren();
            if (kids.containsKey(letter)) {
                cur = kids.get(letter);
            } else
                return false;
        }
        if (cur.isEndOfWord())
            return true;
        else
            return false;
    }

    public Character mostLikelyNextChar(String prefix) {
        prefix = prefix.toUpperCase();
        try {
            TrieNode cur = getEndNode(prefix);
            int max = 0;
            char maxC = '_';
            for (Map.Entry<Character, TrieNode> e : cur.getChildren().entrySet()) {
                if (e.getValue().getCount() > max) {
                    max = e.getValue().getCount();
                    maxC = e.getKey();
                }
            }
            return maxC;
        } catch (NullPointerException n) {
            return '_';
        }
    }

    public HashMap<Character, Integer> prefixFreqTable(String prefix) {
        prefix = prefix.toUpperCase();
        try {
            TrieNode cur = getEndNode(prefix);

            HashMap<Character, Integer> table = new HashMap<>();

            for (Map.Entry<Character, TrieNode> e : cur.getChildren().entrySet()) {
                table.put(e.getKey(), e.getValue().getCount());
            }

            return table;

        } catch (NullPointerException n) {
            return new HashMap<Character, Integer>();
        }
    }

    private TrieNode getEndNode(String str) {
        TrieNode cur = root;
        for (char letter : str.toCharArray()) {
            Map<Character, TrieNode> kids = cur.getChildren();
            cur = kids.get(letter);
        }
        return cur;
    }

    /*********** INNER CLASS ****/
    class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean endOfWord;
        private int count;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
            count = 1;
        }

        private Map<Character, TrieNode> getChildren() {
            return children;
        }

        private void incrementCount() {
            count++;
        }

        private int getCount() {
            return count;
        }

        private boolean isEndOfWord() {
            return endOfWord;
        }

        private void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public String toString() {
            return "(" + count + ")";
        }
    }
}