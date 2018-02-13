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


}


