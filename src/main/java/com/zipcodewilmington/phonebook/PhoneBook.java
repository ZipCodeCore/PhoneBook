package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class PhoneBook {

    TreeMap<String, String> phoneBookList = new TreeMap<String, String>();

    public void addEntry(String name, String number) {
        phoneBookList.put(name, number);
        //Look to see if person exists
        //Get array list value
    }

    public void removeEntry(String name, String number) {
        phoneBookList.remove(name, number);
    }

    public String lookUp(String name) {
        return phoneBookList.get(name);
    }

    public String listNames() {
        return phoneBookList.keySet().toString();
    }

    public String listAll() {

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : phoneBookList.entrySet()) {
            sb.append(entry.getKey() + entry.getValue());
            sb.append("\n");
        }
        return sb.toString();

    }

    public String reverseLookUp(String number) {
        for(Map.Entry<String, String>entry : phoneBookList.entrySet()) {
            if(entry.getValue() == number) {
                return entry.getKey();
            }
        }
        return "That number is not in the phone book";
    }

    public static void main(String[] args) {
        PhoneBook pb1 = new PhoneBook();
        pb1.addEntry("Brian", "12345678");
        pb1.addEntry("Lawrence", "23458984");
        pb1.addEntry("Anthony", "12381927");

    }
}
