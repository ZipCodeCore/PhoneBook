package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map <String, ArrayList<String>> map;
    //private List<String> list = new ArrayList<>();


    public PhoneBook(Map<String, ArrayList<String>> map) {
        //map = new LinkedHashMap<>(0);
        this.map = map;
        //this.list = list;
    }

    public PhoneBook() {

        //map = new LinkedHashMap<String, List<String>>();

        this.map = new TreeMap<String, ArrayList<String>>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> number = map.get(name);
       number.add(phoneNumber);
        map.put(name, number);
    }

    public void addAll(String name, String... phoneNumbers) {
        //adds many phone numbers to a single name entry

        for (String string: phoneNumbers) {
            list.add(string);
        }
        map.put(name,list);

    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String result = "";
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            List<String> listOfPhoneNumbers = map.get(entry.getKey());
            for (int i = 0; i < listOfPhoneNumbers.size(); i++) {
                if (listOfPhoneNumbers.get(i).equals(phoneNumber))
                    result = entry.getKey();
            }
        }
        return result;
    }

    public List<String> getAllContactNames() {

        List<String> result = new ArrayList<>();
        for (Map.Entry<String,ArrayList<String>> entry: map.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }

    public Map<String, ArrayList<String>> getMap() {

        return this.map;
    }
}
