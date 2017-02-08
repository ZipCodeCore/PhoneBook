package armstrong.alexandra;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PhoneBookTest{

    PhoneBook phoneBook;

    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
        phoneBook.add("Name", "Number");
        phoneBook.add("Name2", "Number");
    }

    @Test
    public void lookUpTest(){
        String expected = "Number";
        String actual = phoneBook.lookUp("Name");
        assertEquals(expected, actual);
    }

    @Test
    public void addTest(){
        phoneBook.add("Name3", "Number");
        int expected = 3;
        int actual = phoneBook.size();
        assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        phoneBook.remove("Name2");
        int expected = 1;
        int actual = phoneBook.size();
        assertEquals(expected, actual);
    }
}