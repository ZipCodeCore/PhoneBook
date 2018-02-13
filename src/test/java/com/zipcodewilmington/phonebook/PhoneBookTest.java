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
        testPhoneBook.add("Marky", "123.321.9999");
        testPhoneBook.add("Ricky", "999.543.1234");
        testPhoneBook.remove("Marky");
        String testNumber = testPhoneBook.lookup("Ricky");
        Assert.assertNotEquals(null, testNumber);

    }

    @Test
    public void removeTest2() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Marky", "123.321.9999");
        testPhoneBook.add("Ricky", "999.543.1234");
        testPhoneBook.remove("Ricky");
        String testNumber = testPhoneBook.lookup("Ricky");
        Assert.assertEquals(null, testNumber);

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
    public void listNamesTest1() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNames();
        String expected = "Danny\nMarky\nRicky\nTerri\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNamesTest2() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNames();
        String expected = "Danny\nMarky\nGood Will\nTerri\n";
        Assert.assertNotEquals(expected, actual);
    }


    @Test
    public void listNamesAndNumbersTest1() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNamesAndNumbers();
        String expected = "Danny: 888.546.9087\nMarky: 888.546.9876\nRicky: 888.555.3376\nTerri: 888.123.7862\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNamesAndNumbersTest2() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNamesAndNumbers();
        String expected = "Joey: 888.546.9087\nRobby: 888.546.9876\nJohnny: 888.555.3376\nBrian: 888.123.7862\n";
        Assert.assertNotEquals(expected, actual);
    }

}
