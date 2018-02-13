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

//
//    @Test
//    public void testlreverseLookUp1() {
//        PhoneBook phoneBook = new PhoneBook();
//        String expected = "sam";
//        phoneBook.add(expected, "856-222-4444");
//        String actual = phoneBook.reverseLookUp("856-222-4444");
//        Assert.assertEquals(expected, actual);
//    }
//
//
//    @Test
//    public void testreverseLookUp2() {
//        PhoneBook phoneBook = new PhoneBook();
//        String expected = "toby";
//        phoneBook.add(expected, "856-111-9999");
//        String actual = phoneBook.reverseLookUp("856-111-9999");
//        Assert.assertEquals(expected, actual);
//    }
//
//
//    @Test
//    public void testadd1() {
//        PhoneBook phoneBook = new PhoneBook();
//        String name = "bob";
//        String number = "215-333-3333";
//        phoneBook.add(name, number);
//
//    }
//
//    @Test
//    public void testadd2() {
//        PhoneBook phoneBook = new PhoneBook();
//        String name = "bill";
//        String number = "215-777-8888";
//        phoneBook.add(name, number);
//
//    }
//    @Test
//    public void testremove1() {
//        PhoneBook phoneBook = new PhoneBook();
//        String name = "frank";
//        String number = "215-777-5555";
//        phoneBook.remove(name, number);
//
//    }
//
//    @Test
//    public void testremove2() {
//        PhoneBook phoneBook = new PhoneBook();
//        String name = "will";
//        String number = "215-345-7890";
//        phoneBook.remove(name, number);
//
//    }
//
//    @Test
//    public void testListNames1(){
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("Zebra", "111-222-333");
//        phoneBook.add("Dog", "222-444-4444");
//        Set<String> names = phoneBook.listNames();
//        Assert.assertTrue(names.size() == 2);
//        Assert.assertTrue(names.contains("Zebra"));
//        Assert.assertTrue(names.contains("Dog"));
//
//    }
//
//    @Test
//    public void testListNames2(){
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("Sam", "444-222-333");
//        phoneBook.add("Iam", "888-000-4444");
//        Set<String> names = phoneBook.listNames();
//        Assert.assertTrue(names.size() == 2);
//        Assert.assertTrue(names.contains("Sam"));
//        Assert.assertTrue(names.contains("Iam"));
//
//    }

//    @Test
//    public void testListNameNumber1(){
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("Cam", "555-222-1111");
//        phoneBook.add("Mam", "666-333-4444");
//        phoneBook.add("Will", "222-123-5678");
//        String actual = phoneBook.listNameNumber();
//        String expected = "Cam";
//        Set<String> <String> names = phoneBook.listNameNumber();
//        Assert.assertTrue(names.size() == 2);
//        Assert.assertTrue(names.contains("Sam"), );
//
//
//    }
//    @Test
//    public void testListNameNumber2(){
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("Sam", "444-222-333");
//        phoneBook.add("Iam", "888-000-4444");
//        Set<String> names = phoneBook.listNameNumber();
//        Assert.assertTrue(names.size() == 2);
//        Assert.assertTrue(names.contains("Sam"));
//        Assert.assertTrue(names.contains("Iam"));
//
//    }

}