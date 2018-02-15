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

//Start off here. google "how to write a test for a map"
//    PhoneBook testPhonebook = new PhoneBook(); <=why didn't this work?
    PhoneBook testPhonebook;

    @Before
    public void setup() {
            testPhonebook = new PhoneBook();
    }

    @Test
    public void addEntryTestCase1(){
        new Person("Addison", "1234");
        testPhonebook.add("Addison", "1234");
        String testNumber = testPhonebook.lookup("Addison");
        Assert.assertTrue(testNumber.equals("[1234]"));
    }

    @Test
    public void addEntryTestCase2(){
        new Person("AdDy", "123.4");
        testPhonebook.add("AdDy", "123.4");
        String testNumber = testPhonebook.lookup("AdDy");
        Assert.assertTrue(testNumber.equals("[123.4]"));
    }



    @Test
    public void testLookup() {

        testPhonebook.add("JohnDoe", "1123");

        String expected = "[1123]";
        String actual = testPhonebook.lookup("JohnDoe");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void test (){

    }

}
