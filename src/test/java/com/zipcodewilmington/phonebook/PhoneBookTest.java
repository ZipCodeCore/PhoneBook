package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addTest1() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Vince", "555.867.5309");
        String testNumber = testPhoneBook.lookup("Vince");
        Assert.assertTrue(testNumber.equals("555.867.5309"));
    }

    @Test
    public void addTest2() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Tom", "555.767.9898");
        String testNumber = testPhoneBook.lookup("Tom");
        Assert.assertFalse(testNumber.equals("555.867.5309"));
    }




    @Test
    public void removeTest() {
        PhoneBook testPhoneBook = new PhoneBook();




    }


    @Test
    public void lookupTest1() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Vince", "555.867.5309");
        String testNumber = testPhoneBook.lookup("Vince");
        Assert.assertTrue(testNumber.equals("555.867.5309"));
    }

    @Test
    public void lookupTest2() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Marky", "555.867.5309");
        String testNumber = testPhoneBook.lookup("Marky");
        Assert.assertFalse(testNumber.equals("555.867.1234"));
    }




    @Test
    public void listNamesTest() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        testPhoneBook.listNames();

    }


    @Test
    public void listNamesAndNumbersTest() {

        PhoneBook testPhoneBook = new PhoneBook();

    }


}
