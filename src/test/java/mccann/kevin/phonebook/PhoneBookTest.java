package mccann.kevin.phonebook;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/7/17.
 */
public class PhoneBookTest {

    PhoneBook phoneBook;

    @Before
    public void setUp() throws Exception{
        phoneBook = new PhoneBook();
        phoneBook.add("John", "(555) 555-5555");
        phoneBook.add("John", "(555) 555-5566");
        phoneBook.add("Sally", "(555) 555-4444");
    }

    @Test
    public void lookupTest() throws Exception{
        String expected = "[(555)-555-5555, (555)-555-5566]";
        String actual = phoneBook.lookup("John").toString();
        assertEquals("All 5's expected!",expected,actual);
    }

    @Test
    public void reverseLookupTest() throws Exception{
        String expected = "John";
        String actual = phoneBook.reverseLookup("(555)-555-5555");
        assertEquals("John expected", expected, actual);
    }

    @Test
    public void addEntryTest() throws Exception{
        String expected = "[(555)-444-4444]";
        phoneBook.add("Geoff","(555)-444-4444");
        String actual = phoneBook.lookup("Geoff").toString();
        assertEquals("444-4444 expected",expected,actual);
    }

    @Test
    public void removeEntryTest() throws Exception {
        phoneBook.removeEntry("Sally");
        assertEquals("Name not in address book", "Name not in address book!", phoneBook.lookup("Sally"));
    }

    @Test
    public void listAllNamesTest() {
        String expected = "[John, Sally]";
        String actual = phoneBook.listAllNames().toString();
        assertEquals("John Sally expected",expected,actual);
    }

    @Test
    public void listAllEntriesTest() {
        String expected = "[John=[(555)-555-5555, (555)-555-5566], Sally=[(555)-555-4444]]";
        String actual = phoneBook.listAllEntries().toString();
        assertEquals("John 555-5555 Sally 555-4444 expected",expected,actual);
    }

}