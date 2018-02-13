package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {

    @Test
    public void addTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "1234567890");
        String testNumber = testBook.lookup("George");
        Assert.assertTrue(testNumber.equals("1234567890"));
    }

    @Test
    public void addTest2() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "1234567890");
        String testNumber = testBook.lookup("George");
        Assert.assertFalse(testNumber.equals("1234567891"));
    }

    @Test
    public void lookUpTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "1234567890");
        String testNumber = testBook.lookup("George");
        Assert.assertTrue(testNumber.equals("1234567890"));
    }

    @Test
    public void lookUpTest2() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "1234567890");
        String testNumber = testBook.lookup("George");
        Assert.assertFalse(testNumber.equals("1234567891"));
    }

    @Test
    public void removeTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.remove("Billy");
        String testNumber = testBook.lookup("Billy");
        Assert.assertEquals(null, testNumber);
    }

    @Test
    public void removeTest2() {
        PhoneBook testBook = new PhoneBook();
        testBook.remove("George");
        String testNumber = testBook.lookup("George");
        Assert.assertEquals(null, testNumber);
    }

    /*@Test
    public void listNamesTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "123.456.7890");
        testBook.add("George", "123.456.7890");
        String testNumber = testBook.lookup("George         123.456.7890" + "\n");
        Assert.assertTrue(testNumber.equals("1234567890"));
    }
    */



}
