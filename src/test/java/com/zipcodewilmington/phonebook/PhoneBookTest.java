package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private static PhoneBook phonebook;

    @Before
    public void setup() {
        this.phonebook = new PhoneBook() ;
    }

    @Test
    public void defaultConstructorTest() {
        Assert.assertNotNull(this.phonebook);
    }

    @Test
    public void lookupTest() {
        Person expectedPerson = new Person("Jane", "(111) 222-3333");
        this.phonebook.addEntry("Jane", "(111) 222-3333");

        String expectedPersonName = expectedPerson.getName();
        String expectedPersonPhoneNumber = expectedPerson.getPhoneNumber();

        boolean actualPersonName = this.phonebook.hashMap.containsKey("Jane");
        boolean actualPhoneNumber = this.phonebook.hashMap.containsValue(this.phonebook.hashMap.get("Jane"));

        Assert.assertTrue(actualPersonName);
        Assert.assertTrue(actualPhoneNumber);
    }

    @Test
    public void addEntryTest() {
        this.phonebook.addEntry("Adam", "(222) 333-4444");

        boolean actualPersonName = this.phonebook.hashMap.containsKey("Adam");
        boolean actualPhoneNumber = this.phonebook.hashMap.containsValue(this.phonebook.hashMap.get("Adam"));

        Assert.assertTrue(actualPersonName);
        Assert.assertTrue(actualPhoneNumber);
    }

    @Test
    public void removeEntryTest() {
        this.phonebook.addEntry("Bob", "(333) 444-5555");
        this.phonebook.removeEntry("Bob");

        boolean actualPersonName = this.phonebook.hashMap.containsKey("Bob");
        boolean actualPersonObject = this.phonebook.hashMap.containsValue(this.phonebook.hashMap.get("Bob"));

        Assert.assertFalse(actualPersonName);
        Assert.assertFalse(actualPersonObject);
    }

    @Test
    public void getEntryListTest() {
        this.phonebook.addEntry("Ava", "(000) 111-2222");
        this.phonebook.addEntry("Brian", "(222) 333-4444");
        this.phonebook.addEntry("Charlie", "(444) 555-6666");
        this.phonebook.addEntry("David", "(666) 777-8888");
        this.phonebook.addEntry("Edward", "(777) 888-9999");
        this.phonebook.addEntry("Frank", "(888) 999-0000");

        Assert.assertNotNull(this.phonebook.getEntryList());

        /*
        this.phonebook.removeEntry("Bob");

        boolean actualPersonName = this.phonebook.hashMap.containsKey("Bob");
        boolean actualPersonObject = this.phonebook.hashMap.containsValue(this.phonebook.hashMap.get("Bob"));

        Assert.assertFalse(actualPersonName);
        Assert.assertFalse(actualPersonObject);
        */
    }

    @Test
    public void reverseLookupTest() {

        // This method should allow you to look up names by the phone number associated with them.

        // Given
        String givenPhoneNumber = "(000) 111-2222";

        // When
        this.phonebook.addEntry("Ava", "(000) 111-2222");
        Person expectedPerson = new Person("Ava", "(000) 111-2222");

        String expectedName = "Ava";
        String expectedPhoneNumber = "(000) 111-2222";

        String actualNameFromPerson = expectedPerson.getName();
        String actualPhoneNumberFromPerson = expectedPerson.getPhoneNumber();

        String actualNameFromPhoneBook = "Ava";
        String actualPhoneNumberFromPhoneBook = this.phonebook.hashMap.get(actualNameFromPhoneBook).getPhoneNumber();

        Assert.assertEquals(expectedName, this.phonebook.reverseLookup(givenPhoneNumber));
        // Then



    }

}




