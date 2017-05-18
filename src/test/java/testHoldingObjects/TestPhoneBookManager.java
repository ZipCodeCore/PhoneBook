package testHoldingObjects;

/**
 * Created by mattwu on 5/16/17.
 */


import holdingObjects.PhoneBookManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TestPhoneBookManager {

    PhoneBookManager phoneBook;

    @Before
    public void setUp(){
        phoneBook = new PhoneBookManager();
        phoneBook.add("Mr L", "(123)456-7890");
    }


    @Test
    public void testAdd() {

        int currentSize = phoneBook.size();
        int expectedSize = currentSize + 1;

        phoneBook.add("Ms J", "(111)222-0000");
        int actualSize = phoneBook.size();

        assertEquals("The size of phoneBook should be increased by one",expectedSize, actualSize, 0);

    }


    @Test
    public void testRemove(){

        int currentSize = phoneBook.size();
        int expectedSize = currentSize - 1;

        phoneBook.remove("Mr L");
        int actualSize = phoneBook.size();

        assertEquals("The size of phoneBook should be decread by one",expectedSize, actualSize, 0);

    }

    @Test
    public void testLookup(){

        String expected = "Mr L: (123)456-7890";
        String actual = phoneBook.lookup("Mr L");

        assertEquals("pull phone number by name", expected, actual);
    }

    @Test
    public void testShowAllEntries(){

        phoneBook.add("Ms K", "(678)123-4567");

        String expected = "All Entries are Below\n\nName: Mr L\nPhoneNumbers: (123)456-7890\n\nName: Ms K\nPhoneNumbers: (678)123-4567";
        String actual = phoneBook.showAllEntries();

        assertEquals("Should be showing all the entries", expected, actual);
    }

    @Test
    public void testReverseLookup(){

        String expected =  "(123)456-7890"+ ": " + "Mr L";
        String actual = phoneBook.reverseLookup("(123)456-7890");

        assertEquals("Should be showing all the entries", expected, actual);

    }


}


