package wordhelper;

import java.io.*;
import java.util.HashMap;

public class WordHelper {
    static Trie trie;
    public static final int NOT_WORD = 0, CAN_WORD = 1, PARTIAL_WORD = 2, COMPLETE_WORD = 3;
    static {
        trie = new Trie();
        loadFile();
    }
    
    private static void loadFile() {
        try {
			InputStream is = Trie.class.getResourceAsStream("words.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String text;
			while ((text = br.readLine()) != null) {
				trie.add(text);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
    }

    public static Integer lookup(String word) {
        char res = trie.mostLikelyNextChar(word);
        if(trie.contains(word)) {
            if(res == '_')
                return COMPLETE_WORD;
            else return PARTIAL_WORD;
        }
        else {
            if(res != '_')
                return CAN_WORD;
            else return NOT_WORD;
        }
    }

    public static Character mostLikelyNextChar(String word) {
        return trie.mostLikelyNextChar(word);
    }

    public static Boolean contains(String word) {
        return trie.contains(word);
    }

    public static HashMap<Character, Integer> prefixFreqTable(String prefix) {
        return new HashMap<Character, Integer>();
    }

}
