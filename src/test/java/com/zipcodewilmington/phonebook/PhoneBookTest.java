package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {
    PhoneBook testBook;

    @Before
    public void setup() {

        testBook = new PhoneBook();
    }


    @Test
    public void addMultipleNumbers() {
        testBook.add("George", "142.678.4932");
        testBook.add("Sonny", "142.645.7940");
        testBook.add("Bridget", "104.674.2432");
        testBook.add("Sam", "309.879.5748");
        testBook.nameNumberBook.get("George").addNumbers("111.111.1111");
        testBook.nameNumberBook.get("George").addNumbers("222.222.2222");
        String actual = testBook.listPhoneBook();
        String expected = "Bridget: [104.674.2432]\nGeorge: [142.678.4932, 111.111.1111, 222.222.2222]\nSam: [309.879.5748]\nSonny: [142.645.7940]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest() {
        new Person("George", "156.476.67896");
        testBook.add("Keith", "396.322.7899");
        String testNumber = testBook.lookup("Keith");
        Assert.assertTrue(testNumber.equals("[396.322.7899]"));
    }


    @Test
    public void addTest2() {
        new Person("Billy", "396.216.8908");
        testBook.add("Ralf", "254.678.9876");
        String testNumber = testBook.lookup("Ralf");
        Assert.assertTrue(testNumber.equals("[254.678.9876]"));

    }

    @Test
    public void lookUpTest() {
        testBook.add("Pete", "153.678.3345");
        String testNumber = testBook.lookup("Pete");
        Assert.assertFalse(testNumber.equals("153.678.3345"));
    }


    @Test
    public void lookUpTest2() {
        testBook.add("George", "1234567890");
        String testNumber = testBook.lookup("George");
        Assert.assertFalse(testNumber.equals("1234567891"));
    }

    @Test
    public void removeTest1() {
        testBook.add("Bob", "938.204.7890");
        testBook.add("Thomas", "366.765.4678");
        testBook.removeRecord("Bob");
        String testNumber = testBook.lookup("Thomas");
        Assert.assertNotEquals(null, testNumber);
    }

    @Test
    public void removeTest2() {
        testBook.add("Alex", "887.875.3456");
        testBook.add("Junior", "869.456.3215");
        testBook.removeRecord("Alex");
        String testNumber = testBook.lookup("Junior");
        Assert.assertNotEquals(null, testNumber);
    }

    @Test
    public void removeEachNumberTest(){
        testBook.add("Arnold", "842.378.3098");
        testBook.add("Alex", "584.965.0934");
        testBook.nameNumberBook.get("Alex").addNumbers("496.304.2467");
        testBook.nameNumberBook.get("Alex").addNumbers("496.246.0987");
        String actual = testBook.listPhoneBook();
        String expected = "Alex: [584.965.0934, 496.304.2467, 496.246.0987]\nArnold: [842.378.3098]\n";
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void listPhonebookTest() {
        testBook.add("Brad","609.489.2345");
        String actual = testBook.listPhoneBook();
        String expected = "Brad: [609.489.2345]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listPhonebookTest2() {
        //testBook.add("George", "123.456.7890");
        testBook.add("Brad", "609.489.2345");
        testBook.add("Pitt", "609.356.1865");
        String actual = testBook.listPhoneBook();
        String expected = "Jeff: [609.489.2345]\nPitt: [609.356.1865]\n";
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void listNamesTest() {
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
        testBook.add("George", "123.456.7890");
        String testNumber = testBook.reverseLookup("123.456.7891");
        Assert.assertFalse(testNumber.equals("George"));
    }

    @Test
    public void reverseLookupTest2() {
        testBook.add("Zeke", "146.346.7345");
        String testNumber = testBook.reverseLookup("146.346.7345");
        Assert.assertTrue(testNumber.equals("Zeke"));
    }









}
