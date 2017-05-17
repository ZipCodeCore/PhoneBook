import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBookTest {

    @Test
    public void addEntryWithOneNumberToPhoneBookTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        book.addEntry(entry);
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
    public void addEntryWithMultiplePhoneNumbersToPhoneBookTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        entry.addNumber("8885551234");
        book.addEntry(entry);
        String expectedValue = "(443) 540-1564, (888) 555-1234";

        // when
        String actualValue = book.lookup("Sarah");

        // then
        Assert.assertEquals(expectedValue, actualValue);
    }

   @Test
    public void addNumberToPreviousEntry() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        book.addEntry(entry);
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
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        book.addEntry(entry);
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
    public void lookupEntryTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        entry.addNumber("8885551234");
        book.addEntry(entry);
        String expected = "(443) 540-1564, (888) 555-1234";

        // when
        String actual = book.lookup("Sarah");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookupEntryNotInBookTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry = new PhoneBookEntry("Sarah");
        entry.addNumber("4435401564");
        book.addEntry(entry);
        String expected = null;

        // when
        String actual = book.lookup("Sara");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showListingsTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry1 = new PhoneBookEntry("Sarah");
        entry1.addNumber("4435401564");
        entry1.addNumber("8885551234");
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry1);
        book.addEntry(entry2);
        String[] expected = {"Name: Jenny; Phone Number(s): (302) 867-5309", "Name: Sarah; Phone Number(s): (443) 540-1564, (888) 555-1234"};

        // when
        String[] actual = book.showEntries();

        // then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseLookupByPhoneNumber() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry1 = new PhoneBookEntry("Sarah");
        entry1.addNumber("4435401564");
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry1);
        book.addEntry(entry2);
        String expected = "Jenny";

        // when
        String actual = book.reverseLookup("(302) 867-5309");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookupByPhoneNumberNotFoundTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry1 = new PhoneBookEntry("Sarah");
        entry1.addNumber("4435401564");
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry1);
        book.addEntry(entry2);
        String expected = null;

        // when
        String actual = book.reverseLookup("(402) 867-5309");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeOneNumberFromEntryTest() {
        // given
        PhoneBook book = new PhoneBook();
        PhoneBookEntry entry1 = new PhoneBookEntry("Sarah");
        entry1.addNumber("4435401564");
        entry1.addNumber("8885551234");
        PhoneBookEntry entry2 = new PhoneBookEntry("Jenny");
        entry2.addNumber("3028675309");
        book.addEntry(entry1);
        book.addEntry(entry2);
        String expected = "(443) 540-1564";
        book.removeNumberFromEntry("Sarah", "(888) 555-1234");

        // when
        String actual = book.lookup("Sarah");

        // then
        Assert.assertEquals(expected, actual);

    }
}
