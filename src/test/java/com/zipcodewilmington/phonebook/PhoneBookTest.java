package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    PhoneBook test;
    @Before
    public void setup() {
        Listing eric = new Listing("Eric", "555-5555");
        Listing jenny = new Listing("Jenny", "867-5309");
        Listing horatio = new Listing("Horatio", "987-6543");
        Listing terrance = new Listing("Terrance", "111-2222");
        Listing tariq = new Listing("Tariq", "420-6969");
        test = new PhoneBook ("Jenny", jenny);
        test.addListing("Eric", eric);
        test.addListing("Horatio", horatio);
        test.addListing("Terrance", terrance);
        test.addListing("Tariq", tariq);
    }

    @Test
    public void testNewPhoneBook(){
        Listing alphonse = new Listing("Alphonse", "999-8765");
        PhoneBook testNew = new PhoneBook("Alphonse", alphonse);
        String expectedName = "Alphonse";
        String expectedNumber = "999-8765";
        String actual = testNew.book.get("Alphonse").printName() + testNew.book.get("Alphonse").printNumbers();
        Assert.assertTrue(actual.contains(expectedName) && actual.contains(expectedNumber));
    }

    @Test
    public void testAddListing(){
        Listing bobby = new Listing("Bobby", "123-4567");
        test.addListing("Bobby", bobby);
        String expectedName = "Bobby";
        String expectedNumber = "123-4567";
        String actual = test.book.get("Bobby").printName() + test.book.get("Bobby").printNumbers();
        Assert.assertTrue(actual.contains(expectedName) && actual.contains(expectedNumber));
    }

    @Test
    public void testRemoveListing(){
        try {
            test.removeListing("Jenny");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String expectedKey = "Jenny";
        Assert.assertFalse(test.book.containsKey(expectedKey));
    }

    @Test
    public void testRemoveInvalidListing(){
        boolean thrown = false;
        try {
            test.removeListing("Robby");
        }
        catch(Exception e){
            thrown = true;
             e.printStackTrace();
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void testLookupByName(){
        String expectedNumber = "867-5309";
        try {
            String actual = test.lookupByName("Jenny");
            Assert.assertTrue(actual.equals(expectedNumber));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLookupByInvalidName(){
       boolean thrown = false;
        try {
            test.lookupByName("Robby");
        }
        catch(Exception e){
            thrown = true;
            e.printStackTrace();
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void testListAllNames() {
        String expectedList =
                "Eric\n"+
                "Horatio\n"+
                "Jenny\n"+
                "Tariq\n"+
                "Terrance\n";
        String actual = test.listAllNames();
        System.out.println("Listing all names");
        System.out.println(test.listAllNames().toString());
        Assert.assertTrue(actual.equals(expectedList));
    }

    @Test
    public void testListAllNamesAndNumbers() {
        String expectedList =
                        "    Eric : 555-5555\n"+
                        " Horatio : 987-6543\n"+
                        "   Jenny : 867-5309\n"+
                        "   Tariq : 420-6969\n"+
                        "Terrance : 111-2222\n";
        String actual = test.listAllNamesAndNumbers();
        System.out.println("Listing all names and numbers");
        System.out.println(test.listAllNamesAndNumbers().toString());
        Assert.assertTrue(actual.equals(expectedList));
    }
    @Test
    public void testAddMultipleNumbers(){
        test.book.get("Tariq").addNumber("111-1111");
        String expectedNumbers = "420-6969 | 111-1111";
        String actual = test.book.get("Tariq").printNumbers();
        Assert.assertTrue(actual.equals(expectedNumbers));
    }

    @Test
    public void testListAllNamesAndMultipleNumbers() {
        test.book.get("Tariq").addNumber("111-1111");
        test.book.get("Jenny").addNumber("777-7777");
        test.book.get("Horatio").addNumber("651-9736");
        test.book.get("Horatio").addNumber("324-2424");

        String expectedList =
                        "    Eric : 555-5555\n"+
                        " Horatio : 987-6543 | 651-9736 | 324-2424\n"+
                        "   Jenny : 867-5309 | 777-7777\n"+
                        "   Tariq : 420-6969 | 111-1111\n"+
                        "Terrance : 111-2222\n";
        String actual = test.listAllNamesAndNumbers();
        System.out.println("Listing all names and multiple numbers");
        System.out.println(test.listAllNamesAndNumbers().toString());
        Assert.assertTrue(actual.equals(expectedList));
    }

    @Test
    public void testReverseLookup(){
        String expectedName = "Eric";
        String actual = test.reverseLookup("555-5555");
        Assert.assertTrue(actual.equals(expectedName));

    }

}
