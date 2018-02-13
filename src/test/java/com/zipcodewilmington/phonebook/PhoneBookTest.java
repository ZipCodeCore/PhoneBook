package com.zipcodewilmington.phonebook;


import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void test1() {
        String name = "Steve Harvey";
        String phoneNumber = "2153755497";
        String name2 = "Frankie";
        String pN2 = "2158883323";
        String name3 = "Zoe";
        String pN3 = "7896785647";

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(name, phoneNumber);
        phoneBook.add(name2, pN2);
        phoneBook.add(name3, pN3);
        System.out.println(phoneBook.getPhoneBook());


    }
}
