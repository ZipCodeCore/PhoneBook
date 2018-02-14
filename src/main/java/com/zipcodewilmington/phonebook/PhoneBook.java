package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, String> phoneBook = new TreeMap<String, String>();


    public void addEntryToPhoneBook(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
    }


    public void removeEntryFromPhoneBook(String name, String phoneNumber) {
        phoneBook.remove(name, phoneNumber);
    }

    public String lookUp(String name) {
        return phoneBook.get(name);
    }

    public String listNames() {
        String completeListOfNames = "";
        for (String key : phoneBook.keySet()) {
            completeListOfNames += key + "\n";
        }

        return completeListOfNames;
    }

    public String listNumbers() {
        String completeListOfNumbers = "";
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            completeListOfNumbers += entry.getValue() + "\n";
        }
        return completeListOfNumbers;
    }


    public String entryListAll() {
        String fullList = "";
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            fullList += entry.getKey() + " : " + entry.getValue() + "\n"; //reverse lookup

        }
        return fullList;
    }

    public String reverseLookup(String numberToLookUp) {
        for (Map.Entry<String,String > e : phoneBook.entrySet()) {
            if (e.getValue().equals(numberToLookUp)){
                return e.getKey();
            }
        }return null;
    }




}

