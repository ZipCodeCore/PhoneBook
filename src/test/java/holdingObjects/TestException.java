package holdingObjects;

/**
 * Created by mattwu on 5/16/17.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestException {

    PhoneBookManager pb;

    @Before
    public void setUp() throws InvalidPhoneNumberFormatException {

        pb = new PhoneBookManager();

        pb.addEntry("Ms J", "(302)450-4500");

    }


    @Test(expected = InvalidPhoneNumberFormatException.class)
    public void testAddEntry() throws InvalidPhoneNumberFormatException{

        int currentSize = pb.size();
        int expectedSize = currentSize + 1;


        pb.addEntry("Mr K", "(302)40-0000"); // wrong format
        int actualSize = pb.size();

        assertEquals("The size of phoneBook should be increased by one",expectedSize, actualSize, 0);
    }

    @Test(expected = RecordNotPresent.class)
    public void testRemoveEntry() throws RecordNotPresent{

        int currentSize = pb.size();
        int expectedSize = currentSize - 1;

        pb.removeEntry("zzz"); // name not exist
        int actualSize = pb.size();

        assertEquals("The size of phoneBook should be decread by one",expectedSize, actualSize, 0);
    }



    @Test(expected = RecordNotPresent.class)
    public void testLookup() throws RecordNotPresent{

        String lookupName = "zzz"; // name not exist

        String expected = "Ms J: [(302)450-4500]";
        String actual = pb.lookup(lookupName);

        assertEquals("pull phone number by name", expected, actual);
    }

    @Test (expected = InvalidPhoneNumberFormatException.class)
    public void testShowAllEntries() throws InvalidPhoneNumberFormatException {

        pb.addEntry("Zach Mullen", "(302)50-4000"); // wrong format

        String expected = "\n\nMs J\n[(302)450-4500]\n\nZach Mullen\n[(302)450-4000]";
        String actual = pb.showAllEntries();

        assertEquals("Should be showing all the entries", expected, actual);
    }

    @Test (expected = Exception.class)
    public void testReverseLookup() throws InvalidPhoneNumberFormatException, RecordNotPresent{

        String expected =  "Ms J";
        String actual = pb.reverseLookup("(302)450-4500");

        assertEquals("Should be showing all the entries", expected, actual);
    }

    @Test (expected = Exception.class)
    public void testAddToExistingEntry() throws InvalidPhoneNumberFormatException, RecordNotPresent{

        int expectedNumberOfPhoneNmbers = 2;

        pb.addToExistingEntry("x", "(555)555-5555"); // wrong format



        int actualNumberOfPhoneNumbers = pb.phoneBook.get("Ms J").size();

        assertEquals("Should be showing all the entries", expectedNumberOfPhoneNmbers, actualNumberOfPhoneNumbers);
    }

    @Test (expected = Exception.class)
    public void testRemoveOneNumberFromEntry() throws InvalidPhoneNumberFormatException, RecordNotPresent{

        int expectedNumberOfPhoneNmbers = 1;

        pb.addToExistingEntry("Ms J", "(555)555-5555");

        pb.removeOneNumberFromEntry("x", "(555)555-5555"); //wrong name

        //pb.removeOneNumberFromEntry("", "(555)555-5555");

        int actualNumberOfPhoneNumbers = pb.phoneBook.get("Ms J").size();
    }



}
