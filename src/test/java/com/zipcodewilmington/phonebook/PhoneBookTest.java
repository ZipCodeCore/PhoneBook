package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneBookTest {

    private static PhoneBook phoneBookTest;

    @Before
    public void createPhoneBook() {
        this.phoneBookTest = new PhoneBook();
    }

    @Test
    public void testAddEntry() {
        String name = "Person 1";
        String number = "1234567";
        phoneBookTest.addEntry(name, number);
        String expected = number;
        String actual = phoneBookTest.lookUp(name);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAddEntry2() {
        String name = "Person 2";
        String number = "87654321";
        phoneBookTest.addEntry(name, number);
        String expected = number;
        String actual = phoneBookTest.lookUp(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeEntryTest() {
        String name = "Person 1";
        String number = "8942418";
        phoneBookTest.removeEntry(name);
        String expected = null;
        String actual = phoneBookTest.lookUp(name);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeEntryTest2() {
        String name = "Person 2";
        String number = "12387874";
        phoneBookTest.removeEntry(name);
        String expected = null;
        String actual = phoneBookTest.lookUp(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNamesTest() {
        String name = "Person 1";
        String number = "1234567";
        phoneBookTest.addEntry(name, number);
        String name2 = "Person 2";
        String number2 = "2345678";
        phoneBookTest.addEntry(name2, number2);
        String name3 = "Person 3";
        String number3 = "34567898";
        phoneBookTest.addEntry(name3, number3);
        String expected = "[Person 1, Person 2, Person 3]";
        String actual = phoneBookTest.listNames();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void listAllTest() {
        String name = "Person 1";
        String number = "1234567";
        phoneBookTest.addEntry(name, number);
        String name2 = "Person 2";
        String number2 = "2345678";
        phoneBookTest.addEntry(name2, number2);
        String name3 = "Person 3";
        String number3 = "34567898";
        phoneBookTest.addEntry(name3, number3);
        String expected = "Person 11234567\nPerson 22345678\nPerson 334567898\n";
        String actual = phoneBookTest.listAll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest() {
        String name = "Person 1";
        String number = "1234567";
        phoneBookTest.addEntry(name, number);
        String expected = "Person 1";
        String actual = phoneBookTest.reverseLookUp(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest2() {
        String name = null;
        String number = null;
        String expected = "That number is not in the phone book";
        String actual = phoneBookTest.reverseLookUp(number);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeOneNumberTest() {
        String name = "Brian";

    }
}
