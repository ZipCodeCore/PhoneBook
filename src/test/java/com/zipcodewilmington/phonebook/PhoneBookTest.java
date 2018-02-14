package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    PhoneBook phoneBook;

    @Before
    public void setUp() {
        phoneBook = new PhoneBook();
        phoneBook.addEntryToPhoneBook("Eric", "3021234567");
        phoneBook.addEntryToPhoneBook("Bob", "3029999999");
    }

    @Test
    public void testAddPhoneBookEntryToPhoneBook() {
        String phoneNumber = "3025551111";
        phoneBook.addEntryToPhoneBook("eric", phoneNumber);
        String actual = phoneBook.lookUp("eric");
        Assert.assertEquals(phoneNumber, actual);
    }

    @Test
    public void testRemoveEntryFromPhoneBook() {
        String phoneNumber = "3025551111";
        String name = "eric";
        phoneBook.addEntryToPhoneBook(name, phoneNumber);
        phoneBook.removeEntryFromPhoneBook("eric", phoneNumber);

        String actual = phoneBook.lookUp("eric");
        Assert.assertEquals(null, actual);
    }

    @Test
    public void testListNames() {
        String expected = "Bob\n" +
                "Eric\n";
        String actual = phoneBook.listNames();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListNumber() {


        String expected = "3029999999\n" +
                "3021234567\n";
        String actual = phoneBook.listNumbers();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEntryListAll() {


        String expected = "Bob : 3029999999\n" +
                "Eric : 3021234567\n";
        String actual = phoneBook.entryListAll();

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void testReverseLookup() {
        String expected = "Bob";

        String actual = phoneBook.reverseLookup("3029999999");
        Assert.assertEquals(expected,actual);
    }

}
