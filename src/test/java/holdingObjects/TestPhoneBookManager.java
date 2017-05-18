package holdingObjects;

/**
 * Created by mattwu on 5/16/17.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestPhoneBookManager {

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

    @Test
    public void testRemoveEntry() throws RecordNotPresent{

        int currentSize = pb.size();
        int expectedSize = currentSize - 1;

        pb.removeEntry("Ms J");
        int actualSize = pb.size();

        assertEquals("The size of phoneBook should be decread by one",expectedSize, actualSize, 0);
    }



    @Test
    public void testLookup() throws RecordNotPresent{

        String lookupName = "Ms J";

        String expected = "Ms J: [(302)450-4500]";
        String actual = pb.lookup(lookupName);

        assertEquals("pull phone number by name", expected, actual);
    }

    @Test
    public void testShowAllEntries() throws InvalidPhoneNumberFormatException {

        pb.addEntry("Zach Mullen", "(302)450-4000");

        String expected = "\n\nMs J\n[(302)450-4500]\n\nZach Mullen\n[(302)450-4000]";
        String actual = pb.showAllEntries();

        assertEquals("Should be showing all the entries", expected, actual);
    }

    @Test
    public void testReverseLookup() throws InvalidPhoneNumberFormatException, RecordNotPresent{

        String expected =  "Ms J";
        String actual = pb.reverseLookup("(302)450-4500");

        assertEquals("Should be showing all the entries", expected, actual);
    }

    @Test
    public void testAddToExistingEntry() throws InvalidPhoneNumberFormatException, RecordNotPresent{

        int expectedNumberOfPhoneNmbers = 2;

        pb.addToExistingEntry("Ms J", "(555)555-5555");

        int actualNumberOfPhoneNumbers = pb.phoneBook.get("Ms J").size();

        assertEquals("Should be showing all the entries", expectedNumberOfPhoneNmbers, actualNumberOfPhoneNumbers);
    }

    @Test
    public void testRemoveOneNumberFromEntry() throws InvalidPhoneNumberFormatException, RecordNotPresent{

        int expectedNumberOfPhoneNmbers = 1;

        pb.addToExistingEntry("Ms J", "(555)555-5555");

        pb.removeOneNumberFromEntry("Ms J", "(555)555-5555");

        int actualNumberOfPhoneNumbers = pb.phoneBook.get("Ms J").size();

        assertEquals("Should be showing all the entries", expectedNumberOfPhoneNmbers, actualNumberOfPhoneNumbers);
    }



}


