# WordHelper
This project is intended to be a way to create word based games. The project can be built into a jar file and imported. 

## How to setup
You can download the full project and build it into a jar file and import, 
OR
you can download the jar file at the following path: WordHelper/WordHelper_jar

## How to use
```
String exampleWord = "ON";
// check if word falls into one of four categories
switch(WordHelper.lookup(exampleWord)) {
  case WordHelper.NOT_WORD: 
    System.out.println(exampleWord + " is not a word");
    break;
  case WordHelper.CAN_WORD:
    System.out.println(exampleWord + " is not a word, but can be a word.");
    break;
  case WordHelper.PARTIAL_WORD:
    System.out.println(exampleWord + " is a word, but can be a longer word.");
    break;
  case WordHelper.COMPLETE_WORD:
   System.out.println(exampleWord + " is a word and has no more possible additions.");
   break;
}
// print out the most likely character after the prefix exampleWord
System.out.println(WordHelper.mostLikelyNextChar(exampleWord));
// print out all possible next characters and their frequencies after the prefix exampleWord
System.out.println(WordHelper.prefixFreqTable(exampleWord));
// print out if the word exists
System.out.println(WordHelper.contains(exampleWord));
```

## WordHelper Class Constants
**public static final int NOT_WORD**<br />
This represents a word that is not a word.

**public static final int CAN_WORD**<br />
This represents a word that is not a word, but can be a word with added letters.

**public static final int PARTIAL_WORD**<br />
This represents a word that is a word, but can be a longer word with added letters.

**public static final int COMPLETE_WORD**<br />
This represents a word that is a word, and cannot be made longer with added letters.

## WordHelper Methods
**public static Integer lookup(String word)**<br />
Returns an Integer representing the state of specified word.<br />
Parameters:<br />
word - word to check

Returns:<br />
This will return one of four Integers:<br />
NOT_WORD - the specified word does not exist<br />
CAN_WORD - the specified word is not a valid word, but can be with additional letters<br />
PARTIAL_WORD - the specified word is a valid word, but can be a longer word with additional letters<br />
COMPLETE_WORD - the specified word is a valid word, and cannot be made longer with additional letters<br />

**public static Character mostLikelyNextChar(String prefix)**<br />
Returns the most likely next character for the specified prefix.<br />
Parameters:<br />
prefix - the string whose most likely next letter will be found

Returns:<br />
A Character that will be either an alphabet or an underscore:
_ - the specified prefix has no possible continuations

**public static HashMap<Character, Integer> prefixFreqTable(String prefix)**<br />
Returns a HashMap with all possible continuations and their frequencies.<br />
Parameters:<br />
prefix - prefix whose continuations will be found.

Returns:<br />
A HashMap of all possible continuations and the number of words that have those continuations. An empty HashMap means there are no possible continuations.

**public static Boolean contains(String word)**<br />
Returns whether or not a full word exists. e.g. even though "FLI" is contained in other words, 
WordHelper.contains("FLI") will return false as it is not a valid word on its own. <br />
Parameters:<br />
word - word to be checked

Returns:<br />
true - the word exists
false - the word does not exist


## How to contribute
If a word exists and is not in the words.txt file, feel free to add it! Any helpful changes are welcome! 
Please rebuild the jar file when any changes are made. Please do not change the header of the Trie.java file. 
