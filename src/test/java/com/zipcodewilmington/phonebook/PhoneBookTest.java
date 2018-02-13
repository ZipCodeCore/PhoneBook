package com.zipcodewilmington.phonebook;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    private static volatile PhoneBook phonebook;

    @Before
    public void setup() {
        phonebook = new PhoneBook();
        phonebook.addEntry("Rex", "608-191-6969");
        phonebook.addEntry("Rex", "608-191-6970");
        phonebook.addEntry("Rex", "608-191-6971");
        phonebook.addEntry("Nia", "234-593-2291");
        phonebook.addEntry("Tora", "757-221-3425");
        phonebook.addEntry("Mòrag", "323-988-6543");
        phonebook.addEntry("Zeke", "666-223-9909");
    }

    /**
     * addEntry passing a name that has not yet been added
     */
    @Test
    public void testAddEntry1() {
        String expected = "789-998-1432\n";
        phonebook.addEntry("Pyra", "789-998-1432");
        String actual = phonebook.lookup("Pyra");

        TestUtils.assertEquality(expected, actual);
    }

    /**
     * addEntry passing a name that already exists and has a number/numbers
     */
    @Test
    public void testAddEntry2() {
        String expected = "Nia";
        String actual = phonebook.addEntry("Nia", "218-234-4453").getName();

        TestUtils.assertEquality(expected, actual);
    }


    /**
     * lookup an entry that exists
     */
    @Test
    public void testLookup1() {
        String expected =
                "608-191-6969\n" +
                "608-191-6970\n" +
                "608-191-6971\n";
        String actual = phonebook.lookup("Rex");

        TestUtils.assertEquality(expected, actual);
    }

    /**
     * lookup an entry that does not exist
     */
    @Test
    public void testLookup2() {
        String expected = "[ I have no memory of this person. ]";
        String actual = phonebook.lookup("Poppi");

        TestUtils.assertEquality(expected, actual);
    }




    @Test
    public void testListNumbers() {
        String expected =
                "608-191-6969\n" +
                "608-191-6970\n" +
                "608-191-6971\n";
        String actual = phonebook.lookup("Rex");

        TestUtils.assertEquality(expected, actual);
    }


    /**
     * removeEntry on an entry that should exist in the phonebook
     */
    @Test
    public void testRemoveEntry1() {
        String expected =
                "Rex             608-191-6969 \n" +
                "Rex             608-191-6970 \n" +
                "Rex             608-191-6971 \n" +
                "Tora            757-221-3425 \n" +
                "Mòrag           323-988-6543 \n" +
                "Zeke            666-223-9909 \n";
        phonebook.removeEntry("Nia");
        String actual = phonebook.listAll();

        TestUtils.assertEquality(expected, actual);
    }

    /**
     * removeEntry on an entry that should not exist in the phonebook
     */
    @Test
    public void testRemoveEntry2() {
        String expected =
                "Rex             608-191-6969 \n" +
                "Rex             608-191-6970 \n" +
                "Rex             608-191-6971 \n" +
                "Nia             234-593-2291 \n" +
                "Tora            757-221-3425 \n" +
                "Mòrag           323-988-6543 \n" +
                "Zeke            666-223-9909 \n";
        phonebook.removeEntry("Mythra");
        String actual = phonebook.listAll();

        TestUtils.assertEquality(expected, actual);
    }

    /**
     * removeNumberFromEntry on an entry that is present with a number that exists
     */
    @Test
    public void testRemoveNumberFromEntry1() {
        String expected =
                "Rex             608-191-6969 \n" +
                        "Rex             608-191-6970 \n" +
                        "Nia             234-593-2291 \n" +
                        "Tora            757-221-3425 \n" +
                        "Mòrag           323-988-6543 \n" +
                        "Zeke            666-223-9909 \n";
        phonebook.removeNumberFromEntry("Rex", "608-191-6971");
        String actual = phonebook.listAll();

        TestUtils.assertEquality(expected, actual);
    }

    /**
     * reverseLookup passing a number that exists
     */
    @Test
    public void testReverseLookup1() {
        String expected = "Zeke";
        String actual = phonebook.reverseLookup("666-223-9909");

        TestUtils.assertEquality(expected, actual);
    }

    /**
     * reverseLookup passing a number that does not exist
     */
    @Test
    public void testReverseLookup2() {
        String expected = "[ She definitely changed her number. ]";
        String actual = phonebook.reverseLookup("867-5309");

        TestUtils.assertEquality(expected, actual);
    }

    /**
     * listAllJSON
     */
    @Test
    public void testListAllJSON() {
        String expected = "{\"Rex\":{\"home\":\"608-191-6969\",\"secondary\":\"608-191-6971\"},\"Nia\":{\"home\":\"234-593-2291\"},\"Tora\":{\"home\":\"757-221-3425\"},\"Mòrag\":{\"home\":\"323-988-6543\"},\"Zeke\":{\"home\":\"666-223-9909\"}}";
        String actual = phonebook.listAllJSON();

        TestUtils.assertEquality(expected, actual);
    }
}
