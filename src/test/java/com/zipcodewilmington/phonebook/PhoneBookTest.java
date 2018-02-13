package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

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
        book.add("Bob", "302-555-1234");
        Assert.assertNotNull(book);
    }

    @Test
    public void testAdd() {

        //Given
        PhoneBook book = new PhoneBook();
        String expectedAddition = "302-555-1234";

        //When
        book.add("Bob", "302-555-1234");
        String actualAddition = book.lookup("Bob");

        //Then
        Assert.assertEquals(expectedAddition, actualAddition);

    }

    @Test
    public void testRemove() {

        //Given
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");
        String expectedValue = "";

        //When
        book.remove("Bob");
        String actualValue = book.display();

        //Then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testRemove2() {

        //Given
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");
        String expectedValue = "";

        //When
        book.remove("Robert");
        String actualValue = book.display();

        //Then
        Assert.assertNotEquals(expectedValue, actualValue);


    }


    @Test
    public void testLookup(){

        //Given
        PhoneBook book = new PhoneBook();
        String expectedNumber = "302-555-1234";
        book.add("Bob", expectedNumber);
        //When
        String actualNumber = book.lookup("Bob");
        //Then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testLookup2(){

        //Given
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");
        String expectedNumber = null;
        //When
        String actualNumber = book.lookup("Frank");
        //Then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testLookup3(){

        //Given
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");
        String expectedNumber = "302-555-9988";
        book.add("Frank", expectedNumber);
        //When
        String actualNumber = book.lookup("Frank");
        //Then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testreverseLookup(){

        //Given
        PhoneBook book = new PhoneBook();
        String expectedName = "Bob";
        book.add(expectedName, "302-555-1234");
        //When
        String actualName = book.reverseLookup("302-555-1234");
        //Then
        Assert.assertEquals(expectedName, actualName);
    }


    @Test
    public void testDisplay() {
        //Given: need help from instructor
        String expectedNameNumber = "Bob 302-555-1234\nFrank 777-555-1111\n";
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");
        book.add("Frank", "777-555-1111");
        //When
        String actualNameNumber = book.display();
        //Then
        Assert.assertEquals(expectedNameNumber, actualNameNumber);

    }


}
