package com.zipcodewilmington.phonebook;

import java.util.Arrays;
import org.junit.Assert;
/**
 * created by Leon on some date idk
 * edited by vincent masiello 2/12/18
 */
public class TestUtils {
    public synchronized static void assertEquality(String expected, String actual) {
        boolean equality = expected.equals(actual);
        System.out.println("\n\nExpected:\n" + expected);
        System.out.println("\nActual:\n" + actual);
        System.out.println("\nEquivalence:\n\t" + equality);

        Assert.assertEquals(expected, actual);
    }
}