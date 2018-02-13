package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    private Person john;
    private String number;
    private String name;
    @Before
    public void setUp() throws Exception {
       number = "20000000";
        john = new Person(name,  number);
    }

    @Test
    public void testGetSetName() {

        Assert.assertEquals("John", john.getName());
    }
//    @Test
//    public void testgetNameNull() {
//
//        Assert.assertEquals("John", john.getName());
//    }

    @Test
    public void getNumber() {
    Assert.assertEquals(number, john.getNumber());
    }

    @Test
    public void setName() {
    }

//    @Test
//    public String toString() {
//        return null;
//    }

    @Test
    public void setNumber() {
    }
}
