package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    PhoneBook testPhonebook = new PhoneBook();

    @Before

    public void setup(){

//Start off here. google "how to write a test for a map"

    }

    @Test
    public void testLookup() {

        testPhonebook.add("JohnDoe", "1123");

        String expected = "1123";
        String actual = testPhonebook.lookup("JohnDoe");

        Assert.assertEquals(expected, actual);

    }

}
