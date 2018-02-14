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
        testBook.add("George", "302-532-4531", "302-999-9999");
        String testNumber = testBook.lookUp("George");
        Assert.assertTrue(testNumber.equals("302-532-4531\n302-999-9999"));
    }

    @Test
    public void testAddExtraNumber(){
        testBook.add("George", "302-532-4531");
        testBook.addExtraNumber("George",  "302-999-9999");
        String testNumber = testBook.lookUp("George");
        Assert.assertTrue(testNumber.equals("302-532-4531\n302-999-9999"));
    }

    @Test
    public void testRemoveNumber(){
        testBook.add("George", "302-532-4531", "302-999-9999");
        testBook.removeNumber("George",  "302-999-9999");
        String testNumber = testBook.lookUp("George");
        Assert.assertTrue(testNumber.equals("302-532-4531"));
    }

    @Test
    public void testRemoveRecord() {
        testBook.add("George", "302-532-4531");
        testBook.add("Clara", "302-555-5555");
        testBook.removeRecord("George");
        String expected ="Clara";
        String actual=testBook.listNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLookUp() {
        testBook.add("George", "302-532-4531", "302-540-2578");
        String testNumber = testBook.lookUp("George");
        Assert.assertEquals("302-532-4531\n302-540-2578", testNumber);
    }

    @Test
    public void testListNames() {
        testBook.add("George", "302-532-4531");
        testBook.add("Bob", "659-234-6756");
        testBook.add("Tony", "235-532-4531");
        testBook.add("Paul", "454-532-4531");
        testBook.add("Joe", "234-532-4531");
        String actual= testBook.listNames();
        String expected="Bob\nGeorge\nJoe\nPaul\nTony";
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testListNamesAndNumbers() {
        testBook.add("George", "302-532-4531", "302-555-5555");
        testBook.add("Bob", "659-234-6756");
        testBook.add("Tony", "235-532-4531");
        testBook.add("Paul", "454-532-4531");
        testBook.add("Joe", "234-532-4531");
        String actual= testBook.listNamesAndNumbers();
        String expected="Bob:\n659-234-6756\nGeorge:\n302-532-4531\n302-555-5555\nJoe:\n234-532-4531\nPaul:\n454-532-4531\nTony:\n235-532-4531";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testReverseLookUp() {
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
