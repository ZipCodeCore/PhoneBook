package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        phonebook = map;
    }

    public PhoneBook() {
        phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> num = new ArrayList<>(Arrays.asList(phoneNumber));
        phonebook.put(name,num);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> num = new ArrayList<>(Arrays.asList(phoneNumbers));
        phonebook.put(name,num);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        ArrayList<String> num = new ArrayList<>(Arrays.asList(name));
        return phonebook.containsValue(num) || phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
