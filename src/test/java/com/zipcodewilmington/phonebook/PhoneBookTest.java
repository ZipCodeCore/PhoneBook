package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testlookUpPhoneNum1() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "2153334444";
        phoneBook.add("theresa", expected);
        String actual = phoneBook.lookUpPhoneNumber("theresa");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testlookUpPhoneNum2() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "2158887777";
        phoneBook.add("cody", expected);
        String actual = phoneBook.lookUpPhoneNumber("cody");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testlookUpName1() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "sam";
        phoneBook.add(expected, "8562224444");
        String actual = phoneBook.lookUpName("8562224444");
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testlookUpName2() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "toby";
        phoneBook.add(expected, "8561119999");
        String actual = phoneBook.lookUpName("8561119999");
        Assert.assertEquals(expected, actual);
}





    @Test
    public void testadd1() {
        PhoneBook phoneBook = new PhoneBook();
        String name = "bob";
        String number = "2153333333";
        phoneBook.add(name, number);
        String expected = "";
        //String actual = PhoneBook.add(name, number);
        //Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void testadd2() {
//        String expected = "";
//        String actual = PhoneBook.add();
//        Assert.assertEquals(expected, actual);
//    }
//
//
//
//
//
//    @Test
//    public void testremove1() {
//        String expected = "";
//        String actual = PhoneBook.remove();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testremove2() {
//        String expected = "";
//        String actual = PhoneBook.remove();
//        Assert.assertEquals(expected, actual);
//    }
//
//
//
//
//
//
//    @Test
//    public void testlistAllNames1() {
//        String expected = "";
//        String actual = PhoneBook.listAllNames();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testlistAllNames2() {
//        String expected = "";
//        String actual = PhoneBook.listAllNames();
//        Assert.assertEquals(expected, actual);
//    }
//
//
}