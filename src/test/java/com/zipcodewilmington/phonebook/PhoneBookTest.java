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
    public void setUp(){
         testBook = new PhoneBook();
    }
    @Test
    public void testAdd() {

        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "302-532-4531");
        String testNumber = testBook.lookUp("George");
        Assert.assertTrue(testNumber.equals("302-532-4531"));
    }

    @Test
    public void testRemove() {

        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "302-532-4531");
        testBook.remove("George");
        String testNumber = testBook.lookUp("George");
        Assert.assertEquals("If you remove a phone number, it should return null",null, testNumber);
    }

    @Test
    public void testLookUp() {

        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "302-532-4531");
        String testNumber = testBook.lookUp("George");
        Assert.assertTrue(testNumber.equals("302-532-4531"));
    }

    @Test
    public void testListNames() {

        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "302-532-4531");
        testBook.add("Bob", "659-234-6756");
        testBook.add("Tony", "235-532-4531");
        testBook.add("Paul", "454-532-4531");
        testBook.add("Joe", "234-532-4531");
        String actual= testBook.listNames();
        String expected="Bob\nGeorge\nJoe\nPaul\nTony\n";
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testListNamesAndNumbers() {

        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "302-532-4531");
        testBook.add("Bob", "659-234-6756");
        testBook.add("Tony", "235-532-4531");
        testBook.add("Paul", "454-532-4531");
        testBook.add("Joe", "234-532-4531");
        String actual= testBook.listNamesAndNumbers();
        String expected="Bob 659-234-6756\nGeorge 302-532-4531\nJoe 234-532-4531\nPaul 454-532-4531\nTony 235-532-4531\n";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testReverseLookUp() {

        PhoneBook testBook = new PhoneBook();
        testBook.add("George", "302-532-4531");
        testBook.add("Bob", "659-234-6756");
        testBook.add("Tony", "235-532-4531");
        testBook.add("Paul", "454-532-4531");
        testBook.add("Joe", "234-532-4531");
        String actual= testBook.reverseLookUp( "302-532-4531");
        String expected="George";
        Assert.assertEquals(expected,actual);

    }
}
