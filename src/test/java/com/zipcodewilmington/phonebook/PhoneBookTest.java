package com.zipcodewilmington.phonebook;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    private PhoneBook phoneBook = new PhoneBook();
    String name = "Steve Harvey";
    String phoneNumber = "2153755497";
    String name2 = "Frankie";
    String pN2 = "2158883323";
    String name3 = "Zoe";
    String pN3 = "7896785647";


    @Before
    public void addEntryTest1(){
        phoneBook.add(name, phoneNumber);
        phoneBook.add(name2, pN2);
        phoneBook.add(name3, pN3);
    }

    @Test
    public void addEntryTest2() {
        name = "Durp";
        phoneNumber = "2153755497";
        name2 = "Frankie";
        pN2 = "2158883323";
        name3 = "Lenny Kravitz";
        pN3 = "3645274567";
        phoneBook.add(name, phoneNumber);
        phoneBook.add(name2, pN2);
        phoneBook.add(name3, pN3);
    }

    @Test
    public void lookUpTest1(){
        phoneBook.lookUp(name2);
        //System.out.println(phoneBook.lookUp(name2));
    }

    @Test
    public void removeEntryTest1(){
        phoneBook.removeEntry(name2);
        //System.out.println(phoneBook.getPhoneBook());
    }

    @Test
    public void displayPhoneBook(){
        phoneBook.getPhoneBook();
    }
}
