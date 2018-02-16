package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, Person> phoneBook;

public phoneBook(){
    phoneBook = new TreeMap<String, Person>();
    }


    public void addEntryToPhoneBook(String name, String phoneNumber) {
       Person person = new Person(name, phoneNumber);
        phoneBook.put(name, person);
    }


    public void removeEntryFromPhoneBook(String name, String phoneNumber) {
        phoneBook.remove(name, phoneNumber);
    }

    public String lookUp(String name) {
        return phoneBook.get(name).getPhoneNumbers();
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
        for (Map.Entry<String, Person> entry : phoneBook.entrySet()) {
            completeListOfNumbers += entry.getValue() + "\n";
        }
        return completeListOfNumbers;
    }


    public String entryListAll() {
        String fullList = "";
        for (Map.Entry<String, Person> entry : phoneBook.entrySet()) {
            fullList += entry.getKey() + " : " + entry.getValue() + "\n"; //reverse lookup

        }
        System.out.println(fullList);
        return fullList;
    }

    public String reverseLookup(String numberToLookUp) {
        for (Map.Entry<String,Person > entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(numberToLookUp)){
                return entry.getKey();
            }
        }return null;
    }




}

