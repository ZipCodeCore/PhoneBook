import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBookTest {
    PhoneBookEntry entry;
    PhoneBook book;

    @Before
    public void setUp() throws InvalidPhoneNumberFormatException {
        // given{
        book = new PhoneBook();
        entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        book.addEntry(entry);
    }

    @Test
    public void addEntryWithOneNumberToPhoneBookTest() {
        int expectedSize = 1;
        String expectedValue = "(443) 540-1564";

        // when
        int actualSize = book.getPhoneBook().size();
        String actualValue = book.lookup("Sarah");

        // then
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addEntryWithMultiplePhoneNumbersToPhoneBookTest() throws InvalidPhoneNumberFormatException {
        // given
        entry.addNumber("8885551234");
        book.addEntry(entry);
        String expectedValue = "(443) 540-1564, (888) 555-1234";

        // when
        String actualValue = book.lookup("Sarah");

        // then
        Assert.assertEquals(expectedValue, actualValue);
    }

   @Test
    public void addNumberToPreviousEntry() throws InvalidPhoneNumberFormatException {
        // given
        book.addNumberToEntry("Sarah", "8885551234");
        String expectedValue = "(443) 540-1564, (888) 555-1234";

        // when
        String actualValue = book.lookup("Sarah");

        // then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void removeEntryFromPhoneBookTest() {
        // given
        String expectedRemoved = "(443) 540-1564";
        int expected = 0;

        // when
        String removed = book.removeEntry("Sarah");
        int actual = book.getPhoneBook().size();

        // then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedRemoved, removed);
    }

    @Test
    public void lookupEntryTest() throws InvalidPhoneNumberFormatException {
        // given
        entry.addNumber("8885551234");
        book.addEntry(entry);
        String expected = "(443) 540-1564, (888) 555-1234";

        // when
        String actual = book.lookup("Sarah");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookupEntryNotInBookTest() throws InvalidPhoneNumberFormatException {
        // given
        String expected = null;

        // when
        String actual = book.lookup("Sara");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showListingsTest() throws InvalidPhoneNumberFormatException {
        // given
        entry.addNumber("8885551234");
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry);
        book.addEntry(entry2);
        String[] expected = {"Name: Jenny; Phone Number(s): (302) 867-5309", "Name: Sarah; Phone Number(s): (443) 540-1564, (888) 555-1234"};

        // when
        String[] actual = book.showEntries();

        // then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseLookupByPhoneNumber() throws InvalidPhoneNumberFormatException {
        // given
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry2);
        String expected = "Jenny";

        // when
        String actual = book.reverseLookup("(302) 867-5309");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookupByPhoneNumberNotFoundTest() throws InvalidPhoneNumberFormatException {
        // given
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry);
        book.addEntry(entry2);
        String expected = null;

        // when
        String actual = book.reverseLookup("(402) 867-5309");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeOneNumberFromEntryTest() throws InvalidPhoneNumberFormatException {
        // given
        entry.addNumber("8885551234");
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry);
        book.addEntry(entry2);
        String expected = "(443) 540-1564";
        book.removeNumberFromEntry("Sarah", "(888) 555-1234");

        // when
        String actual = book.lookup("Sarah");

        // then
        Assert.assertEquals(expected, actual);

    }
}
