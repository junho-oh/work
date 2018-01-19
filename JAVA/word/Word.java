package q1;

/**
 * <p>
 * COMP 1510 assignment 3 q1.
 * </p>
 * <p>
 * Word represents a word and it's frequency.
 * </p>
 *
 * @author JunHo_Oh_Set_C.
 * @version 2017
 */
public class Word implements Comparable<Word> {

    /**
     * <p>
     * A word for Word.
     * </p>
     */
    private final String word;

    /**
     * <p>
     * A frequency of Word.
     * </p>
     */
    private int frequency;

    /**
     * <p>
     * Constructs an object of type Word.
     * </p>
     * 
     * @param word
     *            as a String
     */
    public Word(String word) {
        this.word = word;
        frequency = 1;
    }

    /**
     * <p>
     * Returns the word for this Word.
     * </p>
     * 
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * <p>
     * Returns the frequency for this Word.
     * </p>
     * 
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * <p>
     * Sets the frequency for this Word.
     * </p>
     */
    public void incFrequency() {
        frequency++;
    }

    /**
     * <p>
     * Returns information of Word as a string.
     * </p>
     * 
     * @see java.lang.Object#toString()
     * @return toString description contains word and frequency.
     */
    @Override
    public String toString() {
        return "Word [word=" + word + ", frequency=" + frequency + "]";
    }

    /**
     * <p>
     * Compares the frequency of Word.
     * </p>
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param arg0
     *            as a Word.
     * @return as an integer
     */
    @Override
    public int compareTo(Word arg0) {
        return frequency - arg0.getFrequency();
    }

}
