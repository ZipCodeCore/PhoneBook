package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private LinkedHashMap<String, List<String>> namesNumbers = new LinkedHashMap<>();


    public PhoneBook(Map<String, List<String>> map) {
        this.namesNumbers.putAll(map);
    }

    public PhoneBook() {
        this.namesNumbers = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> numList = new ArrayList<>(1);
        numList.add(phoneNumber);
        this.namesNumbers.put(name,numList);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> numList = new ArrayList<>(phoneNumbers.length);
        numList.addAll(Arrays.asList(phoneNumbers));
        this.namesNumbers.put(name,numList);
    }

    public void remove(String name) {
        this.namesNumbers.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.namesNumbers.containsKey(name);
    }

    public List<String> lookup(String name) {
        ArrayList<String> numList = new ArrayList<>(namesNumbers.get(name).size());
        numList.addAll(namesNumbers.get(name));
        return numList;
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry: namesNumbers.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
    }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> nameList = new ArrayList<>(namesNumbers.keySet().size());
        for (String name : namesNumbers.keySet()){
            nameList.add(name);
        }
        return nameList;
    }

    public Map<String, List<String>> getMap() {
        return this.namesNumbers;
    }
}
