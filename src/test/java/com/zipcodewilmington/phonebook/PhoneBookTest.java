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

    TreeMap<String, String> personMapTest= new TreeMap<String, String>();

    @Before

    public void setup(){

//Start off here. google "how to write a test for a map"

    }

    @Test
    public void testLookup() {

        personMapTest.put("JohnDoe", "1123");

        String expected = "JohnDoe";
        String actual = testPhonebook.lookup(expected);

        Assert.assertEquals(expected, actual);

    }

}
