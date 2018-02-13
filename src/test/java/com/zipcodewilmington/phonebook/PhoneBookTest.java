package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void lookup_ValidEntry_ReturnsNumber() {
        // Arrange
        String input = "215-333-4444";
        String expected = "215-333-4444";

        // Act
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("theresa", input);
        String actual = phoneBook.lookup("theresa");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookUp_NoEntry_ReturnsNull() {
        PhoneBook phoneBook = new PhoneBook();
        String actual = phoneBook.lookup("cody");
        Assert.assertNull(actual);
    }

    @Test
    public void add_AddsEntry() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "215-333-4444";
        phoneBook.add("theresa", expected);
        String actual = phoneBook.lookup("theresa");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove_RemovesEntry() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "215-333-4444";
        phoneBook.add("theresa", expected);
        phoneBook.remove("theresa");
        String actual = phoneBook.lookup("theresa");
        Assert.assertNull(actual);
    }

    @Test
    public void display_HasEntry_ReturnsString() {
        // Arrange
        String input = "215-333-4444";
        String expected = "theresa 215-333-4444\n";

        // Act
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("theresa", input);
        String actual = phoneBook.display();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void display_HasMultipleEntry_ReturnsString() {
        // Arrange
        String expected = "min 215-222-4444\ntheresa 215-333-4444\n";

        // Act
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("theresa", "215-333-4444");
        phoneBook.add("min", "215-222-4444");

        String actual = phoneBook.display();

        // Assert
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void reverseLookUp_EntryExists_ReturnsName() {
        // Arrange
        String expected = "min";

        // Act
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("theresa", "215-333-4444");
        phoneBook.add("min", "215-222-4444");

        String actual = phoneBook.reverseLookUp("215-222-4444");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUp_EntryDoesExists_ReturnsNull() {
        // Arrange

        // Act
        PhoneBook phoneBook = new PhoneBook();

        String actual = phoneBook.reverseLookUp("215-222-4444");

        // Assert
        Assert.assertNull(actual);
    }
}