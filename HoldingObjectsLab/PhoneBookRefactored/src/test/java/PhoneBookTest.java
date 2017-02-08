import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;



public class PhoneBookTest {
    PhoneBook phoneBook;
    @Before
    public void setUp(){phoneBook= new PhoneBook();}
    @Test
    public void addEntriesTest() {
        phoneBook.addEntries("John", "215-676-7755");
        Entry actual = phoneBook.entries.get("John");
        Entry expected = phoneBook.entries.get("John");
        assertEquals(actual, expected);
    }
    @Test
    public void lookUpTest(){
        phoneBook.addEntries("John", "215-676-7755");
        Entry derp = phoneBook.entries.get("John");
        String expected = derp.getNumbers();
        String actual = phoneBook.lookUp("John");
        assertEquals(actual, expected);
    }
    @Test
    public  void reverseLookUp() {
        phoneBook.addEntries("Derp", "215-555-7755");
        phoneBook.addEntries("John", "215-676-7755");
        String actual = phoneBook.reverseLookUp("215-676-7755");
        String expected = "John";
        assertEquals(expected, actual);
    }
    @Test
    public void printAllTest(){
            phoneBook.addEntries("Derp", "215-555-7755");
            phoneBook.addEntries("John", "215-676-7755");
            phoneBook.addEntries("Derp", "215-555-7744");
            phoneBook.addEntries("John", "215-676-7766");
            phoneBook.addEntries("John", "215-676-1466");
            phoneBook.printEntries();

        }

    }



