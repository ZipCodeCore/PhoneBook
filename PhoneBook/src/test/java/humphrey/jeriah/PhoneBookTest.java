package humphrey.jeriah;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jeriahhumphrey on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook newBook;
    @Before
    public void setUp() {
        newBook = new PhoneBook();

    }
    @Test
    public void addIncreasesSizeTest(){
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        int expected=2;
        int actual = newBook.getMap().size();
        assertEquals(expected, actual);

    }
    @Test
    public void addTestContainsKey(){
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        assertTrue(newBook.getMap().containsKey("Mike"));
    }

    @Test
    public void addTestDoesnotContainNonexistantKey(){
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        assertFalse(newBook.getMap().containsKey("Ron"));
    }

    @Test
    public void lookUpTest(){
        newBook.addEntry("Don", "098-765-4321");
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        assertEquals("123-455-7266", newBook.lookUp("Mike"));
    }

    @Test
    public void lookUpNonexistantKeyTest(){
        newBook.addEntry("Don", "098-765-4321");
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        assertEquals(null, newBook.lookUp("Jim"));
    }



    @Test
    public void removeTest(){
        newBook.addEntry("Don", "098-765-4321");
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        newBook.remove("John");
        assertFalse(newBook.getMap().containsKey("John"));

    }


    @Test
    public void listNamesTest(){
        newBook.addEntry("Don", "098-765-4321");
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        String expected= "Name: Don, Name: John, Name: Mike, ";
        String actual= newBook.listNames();
        assertEquals(expected, actual);
    }
    @Test
    public void listEntriesTest(){
        newBook.addEntry("Don", "098-765-4321");
        newBook.addEntry("John", "123-456-7890");
        newBook.addEntry("Mike", "123-455-7266");
        String expected= "Name: Don - Number: 098-765-4321| Name: John - Number: 123-456-7890| Name: " +
                "Mike - Number: 123-455-7266| ";
        String actual= newBook.listEntries();
        assertEquals(expected, actual);
    }


}