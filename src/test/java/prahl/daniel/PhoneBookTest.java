package prahl.daniel;

import org.junit.*;

/**
 * Created by danielprahl on 5/16/17.
 */

public class PhoneBookTest {

    @Test
    public void lookupTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        String expected = "(302)-555-5555";
        phoneBook.addEntry("test", "(302)-555-5555");

        //when;
        String actual = phoneBook.lookup("test");

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addEntryTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        String expected = "(302)-555-5555";

        //when;
        phoneBook.addEntry("test", "(302)-555-5555");
        String actual = phoneBook.lookup("test");

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeEntryTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("test", "(302)-555-5555");
        String expected = null;

        //when;
        phoneBook.removeEntry("test");
        String actual = phoneBook.lookup("test");

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listAllNamesTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("test1", "(302)-555-5555");
        phoneBook.addEntry("test2", "(302)-666-6666");
        int expected = 2;

        //when;
        int actual = phoneBook.listAllNames().length;

        //then;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listAllEntriesTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("test1", "(302)-555-5555");
        phoneBook.addEntry("test2", "(302)-666-6666");
        phoneBook.addEntry("test3", "(302)-777-7777");
        int expected = 6;

        //when;
        String[] entries = phoneBook.listAllEntries();
        int actual = entries.length;

        //then;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void reverseLookupTest(){
        //given;
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("test", "(302)-555-5555");
        String expected = "test";

        //when;
        String actual = phoneBook.reverseLookup("(302)-555-5555");

        //then;
        Assert.assertEquals(expected, actual);
    }

}
