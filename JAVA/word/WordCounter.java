package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * <p>
 * COMP 1510 assignment 3 q1.
 * </p>
 * <p>
 * WordCounter contains methods that check each word then, add them to wordList
 * and modifies a frequency of each Word.
 * </p>
 *
 * @author JunHo Oh Set C.
 * @version 1.0
 */
public class WordCounter {

    /**
     * <p>
     * ArrayList of Words.
     * </p>
     */
    private static ArrayList<Word> wordList;

    /**
     * <p>
     * Final number of top frequent Words.
     * </p>
     */
    private static final int TOP10 = 10;

    /**
     * <p>
     * Returns total number of unique Words stored in the wordList.
     * </p>
     * 
     * @param fileName
     *            as a String.
     * @return as a integer
     * @throws FileNotFoundException
     *             exception
     */
    public int parseBook(String fileName) throws FileNotFoundException {
        wordList = new ArrayList<Word>();
        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            Word check = new Word(scan.next());
            if (!checkContains(check)) {
                wordList.add(check);
            }
        }
        scan.close();
        return wordList.size();
    }

    /**
     * <p>
     * Check if the word is already in the list and increments its frequency and
     * add it to the wordList if the word is not in the list.
     * </p>
     * <p>
     * Returns true if word is already in the list.
     * </p>
     * 
     * @param check
     *            as a Word
     * @return as a boolean
     */
    private boolean checkContains(Word check) {
        for (Word i : wordList) {
            if (i.getWord().equalsIgnoreCase(check.getWord())) {
                i.incFrequency();
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Prints the n most frequent words in order( high to low).
     * </p>
     * 
     * @param n
     *        as an integer
     */
    public void printTopWords(int n) {
        wordList.sort(null);
        Collections.reverse(wordList);
        for (int i = 0; i < n; i++) {
            System.out.println(wordList.get(i));
        }
    }

    /**
     * <p>
     * Drives the program.
     * </p>
     *
     * @param args
     *            unused.
     * @throws FileNotFoundException exception
     */
    public static void main(String[] args) throws FileNotFoundException {
        WordCounter bible = new WordCounter();

        System.out.println(bible.parseBook("src/bible.txt"));
        bible.printTopWords(TOP10);

        System.out.println("Question one was called and ran sucessfully.");
    }

};
