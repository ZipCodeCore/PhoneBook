package Kim.Andy;

import java.util.TreeMap;

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
        String expected = "610 - 277 - 1326";
        String actual = phoneBook.lookUp("Andy");
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
    public void removeTest(){
        phoneBook.add("Andy", "610 - 277 - 1326");
        phoneBook.remove("Andy");
        int expected = 0;
        int actual = phoneBook.size();
        Assert.assertEquals("I expect my phonebook to be empty",expected, actual);
    }




}