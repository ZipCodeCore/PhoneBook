package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private HashMap<String, List<String>> namesNumbers = new HashMap<>();

    public PhoneBook(Map<String, List<String>> map) {
        this.namesNumbers.putAll(map);
    }

    public PhoneBook() {
        this.namesNumbers = new HashMap(){};
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> phoneNumbers= new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        this.namesNumbers.put(name,phoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> phoneNumbersList = new ArrayList<>(Arrays.asList(phoneNumbers));
        this.namesNumbers.put(name,phoneNumbersList);
    }

    public void remove(String name) {
        this.namesNumbers.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.namesNumbers.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.namesNumbers.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : this.namesNumbers.entrySet()){
            if (entry.getValue().equals(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(this.namesNumbers.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.namesNumbers;
    }
}
