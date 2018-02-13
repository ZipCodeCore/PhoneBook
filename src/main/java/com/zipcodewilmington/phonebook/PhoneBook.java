package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private TreeMap<String, String> phoneBook;

    public PhoneBook(){
        this.phoneBook = new TreeMap<String, String>();
    }



    public void add(String name, String phoneNumber){
        phoneBook.put(name, phoneNumber);
        System.out.println(phoneBook);
    }


    public String getPhoneBook() {
        String result = String.format("%s  |  %s\n", String.valueOf(phoneBook.get()), String.valueOf(phoneBook.values()));

        return result;
    }
}