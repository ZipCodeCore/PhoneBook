package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testAddPhoneBookEntryToPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        String phoneNumber = "3025551111";
        phoneBook.addEntryToPhoneBook("eric", phoneNumber);
        String actual = phoneBook.lookUp("eric").getPhoneNumber();
        Assert.assertEquals(phoneNumber, actual);
    }


}
