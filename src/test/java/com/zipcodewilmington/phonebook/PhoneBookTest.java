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

    private static PhoneBook testPhoneBook;

    public void setUp() {
        testPhoneBook = new PhoneBook();
    }

    @Test
    public void recordShouldAddToPhoneBook() {
        PhoneBook pb = new PhoneBook();
        pb.addNameAndNumber("Julia", "7173248976");
        String expectedValue = pb.retrieveByName("Julia");
        Assert.assertEquals(expectedValue, "7173248976");
    }

    @Test
    public void phoneNumberShouldRetrieveByName() {
        PhoneBook pb = new PhoneBook();
        pb.addNameAndNumber("Sam", "7173247777");
        String expectedValue = pb.retrieveByName("Sam");
        Assert.assertEquals(expectedValue, "7173247777");
    }

    @Test
    public void nameShouldRetrieveByPhoneNumber() {
        PhoneBook pb = new PhoneBook();
        pb.addNameAndNumber("Sam", "7173247777");
        String expectedValue = pb.retrieveByPhoneNumber("7173247777");
        Assert.assertEquals(expectedValue, "7173247777");
    }

    @Test
    public void recordShouldDeleteFromPhoneBook() {
        PhoneBook pb = new PhoneBook();
        pb.deleteNameAndNumber("Julia");
        String expectedValue = pb.retrieveByName("Julia");
        Assert.assertEquals(expectedValue, null);
    }

/**
    @Test
    public void shouldlistAllNamesAlphabeticalOrder() {
        PhoneBook pb = new PhoneBook();
        pb.addNameAndNumber("Sally", "7173243456");
        pb.addNameAndNumber("Adam", "7173244567");
        pb.addNameAndNumber("Chance", "7173247891");
        pb.addNameAndNumber("Zach", "7173242345");
        pb.addNameAndNumber("Wally", "7173242345");
        String actual = pb.listAllNames();
        String testList = "Name: Adam\nName: Chance\nName: Sally\nName: Wally\nName: Zach";
        Assert.assertEquals(testList, actual);
    }

    @Test
    public void shouldlistAllNamesAndNumbers() {

        Assert.assertEquals(false, false);
    }

*/
}