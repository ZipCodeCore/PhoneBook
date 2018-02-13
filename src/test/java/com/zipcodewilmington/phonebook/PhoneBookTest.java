package com.zipcodewilmington.phonebook;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private PhoneBook testRecord;


    @Before
    public void testSetUp() {

        testRecord = new PhoneBook();

        testRecord.addNameAndNumber("Sally", "7173419899");
        testRecord.addNameAndNumber("Zach", "7173413244");
        testRecord.addNameAndNumber("Adam", "7173419675");
        testRecord.addNameAndNumber("Chance", "555");
        testRecord.addNameAndNumber("Wally", "8906786");

    }

    @Test
    public void recordShouldAddToPhoneBook() {
        testRecord.addNameAndNumber("Julia", "7173248976");
        boolean expectedName = testRecord.containsKey(name);
        boolean expectedValue = testRecord.containsKey(value);
        Assert.assertEquals(expectedName, true);
        Assert.assertEquals(expectedValue, true);
    }

    @Test
    public void recordShouldDeleteFromPhoneBook() {
        testRecord.deleteNameAndNumber("Julia");
        boolean expectedName = testRecord.containsKey(name);
        boolean expectedValue = testRecord.containsKey(value);
        Assert.assertEquals(expectedName, false);
        Assert.assertEquals(expectedValue,false);
    }

    @Test
    public void phoneNumberShouldRetrieveByName() {

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nameShouldRetrieveByPhoneNumber() {

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldlistAllNames() {

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldlistAllNamesAndNumbers() {

        Assert.assertEquals(expected, actual);
    }
}





