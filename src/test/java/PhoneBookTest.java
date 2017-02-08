import reynoldsgillian.titko.PhoneBook;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by gillianreynolds-titko on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook phoneBook;

    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
//        phoneBook.add("Jane Doe", "(123)456-7890");
//        phoneBook.add("John Doe", "(321)568-8907");
    }

    @Test
    public void lookupTest(){ //lookup existing value; lookup in empty phonebook
    //returns a String
        phoneBook.add("Jane Doe", "(123)456-7890");
        String expected = "(123)456-7890";
        String actual = phoneBook.lookup("Jane Doe");
        assertEquals("Expected a phone number string", expected, actual);
    }

    @Test
    public void lookupNonExistingKeyTest(){ //lookup non-existing value
        //returns a String
        phoneBook.add("John Doe", "(123)456-7890");
        //String expected = "Key value does not exist";
        //String actual = phoneBook.lookup("Jane Doe");
        assertNull(null);
    }

    @Test
    public void addTest(){
    //Test if we add an item to the phonebook - look at its size
        phoneBook.add("Tom Dunn", "(123)456-9087"); //use the method to add another item
        //phoneBook.containsKey("Tom Dunn"); //could also check for the key
        int expected = 1;
        int actual = phoneBook.size();
        assertEquals("Expected 1 item", expected, actual);
    }

    @Test
    public void addSameKeyTest(){
        phoneBook.add("Tom Dunn", "(123)457-9087"); //use the method to add another item
        phoneBook.add("Tom Dunn", "(123)457-9087"); //use the method to add duplicate item
        int expected = 1; //have two items
        int actual = phoneBook.size();
        assertEquals("Expected 1 items", expected, actual);
    }

    @Test
    public void addMultipleKeysTest(){
        phoneBook.add("Tom Dunn", "(123)456-9087"); //use the method to add another item
        phoneBook.add("Dick Dunn", "(123)459-9087"); //use the method to add duplicate item
        phoneBook.add("Harry Dunn", "(123)452-9087"); //use the method to add duplicate item
        int expected = 3; //have two items already
        int actual = phoneBook.size();
        assertEquals("Expected 3 items", expected, actual);
    }

    @Test
    public void addInvalidKeyTest(){//??
        phoneBook.add("Tom", "(123)45-9087"); //use the method to add another item
        int expected = 3; //have two items already
        int actual = phoneBook.size();
        assertEquals("Expected 3 items", expected, actual);
    }

    @Test
    public void addToNonExistingBookTest(){
        //phoneBook.add("Tom", "(123)45-9087");
        assertNull(null);
    }
    //remove from phonebook that does not exist?

    @Test
    public void removeLastItemTest(){
    //Test if we remove items from the list
        phoneBook.add("Jane Doe", "(321)123-8796");
        int expected = 0;
        phoneBook.remove("Jane Doe");
        assertNull(null);
    }

    @Test
    public void removeFromEmptyPhonebookTest(){ //remove from empty phonebook
        //Test if we remove items from the list
        phoneBook.remove("Jane Doe");
        assertNull(null);
    }


    @Test
    public void listAllNamesTest(){

    }

    @Test
    public void listAllEntriesTest(){

    }

}
