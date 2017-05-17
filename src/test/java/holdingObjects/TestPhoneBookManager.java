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
    public void setUp(){

        pb = new PhoneBookManager();

        pb.addEntries("Ms J", "(302)450-4500");

    }

    @Test
    public void testAddEntry() {

        int currentSize = pb.size();
        int expectedSize = currentSize + 1;


        pb.addEntries("Mr K", "(302)450-0000");
        int actualSize = pb.size();

        assertEquals("The size of phoneBook should be increased by one",expectedSize, actualSize, 0);
    }

    @Test
    public void testRemoveEntry(){

        int currentSize = pb.size();
        int expectedSize = currentSize - 1;

        pb.removeEntry("Ms J");
        int actualSize = pb.size();

        assertEquals("The size of phoneBook should be decread by one",expectedSize, actualSize, 0);
    }

    @Test
    public void testLookup(){

        String lookupName = "Ms J";

        String expected = "Ms J: [(302)450-4500]";
        String actual = pb.lookup(lookupName);

        assertEquals("pull phone number by name", expected, actual);
    }

    @Test
    public void testShowAllEntries(){

        pb.addEntries("Zach Mullen", "(302)450-4000");

        String expected = "\n\nMs J\n[(302)450-4500]\n\nZach Mullen\n[(302)450-4000]";
        String actual = pb.showAllEntries();

        assertEquals("Should be showing all the entries", expected, actual);
    }

    @Test
    public void testReverseLookup(){

        String expected =  "Ms J";
        String actual = pb.reverseLookup("(302)450-4500");

        assertEquals("Should be showing all the entries", expected, actual);
    }

    @Test
    public void testAddToExistingEntry() {

        int expectedNumberOfPhoneNmbers = 2;

        pb.addToExistingEntry("Ms J", "(555)555-5555");

        int actualNumberOfPhoneNumbers = pb.phoneBook.get("Ms J").size();
    }

    @Test
    public void testRemoveOneNumberFromEntry() {

        int expectedNumberOfPhoneNmbers = 1;

        pb.addToExistingEntry("Ms J", "(555)555-5555");

        pb.removeOneNumberFromEntry("Ms J", "(555)555-5555");

        int actualNumberOfPhoneNumbers = pb.phoneBook.get("Ms J").size();
    }



}


