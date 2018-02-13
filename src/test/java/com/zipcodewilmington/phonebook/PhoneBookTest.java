package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {


    @Test
    public void addTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Luke", "6109998787");
        String testNumber = testBook.stringLookup("Luke");
        Assert.assertTrue(testNumber.equals("6109998787"));

    }

    @Test
    public void addTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        String testNumber = testBook.stringLookup("Kate");
        Assert.assertTrue(testNumber.equals("4846569090"));

    }

    @Test
    public void removeTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        testBook.remove("Kate");
        String testNumber = testBook.stringLookup("Kate");
        Assert.assertEquals(null, testNumber);


    }

    @Test
    public void stringLookupTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        String testNumber = testBook.stringLookup("Kate");
        Assert.assertFalse(testNumber.equals("4846587091"));

    }

    @Test
    public void stringLookupTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        String testNumber = testBook.stringLookup("Kate");
        Assert.assertTrue(testNumber.equals("4846569090"));

    }

    @Test
    public void listNamesTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        testBook.addEntry("Adam", "4864569090");
        testBook.addEntry("Zeke", "4787869090");
        String actual = testBook.listNames();
        String expected = "Adam\nKate\nZeke\n";
        Assert.assertEquals(actual, expected);


    }

    @Test
    public void listPhonebookTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        testBook.addEntry("Adam", "4864569090");
        testBook.addEntry("Zeke", "4787869090");
        String actual = testBook.listPhoneBook();
        String expected = "Adam = 4864569090\nKate = 4846569090\nZeke = 4787869090\n";
        Assert.assertEquals(actual, expected);


    }
    @Test
    public void ReverseLookupTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        String testNumber = testBook.reverseLookup("4846569090");
        Assert.assertTrue(testNumber.equals("Kate"));

    }

}
