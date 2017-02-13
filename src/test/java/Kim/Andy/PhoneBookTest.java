package Kim.Andy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import static junit.framework.TestCase.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by andykim on 2/12/17.
 */
public class PhoneBookTest {

    PhoneBook phoneBook;


    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
    }

    @Test
    public void lookupTest(){
        phoneBook.add("Andy", "610 - 277 - 1326");
        String expected = "[610 - 277 - 1326]";
        ArrayList actual = phoneBook.lookUp("Andy");
        Assert.assertEquals("I expect this to return my phone #", expected, actual);
    }
    @Test
    public void addDupesTest(){
        phoneBook.add("Andy", "610 - 277 - 1326");
        phoneBook.add("Andy", "610 - 277 - 1326");
        int actual = 1;
        int expected = phoneBook.size();
        Assert.assertEquals("I expect dupes not to be added", expected, actual);
    }
    @Test
    public void deleteTest(){
        phoneBook.add("Andy", "610 - 277 - 1326");
        phoneBook.removeRecord("Andy");
        int expected = 0;
        int actual = phoneBook.size();
        Assert.assertEquals("I expect my phonebook to be empty",expected, actual);
    }
    @Test
    public void reverseLookUpTEst(){
        phoneBook.add("Andy", "610 - 277 - 1326");
        String expected = "Andy";
        String actual = phoneBook.reverseLookUp("610 - 277 - 1326");
        Assert.assertEquals("I expect for the name to return", expected, actual);
    }
    @Test
    public void addToExistingContactTest(){
       phoneBook.add("Andy", "610-277-1326");
       phoneBook.add("Andy", "215-612-1333");
       assertEquals("I expect this to return the # of numbers with key Andy",2, phoneBook.get("Andy").size());

    }
    @Test
    public void deleteSingleNumberTest(){
        phoneBook.add("Andy", "610-277-1326");
        phoneBook.add("Andy", "215-612-1333");
        phoneBook.removeASingleNumber("215-612-1333");
        assertEquals("I expect this to remove one of my phone numbers",1, phoneBook.get("Andy").size());

    }





}