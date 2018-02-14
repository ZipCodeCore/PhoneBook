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
    public void testSetName() {
        String expected = "John Smith";
        person.setName(expected);
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetPhoneNumber() {
        String expected = "(111) 222-3333";
        person.setPhoneNumber(expected);
        String actual = person.getPhoneNumber();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetName() {
        String expected = "John Smith";
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPhoneNumber() {
        String expected = "(111) 222-3333";
        String actual = person.getPhoneNumber();
        Assert.assertEquals(expected, actual);
    }

}
