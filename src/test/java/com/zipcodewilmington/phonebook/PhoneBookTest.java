package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    private PhoneBook myPhoneBook;
    private String name;
    private String number;
    private Person somePerson;

    private TreeMap<String, Person> myPhoneBookEntries;

    @Before
    public void setUp() throws Exception {
        name = "bob";
        number = "1000";
        myPhoneBookEntries = new TreeMap<>();
        myPhoneBook = new PhoneBook(myPhoneBookEntries);

    }

    @Test
    public void testAdd() {

        Assert.assertEquals(true, myPhoneBook.add(name, number));
    }


    @Test
    public void testlookUpPhoneNumber() {

    }

    @Test
    public void testlookUpName() {
    }

    @Test
    public void testGetlistAllNames() {

    }

    @Test
    public void testGetlListAllPhonebook() {

    }
}
