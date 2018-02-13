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
        testBook.add("George", "1234567890");
        testBook.add("Brad", "609.489.2345");
        testBook.remove("Brad");
        String testNumber = testBook.lookup("George");
        Assert.assertNotEquals(null, testNumber);
    }


    @Test
    public void listPhonebookTest() {
        PhoneBook testBook = new PhoneBook();
        //testBook.add("George", "123.456.7890");
        testBook.add("Brad", "609.489.2345");
        String actual = testBook.listPhoneBook();
        String expected = "Brad      609.489.2345\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listPhonebookTest2() {
        PhoneBook testBook = new PhoneBook();
        //testBook.add("George", "123.456.7890");
        testBook.add("Brad", "609.489.2345");
        testBook.add("Pitt", "609.356.1865");
        String actual = testBook.listPhoneBook();
        String expected = "Jeff      609.489.2345\nPitt      609.356.1865\n";
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void listNamesTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "123.456.7890");
        testBook.add("Pete", "839.302.8594");
        testBook.add("Alex", "395.823.0987");
        testBook.add("Vincent", "973.920.8132");
        String actual = testBook.listNames();
        String expected = "Alex\nGeorge\nPete\nVincent\n";
        Assert.assertEquals(expected, actual);
        }

    @Test
    public void reverseLookupTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "123.456.7890");
        String testNumber = testBook.reverseLookup("123.456.7891");
        Assert.assertFalse(testNumber.equals("George"));
    }

    @Test
    public void reverseLookupTest2() {
        PhoneBook testBook = new PhoneBook();
        testBook.add("Zeke", "146.346.7345");
        String testNumber = testBook.reverseLookup("146.346.7345");
        Assert.assertTrue(testNumber.equals("Zeke"));
    }





    /*
    @Test
    public void testNightsOfSleep() {
        PhoneBook testBook = new PhoneBook();
        String expected = "none";
        person.setNightsOfSleep(expected);
        String actual = person.getNightsOfSleep();
        Assert.assertEquals(expected, actual);
    }
    */



}
