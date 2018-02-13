package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private String myName;
    private String myName1;
    private String myName2;

    private String myNumber;
    private String myNumber1;
    private String myNumber2;

    private Person myPerson;
    private Person myPerson1;
    private Person myPerson2;

    private TreeMap<String, Person> myPhoneBookEntries;
    private PhoneBook myPhoneBook;

    @Before
    public void setUp() throws Exception {
        myName = "bob";
        myName1 = "tim";
        myName2 = "lady";

        myNumber ="1000";
        myNumber1 = "200";
        myNumber2 = "300";

        myPerson = new Person(myName, myNumber);
        myPerson1 = new Person(myName1, myNumber1);
        myPerson2 = new Person(myName2, myNumber2);

        myPhoneBookEntries = new TreeMap<>();
        myPhoneBookEntries.put(myName, myPerson);//myPhoneBook = new PhoneBook(myPhoneBookEntries);
        myPhoneBookEntries.put(myName1, myPerson1);
        myPhoneBookEntries.put(myName2, myPerson2);

        myPhoneBook = new PhoneBook(myPhoneBookEntries);
    }

    @Test
    public void testAdd() {
         String testName = "Lary";
         String testPhone = "777";
        Assert.assertEquals(true, myPhoneBook.add(testName, testPhone));
    }

    @Test
    public void testAddFalse() {
        String testName = "bob";
        String testPhone = "1000";
        Assert.assertEquals(false, myPhoneBook.add(testName, testPhone));
    }

    @Test
    public void testRemove() {
        String testName = "bob";
        String testName1 = "Gordy";
        Assert.assertEquals(true, myPhoneBook.removeListing(testName));
        Assert.assertEquals(false, myPhoneBook.removeListing(testName1));
    }



    @Test
    public void testlookUpPhoneNumber() {
     String testNumber = "1000";
     String testNumber1 = "500";
     String testName1 = "Steve";
     Person expected = myPerson;

     Assert.assertEquals(expected, myPhoneBook.lookUpPhoneNumber(testNumber));
     Assert.assertEquals(null, myPhoneBook.lookUpPhoneNumber(testNumber1));

    }

    @Test
    public void testlookUpName() {
        String testName = "bob";
        String testName1 = "Steve";
        Person expected = myPerson;

        Assert.assertEquals(expected, myPhoneBook.lookUpName(testName));
        Assert.assertEquals(null, myPhoneBook.lookUpName(testName1));

    }

    @Test
    public void testGetlistAllNames() {
      String [] expected = {"bob", "lady", "tim"};
      String [] actual = myPhoneBook.getlistAllNames();
      Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetlListAllPhonebook() {
        Object[] expected = myPhoneBook.getlistAllListings();
                Object[] actual = myPhoneBook.getlistAllListings();
        Assert.assertEquals(expected, actual);
    }
}
