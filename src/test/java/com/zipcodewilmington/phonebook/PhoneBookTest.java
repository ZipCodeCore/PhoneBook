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
        bobNumber.add("302-555-2222");
        book.inputEntry("Bob", bobNumber);
        book.display();
        //Expected
        ArrayList<String> expectedAddition = new ArrayList<String>();
        expectedAddition.add("302-555-2222");
        expectedAddition.add("302-555-1111");
        //When
        book.addNumberToEntry("Bob", "302-555-1111");
        ArrayList<String> actualAddition = book.lookup("Bob");
        //Then
        Assert.assertEquals(expectedAddition, actualAddition);

    }

    //add test for removeNumberFromEntry

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
    public void testRemoveEntry2() {

        //Given
        PhoneBook book = new PhoneBook();

        ArrayList<String> expectedValue = new ArrayList<String>();
        expectedValue.add("302-555-2222");
        expectedValue.add("302-555-3456");
        book.inputEntry("Bob", expectedValue);

        //When
        book.removeEntry("Robert");
        String actualValue = book.display();

        //Then
        Assert.assertNotEquals(expectedValue, actualValue);
    }

    @Test
    public void testLookup(){
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
    public void testLookup3(){

        //Given
        PhoneBook book = new PhoneBook();

        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-2223");
        book.inputEntry("Bob", bobNumber);

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

        //Given
        PhoneBook book = new PhoneBook();
        String expectedName = "Bob";
        ArrayList<String> bobNumber = new ArrayList<String>();
        bobNumber.add("302-555-2223");
        bobNumber.add("302-555-5555");
        book.inputEntry(expectedName, bobNumber);

        //When;
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
        ArrayList<String> frankNumber = new ArrayList<String>();
        frankNumber.add("777-555-1111");
        book.inputEntry("Bob", bobNumber);
        book.inputEntry("Frank", frankNumber);

        String expectedNameNumber = "Bob " + bobNumber.toString() + "\n" + "Frank " + frankNumber.toString() + "\n";

        //When
        String actualNameNumber = book.display();
        //Then
        Assert.assertEquals(expectedNameNumber, actualNameNumber);

    }


}
