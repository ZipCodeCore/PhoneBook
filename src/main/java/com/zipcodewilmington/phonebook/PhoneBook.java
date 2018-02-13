package com.zipcodewilmington.phonebook;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */


public class PhoneBook {

    TreeMap<String, String> contacts;

    public PhoneBook () {
        contacts = new TreeMap();
    }

    public String addPerson(String name, String phoneNumber) {
        return contacts.put(name, phoneNumber);
    }

    public String lookupPhoneNumber(String name) {
        return contacts.get(name);
    }

    public String removePerson(String name) {
        return contacts.remove(name);
    }

    public void  listNamesAndNums(String name, String phoneNumber) {

        for (String key : contacts.keySet()){
            String value = contacts.get(key);
            System.out.println(key + ": " + value);
        }

    }


}
