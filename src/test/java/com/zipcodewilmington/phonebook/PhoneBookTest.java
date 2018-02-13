package com.zipcodewilmington.phonebook;
import org.junit.Test;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
//test for adding an entry
    @Test
    public void test addEntry1() {
        String expected = "856-774-4773";
        PhoneBook.addEntry("Rodney", "856-774-4773");
        String actual = PhoneBook.listAllNumbers("Rodney");

        TestUtils.assertEquality(expected, actual);
    }

    @Test
    public void test addEntry2() {
        String expected = "856-774-4773";
        PhoneBook.addEntry("Rodney", "856-774-4773");
        String actual = PhoneBook.listAllNumbers("Rodney");

        TestUtils.assertEquality(expected, actual);
    }
//


}
