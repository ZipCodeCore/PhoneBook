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

        String actualPersonName = expectedPerson.getName();
        String actualPersonPhoneNumber = expectedPerson.phoneNumberList.get(0);

        boolean actualPersonNameExists = this.phonebook.hashMap.containsKey("Jane");
        //boolean actualPhoneNumberExists = this.phonebook.hashMap.get("Jane").phoneNumberList.get(0);

        Assert.assertTrue(actualPersonNameExists);
        //Assert.assertTrue(actualPhoneNumberExists);
    }


    @Test
    public void addEntryTest() {
        this.phonebook.addEntry("Adam", "(000) 000-0000", "(111) 111-1111");

        boolean actualPersonName = this.phonebook.hashMap.containsKey("Adam");
        boolean actualPhoneNumber = this.phonebook.hashMap.containsValue(this.phonebook.hashMap.get("Adam"));
        Assert.assertTrue(actualPersonName);
        Assert.assertTrue(actualPhoneNumber);

        String expectedPhoneNumber1 = "(000) 000-0000";
        String expectedPhoneNumber2 = "(111) 111-1111";

        String actualPhoneNumber1 = this.phonebook.hashMap.get("Adam").phoneNumberList.get(0);
        String actualPhoneNumber2 = this.phonebook.hashMap.get("Adam").phoneNumberList.get(1);

        Assert.assertEquals(expectedPhoneNumber1, actualPhoneNumber1);
        Assert.assertEquals(expectedPhoneNumber2, actualPhoneNumber2);

    }

    @Test
    public void removeRecordTest() {
        this.phonebook.addEntry("Bob", "(333) 444-5555");
        this.phonebook.removeRecord("Bob");

        boolean actualPersonName = this.phonebook.hashMap.containsKey("Bob");
        boolean actualPersonObject = this.phonebook.hashMap.containsValue(this.phonebook.hashMap.get("Bob"));

        Assert.assertFalse(actualPersonName);
        Assert.assertFalse(actualPersonObject);
    }

    /*
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
    /*
    }
    */

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

        //String actualNameFromPerson = expectedPerson.getName();
        //String actualPhoneNumberFromPerson = expectedPerson.getPhoneNumber();

        String actualNameFromPhoneBook = "Ava";
        boolean actualPhoneNumberFromPhoneBook = this.phonebook.hashMap.get(actualNameFromPhoneBook).phoneNumberList.contains(expectedPhoneNumber);

        Assert.assertEquals(expectedName, this.phonebook.reverseLookup(givenPhoneNumber));
        // Then



    }

}




