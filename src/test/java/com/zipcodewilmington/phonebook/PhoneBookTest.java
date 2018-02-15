package com.zipcodewilmington.phonebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */




public class PhoneBookTest {
    private static PhoneBook phoneBookTest;

     @Before
     public void setUp() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("John","1234567890");

    }

    @After
    public void tearDown() {
    }

    @Test
   public void testLookup() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("James","555555555");

        String actual = phoneBookTest.lookup("John");
        Assert.assertEquals("555555555  ",actual);
    }
    @Test
    public void testListNames(){
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("John","1234567890");
        phoneBookTest.add("James","555555555");
        String expected = "James\n" +
                            "John\n";
        String actual = phoneBookTest.listNames();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testListNumbersAndNumbers(){
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("John","1234567890");
        phoneBookTest.add("James","555555555");
        phoneBookTest.add("Micheal","5678901234");
        String expected = "James    "+ "555555555\n"+
                "John    "+"1234567890\n"+
                "Micheal    "+"5678901234\n";
        String actual =phoneBookTest.listNamesAndNumbers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAdd(){
        PhoneBook phoneBookTest = new PhoneBook();
        boolean expected = true;
        boolean actual = phoneBookTest.add("Peter","7777777777");
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testRemove(){
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("John","1234567890");
        boolean expected =true;
        boolean actual = phoneBookTest.remove("John");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testReverseLookup() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("James","555555555");

        String actual = phoneBookTest.reverseLookUp("555555555");
        Assert.assertEquals("James",actual);
    }



}
