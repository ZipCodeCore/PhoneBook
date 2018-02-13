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


    @Test
    public void getTestNumber(){
        yellowPages.add("bill", "1234567890");
        Assert.assertEquals(bill.getNumber(), yellowPages.get("bill"));
    }

    //i kinda need to talk to someone about this? how to instantiate my phonebook with a value. otherwise i'm testing get and set at the same time,
    //and i can't SRP effectively
    @Test
    public void addTest(){
        yellowPages.add("bill", "1234567890");
        Assert.assertEquals(bill.getNumber(), yellowPages.get("bill"));
    }

    @Test
    public void removeTest(){
        yellowPages.add("bill", "1234567890");
        yellowPages.remove("bill");
        Assert.assertFalse(yellowPages.find("bill"));
    }
}
