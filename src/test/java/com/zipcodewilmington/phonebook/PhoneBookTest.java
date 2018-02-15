package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


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
    public void addContactTest(){
        phoneBook.addContact("Genya", "6578356767");
        boolean genyaIsInPhoneBook = phoneBook.getContactsList().keySet().contains("Genya");
        Assert.assertTrue(genyaIsInPhoneBook);

    }
    @Test
    public void removeContactTest(){
        phoneBook.removeContact("Pete Jones");
        boolean peteJonesHasBeenRemoved = !phoneBook.getContactsList().containsKey("Pete Jones");
        Assert.assertTrue(peteJonesHasBeenRemoved);
    }

    @Test
    public void listAllNamesAndNumbersTest(){
        phoneBook.listAllNamesAndNumbers();
        String expected = new String();
        Set<Map.Entry<String, ArrayList>> actual = phoneBook.getContactsList().entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest(){
        phoneBook.reverseLookUp();
        String expected = new String();
        Set<Map.Entry<String, ArrayList>> actual = phoneBook.getContactsList().entrySet();
        Assert.assertEquals(expected, actual);

    }

}


