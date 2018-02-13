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
        book.add("Robert", "302-555-1234");
        Assert.assertNotNull(book);



    }
    @Test
    public void testConstructorWithArgument() {

    }

    @Test
    public void testAdd() {
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");


    }

    @Test
    public void testRemove() {

        //Given
        PhoneBook book = new PhoneBook();
        book.add("Robert", "302-555-1234");
        String expectedValue = "Robert " + book.lookup("Robert") + " has been removed";
        book.add("Robert", expectedValue);

        //When
        String actualNumber = book.remove("Robert");

        //Then
        Assert.assertEquals(expectedValue, actualNumber );


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
