import java.io.*;

public class main {

    public static void main(String[] args) {
        App app = new App();


        String[] wordsToAdd = {
                "Apple", "Banana", "Cherry", "Date", "Eggplant", "Fig", "Grape", "Honeydew",
                "Iceberg", "Jackfruit", "app","Kiwi", "Lemon", "Mango", "Nectarine", "Orange", "Papaya",
                "Quince", "Raspberry", "people","Strawberry", "Tomato", "Ugli", "Vanilla", "Watermelon",
                "Xigua", "Yam", "Zucchini" ,"mohsen"
        };

        for (String word : wordsToAdd) {
            app.addWord(word);
        }

        app.printAllLettersAndWords();

        app.printWordsForLetter('A');
        app.printWordsForLetter('M');


    }
}
