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
    public void setUp(){
        phoneBook = new PhoneBook();

    }
    @Test
    public void testAddContact(){
        phoneBook.addContact("Genya", "6578356767");
        boolean genyaIsInPhoneBook = phoneBook.getContactsList().keySet().contains("Genya");
        Assert.assertTrue(genyaIsInPhoneBook);

    }
    @Test
    public void testRemoveContact(){
        phoneBook.removeContact("Pete Jones");
        boolean peteJonesHasBeenRemoved = !phoneBook.getContactsList().containsKey("Pete Jones");
        Assert.assertTrue(peteJonesHasBeenRemoved);
    }
    @Test
    public void testLookUpContactByName(){
        phoneBook.lookUpContactByName("Nala Bits");
        String expected = "2345578122";
        String actual = phoneBook.getContactsList().get("Nala Bits");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testListAllByName(){
        phoneBook.listAllByName(phoneBook.getContactsList().keySet().toString());
        String expected = ;
        String actual = phoneBook.getContactsList().keySet().toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListAllNamesAndNumbers(){
        phoneBook.listAllNamesAndNumber();
        String expected = ;
        String actual = phoneBook.getContactsList().entrySet();
        Assert.assertEquals(expected, actual);
    }
}

