package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PersonTest {
    private Person john;
    private String number;
    private String name;
    private ArrayList<String> listOfPhoneNumbers;
    @Before
    public void setUp() throws Exception {
       number = "20000000";
       name = "John";
       listOfPhoneNumbers = new ArrayList<>();
       listOfPhoneNumbers.add(number);

       john = new Person(name, number,listOfPhoneNumbers);
    }

    @Test
    public void testGetSetName() {

        Assert.assertEquals("John", john.getName());
    }

    @Test
    public void getNumber() {
    Assert.assertEquals(number, john.getNumber());
    }

    @Test
    public void testSetName() {
    john.setName("Steve");
    Assert.assertEquals("Steve", john.getName());
    }

    @Test
    public void setNumber() {
        john.setNumber("1000");
        Assert.assertEquals("1000", john.getNumber());
    }
}
