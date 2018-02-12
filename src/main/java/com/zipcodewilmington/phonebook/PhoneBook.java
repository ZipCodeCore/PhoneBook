package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, Person> database = new TreeMap<String, Person>();

    public void addEntry(String name, Person details) {
        database.put(name, details);
    }

    public void addNumberToExistingEntry(String numberToBeAdded) {

    }

    public getPhoneNumber() {
        return database.get(name);
    }

}
