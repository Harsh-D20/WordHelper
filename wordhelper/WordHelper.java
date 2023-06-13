package wordhelper;

import java.io.*;

public class WordHelper {
    static Trie trie;
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
                return 3;
            else return 2;
        }
        else {
            if(res != '_')
                return 1;
            else return 0;
        }
    }
}
