import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {
    private Map<Character, List<String>> wordsMap;

    public App() {
        wordsMap = new TreeMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            wordsMap.put(c, new ArrayList<>());
        }
    }

    public void addWord(String word) {
        if (word != null && !word.isEmpty()) {
            char firstLetter = Character.toLowerCase(word.charAt(0));
            if (Character.isLetter(firstLetter)) {
                wordsMap.get(firstLetter).add(word);
            }
        }
    }

    public void printAllLettersAndWords() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + ": ");
            List<String> wordsList = wordsMap.get(c);
            for (String word : wordsList) {
                System.out.print(word + ", ");
            }
            System.out.println();
        }
    }

    public void printWordsForLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (wordsMap.containsKey(letter)) {
            List<String> wordsList = wordsMap.get(letter);
            System.out.println("Words for letter " + letter + ": " + wordsList);
        } else {
            System.out.println("No words found for letter " + letter);
        }
    }

}
