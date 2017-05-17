import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBookTest {

    @Test
    public void addEntryToPhoneBookTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        book.addEntry(entry);
        int expected = 1;

        // when
        int actual = book.getPhoneBook().size();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeEntryFromPhoneBookTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        book.addEntry(entry);
        book.removeEntry("Sarah");
        int expected = 0;

        // when
        int actual = book.getPhoneBook().size();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookupEntryTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah", "4435401564");
        book.addEntry(entry);
        String expected = "(443) 540-1564";

        // when
        String actual = book.lookup("Sarah");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showListingsTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry1 = new PhoneBookEntry("Sarah", "4435401564");
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny", "3028675309");
        book.addEntry(entry1);
        book.addEntry(entry2);
        String[] expected = {"Name: Jenny; Phone Number: (302) 867-5309", "Name: Sarah; Phone Number: (443) 540-1564"};

        // when
        String[] actual = book.showEntries();

        // then
        Assert.assertArrayEquals(expected, actual);
    }
}
