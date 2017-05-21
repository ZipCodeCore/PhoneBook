package kalaygian.dennis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by denniskalaygian on 5/16/17.
 */
public class TestPhoneBook {

    PhoneBook phoneBook;
    PhoneNumber phoneNumber;
    ArrayList<PhoneNumber> phoneNumbers;

    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
        phoneNumbers = new ArrayList<PhoneNumber>();
    }


    // addPhoneNumber
    @Test
    public void testAddPhoneNumber() throws InvalidPhoneNumberFormatException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        phoneNumbers.add(phoneNumber);

        int expectedSize = 1;

        //When
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);

        //Then
        Assert.assertEquals("Checking to see if the number was successfully added", expectedSize, phoneBook.getPhoneCatalog().size());
    }

    // removeFromCatalog
    @Test
    public void testRemoveFromCatalog() throws InvalidPhoneNumberFormatException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        phoneNumbers.add(phoneNumber);
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);
        int expectedSize = 0;

        //When
        phoneBook.removeFromCatalog("Dennis");

        //Then
        Assert.assertEquals("Checking to see if the number was successfully removed", expectedSize, phoneBook.getPhoneCatalog().size());
    }

    @Test
    public void testRemoveFromCatalog_Failure() throws InvalidPhoneNumberFormatException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        phoneNumbers.add(phoneNumber);
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);
        int expectedSize = 1;

        //When
        phoneBook.removeFromCatalog("Aaron");

        //Then
        Assert.assertEquals("Checking to see if the number was successfully removed", expectedSize, phoneBook.getPhoneCatalog().size());
    }


    // lookUp
    @Test
    public void testLookUp() throws InvalidPhoneNumberFormatException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        phoneNumbers.add(phoneNumber);
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);
        String expectedNumber = "(302)-531-5564\n";

        //When
        String returnedPhoneNumbers = phoneBook.lookUp("Dennis");

        //Then
        Assert.assertEquals("Checking to see if the correct phone number is returned", expectedNumber, returnedPhoneNumbers);
    }

    @Test(expected = NullPointerException.class)
    public void testLookUp_Failed() throws InvalidPhoneNumberFormatException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        phoneNumbers.add(phoneNumber);
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);

        //When
        String returnedPhoneNumbers = phoneBook.lookUp("Aaron");

        //Then
        //This will never be reached
    }

    // listAllEntries
    @Test
    public void testListAllEntries() throws InvalidPhoneNumberFormatException, NullPointerException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        PhoneNumber phoneNumber2 = new PhoneNumber("(100)-200-3000");
        phoneNumbers.add(phoneNumber);
        ArrayList<PhoneNumber> phoneNumbers2 = new ArrayList<PhoneNumber>();
        phoneNumbers2.add(phoneNumber2);
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);
        phoneBook.addPhoneNumber("Aaron", phoneNumbers2);
        String expectedReturnValue = "Aaron: (100)-200-3000\nDennis: (302)-531-5564\n";

        //When
        String returnValue = phoneBook.listAllEntries();

        //Then
        Assert.assertEquals("Checking to see if the correct string is returned", expectedReturnValue, returnValue);
    }

    // reverseLookup()
    @Test
    public void testReverseLookup() throws InvalidPhoneNumberFormatException, NullPointerException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        phoneNumbers.add(phoneNumber);
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);
        String expectedName = "Dennis\n";

        //When
        String name = phoneBook.reverseLookup("(302)-531-5564");

        //Then
        Assert.assertEquals("Checking to see if the correct name is returned", expectedName, name);
    }

    @Test(expected = NullPointerException.class)
    public void testReverseLookup_Fails() throws InvalidPhoneNumberFormatException, NullPointerException{
        //Given
        phoneNumber = new PhoneNumber("(302)-531-5564");
        phoneNumbers.add(phoneNumber);
        phoneBook.addPhoneNumber("Dennis", phoneNumbers);
        String expectedName = "Dennis";

        //When
        String name = phoneBook.reverseLookup("(180)-031-4464");

        //Then
        //This will never be reached
    }


}
