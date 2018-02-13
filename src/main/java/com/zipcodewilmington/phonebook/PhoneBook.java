package com.zipcodewilmington.phonebook;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

private String name;
private String phoneNumber;

    private TreeMap<String, String> phoneBookDirectory = new TreeMap<String, String>();


    public String lookupNameToGetAccompanyingPhoneNumber(String name) {
       return phoneBookDirectory.get(name);

    }
    public String addEntry(String name, String phoneNumber) {
        phoneBookDirectory.put(name, phoneNumber);
        return phoneBookDirectory.get(name);

    }
    public String removeEntry(String name) {
        phoneBookDirectory.remove(name);
        return phoneBookDirectory.get(name);
    }
    public java.util.Set listNames(){
        return phoneBookDirectory.keySet();
    }
    public java.util.Set listNamesAndNumbers() {
        return phoneBookDirectory.entrySet();
    }
}
