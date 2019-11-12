package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private final Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {

        this.map = new TreeMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumberList = map.get(name);
        phoneNumberList.add(phoneNumber);
        map.put(phoneNumber, phoneNumberList);
    }

    public void addAll(String name, String... phoneNumbers) {
        for(String phoneNumber : phoneNumbers){
            add(name, phoneNumber);
        }
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return map.get(name) != null;
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        return null;
    }
}
