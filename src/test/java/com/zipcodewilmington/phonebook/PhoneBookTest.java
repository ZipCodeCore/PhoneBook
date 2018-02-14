package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;
import sun.nio.cs.ext.SJIS;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    @Test
    public void testDefaultConstructor() {
        PhoneBook book = new PhoneBook();
        Assert.assertNotNull(book);
    }

    @Test
    public void testConstructorWithArgument() {
        PhoneBook book = new PhoneBook();
        ArrayList<String> number = new ArrayList<String>();
        number.add("302-555-2222");
        number.add("302-555-3456");
        book.inputEntry("Bob", number);
        Assert.assertNotNull(book);
    }

    @Test
    public void testInputEntry() {
        //Given
        PhoneBook book = new PhoneBook();

        ArrayList<String> expectedAddition = new ArrayList<String>();
        expectedAddition.add("302-555-2222");
        expectedAddition.add("302-555-3456");

        //When
        book.inputEntry("Bob", expectedAddition);
        ArrayList<String> actualAddition = new ArrayList<String>(book.lookup("Bob"));

        //Then
        Assert.assertEquals(expectedAddition, actualAddition);
    }

    @Test
    public void addNumberToEntry() {
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-2234");
        book.inputEntry("Bob", bobNumber);
        ArrayList<String> expectedAddition = new ArrayList<String>();
        expectedAddition.add("302-555-2234");
        expectedAddition.add("302-555-1111");
        //When
        book.addNumberToEntry("Bob", "302-555-1111");
        ArrayList<String> actualAddition = book.lookup("Bob");
        //Then
        Assert.assertEquals(expectedAddition, actualAddition);
    }

    @Test
    public void removeNumberFromEntry() {
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-2234");
        bobNumber.add("302-555-1111");
        book.inputEntry("Bob", bobNumber);

        ArrayList<String> expectedAfterDeletion = new ArrayList<String>();
        expectedAfterDeletion.add("302-555-2234");

        //When
        book.removeNumberFromEntry("Bob", "302-555-1111");
        ArrayList<String> actualAfterDeletion = book.lookup("Bob");
        //Then
        Assert.assertEquals(expectedAfterDeletion, actualAfterDeletion);
    }

    @Test
    public void testRemoveEntry() {

        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-2222");
        bobNumber.add("302-555-3456");
        book.inputEntry("Bob", bobNumber);
        String expectedValue = "";

        //When
        book.removeEntry("Bob");
        String actualValue = book.display();

        //Then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testLookup(){
        //To test if lookup returns all of the person's phone numbers
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> expectedNumber = new ArrayList<String>();
        expectedNumber.add("302-555-2223");
        expectedNumber.add("302-555-3456");
        book.inputEntry("Bob", expectedNumber);
        //When
        ArrayList<String> actualNumber = new ArrayList<String>(book.lookup("Bob"));
        //Then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testLookup2(){
        //To test if lookup picks out the right person when there are multiple entries
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-2223");
        book.inputEntry("Bob", bobNumber);
        //Expected
        ArrayList<String> expectedNumber = new ArrayList<String>();
        expectedNumber.add("302-555-9988");
        book.inputEntry("Frank", expectedNumber);
        //When
        ArrayList<String> actualNumber = new ArrayList<String> (book.lookup("Frank"));
        //Then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testreverseLookup(){
        // to test if right person is returned when searching by one of multiple phone numbers
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-2223");
        bobNumber.add("302-555-5555");
        String expectedName = "Bob";
        book.inputEntry(expectedName, bobNumber);
        //When
        String actualName = book.reverseLookup("302-555-2223");
        //Then
        Assert.assertEquals(expectedName, actualName);
    }


    @Test
    public void testDisplay() {
        //Given:
        PhoneBook book = new PhoneBook();

        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-1234");
        bobNumber.add("302-556-1245");
        book.inputEntry("Bob", bobNumber);

        ArrayList<String> frankNumber = new ArrayList<String>();
        frankNumber.add("777-555-1111");
        book.inputEntry("Frank", frankNumber);
        //Expected
        String expectedNameNumber = "Bob " + bobNumber.toString() + "\n" + "Frank " + frankNumber.toString() + "\n";
        //When
        String actualNameNumber = book.display();
        //Then
        Assert.assertEquals(expectedNameNumber, actualNameNumber);
    }

}
