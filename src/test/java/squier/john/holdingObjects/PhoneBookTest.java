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

        try {
            entry1 = new PhoneBookEntry("John Squier", new PhoneNumber("123-456-7890"));
            entry2 = new PhoneBookEntry("Mike Wolfe", new PhoneNumber("098-765-4321"));
        }
        catch ( InvalidPhoneNumberFormatException e ) {

        }

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
        PhoneNumber expected = null;
        try {
            expected = new PhoneNumber("123-456-7890");
        }
        catch ( InvalidPhoneNumberFormatException e ) {

        }

        PhoneNumber actual = phoneBook.lookup("John Squier");
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void lookupEntryThatDoesntExist() {
        Assert.assertNull(phoneBook.lookup("Sam Sampson"));
    }

    @Test
    public void addEntryToPhoneBookTest() {
        int expectedBefore = 2, expectedAfter = 3;

        int actualBefore = phoneBook.size();

        try {
            phoneBook.addEntry(new PhoneBookEntry("Bob Dole", new PhoneNumber("333-333-3333")));
        }
        catch ( InvalidPhoneNumberFormatException e ) {

        }

        int actualAfter = phoneBook.size();

        Assert.assertTrue(expectedBefore == actualBefore
                            && expectedAfter == actualAfter);
    }

    @Test
    public void removeEntryFromPhoneBookTest() {
        int expectedBefore = 2, expectedAfter = 1;

        int actualBefore = phoneBook.size();

        boolean removed = false;
        try {
            removed =
                    phoneBook.removeEntry(new PhoneBookEntry("Mike Wolfe", new PhoneNumber("098-765-4321")));
        }
        catch ( InvalidPhoneNumberFormatException e ) {

        }

        int actualAfter = phoneBook.size();

        Assert.assertTrue( expectedBefore == actualBefore
                            && expectedAfter == actualAfter
                            && removed );
    }

    @Test
    public void attemptToRemoveEntryThatDoesntExistTest() {
        int expectedBefore = 2, expectedAfter = 2;

        int actualBefore = phoneBook.size();

        boolean removed = false;
        try {
            removed = phoneBook.removeEntry(new PhoneBookEntry("John Doe", new PhoneNumber("123-456-7890")));
        }
        catch ( InvalidPhoneNumberFormatException e ) {

        }

        int actualAfter = phoneBook.size();

        Assert.assertTrue( expectedBefore == actualBefore
                            && expectedAfter == actualAfter
                            && removed == false);
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
