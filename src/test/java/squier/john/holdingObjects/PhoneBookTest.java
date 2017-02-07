package squier.john.holdingObjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author John A. Squier
 */
public class PhoneBookTest {

    PhoneBook phoneBook;
    PhoneBookEntry entry1, entry2;

    @Before
    public void setup() {
        phoneBook = new PhoneBook();

        entry1 = new PhoneBookEntry("John Squier", new PhoneNumber("123-456-7890"));
        entry2 = new PhoneBookEntry("Mike Wolfe", new PhoneNumber("098-765-4321"));

        phoneBook.addEntry(entry2);
        phoneBook.addEntry(entry1);
    }

    @Test
    public void isPhoneBookSortedTest() {
        Assert.assertTrue(phoneBook.get(0).equals(entry1)
                        && phoneBook.get(1).equals(entry2));

    }

    @Test
    public void lookupEntryThatExistsTest() {
        PhoneNumber expected = new PhoneNumber("123-456-7890");
        PhoneNumber actual = phoneBook.lookup("John Squier");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addEntryToPhoneBookTest() {
        int expectedBefore = 2, expectedAfter = 3;

        int actualBefore = phoneBook.size();

        phoneBook.addEntry(new PhoneBookEntry("Bob Dole", new PhoneNumber("333-333-3333")));

        int actualAfter = phoneBook.size();

        Assert.assertTrue(expectedBefore == actualBefore
                            && expectedAfter == actualAfter);
    }

    @Test
    public void removeEntryFromPhoneBookTest() {
        int expectedBefore = 2, expectedAfter = 1;

        int actualBefore = phoneBook.size();

        phoneBook.removeEntry(new PhoneBookEntry("Mike Wolfe", new PhoneNumber("098-765-4321")));

        int actualAfter = phoneBook.size();

        Assert.assertTrue( expectedBefore == actualBefore
                            && expectedAfter == actualAfter );
    }

    @Test
    public void listAllNamesTest() {
        String[] expected = new String[2];
        expected[0] = "John Squier";
        expected[1] = "Mike Wolfe";

        String[] actual = phoneBook.listAllNames();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void listAllEntriesTest() {
        PhoneBookEntry[] expected = new PhoneBookEntry[2];
        expected[0] = entry1;
        expected[1] = entry2;

        PhoneBookEntry[] actual = phoneBook.listAllEntries();

        Assert.assertArrayEquals(expected, actual);
    }
}
