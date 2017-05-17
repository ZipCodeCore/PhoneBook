import java.util.TreeMap;

/**
 * Created by jarrydstamatelos on 5/16/17.
 */
public class Main {

    public static void main(String[]args) {

        PhoneBook.addPhoneBookEntry("123456789", "Keanu Reaves");
        PhoneBook.addPhoneBookEntry("234234253", "Neo");
        PhoneBook.addPhoneBookEntry("438209893", "Johnny Utah");
        PhoneBook.addPhoneBookEntry("935235389", "Ted");
        PhoneBook.addPhoneBookEntry("789766878", "Jack Traven");

        PhoneBook.removePhoneBookEntryByName("789766878");


        PhoneBook.listAllEntriesInPhoneBook();

        PhoneBook.lookUpNameBasedOnPhoneNumber("123456789");


    }

}
