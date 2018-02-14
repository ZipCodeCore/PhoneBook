package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

    private ArrayList<String> myListOfPhoneNumbers;
    private ArrayList<String> myListOfPhoneNumbers1;
    private ArrayList<String> myListOfPhoneNumbers2;

    private TreeMap<String, Person> myPhoneBookEntries;
    private PhoneBook myPhoneBook;

    @Before
    public void setUp() throws Exception {
        myName = "bob";
        myName1 = "tim";
        myName2 = "lady";

        myNumber = "1000";
        myNumber1 = "200";
        myNumber2 = "300";

        myListOfPhoneNumbers = new ArrayList<>();
        myListOfPhoneNumbers1 = new ArrayList<>();
        myListOfPhoneNumbers2 = new ArrayList<>();

        myListOfPhoneNumbers.add(myNumber);
        myListOfPhoneNumbers1.add(myNumber1);
        myListOfPhoneNumbers2.add(myNumber2);

        myPerson = new Person(myName, myNumber, myListOfPhoneNumbers);
        myPerson1 = new Person(myName1, myNumber1, myListOfPhoneNumbers1);
        myPerson2 = new Person(myName2, myNumber2, myListOfPhoneNumbers2);

        myPhoneBookEntries = new TreeMap<>();
        myPhoneBookEntries.put(myName, myPerson);//myPhoneBook = new PhoneBook(myPhoneBookEntries);
        myPhoneBookEntries.put(myName1, myPerson1);
        myPhoneBookEntries.put(myName2, myPerson2);

        myPhoneBook = new PhoneBook(myPhoneBookEntries);
    }

    @Test
    public void testAdd() {
        String testName = "bob";
        String testPhone = "777";
        Assert.assertEquals(true, myPhoneBook.add(testName, testPhone));
        //Assert.assertEquals(true, myPhoneBook.add(testName, testPhone));
    }
//
//    @Test
//    public void testAddANumberToAList(){
//        String testName = "Lary";
//        String testPhone = "777";
//        myPhoneBook.addNumberToList(testName, testPhone);
//        Assert.assertEquals(true, actual);
//    }

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
    public void testRemoveAPhoneNumber() {
//        String testName = "Gordy";
       String testName1 = "Lady";
       String testNumber = "8900";
//        String testNumber1 = "9999";
        boolean actual = myPhoneBook.removeAPhoneNumber(myName1, myNumber1);
        boolean actual1 =myPhoneBook.removeAPhoneNumber(myName, myNumber);
        Assert.assertEquals(true, actual);
        //Assert.assertEquals(false,  actual1);
    }
    @Test
    public void testlookUpPhoneNumber() {
        String testNumber = "1000";
        String testNumber1 = "500";
        String testName1 = "Steve";
        Person expected = myPerson;

        Assert.assertEquals(expected, myPhoneBook.lookUpPhoneNumber(testNumber));
        //Assert.assertEquals(null, myPhoneBook.lookUpPhoneNumber(testNumber1));

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
        String[] expected = {"bob", "lady", "tim"};
        String[] actual = myPhoneBook.getlistAllNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetlListAllPhonebook() {
        Object[] expected = myPhoneBook.getlistAllListings();
        Object[] actual = myPhoneBook.getlistAllListings();
        Assert.assertEquals(expected, actual);
    }
}
