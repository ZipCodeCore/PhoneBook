package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    private PhoneBook phoneBook = new PhoneBook();
    String name = "Steve Harvey";
    String phoneNumber = "2153755497";
    String name2 = "Frankie";
    String pN2 = "2158663323";
    String name3 = "Zoe";
    String pN3 = "7896785647";
    String pN4 = "6574383954";


    @Before
    public void addEntryTest1(){
        phoneBook.add(name, phoneNumber, pN4);
        phoneBook.add(name2, pN2);
        phoneBook.add(name3, pN3);
    }

    @Test
    public void addEntryTest2() {
        name = "Durp";
        phoneNumber = "2153755497";
        name2 = "Frankie";
        pN2 = "2675677701";
        name3 = "Lenny Kravitz";
        pN3 = "3645274567";
        phoneBook.add(name, phoneNumber, pN2);
        phoneBook.add(name2, pN2);
        phoneBook.add(name3, pN3);
    }

    @Test
    public void lookUpTest1(){
        String expected = "2158663323";
        String actual = phoneBook.lookUp(name2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookUpTest2(){
        String expected = "2153755497, 6574383954";
        String actual = phoneBook.lookUp(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookupTest1(){
        String expected = "Frankie";
        String actual = phoneBook.reverseLookup(pN2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeRecordTest1(){
        phoneBook.removeRecord(name2);
        String actual = phoneBook.getPhoneBook();
        String expected = "Steve Harvey         [2153755497, 6574383954]\n" +
                "Zoe                  [7896785647]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeEntryTest1(){
        phoneBook.removeEntry(name, pN4);
        String actual = phoneBook.getPhoneBook();
        String expected = "Frankie              [2158663323]\n" +
                "Steve Harvey         [2153755497]\n" +
                "Zoe                  [7896785647]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayPhoneBook(){
        phoneBook.getPhoneBook();
    }
}
