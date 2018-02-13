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

    /**
     * double brace initializing: outer pair of braces means that you
     * are declaring and initializing an anonymous inner class that
     * extends TreeMap. Inner braces represents an instance initializer,
     * code that is run when an instance is created.
     */
    @Before
    public void setUp() {

        Map<String, String> expectedPhoneBook = new TreeMap<String, String>() {
            {
                put("fa", "43234");
                put("jj", "54323");
                put("dfafa", "894579");
            }
        };
        testPhoneBook = new PhoneBook(expectedPhoneBook);
    }


    @Test
    public void recordShouldAddToPhoneBook() {
        testPhoneBook.addNameAndNumber("Julia", "7173248976");
        boolean actualValue = testPhoneBook.containsName("Julia");
        boolean actualName = testPhoneBook.containsPhoneNumber("7173248976");
        Assert.assertTrue(actualName);
        Assert.assertTrue(actualValue);
    }


    @Test
    public void recordShouldDeleteFromPhoneBook() {
        testPhoneBook.deleteNameAndNumber("Julia");
        boolean actualValue = testPhoneBook.containsPhoneNumber("Julia");
        boolean actualName = testPhoneBook.containsPhoneNumber("7173248976");
        Assert.assertFalse(actualName);
        Assert.assertFalse(actualValue);
    }

    @Test
    public void phoneNumberShouldRetrieveByName() {
        String expected = testPhoneBook.deleteNameAndNumber("Julia");
        boolean expectedName = testPhoneBook.containsName(name);
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





