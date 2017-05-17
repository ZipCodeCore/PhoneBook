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
    public void setUp(){ phoneBook = new PhoneBookManager(); }


    @Test
    public void testAdd() {

        int currentSize = phoneBook.size();
        int expectedSize = currentSize + 1;

        phoneBook.add("Mr L", "(123)456-7890");
        int actualSize = phoneBook.size();

        assertEquals("The size of phoneBook should be increased by one",expectedSize, actualSize, 0);

    }


    @Test
    public void testRemove(){

        phoneBook.add("Mr L", "(123)456-7890");
        int currentSize = phoneBook.size();
        int expectedSize = currentSize - 1;

        phoneBook.remove("Mr L");
        int actualSize = phoneBook.size();

        assertEquals("The size of phoneBook should be decread by one",expectedSize, actualSize, 0);

    }

    @Test
    public void showAllEntires(){

        phoneBook.add("Mr L", "(123)456-7890");
        phoneBook.add("Ms K", "(678)123-4567");

        String expected = "All Entries are Below\n\nName: Mr L\nPhoneNumbers: (123)456-7890\n\nName: Ms K\nPhoneNumbers: (678)123-4567";
        String actual = phoneBook.showAllEntires();

        assertEquals("Should be showing all the entries", expected, actual);
    }


}


