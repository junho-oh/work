
/**
 * Person.
 *
 * @author JunHo_Oh
 * @version 2018
 */
public class Person implements Comparable<Person> {
    private String name;
    private String number;

    /**
     * Constructs an object of type Person.
     * 
     * @param name
     * @param number
     */
    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Returns the name for this Person.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number for this Person.
     * 
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Returns the data with the format (Max char) for this Person.
     * 
     * @param data
     *            the name or number of the Person
     * @param max
     *            maximum char
     * @return data + spaces
     */
    private String format(String data, int max) {
        int extra = max - data.length();
        String space = "";
        for (int i = 0; i < extra; i++) {
            space += " ";
        }
        return data + space;
    }

    /**
     * Return the name and the number using the format
     * 
     * @see java.lang.Object#toString()
     * @return the name and the number in the format
     */
    @Override
    public String toString() {

        return format(name, 20) + format(number, 15);
    }

    /**
     * Compares the names.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param i
     * @return
     */
    @Override
    public int compareTo(Person i) {

        return name.compareTo(i.getName());
    }
}
