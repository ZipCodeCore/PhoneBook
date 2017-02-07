package jackson.rick;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rickjackson on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook phoneBook;
    
    @Before
    public void setUp() {
        this.phoneBook = new PhoneBook();
        this.phoneBook.phoneNumbers.put("First Person", "302-555-0001");
        this.phoneBook.phoneNumbers.put("Second Person", "302-555-0002");
        this.phoneBook.phoneNumbers.put("Third Person", "302-555-0003");
    }
    
    @Test
    public void lookupTest() {
        String expected = "302-555-0001";
        String actual = this.phoneBook.lookup("First Person");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
    
    @Test
    public void reverseLookupTest() {
        String expected = "First Person";
        String actual = this.phoneBook.reverseLookup("302-555-0001");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                     expected, actual);
    }
}