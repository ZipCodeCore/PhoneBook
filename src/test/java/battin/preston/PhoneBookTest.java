package battin.preston;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prestonbattin on 2/7/17.
 */
public class PhoneBookTest {

    PhoneBook phoneBook;

    @Before
    public void setUp() throws InvalidPhoneNumberFormat{

        phoneBook = new PhoneBook();
        phoneBook.addEntry("Bob", "3027223221");
    }

    @Test
    public void lookUpTest() throws RecordNotPresent{

        String expected = "[3027223221]";
        String actual = phoneBook.lookUp("Bob");
        Assert.assertEquals("Testing adding a person", expected, actual);

    }

    @Test
    public void addEntryTest () throws InvalidPhoneNumberFormat, RecordNotPresent{

        phoneBook.addEntry("Euge", "4345677890");
        String expected = "[4345677890]";
        String actual = phoneBook.lookUp("Euge");
        Assert.assertEquals("Testing adding an entry", expected, actual);
    }

    @Test
    public void removeEntryTest() throws  InvalidPhoneNumberFormat, RecordNotPresent{

        phoneBook.addEntry("Euge", "4345677890");
        phoneBook.removeEntry("Bob");
        Entries expected = null;
        Entries actual = phoneBook.getEntry("Bob");
        Assert.assertEquals("Testing removing an item", expected, actual);
    }

    @Test
    public void printEntryNumbersTest()throws RecordNotPresent{

        String expected = "[Bob]";
        String actual = phoneBook.printAllNames().toString();
        Assert.assertEquals("Testing print all values", expected,actual);
    }

    @Test
    public void printAllEntriesTest() throws InvalidPhoneNumberFormat, RecordNotPresent{

        phoneBook.addEntry("Euge", "4345677890");
        String expected = "Bob [3027223221]" + "\n" + "Euge [4345677890]" + "\n";
        String actual = phoneBook.printAllEntries();
        Assert.assertEquals("Testing all entries print", expected, actual);
    }

    @Test
    public void reverseLookUpTest() throws  InvalidPhoneNumberFormat{

        String expected = "Bob";
        String actual = phoneBook.reverseLookUp("3027223221");
        Assert.assertEquals("Testing looking up by value", expected, actual);
    }

    @Test
    public void removeNumberTest() throws RecordNotPresent{

        phoneBook.getEntry("Bob").removeNumber("3027223221");
        String expected = "[]";
        String actual = phoneBook.getEntry("Bob").getPhoneNumbers().toString();
        Assert.assertEquals("Testing removing a number", expected, actual);
    }

    @Test(expected = InvalidPhoneNumberFormat.class)
    public void reverseLookUpExceptionTest() throws InvalidPhoneNumberFormat{

      phoneBook.reverseLookUp("");

    }

    @Test(expected = InvalidPhoneNumberFormat.class)
    public void addEntryExceptionTest() throws InvalidPhoneNumberFormat{

        phoneBook.addEntry("Kevin", "");
    }

    @Test(expected = RecordNotPresent.class)
    public void lookUpExceptionTest() throws RecordNotPresent{

        phoneBook.lookUp("Bob1");
    }

    @Test(expected = RecordNotPresent.class)
    public void removeEntryExceptionTest() throws RecordNotPresent{

        phoneBook.lookUp("");
    }

    @Test(expected = RecordNotPresent.class)
    public void getEntryExceptionTest() throws RecordNotPresent{

        phoneBook.getEntry("");
    }

    @Test(expected = RecordNotPresent.class)
    public void printAllNamesExceptionTest() throws RecordNotPresent{

        phoneBook.getEntries().clear();
        phoneBook.printAllNames();
    }

    @Test(expected = RecordNotPresent.class)
    public void printAllEntriesExceptionTest() throws RecordNotPresent{

        phoneBook.getEntries().clear();
        phoneBook.printAllEntries();
    }

}
