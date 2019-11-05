package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String, List<String>> theMap;

    public PhoneBook(Map<String, List<String>> map) {
        this.theMap = map;
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        theMap.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        theMap.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        if (hasEntry(name)) {
            theMap.remove(name);
        }
    }

    public Boolean hasEntry(String name) {
        if(theMap.containsKey(name)){
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return null;
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
