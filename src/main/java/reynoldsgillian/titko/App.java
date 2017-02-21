package reynoldsgillian.titko;

import java.lang.*;

/**
 * Created by gillianreynolds-titko on 2/7/17.
 */
public class App {
    static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] arg) throws InvalidNumberFormatException, RecordNotPresentException, AssertionError {

        phoneBook.add("Jane Doe", "(321)123-4678");
        phoneBook.add("Jim Doe", "(321)123-4689");
        phoneBook.add("Jim Jones", "(321)223-4678");

        phoneBook.add("Jim Jones", "(321323-4678");


        phoneBook.removeEntry("Jim Doe");


//        phoneBook.add("Jane Doe", "(321)123-4678");
//        phoneBook.add("Jane Doe", "(321)123-4688");


       phoneBook.listAllEntries();

        phoneBook.removeSingleNumber("(321)123-4688");
        phoneBook.listAllEntries();
    }

}
