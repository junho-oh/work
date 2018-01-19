import java.util.Scanner;

/**
 * 
 * Main. (Address Book) The program adds, searches or removes a person from the
 * Address Book. It also display all the people in the database using the
 * certain format.
 *
 * @author JunHo_Oh
 * @version 2018
 */
public class Main {
    private Person[] database;
    private Scanner input;

    /**
     * Constructs an object of type Main.
     */
    public Main() {
        database = new Person[0];
        input = new Scanner(System.in);
    }

    /**
     * Adds new person's data to the address book(database).
     * 
     * @param name
     *            the name of new person.
     * @param number
     *            the number of new person.
     */
    public void add(final String name, String number) {
        Person[] temp = new Person[database.length + 1];
        for (int i = 0; i < database.length; i++) {
            temp[i] = database[i];
        }
        temp[database.length] = new Person(name, number);
        database = temp;
    }

    /**
     * Given the name of the person to find, Returns the position of that entry in
     * the address book (database) OR returns -1 indicating not found.
     * 
     * @param name
     *            The name of the person to find.
     * @return the position in the database
     */
    public int search(final String name) {
        for (int i = 0; i < database.length; i++) {
            if (database[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sorts the address book(database) in an alphabetical order.
     */
    private void sorting() {
        for (int i = 0; i < database.length - 1; i++) {
            for (int j = i + 1; j < database.length; j++) {
                if (database[i].compareTo(database[j]) > 0) {
                    Person temp = database[i];
                    database[i] = database[j];
                    database[j] = temp;
                }
            }
        }
    }

    /**
     * Displays all the records in the address book(database).
     */
    public void displayAll() {
        sorting();
        System.out.println("\nName                PhoneNumber");
        for (Person i : database) {
            System.out.println(i);
        }
    }

    /**
     * Checks the person's data for the database to be removed.
     * 
     * @param name
     *            a name of the person to be removed
     * @return true if the name is existed.
     */
    public boolean remove(final String name) {
        int pos = search(name);
        if (pos >= 0) {
            Person[] temp = new Person[database.length - 1];
            System.arraycopy(database, 0, temp, 0, pos);
            System.arraycopy(database, pos + 1, temp, pos, database.length - pos - 1);
            database = temp;
            return true;
        }
        return false;
    }

    /**
     * Displays the options.
     */
    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }

    /**
     * Checks if the choice is within the bounds and returns the user's choice.
     * 
     * @return user's choice.
     */
    public int getChoice() {
        int choice = 0;// default
        boolean done = false;
        while (!done) {
            System.out.print("choice? ");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                input.next();
            }
            if (choice > 0 && choice <= 5)
                done = true;
            else
                System.out.println("\nYour choice is incorrect, please try again");
        }
        return choice;
    }

    /**
     * Adds a new person's data to the database.
     */
    public void addPerson() {
        String name = "";
        String phone = "";
        try {
            System.out.print("Enter the persons name ");
            name = valid(20);
            System.out.print("\nEnter the persons phone number ");
            phone = valid(15);
        } catch (Exception e) {
        }
        add(name, phone);
    }

    /**
     * Checks if the name is already exist in the database and checks if the length
     * of name and number is within the range.
     * 
     * @param maximum
     *            the maximum char of the data.
     * @return user's input
     */
    private String valid(int maximum) {
        String data;
        boolean check = false;
        do {
            data = input.next();
            if (search(data) >= 0) {
                System.out.print("Already exist\nEnter again: ");
            } else if (data.length() >= maximum) {
                System.out.print("Too long! (maximum " + maximum + " chars)\nEnter again: ");
            } else {
                check = true;
            }
        } while (!check);
        return data;
    }

    /**
     * Deletes the person's data from the database.
     */
    public void deletePerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
        }
        if (!remove(name))
            System.out.println("Could not delete " + name);
        else
            System.out.println(name + " was deleted successfully");
    }

    /**
     * Finds the person's data from the database.
     */
    public void findPerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
        }
        int pos = search(name);
        if (pos >= 0) {
            // ADD YOUR DISPLAY CODE HERE TO DISPLAY A SINGLE PERSON'S INFO
            System.out.println(database[pos]);
        } else {
            System.out.println("No such person");
        }
    }

    /**
     * Runs the options.
     */
    public void run() {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
            case 1:
                addPerson();
                break;
            case 2:
                deletePerson();
                break;
            case 3:
                findPerson();
                break;
            case 4:
                displayAll();
            default:
                // should not get here
            }

        } while (choice != 5);
    }

    /**
     * Drives the program.
     * 
     * @param args
     *            unused.
     */
    public static void main(String[] args) {
        new Main().run();
    }
}