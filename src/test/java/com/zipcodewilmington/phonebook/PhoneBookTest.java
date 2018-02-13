package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Before
    public void setUp() {
        testBook = new PhoneBook();
    }




    @Test
    public void addTest() {

        PhoneBook testBook = new PhoneBook();
        String name = "Dan";
        String number = "4847986543";
       // String expected = "Dan 4847986543";

        testBook.add(name, number);
        Assert.assertEquals(expected, actual);
    }



}
