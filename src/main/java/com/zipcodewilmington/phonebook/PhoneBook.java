package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private String name;
    private String number;
    public TreeMap<String, String> phoneBookEntries = new TreeMap<String, String>();


    public PhoneBook() {

    }

    public void add(String name, String number) {
        phoneBookEntries.put(name, number);
    }

    public void remove(String name) {
        phoneBookEntries.remove(name).toString();
    }

    public String lookUp(String name) {
        return phoneBookEntries.get(name);

    }

    public String listNames() {

        Set<String> contacts = phoneBookEntries.keySet();
        String allContatcts = "";

        for (String name : contacts) {
            allContatcts += name + "\n";
        }

        return allContatcts;

    }

    public String listNamesAndNumbers() {

        Set<String> contacts = phoneBookEntries.keySet();
        String allContacts = "";

        for (String name : contacts) {
            allContacts += name + " " + phoneBookEntries.get(name) + "\n";
        }

        return allContacts;
    }

        public  String reverseLookUp(String value) {

            Set<String> contacts = phoneBookEntries.keySet();
            for(String name: contacts){
                if(phoneBookEntries.get(name).equals(value)){
                    return name;
                }

            }
            return null;

    }
}