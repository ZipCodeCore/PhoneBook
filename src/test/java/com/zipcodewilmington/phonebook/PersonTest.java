package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Luis J. Romero on 2/12/2018
 */

public class PersonTest {

    private static Person person;

    @Before
    public void setup() {
        this.person = new Person("John Smith", "(111) 222-3333");
    }


    @Test
    public void setNameTest() {
        String expected = "John Smith";
        person.setName(expected);
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest() {
        String expected = "John Smith";
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    public void addPhoneNumbersTest() {
        this.person = new Person("John Smith", "(000) 000-0000");
        String expectedPhoneNumberToAdd1 = "(111) 111-1111";
        String expectedPhoneNumberToAdd2 = "(222) 222-2222";

        this.person.addPhoneNumbers(expectedPhoneNumberToAdd1, expectedPhoneNumberToAdd2);

        String actualPhoneNumberAdded1 = this.person.phoneNumberList.get(1);
        String actualPhoneNumberAdded2 = this.person.phoneNumberList.get(2);

        Assert.assertEquals(expectedPhoneNumberToAdd1, actualPhoneNumberAdded1);
        Assert.assertEquals(expectedPhoneNumberToAdd2, actualPhoneNumberAdded2);

    }

    public void removePhoneNumbersTest() {
        this.person = new Person("John Smith", "(000) 000-0000", "(111) 111-1111", "(222) 222-2222");
        String expectedPhoneNumberToDelete1 = "(111) 111-1111";
        String expectedPhoneNumberToDelete2 = "(222) 222-2222";

        this.person.removePhoneNumbers(expectedPhoneNumberToDelete1, expectedPhoneNumberToDelete2);

        boolean isPhoneNumberInList1 = this.person.phoneNumberList.contains(expectedPhoneNumberToDelete1);
        boolean isPhoneNumberInList2 = this.person.phoneNumberList.contains(expectedPhoneNumberToDelete2);

        Assert.assertFalse(isPhoneNumberInList1);
        Assert.assertFalse(isPhoneNumberInList2);
    }

}

