package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testConstructor() {
        // Given
        String expectedName = "";
        String expectedPhoneNumber = "";

        // When
        Person person = new Person(expectedName, expectedPhoneNumber);

        // Then
        String actualName = person.getName();
        String actualPhoneNumber = person.getPhoneNumber();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPhoneNumber, actualPhoneNumber);
    }

    @Test
    public void testConstructorWithNameAndPhonNumber() {
        // Given
        String expectedName = "Leon";
        String expectedPhoneNumber = "123";

        // When
        Person person = new Person(expectedName, expectedPhoneNumber);

        // Then
        String actualPhoneNumber = person.getPhoneNumber();
        String actualName = person.getName();

        Assert.assertEquals(expectedPhoneNumber, actualPhoneNumber);
        Assert.assertEquals(expectedName, actualName);
    }
}
