package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    PhoneBook testPhonebook;
    Person john;

    @Before
    public void setup() {
        testPhonebook = new PhoneBook();
        john = new Person("JohnDoe", "111-555-1234");
    }


    @Test
    public void testLookup() {

        testPhonebook.add(john.getName(), john.getPhoneNumber());

        Person actualPerson = testPhonebook.lookup(john.getName());

        Assert.assertEquals(john.getPhoneNumber(), actualPerson.getPhoneNumber());

    }

}
