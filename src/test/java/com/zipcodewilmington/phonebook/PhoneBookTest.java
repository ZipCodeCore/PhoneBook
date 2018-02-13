package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;
/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {

    PhoneBook testbook;
    @Before
    public void setUp(){
        testbook = new PhoneBook();
    }

    @Test
    public void testPhoneBookAddName() {
        // Given
        PhoneBook testbook = new PhoneBook();
       testbook.add("Keith", "555-666-7777");

      String testNumber = testbook.lookup("Keith");
      Assert.assertTrue(testNumber.equals("555-666-7777"));

    }
@Test
    public void testPhoneBookDelete(){
        PhoneBook testbook = new PhoneBook();
        testbook.add("Keith", "555-666-7777");
        testbook.deleter("Keith");
        String testnumber = testbook.lookup("Keith");
        Assert.assertEquals(null, testnumber);
    }
@Test
    public void testPhoneBookLookUp(){
        PhoneBook testbook = new PhoneBook();
        testbook.add("Keith", "555-666-7777");
        String testnumber = testbook.lookup("Keith");
        Assert.assertEquals("555-666-7777", testnumber);
    }

    @Test
    public void testPhoneBookList(){

        PhoneBook testbook = new PhoneBook();
        testbook.add("Keith", "555-666-7777");
        testbook.add("John", "555-612-7777");
        testbook.add("Mike", "555-623-7777");
        testbook.add("Steve", "555-645-7777");

        String expected = "John 555-612-7777\n" +
                "Keith 555-666-7777\n" +
                "Mike 555-623-7777\n" +
                "Steve 555-645-7777\n";
        String actual = testbook.listNamesAndNumbers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPhoneBookNames(){

        PhoneBook testbook = new PhoneBook();
        testbook.add("Keith", "555-666-7777");
        testbook.add("John", "555-612-7777");
        testbook.add("Mike", "555-623-7777");
        testbook.add("Steve", "555-645-7777");

        String expected = "John\n" +
                "Keith\n" +
                "Mike\n" +
                "Steve\n";
        String actual = testbook.listNames();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testPhoneBookReverseLookUp() {
        PhoneBook testbook = new PhoneBook();
        testbook.add("Keith", "555-666-7777");
        testbook.add("John", "555-612-7777");
        testbook.add("Mike", "555-623-7777");
        testbook.add("Steve", "555-645-7777");
        String testnumber = testbook.reverselookup("555-666-7777");
        Assert.assertEquals("Keith", testnumber);
    }
}
