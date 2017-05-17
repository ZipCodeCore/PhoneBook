package prahl.daniel;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielprahl on 5/16/17.
 */

public class PhoneBookTest {

    @Test
    public void lookupTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        String expected = "(302)-555-5555";
        phoneBook.addEntry("Alex", "(302)-555-5555");

        //when;
        List<String> numbers = phoneBook.lookup("Alex");
        String actual = numbers.get(0);

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addEntryTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        String expected = "(302)-555-5556";

        //when;
        phoneBook.addEntry("Alex", "(302)-555-5555");
        phoneBook.addEntry("Alex", "(302)-555-5556");
        List<String> numbers = phoneBook.lookup("Alex");
        String actual = numbers.get(1);

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = NumberFormatException.class)
    public void addEntryBadFormatTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();

        //when;
        phoneBook.addEntry("Alex", "1234567890");

        //then;
    }

    @Test
    public void removeRecordTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alex", "(302)-555-5555");
        ArrayList expected = null;

        //when;
        phoneBook.removeRecord("Alex");
        List actual = phoneBook.lookup("Alex");

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNumberTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alex", "(302)-555-5555");
        phoneBook.addEntry("Alex", "(302)-555-5556");
        String expected = "(302)-555-5556";

        //when;
        phoneBook.removeNumber("Alex", "(302)-555-5555");
        List<String> numbers = phoneBook.lookup("Alex");
        String actual = numbers.get(0);

        //then;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void listAllNamesTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alex", "(302)-555-5555");
        phoneBook.addEntry("Bob", "(302)-666-6666");
        phoneBook.addEntry("Cassie", "(302)-777-7777");
        int expected = 3;

        //when;
        int actual = phoneBook.listAllNames().size();

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listAllEntriesTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alex", "(302)-555-5555");
        phoneBook.addEntry("Bob", "(302)-666-6666");
        phoneBook.addEntry("Cassie", "(302)-777-7777");
        phoneBook.addEntry("Cassie", "(302)-888-8888");
        int expected = 7;

        //when;
        List<String> entries = phoneBook.listAllEntries();
        int actual = entries.size();

        //then;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void reverseLookupTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alex", "(302)-555-5555");
        String expected = "Alex";

        //when;
        String actual = phoneBook.reverseLookup("(302)-555-5555");

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void reverseLookupBadFormatTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alex", "(302)-555-5555");

        //when;
        phoneBook.reverseLookup("alex");

        //then;

    }

}
