package com.zipcodewilmington.phonebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private HashMap<String, Entry> book;
    private int numberOfEntries;

    //TODO: create constructor that allows a default dataset
    public PhoneBook() {
        book = new HashMap<>();
        numberOfEntries = 0;
    }

    public Entry lookup(String name) {
       return book.get(name);
    }

    //TODO: reverseLookup
    public String reverseLookup(String number) {
        return null;
    }

    public Entry removeEntry(String name) {
        return book.remove(name);
    }

    public Entry addEntry(String name, String number) {
        numberOfEntries++;
        return book.put(name, new Entry(name, number));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Entry> entry : book.entrySet())
            sb.append(entry.toString());
        return sb.toString();
    }
}
