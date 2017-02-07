package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook phoneBook;

    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
        phoneBook.addEntry("Hank", "123-456-7890");

    }
    @Test
    public void lookup() {
        String expected = "123-456-7890";
        String actual = phoneBook.lookup("Hank");
        assertEquals(expected,actual);
    }

    @Test
    public void addEntry() {
        phoneBook.addEntry("Suzy", "444-444-4444");
        String expected = "444-444-4444";
        String actual = phoneBook.lookup("Suzy");
        assertEquals(expected,actual);
    }

    @Test
    public void deleteEntry() {
        phoneBook.deleteEntry("Hank");
        String expected = null;
        String actual = phoneBook.lookup("Hank");
        assertEquals(expected,actual);
    }

    @Test
    public void getAllNames()  {
        phoneBook.addEntry("Suzy", "444-444-4444");
        String actual = phoneBook.getAllNames();
        String expected = "[Hank=123-456-7890, Suzy=444-444-4444]";
        assertEquals(expected,actual);
    }

}