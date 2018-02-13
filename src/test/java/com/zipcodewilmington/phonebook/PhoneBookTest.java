package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    public void testDefaultConstructor() {

        PhoneBook book = new PhoneBook();



    }

    public void testConstructorWithArgument() {

    }

    public void testAdd() {
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");
        Assert.assertNotNull(book);
    }

    public void testRemove() {

    }

    public void testLookup(){

        //Given
        String expectedNumber = "302-555-1234";
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");

        //When
        book.lookup("Bob");

        //Then
        Assert.assertEquals(expectedNumber, "302-555-1234");
    }

    public void testDisplay() {
        //Given
        String expectedNameNumber = "Bob 302-555-1234 \n";
        PhoneBook book = new PhoneBook();
        book.add("Bob", "302-555-1234");
        //When
        String actualNameNumber = book.display();
        //Then
        Assert.assertEquals(expectedNameNumber, actualNameNumber);

    }


}
