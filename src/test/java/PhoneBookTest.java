import reynoldsgillian.titko.AssertionError;
import reynoldsgillian.titko.InvalidNumberFormatException;
import reynoldsgillian.titko.PhoneBook;
import org.junit.Before;
import org.junit.Test;
import reynoldsgillian.titko.RecordNotPresentException;

import java.util.Stack;

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
    public void lookupTest() throws InvalidNumberFormatException, RecordNotPresentException, AssertionError {
        phoneBook.add("Jane Doe", "(123)456-7890");
        String expected = "[(123)456-7890]";
        String actual = phoneBook.lookup("Jane Doe");
        assertEquals("Expected a phone number string", expected, actual);
    }

    @Test(expected = RecordNotPresentException.class) //expect an error
    public void lookupNonExistingKeyTest() throws InvalidNumberFormatException, RecordNotPresentException, AssertionError { //lookup non-existing value
        phoneBook.add("John Doe", "(123)456-7890");
        phoneBook.reverseLookup("(123)465-7980");
        //assertNull(null);
    }

    //http://stackoverflow.com/questions/1836364/bad-form-for-junit-test-to-throw-exception
    @Test //expect no errors from this test
    public void addTest() throws InvalidNumberFormatException, AssertionError {
    //Test if we add an item to the phonebook - look at its size
        phoneBook.add("Tom Dunn", "(123)456-9087"); //use the method to add another item
        //phoneBook.containsKey("Tom Dunn"); //could also check for the key
        int expected = 1;
        int actual = phoneBook.size();
        assertEquals("Expected 1 item", expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void addSameKeyTest() throws AssertionError, InvalidNumberFormatException {
        phoneBook.add("Tom Dunn", "(123)457-9087"); //use the method to add another item
        phoneBook.add("Tom Dunn", "(123)457-9087"); //use the method to add duplicate item
    }

    @Test
    public void addMultipleKeysTest() throws InvalidNumberFormatException, AssertionError {
        phoneBook.add("Tom Dunn", "(123)456-9087"); //use the method to add another item
        phoneBook.add("Dick Dunn", "(123)459-9087"); //use the method to add duplicate item
        phoneBook.add("Harry Dunn", "(123)452-9087"); //use the method to add duplicate item
        int expected = 3; //have two items already
        int actual = phoneBook.size();
        assertEquals("Expected 3 items", expected, actual);
    }

    @Test(expected = InvalidNumberFormatException.class) //expect exception to be thrown from this test
    public void addInvalidKeyTest() throws InvalidNumberFormatException, AssertionError {
        phoneBook.add("Tom", "(12)45-9087");
    }

    @Test
    public void removeLastItemTest() throws InvalidNumberFormatException, AssertionError {
    //Test if we remove items from the list
        phoneBook.add("Jane Doe", "(321)123-8796");
        int expected = 0;
        phoneBook.remove("Jane Doe");
        //assertNull(null);
    }

    @Test(expected = RecordNotPresentException.class)
    public void removeFromEmptyPhonebookTest(){ //remove from empty phonebook
        //Test if we remove items from the list
        phoneBook.remove("Jane Doe");
    }


    @Test //no error expected
    public void reverseLookupTest() throws InvalidNumberFormatException, RecordNotPresentException, AssertionError {
        phoneBook.add("Jane Doe", "(321)123-7999");
        String expected = "Jane Doe";
        String actual = phoneBook.reverseLookup("(321)123-7999");
        assertEquals("Expected a phone number", expected, actual);
    }

    @Test(expected = RecordNotPresentException.class) //error expected
    public void badReverseLookupTest() throws InvalidNumberFormatException, RecordNotPresentException, AssertionError {
        phoneBook.add("Jane Doe", "(321)123-7999");
        String actual = phoneBook.reverseLookup("(321)123-7099");
    }

    @Test
    public void removeSingleNumberTest() throws InvalidNumberFormatException, RecordNotPresentException, AssertionError {
        phoneBook.add("Jane Doe", "(321)123-7999");
        phoneBook.add("Jane Doe", "(321)123-7897");
        phoneBook.removeSingleNumber("(321)123-7897");
        int actual = this.phoneBook.get("Jane Doe").size();
        int expected = 1;
        assertEquals("Expected to get 1", expected, actual);
    }

    @Test(expected = Exception.class) //error expected
    public void badRemoveSingleNumberTest() throws InvalidNumberFormatException, RecordNotPresentException, AssertionError {
        phoneBook.add("Jane Doe", "(321)123-7999");
        phoneBook.add("Jane Doe", "(321)123-7897");
        phoneBook.add("Jim Doe", "(321)123-1457");
        phoneBook.removeSingleNumber("(321)123-7890");
    }

}
