package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Test;


public class ListingTest {


    @Test
    public void testNewListing(){
        Listing jenny = new Listing("Jenny", "867-5309");
        String expectedNumber = "867-5309";
        String expectedName = "Jenny";
        String actual = jenny.printName() + jenny.printNumbers();
        Assert.assertTrue(actual.contains(expectedName) && actual.contains(expectedNumber));
    }

    @Test
    public void testAddNumber(){
        Listing jenny = new Listing("Jenny", "867-5309");
        String expectedNumber = "117-2490";
        jenny.addNumber(expectedNumber);
        String actual = jenny.printNumbers();
        Assert.assertTrue(actual.contains(expectedNumber));
    }

    @Test
    public void testPrintName(){
        Listing jenny = new Listing("Jenny", "867-5309");
        String expectedName = "Jenny";
        String actual = jenny.printName();
        Assert.assertTrue(actual.contains(expectedName));
    }

    @Test
    public void testPrintNumbers(){
        Listing jenny = new Listing("Jenny", "867-5309");
        jenny.addNumber("117-2490");
        String expectedNumbers = "867-5309 | 117-2490";
        String actual = jenny.printNumbers();
        Assert.assertTrue(actual.equals(expectedNumbers));
    }


}
