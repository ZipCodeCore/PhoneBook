package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.TreeMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {

    PhoneBook yellowPages;
    Person bill;

    @Before
    public void setup(){
        yellowPages = new PhoneBook();
        bill = new Person("bill", "1234567890");
    }

//    public void addTest(String name, String number){
//        //Person expected = ("Bill", "1234567890");
//
//
//    }
    @Test
    public void getTest(){
        yellowPages.add(bill);
        Assert.assertEquals(bill, yellowPages.get("bill"));
    }

    @Test
    public void getTestNumber(){
        yellowPages.add(bill);
        Assert.assertEquals(bill.getNumber(), yellowPages.get("bill"));
    }
}
