package reynoldsgillian.titko;

/**
 * Created by gillianreynolds-titko on 2/7/17.
 */
public class App {
    static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] arg){
       phoneBook.add("Jane Doe", "(321)123-4678");
        phoneBook.add("Jim Doe", "(321)123-4688");
        phoneBook.add("Jim Jones", "(321)223-4678");

        phoneBook.listAllEntries();
        phoneBook.listAllNames();

        phoneBook.removeEntry("Jim Doe");
        phoneBook.listAllEntries();

    }

}
