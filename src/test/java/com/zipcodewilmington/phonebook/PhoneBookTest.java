package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Before
    public void setup() {

    }

    @Test
    public void testAddEntry() {
        Person mitch = new Person("Mitch", "5551234");
        String expected = "Mitch";
        String actual = mitch.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddEntry2() {

    }

    @Test
    public void testAddNumber() {

    }

}
